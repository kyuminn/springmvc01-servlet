<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- MemberSaveServlet.java의 service()와  같은 역할을 함-->
<%
    // request, response는 jsp가 기본적으로 제공하는 객체 (HttpServletRequest/Response)
    // request는 내부에 데이터 저장소를 가지고 있음 (나중에 Model 에서 HttpServletRequest객체를 사용하여 attribute를 저장,조회 할수 있음)
    // jsp도 나중엔 결국 servlet으로 변환됨, service() 가 호출
    MemberRepository memberRepository = MemberRepository.getInstance();
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username,age);
    memberRepository.save(member);

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%></li>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">main</a>
</body>
</html>
