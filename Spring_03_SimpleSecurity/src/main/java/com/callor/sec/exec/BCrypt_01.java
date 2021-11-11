package com.callor.sec.exec;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BCrypt_01 {
    public static void main(String[] args) {

        // BCryptPasswordEncoder() -> applicationContext.xml에 설정해놓은 친구.
        PasswordEncoder pass = new BCryptPasswordEncoder(4);
        String password = "12345";
        String encPassword = "$2a$10$AGnTrYuKlKkr7438t6jf2.idhQFDGRshjtqr0uKSoCtRt.3NA7mC2";

        String bcPassword = pass.encode(password);
        System.out.println("생성된 문자열: " + bcPassword);
        System.out.println("생성된 문자열의 길이: " + bcPassword.length());

        // password와 encPassword를 비교해서 같을 경우 true를 return.?
        // matches(rowPassword, encPassword)
        boolean loginOk = pass.matches(password, encPassword);

        if(loginOk) {
            System.out.println("맞았습니다");
        } else {
            System.out.println("틀렸습니다");
        }
    }
}
