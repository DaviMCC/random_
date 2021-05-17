package com.example.demo.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    @Cacheable(value = "hello")             //quando o /hello é requisitado
    public String hello(){                  //guarda o return do metodo hello no cache hello
        System.out.println("Cacheando");
            return "Hello";
    }

    @GetMapping("/cancel")                  //quando o /cancel é requisitado
    @CacheEvict("hello")                    //limpa o que tá no cache hello
    public String cancel () {
        System.out.println("Limpando o cache");
        return "Cache Cancelado";
    }
}
