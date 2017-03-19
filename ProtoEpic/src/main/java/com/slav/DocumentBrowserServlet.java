package com.slav;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@WebServlet(
        name = "DocumentBrowserServlet",
        urlPatterns = "/documentBrowser",
        loadOnStartup = 1
)
@MultipartConfig(
        fileSizeThreshold = 5_242_880, //5MB
        maxFileSize = 20_971_520L, //20MB
        maxRequestSize = 41_943_040L //40MB
)
public class DocumentBrowserServlet extends HttpServlet {

    DocumentDatabase docDatabase = new DocumentDatabase();
    Map<String, ProjectDocument> documentDatabase;
    Map<String, ProjectDocument> resultFromDatabase;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if(documentDatabase == null) {
            documentDatabase = docDatabase.populateDatabase();
        }

        if(request.getParameter("documentName") != null) {
            //documentDatabase = docDatabase.populateDatabase();
            resultFromDatabase = docDatabase.filterDatabase(request.getParameter("documentName"));

            request.setAttribute("searchResult", resultFromDatabase);
            request.setAttribute("searchDone", true);
            request.getRequestDispatcher("/WEB-INF/jsp/view/project.jsp")
                    .forward(request, response);
        }

        ProjectDocument userSelectedDocument = documentDatabase.get(request.getParameter("docName"));
        if(userSelectedDocument != null) {

            request.setAttribute("doc", userSelectedDocument);
            request.getRequestDispatcher("/WEB-INF/jsp/view/document.jsp")
                    .forward(request, response);
        }

        if(request.getParameter("attachmentName") != null) {
            this.downloadAttachment(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if(request.getParameter("action").equals("upload")) {
            this.createAttachment(request, response);
        }
        String currentDoc = request.getParameter("docName");

        request.setAttribute("doc", documentDatabase.get(currentDoc));
        request.getRequestDispatcher("/WEB-INF/jsp/view/document.jsp")
                .forward(request, response);
    }

    private void createAttachment(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String currentDoc = request.getParameter("docName");

        Part filePart = request.getPart("file1");
        if(filePart != null && filePart.getSize() > 0) {

            Attachment attachment = this.processAttachment(filePart);
            if(attachment != null) {
                documentDatabase.get(currentDoc).addAttachment(attachment);
            }
        }

    }

    private Attachment processAttachment(Part filePart) throws IOException {

        InputStream inputStream = filePart.getInputStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        int read;
        final byte[] bytes = new byte[1024];

        while((read = inputStream.read(bytes)) != -1) {

            outputStream.write(bytes, 0, read);
        }

        Attachment attachment = new Attachment();
        attachment.setName(filePart.getSubmittedFileName());
        attachment.setContents(outputStream.toByteArray());

        return attachment;
    }

    private void downloadAttachment(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String downloadDocName = request.getParameter("downloadDocName");
        String attachmentName = request.getParameter("attachmentName");

        ProjectDocument downloadDoc = documentDatabase.get(downloadDocName);

        Attachment attachment = downloadDoc.getAttachments()
                                           .get(attachmentName);

        response.setHeader("Content-Disposition",
                "attachment; filename=" + attachment.getName());
        response.setContentType("application/octet-stream");

        ServletOutputStream stream = response.getOutputStream();
        stream.write(attachment.getContents());
    }
}














