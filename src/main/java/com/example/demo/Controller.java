package com.example.demo;

import java.lang.String;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(path="/")
public class Controller{

    @GetMapping(path="/")
    public String home(){
        return "AT70392439 - Claudio Jara";
    }

    @GetMapping(path="/idat/codigo")
    public String cod(){
        return "AT70392439";
    }

    @GetMapping(path="/idat/nombre-completo")
    public String nombrecompleto(){
        return "Claudio Arturo Jara Almonacid Jara";
    }

}   