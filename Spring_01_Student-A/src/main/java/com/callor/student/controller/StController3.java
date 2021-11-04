package com.callor.student.controller;

import com.callor.student.model.StudentVO;
import com.callor.student.service.StService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class StController3 {

    // interface로 선언만 하기
    private final StService stService;
    // 생성자
    public StController3(StService stService) {
        this.stService = stService;
    }

    public void list() {
        List<StudentVO> stList = stService.selectAll();

        for (StudentVO vo : stList) {
            log.debug(vo.toString());
        }
    }
}
