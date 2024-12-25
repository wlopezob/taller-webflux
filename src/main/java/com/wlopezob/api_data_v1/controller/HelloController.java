package com.wlopezob.api_data_v1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/hello")
public class HelloController {

  @GetMapping
  public Mono<String> hello() {
    return Mono.just("Hello World");
  }
}
