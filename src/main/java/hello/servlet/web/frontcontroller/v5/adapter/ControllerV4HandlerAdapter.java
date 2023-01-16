package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v4.ControllerV4;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import org.springframework.http.HttpStatus;

import javax.naming.ldap.Control;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {
    // ControllerV4를 처리할 수 있는지 먼저 확인
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV4);
    }

    // 실제 Controller 호출 부분 (ControllerV4)
    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV4 controller = (ControllerV4) handler;
        Map<String, String> paramMap = createParamMap(request);
        Map<String,Object> model = new HashMap<>();
        // ControllerV4는 논리적은 view 이름을 반환
        String viewName = controller.process(paramMap, model);
        // adapter 역할! viewName 이용하여 ModelView를 반환 (형식에 맞추어서.. adapting 해주는 상황)
        ModelView modelView = new ModelView(viewName);
        modelView.setModel(model);
        return modelView;
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String,String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(paramName->paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
