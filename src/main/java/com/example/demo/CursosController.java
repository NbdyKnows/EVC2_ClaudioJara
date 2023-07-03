package com.example.demo;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.lang.String;
import java.lang.Object;


@Controller // This means that this class is a Controller
@RequestMapping(path="/api/curso") 
public class CursosController {
    @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
    private CursosRepository userRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping(path="/listar") //GET http://localhost:8080/demo/add
    public @ResponseBody Iterable<Cursos> getAllSubjects() {
        return userRepository.findAll();
    }

    @PostMapping(path="/nuevo") //POST http://localhost:8080/demo/add
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam int creditos) {
    Cursos n = new Cursos();
    n.setNombre(name);
    n.setCreditos(creditos);
    userRepository.save(n);
    return "Saved";
    }

    @DeleteMapping(path = "/eliminar ")
    public @ResponseBody String deleteUser(@RequestParam Integer id){
        Cursos user = userRepository.findById(id).orElse(null);
        if(user != null){
            userRepository.delete(user);
            return "Deleted";
        }
        return "Not Found";
    }

    @GetMapping(path="/get/report")
    public @ResponseBody List getReport() {
        String sql = "SELECT CONCAT(nombre, ' ==> ', creditos) as reporte FROM cursos";
        List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql);
        return queryResult;
    }

}