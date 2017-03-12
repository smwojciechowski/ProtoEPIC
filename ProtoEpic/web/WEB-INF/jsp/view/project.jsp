<%--@elvariable id="requestedProject" type="com.slav.Project"--%>
<!DOCTYPE html>
<html>
    <head>
        <title>${requestedProject.projectName}</title>
    </head>
    <body>
        Welcome to, the ${requestedProject.projectName} view!
        <br/>
        <br/>
        <br/>
        <form method="GET" action="<c:url value="/documentBrowser" />">
            Name:<br/>
            <input type="text" name="documentName"><br/>
            Type:<br/>
            <input type="text" name="documentType"><br/>
            SubType:<br/>
            <input type="text" name="documentSubType"><br/>
            Responsible Person:<br/>
            <input type="text" name="responsiblePerson"><br/>
            Description:<br/>
            <input type="text" name="documentDescription"><br/>
            Status:<br/>
            <input type="text" name="documentStatus"><br/>
            <br/>
            <br/>
            <br/>
            Status Date:<br/>
            <input type="date" name="statusDate"><br/>
            Received Date:<br/>
            <input type="date" name="receivedDate"><br/>
            Forecast Issued Date:<br/>
            <input type="date" name="forecastIssuedDate"><br/>
            Issued Date:<br/>
            <input type="date" name="issuedDate"><br/>
            <input type="submit" value="Find">
        </form>
    </body>
</html>
