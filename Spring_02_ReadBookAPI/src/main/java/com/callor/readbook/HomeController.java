package com.callor.readbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    Logger logger = LoggerFactory.getLogger(HomeController.class);

    // 문자열 변수에 Autowiring하는 것
    // @Value(): Controller에서 조회 가능하게 하는 것
    // @Value("${props.username}")
    private String userName;
    // @Value("${props.password}")
    private String password;
    // @Value("${props.driver}")
    private String className;
    // @Value("${props.url}")
    private String url;

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {

        logger.debug("여기는 홈입니다");

        // return "HOME";
        // return "여기는 Home!!";
        // return "home/home";
        return String.format("username: %s \n password: %s \n url: %s \n driverClassName: %s", userName, password, url, className);
    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    // tiles-layout.xml이 먼저 받기 때문에
    // book/list.jsp가 아닌
    // tiles-layout.xml에 설정해놓은 name이 받아진다.
    public String book() {
        return "book/list";
    }

    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String write() {
        return "read/write";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search() {
        return "api/jusoSearch";
    }

    @RequestMapping(value = "/popup", method = RequestMethod.GET)
    public String popup() {
        return "api/jusoPopup";
    }

}
