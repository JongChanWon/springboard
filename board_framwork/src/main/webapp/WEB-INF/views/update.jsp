<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/board/update" method="post" name="updateForm">
		<input type="hidden" name="id" value="${board.id}" readonly />
		<input type="text" name="boardWriter" value="${board.boardWriter}" readonly />
		<input type="password" name="boardPass" id="boardPass" placeholder="비밀번호" />
		<input type="text" name="boardTitle" value="${board.boardTitle}" />
		<textarea rows="10" cols="30" name="boardContents">${board.boardContents}</textarea>
		<input type="button" value="수정" onclick="updateReqFn()"/>
	</form>
</body>
<script type="text/javascript">
	const updateReqFn = () => {
		const passInput = document.getElementsByName("boardPass")[0].value; // name값은 중복을 허용하기 때문에 [index]를 넣어줘야함
		const passDB = '${board.boardPass}';

		if(passInput == passDB) {
			document.updateForm.submit();
		} else {
			alert('비밀번호가 일치하지 않습니다. 다시 입력해주세요!!');
		}
	}
</script>
</html>