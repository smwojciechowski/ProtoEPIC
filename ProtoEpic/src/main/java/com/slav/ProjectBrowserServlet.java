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
        name = "ProjectBrowserServlet",
        urlPatterns = "/projectBrowser"
)
public class ProjectBrowserServlet extends HttpServlet {

    public static final Map<String, Project> projectsDatabase = new HashMap<String, Project>();

    //TO-DO: move to a separate ProjectDatabase class (like DocumentDatabase)
    static {
        projectsDatabase.put("Ichthys", new Project("Ichthys"));
        projectsDatabase.put("Kizomba", new Project("Kizomba"));
        projectsDatabase.put("Tombua", new Project("Tombua"));
        projectsDatabase.put("Sverdrup", new Project("Sverdrup"));
        projectsDatabase.put("Eni", new Project("Eni"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String requestedProject = request.getParameter("name");

        request.setAttribute("requestedProject", projectsDatabase.get(requestedProject));
        request.getRequestDispatcher("/WEB-INF/jsp/view/project.jsp")
                .forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if(request.getParameter("name") != null) {
            doGet(request, response);
        }

        request.setAttribute("projectsDatabase", projectsDatabase);
        request.getRequestDispatcher("/WEB-INF/jsp/view/projects.jsp")
                .forward(request, response);
    }
}
