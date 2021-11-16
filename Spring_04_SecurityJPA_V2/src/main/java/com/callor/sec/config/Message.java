package com.callor.sec.config;

public class Message {

    public static class ERROR {
        public final static String BadCredentials = "ID나 비밀번호가 맞지 않습니다. 다시 확인해주세요.";
        public final static String Disabled = "계정이 비활성화되었습니다. 관리자에게 문의하세요.";
        public final static String CredentialsExpired = "비밀번호 유효기간이 만료되었습니다. 비밀번호를 변경해주세요.";
        public final static String Locked = "계정이 잠겨있습니다. 관리자에게 문의하세요.";
        public final static String AccountExpired = "계정 사용기한이 만료되었습니다. 관리자에게 문의하세요";
        public final static String SessionAuthentication = "인증 세션에 문제가 있습니다. 관리자에게 문의하세요.";
    }

}
