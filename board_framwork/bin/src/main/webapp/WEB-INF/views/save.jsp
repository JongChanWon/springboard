<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
	<form action="/board/save" method="post">
		<p>작성자: <input type="text" name="boardWriter" placeholder="작성자"/> </p>
		<p>비밀번호: <input type="password" name="boardPass" placeholder="비밀번호"/> </p>
		<p>제목: <input type="text" name="boardTitle" placeholder="제목"/> </p>
		<p>내용: <textarea rows="10" cols="20" name="boardContents" ></textarea> </p>
		<input type="submit" value="작성"/>
	</form>
</body>
</html>