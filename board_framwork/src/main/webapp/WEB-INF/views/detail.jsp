<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>detail</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>No</th>
			<td>${board.id}</td>
		</tr>
		<tr>
			<th>writer</th>
			<td>${board.boardWriter}</td>
		</tr>
		<tr>
			<th>date</th>
			<td>${board.boardCreatedTime}</td>
		</tr>
		<tr>
			<th>hits</th>
			<td>${board.boardHits}</td>
		</tr>
		<tr>
			<th>title</th>
			<td>${board.boardTitle}</td>
		</tr>

		<tr>
			<th>contents</th>
			<td><textarea rows="10" cols="30" readonly>${board.boardContents}</textarea></td>
		</tr>
	</table>
	<button onclick="listFn()">목록</button>
	<button onclick="updateFn()">수정</button>
	<button onclick="deleteFn()">삭제</button>
</body>

<script type="text/javascript">
	const listFn = () => {
		console.log("여기 들어오냐?");
		location.href = "/board/";
	}

	const updateFn = () => {
		console.log('updateform 들어오냐');
		const id = '${board.id}'; // 싱글쿼터로 묶어줘야함
		location.href = "/board/update?id=" + id;
	}

	const deleteFn = () => {
		const id = '${board.id}';
		location.href = "/board/delete?id=" + id;
	}
</script>
</html>









