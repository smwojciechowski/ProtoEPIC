package com.slav;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(
        name = "DocumentBrowserServlet",
        urlPatterns = "/documentBrowser"
)
public class DocumentBrowserServlet extends HttpServlet {

    DocumentDatabase docDatabase = new DocumentDatabase();
    Map<String, ProjectDocument> documentDatabase;
    Map<String, ProjectDocument> resultFromDatabase;


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        documentDatabase = docDatabase.populateDatabase();
        documentDatabase.forEach((k, v) -> System.out.println("Key: " + k));

        docDatabase.filterDatabase("7")
                    .forEach((k, v) -> System.out.println("Filter result: " + k));

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
