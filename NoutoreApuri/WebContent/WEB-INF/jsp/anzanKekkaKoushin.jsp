<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js" lang="">

<head>
  <meta charset="utf-8">
  <title>脳トレアプリ</title>
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
<h1 id="text">スコア更新しました！</h1>
  <div class="container">
    <p>結果:<c:out value="${theNumberOfCorrectAnswers}"/>/10です！</p>
	<a href="/NoutoreApuri/MenuServlet">戻る</a>
  </div>
</body>
<script>
	const h1 = document.getElementById("text");
	let count = 0;

	const timer = setInterval(() => {
	    h1.style.fontSize = count + `px`;
	    count++;

	    if (count >= 100) clearInterval(timer);
	}, 10);
</script>

</html>
