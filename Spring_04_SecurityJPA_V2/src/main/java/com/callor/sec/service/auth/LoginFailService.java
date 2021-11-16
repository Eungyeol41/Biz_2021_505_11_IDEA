package com.callor.sec.service.auth;

import com.callor.sec.config.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Service("loginFailService")
public class LoginFailService implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        log.debug("Login 실패 처리 시작");
        log.debug("Exception: {}", exception.getClass().getName());

        String exceptionClassName = exception.getClass().getName();
        // 어떤 문제가 발생하여 LoginFail이 작동되었는 지를 알기 위해
        // 1. exception의 클래스 이름을 문자열로 비교하여 정체 파악하기
        //      type 오류로 인한 문제를 일으킬 수 있다.
        if (exceptionClassName.equalsIgnoreCase("CredentialsExpiredException")) {

        }

        // 2. exception 객체가 어떤 클래스의 인스턴스인가를 알아보고 exception의 정체 파악하기
        //      최소한 type 오류는 발생하지 않는다.
        String error_msg = "";
        // exception이 CredentialsExpiredException이냐?
        if (exception instanceof CredentialsExpiredException) {
            error_msg = Message.ERROR.CredentialsExpired;
        } else if (exception instanceof AccountExpiredException) {
            error_msg = Message.ERROR.AccountExpired;
        } else if (exception instanceof DisabledException) {
            error_msg = Message.ERROR.Disabled;
        } else if (exception instanceof LockedException) {
            error_msg = Message.ERROR.Locked;
        } else if (exception instanceof SessionAuthenticationException) {
            error_msg = Message.ERROR.SessionAuthentication;
        } else {
            error_msg = Message.ERROR.BadCredentials;
        }

        /**
         * /member/login URL은 login.jsp를 열기 위한 요청(GET)
         * login.jsp에서 "로그인" 버튼 클릭(-- submit) 하면 /login URL로 요청이 전달된다.(POST)
         *
         * 로그인이 실패했을 때 다시 /member/login으로 forwarding 수행
         * 이 때 /member/login은 POST 방식으로 호출이 된다.
         */

        request.setAttribute("ERROR_MSG", error_msg);
        request.setAttribute("AUTHOR", "iniziato@naver.com");
        // 위의 ERROR_MSG를 같이 담아서 가기 위해서 forwarding 하기!
        // /member/login URL로 forwarding 수행하라
        // redirect가 아닌 forwarding
        request.getRequestDispatcher("/member/login?error").forward(request, response);

    }
}
