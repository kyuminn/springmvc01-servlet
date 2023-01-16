package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//,BeanNameUrlHandlerMapping, HttpRequestHandlerAdapter 가 처리 ~ ( DispatcherServlet 디버깅..)

// 실무에서는 어노테이션 기반 99.9 % ! => RequestMappingHandlerMapping, RequestMappingHandlerAdapter 가 우선순위가 높음
@Component("/springmvc/request-handler")
public class MyHttpRequestHandler implements HttpRequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MyHttpRequestHandler.handlerRequest");
    }
}
