package com.slav;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(
        name = "LoginServlet",
        urlPatterns = "/login"
)
public class LoginServlet extends HttpServlet {

    private static final Map<String, String> userDatabase = new HashMap<String, String>();

    static{
        userDatabase.put("Bobby", "password");
        userDatabase.put("Jenny", "pass");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        if(request.getParameter("logout") != null) {

            session.invalidate();
            request.setAttribute("loggedOut", true);
            request.getRequestDispatcher("/WEB-INF/jsp/view/login.jsp")
                    .forward(request, response);
        }

        if(request.getParameter("username") == null) {

            request.getRequestDispatcher("/WEB-INF/jsp/view/login.jsp")
                    .forward(request, response);
        } else {
            response.sendRedirect("projectBrowser");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if(userDatabase.containsKey(request.getParameter("username"))
                && userDatabase.get(request.getParameter("username"))
                    .equals(request.getParameter("password"))) {

            HttpSession session = request.getSession();
            session.setAttribute("loggedUsername", request.getParameter("username"));

            request.changeSessionId();
            request.getRequestDispatcher("/projectBrowser")
                    .forward(request, response);
        } else {
            request.setAttribute("loginFailed", true);
            request.getRequestDispatcher("/WEB-INF/jsp/view/login.jsp")
                    .forward(request, response);
        }

    }
}
