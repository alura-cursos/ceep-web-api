package br.com.alura.ceep.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class MainController {

    @GetMapping
    fun home(): String {
        return "index.html"
    }

}