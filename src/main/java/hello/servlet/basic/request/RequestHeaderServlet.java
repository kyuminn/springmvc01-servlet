package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet",urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    // 꼭 protected service() override 할 것
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printStartLine(request);
        //header부분 

    }

    private void printStartLine(HttpServletRequest request) {
        System.out.println("---Reuqest Line Start---");
        System.out.println("request.getMethod() = "+ request.getMethod()); //get vs post
        System.out.println("request.getProtocol() = "+ request.getProtocol()); // HTTP/1.1
        System.out.println("request.getScheme() = "+ request.getScheme()); // http
        System.out.println("request.getRequestURL() = "+ request.getRequestURL()); // http://localhost:8080/request-header
        System.out.println("request.getRequestURI() = "+ request.getRequestURI()); // /request-header
        System.out.println("request.getQueryString() = "+ request.getQueryString()); // username=hi
        System.out.println("request.isSecure() = "+ request.isSecure()); // https 사용 유무
        System.out.println("--- Request Line End---");
        System.out.println();
    }
}
