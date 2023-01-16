package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Spring bean 이름을 url 패턴으로 맞춤
// DispatcherServlet에서 디버깅모드로 확인해보면 알 수 있음
// Spring MVC에서 필요한 HandlerMapping과 HandlerAdapter가 이미 등록되어 있음
// bean 네임으로 url을 설정한 이 경우에는 BeanNameUrlHandlerMapping, SimpleControllerHandlerAdapter가 자동실행됨
// cf) 애노테이션 기반 @Controller에서는  RequestMappingHandlerMapping 사용
@Component("/springmvc/old-controller")
//@Controller 사용하기 전에 제공했던 Controller interface (현재는 사용하지 않음)
public class OldController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");
        // Spring boot는 InternalResourceViewResolver라는 뷰 리졸버를 자동으로 등록하는데 이 때
        // application.properties에 등록한 prefix, suffix 정보를 가져온다 .
        return new ModelAndView("new-form");
    }
}
