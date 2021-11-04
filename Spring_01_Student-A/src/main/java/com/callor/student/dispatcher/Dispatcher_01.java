package com.callor.student.dispatcher;

import com.callor.student.controller.StController;

public class Dispatcher_01 {
    public static void main(String[] args) {
        StController stController = new StController();
        stController.list();
    }
}
