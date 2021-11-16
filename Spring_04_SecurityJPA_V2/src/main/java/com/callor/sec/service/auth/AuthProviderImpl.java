package com.callor.sec.service.auth;


import com.callor.sec.models.UserDetailsVO;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Login을 수행하는 절차의 일부를 가로채서 customizing하기
 */
@Service("authenticationProvicer")
public class AuthProviderImpl implements AuthenticationProvider {

    private final LoginService lService;
    private final PasswordEncoder passwordEncoder;
    public AuthProviderImpl(LoginService lService, PasswordEncoder passwordEncoder) {
        this.lService = lService;
        this.passwordEncoder = passwordEncoder;
    }


    /**
     * 사용자 이름, 비밀번호 검증 등을 자체적으로 수행하는 코드
     * Spring Security에서 제공하는 기본 Provider를 가로채서 코드를 수행한다.
     *
     * 정상적으로 로그인이 수행되면 (username, password 검증 완료)
     * 반드시 UsernamePasswordAuthenticationToken 객체를 return해야 한다
     * 이 객체에는 username, password, Roles 정보가 포함되어야한다.
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        // login.jsp에서 POST로 전달받은 username, password
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        /**
         * login한 사용자 정보를 DB로부터 가져오기
         * loadUserByUsername() method에서는 DB로부터 findById()를 수행하여
         *  사용자 정보를 fetch하고, username을 검증한 상태이다.
         */
        UserDetailsVO userVO = (UserDetailsVO) lService.loadUserByUsername(username);

        // 사용자 정보 한 단계씩 검증하기
        // Enable이 false로 되어있으면
        if(!userVO.isEnabled()) {
            throw new DisabledException(username);
        }

        if (!userVO.isAccountNonExpired()) {
            throw new AccountExpiredException(username);
        }

        if(!userVO.isAccountNonLocked()) {
            throw new LockedException(username);
        }

        if(!userVO.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException(username);
        }

        // password에 문제가 생기면
        if (!passwordEncoder.matches(password, userVO.getPassword())) {
            throw new BadCredentialsException(username);
        }

        return new UsernamePasswordAuthenticationToken(username, password, userVO.getAuthorities());

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
