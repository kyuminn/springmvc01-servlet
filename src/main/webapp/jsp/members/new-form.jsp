<!--2번째줄 내용을 넣어줘야 jsp라고 인식할 수 있음 -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- http://localhost:8080/jsp/members/new-form.jsp 로 호출 시 jsp 파일 볼 수 있음 (spring 프로젝트는 기본적으로 webapp 아래에 있는 폴더는 정적으로 서빙 가능한듯?-->
<form action="/jsp/members/save.jsp" method="post">
    username: <input type="text" name="username" />
    age:      <input type="text" name="age"  />
    <button type="submit">전송</button>
</form>
</body>
</html>
