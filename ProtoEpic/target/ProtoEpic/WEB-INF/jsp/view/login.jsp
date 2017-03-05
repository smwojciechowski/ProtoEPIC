<%--@elvariable id="loginFailed" type="boolean"--%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <h2>Please log in:</h2></br>
        <c:if test="${loginFailed}">
            <b>The user and password values you have entered are not correct. Please try again</b><br>
        </c:if>
        <c:if test="${loggedOut}">
            <b>You have been logged out.</b>
        </c:if>
        <form method="POST" action="<c:url value="/login" />">
            Username:</br>
            <input type="text" name="username"></br>
            Password:</br>
            <input type="password" name="password"></br>
            <input type="submit" value="Log In">
        </form>
    </body>
</html>
