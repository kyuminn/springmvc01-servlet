package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// adapter -> 실제 controller를 호출하여 값을 받아온다고 생각~
// 실제 컨트롤러를 호출하기 전에 이 컨트롤러를 지원하는 어댑터인지 먼저 확인(supports()로)
// 컨트롤러에서 값을 받아와서 구현한 부모 어댑터의 return 타입에 맞게 adapting 작업도 해줌~ (ControllerV4HandlerAdapter 확인)
public class ControllerV3HandlerAdapter implements MyHandlerAdapter {
    // ControllerV3만 지원하는 Adapter인지 확인하기
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV3);
    }

    // 실제 Controller 호출 부분 (ControllerV3)
    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV3 controller = (ControllerV3) handler;
        Map<String, String> paramMap = createParamMap(request);
        ModelView mv = controller.process(paramMap);
        // ControllerV3는 ModeLView를 반환
        return mv;
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String,String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }

}
