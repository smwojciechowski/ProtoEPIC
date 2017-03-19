package com.slav;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

public class DocumentBrowserServletTest extends Mockito {

    @Test
    public void testDocumentBrowserServlet() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("docName")).thenReturn("Project Number 12");

        new DocumentBrowserServlet().doGet(request, response);

        Assert.assertEquals("Project Number 12", request.getParameter("docName"));
    }
}
