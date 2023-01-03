package hello.servlet.basic.response;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="responseHeaderServlet",urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // [status-line]
        response.setStatus(HttpServletResponse.SC_OK); // Http Status Code

        // [response-header]
        response.setHeader("Content-Type","text/plain;charset=utf-8");
        response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); // 캐시 무효화
        response.setHeader("Pragma","no-cache"); // 과거의 캐시까지 무효화
        response.setHeader("my-header","hello header! ");
        // [Header 편의 메서드]
//        content(response);
//        cookie(response);
        redirect(response);
        PrintWriter writer = response.getWriter();
        writer.write("안녕하세요 Response Header ");

    }

    private void content(HttpServletResponse response){
//        response.setHeader("Content-Type","text/plain;charset=utf-8");
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
//        response.setContentLength(2); //(생략 시 자동 생성)
    }

    private void cookie(HttpServletResponse response){
        // Set-Cookie : myCookie=good; Max-Age=600;
        // response.setHeader("Set-Cookie","myCookie=good; Max-Age=600");
        // 위와 같은 방법으로 쿠키를 헤더에 보낼 수 있지만 제공되는 Cookie 객체를 통해 아래와 같이 편리하게 할 수 있음
        // 최초로 쿠키는 서버에서 생성, 그 이후에 response에 해당 쿠키를 담아서 브라우저에 전송
        // 이후 브라우저는 쿠키를 저장하고 있다가 서버에 요청할 때마다 request header에 해당 쿠키를 담아 서버로 전송
        Cookie cookie = new Cookie("myCookie","good");
        cookie.setMaxAge(600); // 600초
        response.addCookie(cookie);
    }

    private void redirect(HttpServletResponse response) throws IOException {
//        Status Code 302
//        Location : /basic/hello-form.html

//        response.setStatus(HttpServletResponse.SC_FOUND); //302
//        response.setHeader("Location","basic/hello-form.html");
        // 위 두 줄 대신 아래 한줄로 간편하게 redirect 가능
        response.sendRedirect("/basic/hello-form.html");
    }
}
