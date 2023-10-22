<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>list</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>No</th>
				<th>title</th>
				<th>writer</th>
				<th>date</th>
				<th>hits</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="board" items="${boardList}" varStatus="stat">
			<tr>
				<td align="center">${board.id}</td>
				<td>
					<a href="/board?id=${board.id}">${board.boardTitle}</a>
				</td>
				<td>${board.boardWriter}</td>
				<td>${board.boardCreatedTime}</td>
				<td>${board.boardHits}</td>
				
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>