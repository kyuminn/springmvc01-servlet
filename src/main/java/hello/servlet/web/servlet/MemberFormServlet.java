package hello.servlet.web.servlet;

import hello.servlet.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// 발전역사 : servlet(java 코드 안의 html..가독성 구림) ---> jsp(html 안의 java 코드..여전히 불편) -------> mvc pattern 흉내(servlet을 controller로, jsp를 view로서만 이용)
// -----------> Spring MVC (최종) :frontcontroller=(DispatcherServlet)가 포함된!
// 같은 역할의 class가 순서에 따라서 어떤 식으로 바뀌었는지 보면 좋을 듯.
@WebServlet(name="memberFormServlet",urlPatterns = "/servlet/members/new-form")
public class MemberFormServlet extends HttpServlet {
    // cf = ctrl+e => recent file 목록 보여줌
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");
        PrintWriter w = response.getWriter();

        w.write("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form action=\"/servlet/members/save\" method=\"post\">\n" +
                "    username: <input type=\"text\" name=\"username\" />\n" +
                "    age:      <input type=\"text\" name=\"age\" />\n" +
                "    <button type=\"submit\">전송</button>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>\n");
    }
}
