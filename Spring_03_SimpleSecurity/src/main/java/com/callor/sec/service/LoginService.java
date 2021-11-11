package com.callor.sec.service;

import com.callor.sec.models.UserDetailsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Security에서 login 서버를 수행하는 방법이 다양하다
 *
 * DB와 연동을 하여 로그인을 수행하는 비교적 쉬운 방법으로 UserDetailsService를 상속받아 클래스를 만들고 수행한다
 */
@Slf4j
public class LoginService implements UserDetailsService {

    public final String encPassword = "$2a$04$Mycjo87tbNxERHlUIRlJl.CoD01MtyhQn2uUmYlkVCZvjJs7lBV9.";
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 1. dao에서 사용자 정보 가져오기
        //      username으로 member table에서 findById(username) 등을 수행하여 User 정보를 가져온다.
        UserDetailsVO userVO = UserDetailsVO.builder()
                .username("callor")
                // .password("{noop}1234")
                .password(encPassword)
                .isAccountNonExpired(true)
                .isEnabled(true)
                .isCredentialsNonExpired(true)
                .isAccountNonLocked(true)
                .build();

        // 2. dao에서 받은 사용자 정보가 없으면
        //      즉, username에 저장된 사용자 이름이 DB에 없으면 강제로 Exception 발생하게 하여 Security에 알려준다
        if(userVO == null) {
            log.debug("{} username 없음", username);

            throw new UsernameNotFoundException(username + " 사용자 없음");
        }

        // ==================================================
        // security에 내장된 코드
        // 요론 식으로 들어가 있을 것이다!!
        /*
        try {
            UserDetails vo = loadUserByUsername("callor");
        } catch (UsernameNotFoundException e) {
            // redirect "/member/login?error=xxxx";
        }
        */
        // ==================================================

        return userVO;
    }
}
