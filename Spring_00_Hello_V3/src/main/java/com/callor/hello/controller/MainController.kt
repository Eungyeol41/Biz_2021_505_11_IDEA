package com.callor.hello.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class MainController {

    @ResponseBody
    @RequestMapping(value = ["/main"], method = [RequestMethod.GET])
    fun main():String {
        return "Kotlin Controller"
    }
}