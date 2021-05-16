<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  <div class="position-relative">
  	<div class="position-absolute top-50 start-50">
	    <form action="/NoutoreApuri/WordServlet" name="form" method="post">
			1:<input id="dat1" type="text" name="answer1"/><br>
			2:<input id="dat1"  type="text" name="answer2"/><br>
			3:<input id="dat1"  type="text" name="answer3"/><br>
			4:<input id="dat1"  type="text" name="answer4"/><br>
			5:<input id="dat1"  type="text" name="answer5"/><br>
			6:<input id="dat1"  type="text" name="answer6"/><br>
			7:<input id="dat1"  type="text" name="answer7"/><br>
			8:<input id="dat1"  type="text" name="answer8"/><br>
			9:<input id="dat1"  type="text" name="answer9"/><br>
			10:<input id="dat1"  type="text" name="answer10"/><br>
			<input class="btn btn-dark" type="submit" value="回答する"/>
		</form>
	</div>
  </div>
</body>

</html>
