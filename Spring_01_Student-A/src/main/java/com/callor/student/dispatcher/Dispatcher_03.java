package com.callor.student.dispatcher;

import com.callor.student.controller.StController3;
import com.callor.student.service.impl.StService;
import com.callor.student.service.impl.StService2;

public class Dispatcher_03 {
    public static void main(String[] args) {
        // 생성자 주입 방식
        StService stService= new StService2();
        StController3 stController = new StController3(stService);

        stController.list();
    }
}
