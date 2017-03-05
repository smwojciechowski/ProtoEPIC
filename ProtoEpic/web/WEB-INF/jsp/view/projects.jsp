<!DOCTYPE html>
<html>
    <head>
        <title>Project Browser</title>
    </head>
    <body>
        <h3><c:out value="Hello, ${loggedUsername}!" /></h3><br/><br/>
        <a href="<c:url value="/login?logout" />">Logout</a>
    </body>
</html>
