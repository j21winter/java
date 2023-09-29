<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- To use JSTL Tags -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!-- To use Data binding and Model Attribute in our forms -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- To use Error messages in our forms -->
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <!-- To connect CSS file (create folder in src>main>resources>static> “css”) -->
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <!-- To connect JS file (create folder in src>main>resources>static> “js”) -->
    <script type="text/javascript" src="/js/app.js"></script>
    <!-- To use bootstrap -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- For any Bootstrap that uses JS -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    HOME! 

    <p>${user.getUserName()}</p>
    <a href="/logout">Logout</a>
</body>
</html>