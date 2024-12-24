package com.wlopezob.api_data_v1.controller;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/hello")
public class HelloController {

  @GetMapping
  public Mono<String> hello() {
    Function<Integer, Integer> sumar = (a) -> a + 2;
    Predicate<Integer> esPar = (a) -> a % 2 == 0;
    Consumer<Integer> imprimir = (a) -> System.out.println(a);
    imprimir.accept(sumar.apply(2));
    sumar2(sumar, 2, 2);
    return Mono.just("Hello World: " + esPar.test(sumar.apply(2)));
  }

  int sumar(int a, int b) {
    return a + b;
  }

  int sumar2(Function<Integer, Integer> suma, int a, int b) {
    return suma.apply(a) + b;
  }
  
}
