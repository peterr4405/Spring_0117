<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FileUpload</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css" >
    </head>
    <body style="padding: 20px">
        <form:form modelAttribute="photo"
                   class="pure-form" 
                   method="POST"
                   action="uploadFile"
                   enctype="multipart/form-data">
            <fieldset>
                <legend>Photo upload form</legend>
                <form:input path="name" /><p />
                <form:hidden path="base64" />
                Select a file to upload <p />
                <input type="file" name="file" /><p />
                <button type="submit" class="pure-button pure-button-primary">Submit</button>
            </fieldset>
            <form:errors path="*" style="color:red" />
        </form:form>
        <table class="pure-table pure-table-bordered">
            <thead>
                <tr>
                    <th>name</th>
                    <th>photo</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="photo" items="${list}">
                    <tr>
                        <td>${photo.name}</td>
                        <td><img width="300" src="data:image/png;base64, ${photo.base64}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>