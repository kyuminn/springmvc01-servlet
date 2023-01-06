package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="mvcMemberFormServlet",urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {
    // webapp/jsp 폴더에 있는 jsp 파일들은 url로 직접 요청할수 있지만 WEB-INF 하위 jsp파일들은 controller 거쳐야만 볼 수 있음. (was 서버의 rule임..)
    // 기본적으로 WEB-INF에 있는 자원들은 url로 직접 호출할 수 없다 ! (was가 이미 정해둔 rule임)
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath ="/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }
}
