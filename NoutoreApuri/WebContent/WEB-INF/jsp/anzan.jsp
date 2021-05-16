<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

  <meta name="theme-color" content="#fafafa">
</head>

<body>
<h1 id="text">スタート！</h1>
   <div class="d-flex flex-wrap justify-content-center">
      <div class="col-md-6 col-12 p-0">
        <c:forEach var="anzanList" items="${anzanList }">
		<p><c:out value= "${anzanList.num1 }${anzanList.operator }${anzanList.num2 }"/> = </p><br>
		</c:forEach>
      </div>
      <div class="col-md-6 col-12 p-0 align-self-center">
        <div class="p-4 h3">
         <form action="/NoutoreApuri/AnzanServlet" name="form1" onSubmit="return check1()" method="post">
			1:<input id="dat1" type="text" name="answer1" required/>
			2:<input id="dat1"  type="text" name="answer2" required/>
			3:<input id="dat1"  type="text" name="answer3" required/>
			4:<input id="dat1"  type="text" name="answer4" required/>
			5:<input id="dat1"  type="text" name="answer5" required/>
			6:<input id="dat1"  type="text" name="answer6" required/>
			7:<input id="dat1"  type="text" name="answer7" required/>
			8:<input id="dat1"  type="text" name="answer8" required/>
			9:<input id="dat1"  type="text" name="answer9" required/>
		   10:<input id="dat1"  type="text" name="answer10" required/>
			<input type="submit" value="回答する"/>
		 </form>
        </div>
      </div>
   </div>

   <script type="text/javaScript" src="/NoutoreApuri/js/anzan.js"></script>

</body>

</html>
