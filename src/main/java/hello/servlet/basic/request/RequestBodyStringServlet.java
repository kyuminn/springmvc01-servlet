package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
// httpBody안에 직접 넣어서 전송한 데이터 받아보기
@WebServlet(name="requestBodyStringServlet",urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // inputStream으로 HttpBody 안의 데이터를 읽어들일 수 있음.
        ServletInputStream inputStream = request.getInputStream();// message body의 내용을 byte code로 바꿀수 있음
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);// byte code -> String

        System.out.println("messageBody = "+ messageBody);
        response.getWriter().write("ok");
    }
}
