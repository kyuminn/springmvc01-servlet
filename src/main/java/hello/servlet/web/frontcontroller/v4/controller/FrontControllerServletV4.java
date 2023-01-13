package hello.servlet.web.frontcontroller.v4.controller;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v4.ControllerV4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV4",urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {

    private Map<String, ControllerV4> controllerV4Map = new HashMap<>();

    public FrontControllerServletV4() {
        controllerV4Map.put("/front-controller/v4/members/new-form",new MemberFormControllerV4());
        controllerV4Map.put("/front-controller/v4/members/save",new MemberSaveControllerV4());
        controllerV4Map.put("/front-controller/v4/members",new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // v3처럼 메소드 따로 안빼고 그냥 직접 해봤음. 사실상 v3랑 달라진점은 ModelView에서 model을 얻어오지 않고 frontController에서 model을 생성해서 직접 전달해준것.
        String requestURI = request.getRequestURI();
        ControllerV4 controllerV4 = controllerV4Map.get(requestURI);

        if(controllerV4 == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String,String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(name->paramMap.put(name,request.getParameter(name)));


        Map<String,Object> model = new HashMap<>();
        String viewName = controllerV4.process(paramMap, model);

        MyView myView = new MyView("/WEB-INF/views/"+viewName+".jsp");
        myView.render(model,request,response);

    }
}
