<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="model.Word" %>
<!doctype html>
<html class="no-js" lang="">

<head>
  <meta charset="utf-8">
  <title></title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <meta property="og:title" content="">
  <meta property="og:type" content="">
  <meta property="og:url" content="">
  <meta property="og:image" content="">

  <link rel="manifest" href="site.webmanifest">
  <link rel="apple-touch-icon" href="icon.png">
  <!-- Place favicon.ico in the root directory -->
  <!-- CSS only -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

  <meta name="theme-color" content="#fafafa">
</head>

<body>
 <div class="container">
    <h1><span id="count">5</span>分後に移動</h1>
  <script>
	var count=document.getElementById("count");
	setInterval(function(){count.innerHTML--;},60000);
	setTimeout(function(){location.href="http://localhost:8080/NoutoreApuri/KaitouServlet";},300000);
  </script>

  <div class="position-relative">
	  <div class="position-absolute top-50 start-50">
	  	 <c:forEach var="questionWord" items="${questionWordList }">
		 <p><c:out value="${questionWord.wordValue}"/></p>
	     </c:forEach>
		<a href="/NoutoreApuri/WordKaitouServlet"><button type="button" class=""btn btn-outline-dark btn-lg">回答</button></a>
  	  </div>
  </div>
 </div>
</body>

</html>
