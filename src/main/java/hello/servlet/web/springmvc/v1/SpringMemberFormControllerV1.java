package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
// RequestMappingHandlerMapping이 찾아낼 수 있도록 클래스 레벨에 어노테이션 필요!
@Controller
public class SpringMemberFormControllerV1 {
    /*
    어노테이션 기반의 Spring mvc 
    * Http 요청 -> 처음에 DispatcherServlet.class로 감
    DispatcherServlet 안의 doDispatch() 실행 !
    DispatcherServlet 클래스 안에 HandlerMapping, HandlerAdapter, ViewResolver 가 각각 List<> 형태로 존재
    * RequestMappingHandlerMapping class가  요청에 알맞은 핸들러(controller) 탐색, 반환
    * RequestMappingHandlerAdapter class가  위에서 반환된 핸들러의 비즈니스 메서드 호출
    *
    *
    * 해당 controller의 비즈니스 메서드에서는
     ModelAndView 객체를 생성한 후 model, viewName에 필요한 값을 담고 DispatcherSerlvet 에게 리턴하면
    * 알맞은 viewResolver가 적절한 View class를 리턴
    최종적으로 render() 가 호출되면서 화면이 사용자에게 보여진다

    ==> 결국 Dispatcher 서블릿이 최초 요청을 받고, doDispatch()가 실행됨
    doDispatch() 내에서
        getHandler() => 이 요청을 처리할 controller 가져옴
        getHandlerAdapter() => 해당 controller를 호출할 어댑터 가져옴
        ha.handle() => 어댑터의  handle() 매서드를 호출하여 controller의 비즈니스 메서드를 호출함, ModelAndView 반환
        반환받은 ModelAndView를 processDispatchResult()의 인자로 보내서 이 메서드 내에서 render() 호출 
    
    전반적인 비즈니스 로직은 DispatcherServlet의 doDispatch()를 보면 이해 가능(pdf 그림과 함께.)
    frontcontroller 패키지 내의 클래스들도 이 부분을 따라서 구현해 본 것
    * */

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process(){
        return new ModelAndView("new-form");
    }
}
