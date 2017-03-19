<%--@elvariable id="doc" type="com.slav.ProjectDocument"--%>

<!DOCTYPE html>
<html>
    <head>
        <title>${doc.documentName}</title>
    </head>
    <body>
        Document Name: ${doc.documentName}<br/><br/><br/>
        <form method="POST" action="/documentBrowser" enctype="multipart/form-data">
            <input type="hidden" name="action" value="upload" />
            <b>Attachments</b>
            <input type="hidden" name="docName" value="${doc.documentName}" />
            <input type="file" name="file1" />
            <input type="submit" value="Submit" />
        </form><br/>
    Available document files:<br/>
    <c:forEach items="${doc.attachments}" var="entry">
        <a href="<c:url value="/documentBrowser">
        <c:param name="downloadDocName" value="${doc.documentName}" />
        <c:param name="attachmentName" value="${entry.value.name}" />
        </c:url>">
        <c:out value="${entry.value.name}" /></a><br/>
    </c:forEach>
    </body>
</html>
