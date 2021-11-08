package com.callor.student.controller;

import com.callor.student.model.StudentVO;
import com.callor.student.service.StudentService;
import com.callor.student.service.impl.StService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController {

    /**
     * 현재 방식은 setter 주입방식으로 객체를 DI하기
     * 메모리 누수가 발생한다고 보고되었고 생성자 주입 방식에 비해서 NullPointException이 발생할 확률도 있다고 한다
     *
     */
    // @Autowired
    // private StudentService stService;

    /**
     * 생성자 주입 방식
     * 1. 주입받을 객체를 선언(가급적 interface로)
     * private StudentService stService;
     * 2. final 선언을 하여 불변 객체로 변환한다.
     * private final StudentService stService;
     * 3. 생성자 method를 선언
     * public StudentController(StudentService stService) { this.stService = stService; }
     * <p>
     * 생성자 주입방식은 setter 주입 방식에 비해 더 강력한 강제성을 갖는다.
     */
    private final StudentService stService;

    public StudentController(StudentService stService) {
        this.stService = stService;
    }

    //    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public List<StudentVO> list(Model model) {
    public String list(Model model) {
        List<StudentVO> stList = stService.selectAll();
        model.addAttribute("STLIST", stList);

        return "layout";
//        return "student/list";
//        return stList;
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String details() {
        return "ST_DETAIL";
    }

}
// Controller와 Autowired를 붙였기 때문에 Spring에서 알아서 챙겨서 객체를 주입해준다...?