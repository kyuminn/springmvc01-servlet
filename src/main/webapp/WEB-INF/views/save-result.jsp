<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <!-- Model 에 담은 데이터 꺼내오기 / 2가지 방식. $방식을 를 더 많이 사용함-->
    <li>id=<%=((Member)request.getAttribute("member")).getId()%></li>
    <li>username=${member.username}</li>
    <li>age=${member.age}</li>
</ul>
<a href="/index.html">main</a>
</body>
</html>
