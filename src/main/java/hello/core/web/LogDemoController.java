package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final ObjectProvider<MyLogger> myLoggerProvider;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) throws InterruptedException { // java에서 제공하는 표준서블릿규약에 의해 Http request 정보를 받을 수 있음
        String requestURL = request.getRequestURL().toString();
        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
//        Thread.sleep(1000); // 1초 슬립을 걸면 동시 요청(새로고침 파바박) 시에 위 로그 먼저 찍힌 뒤 1초 뒤에 서비스 로그 찍히는 것 확인 가능
        logDemoService.logic("testId");

        return "OK";
    }
}
