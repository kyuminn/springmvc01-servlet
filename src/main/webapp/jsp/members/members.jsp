<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
  MemberRepository memberRepository = MemberRepository.getInstance();
  List<Member> members = memberRepository.findAll();
%>
<head>
    <title>Title</title>
</head>
<body>
  <table>
    <thead>
        <th>id</th>
        <th>username</th>
        <th>age</th>
    </thead>
    <tbody>
    <%
      // out도 기본 객체
    for (Member member : members) {
    out.write("    <tr>");
      out.write("        <td>"+member.getId()+"</td>");
      out.write("        <td>"+member.getUsername()+"</td>");
      out.write("        <td>"+member.getAge()+"</td>");
      out.write("    </tr>");
    }
    %>
    </tbody>
  </table>
</body>
</html>
