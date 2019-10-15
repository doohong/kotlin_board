package com.doohong.kotlin.board

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BoardController{
    @GetMapping(value="/")
    fun getBoard(): String {
        return "hello world"
    }
}