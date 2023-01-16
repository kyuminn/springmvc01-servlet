package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {

    // handler = controller라고 생각할 것
    // supports()= 파라미터로 넘어온 controller를 처리할 adapter가 있는지 검사하는 메서드
    boolean supports(Object handler);

    ModelView handle(HttpServletRequest request, HttpServletResponse response,Object handler) throws ServletException, IOException;

}
