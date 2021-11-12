package com.callor.sec.controller;


import com.callor.sec.models.UserDetailsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping(value="/member")
public class MemberController {

    // login form 을 열기 위한 URL
    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String login() {
        return "member/login";
    }

    @RequestMapping(value="/join", method= RequestMethod.GET)
    public String join() {
        return "member/join";
    }

    @RequestMapping(value="/join", method= RequestMethod.POST)
    public String join(UserDetailsVO userVO) {

        log.debug("회원가입: {}", userVO.toString());

        return "redirect:/member/login";
    }

    @ResponseBody
    @RequestMapping(value = "/idcheck", method = RequestMethod.GET)
    public String idCheck(String username) {
        if(username.equalsIgnoreCase("callor")) {
            return "FAIL";
        } else {
            return null;
        }
    }

}
