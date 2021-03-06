package com.callor.student.controller;

import com.callor.student.model.StudentVO;
import com.callor.student.service.impl.StService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class StController2 {

    // interface로 선언만 하기
    // @Autowired
    private StService stService;

    // setter()를 통해서 객체를 주입받도록 하기기
    public void setStService(StService stService) {
        this.stService = stService;
    }

    public void list() {
        List<StudentVO> stList = stService.selectAll();

        for (StudentVO vo : stList) {
            log.debug(vo.toString());
        }
    }
}
