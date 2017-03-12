<%--@elvariable id="projectsDatabase" type="java.util.Map<String, com.slav.Project>"--%>
<%--@elvariable id="loggedUsername" type="java.lang.String"--%>
<!DOCTYPE html>
<html>
    <head>
        <title>Project Browser</title>
    </head>
    <body>
        <h3><c:out value="Hello, ${loggedUsername}!" /></h3><br/><br/>
        <a href="<c:url value="/login?logout" />">Logout</a>
        <br/><br/><br/>
        Project list:<br/><br/>
            <c:forEach items="${projectsDatabase}" var="entry">
                <a href="<c:url value="/projectBrowser">
                    <c:param name="name" value="${entry.key}" />
                </c:url>"><c:out value="${entry.value.projectName}" /></a><br/>
            </c:forEach>
    </body>
</html>
