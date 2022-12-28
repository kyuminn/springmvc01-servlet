package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="helloServlet",urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    
    // Servlet이 호출되면 service()가 자동으로 호출됨
    // http요청이 오면 was가 (= 서블릿 컨테이너)가 request,response객체를 생성해서 servlet에 전달해줌
    // 서블릿을 사용하는데 스프링 부트가 필수적인건 아니지만 was도 있고 여러 어노테이션을 지원해주기 때문에 편해서 스프링 부트로 프로젝트 만든 것.

    // 톰캣: was는 was인데 내부에 서블릿 컨테이너 기능을 가지고 있는 was
    // 톰캣 : 기본적 was + 서블릿 컨테이너 기능 이라고 생각하면 됨.
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        String username = request.getParameter("username");
        System.out.println(username);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");

        response.getWriter().write("hello "+username);
//        super.service(request,response);
    }
}
