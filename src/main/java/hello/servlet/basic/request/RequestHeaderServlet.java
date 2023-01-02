package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
        printHeaders(request);
        printHeaderUtils(request);
        printEtc(request);
    }

    private void printEtc(HttpServletRequest request) {
        System.out.println("--- 기타 조회 start ---");

        System.out.println("[Remote 정보]");
        System.out.println("request.getRemoteHost() = "+ request.getRemoteHost());
        System.out.println("request.getRemoteAddr() = "+ request.getRemoteAddr());
        System.out.println("request.getRemotePort() = "+ request.getRemotePort());
        System.out.println();

        System.out.println("[Local 정보]");
        System.out.println("request.getLocalName() = "+ request.getLocalName());
        System.out.println("request.getLocalAddr() = "+ request.getLocalAddr());
        System.out.println("request.getLocalPort() = "+ request.getLocalPort());

        System.out.println("--- 기타 조회 end ---");
        System.out.println();
    }

    private void printHeaderUtils(HttpServletRequest request) {
        System.out.println("----Header Utils 조회 start----");
        System.out.println("[Host Utils 조회]");
        System.out.println("request.getServerName() = "+ request.getServerName()); // Host Header
        System.out.println("request.getServerPort() = "+ request.getServerPort()); // Host Header 
        System.out.println();

        System.out.println("[Accept-Language Utils 조회]");
        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " + locale));
        System.out.println("request.getLocale() = "+ request.getLocale());

        System.out.println("[cookie Utils 조회]");
        if(request.getCookies()!= null){
            for(Cookie cookie : request.getCookies()){
                System.out.println(cookie.getName()+": "+ cookie.getValue());
            }
        }
        System.out.println();

        System.out.println("[Content 편의 조회]");
        System.out.println("request.getContentType() = "+ request.getContentType());
        System.out.println("request.getContentLength() = "+ request.getContentLength());
        System.out.println("request.getCharacterEncoding() = "+ request.getCharacterEncoding());

        System.out.println("----Header Utils 조회 end ----");
        System.out.println();
    }

    private void printHeaders(HttpServletRequest request) {
        System.out.println("-----Headers start------");

//        Enumeration<String> headerNames = request.getHeaderNames();
//        while(headerNames.hasMoreElements()){
//            String headerName = headerNames.nextElement();
//            System.out.println(headerName+" : "+ request.getHeader(headerName));
//        }

        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println(headerName+" : "+request.getHeader(headerName)));

        System.out.println("하나의 헤더정보  = " + request.getHeader("host"));
        System.out.println("-----Headers end ------");
        System.out.println();
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
