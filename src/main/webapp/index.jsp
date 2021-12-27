<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<jsp:useBean id="User" class="io.olen4ixxx.investing.entity.User"/>
Hello, Mr. <jsp:getProperty name="User" property="lastName"/>
<h1><%= "Hello !" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>