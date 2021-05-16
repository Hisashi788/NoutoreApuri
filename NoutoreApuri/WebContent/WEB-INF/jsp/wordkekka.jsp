<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>脳トレ</title>
</head>
<body>
<table border="1">
	<tr>
		<th>問題</th><th>回答</th><th>合否</th>
	</tr>
	<c:forEach var="i" begin="0" end="9" step="1">
		<tr>
		 <td><c:out value="${questionWordList.get(i).wordValue}"/></td>
		 <td><c:out value="${wordInputList.get(i)}"/></td>
		 <td><c:out value="${resultCheckList.get(i)}"/><br></td>
		</tr>
	</c:forEach>
</table>
<p>結果:<c:out value="${theNumberOfCorrectAnswers}"/>/10です！</p>
<a href="/NoutoreApuri/MenuServlet">戻る</a>
</body>
</html>