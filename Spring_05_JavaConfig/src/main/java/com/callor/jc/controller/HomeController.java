package com.callor.jc.controller;

import com.callor.jc.repository.BookDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    private final BookDao bookDao;
    public HomeController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

//    @ResponseBody

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String home() {
        bookDao.selectAll();

        return "home";
    }

}
