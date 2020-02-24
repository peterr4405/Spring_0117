<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css">
        <title>Upload File</title>
    </head>
    <body>
        <form style="padding: 20px"
              class="pure-form" method="POST"
              action="uploadFile"
              enctype="multipart/form-data">
            <fieldset>
                <legend>Upload File</legend>
                <input type="file" name="file" /><p/>
                <input type="file" name="file" /><p/>
                <input type="file" name="file" /><p/>
                <button type="submit" class="pure-button pure-button-primary">submit</button>
            </fieldset>
        </form>
        <c:forEach var="base64" items="${base64List}">
            <img src="data:image/png;base64, ${base64}" /><p />
        </c:forEach>       
    </body>
</html>
