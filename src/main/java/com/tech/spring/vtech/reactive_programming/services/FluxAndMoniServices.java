package com.tech.spring.vtech.reactive_programming.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxAndMoniServices {

    public Flux<String> fruitsFlux() {
        return Flux.fromIterable(List.of("Mango","Apple","Banana")).log();
    }

    public Flux<String> fruitsFluxMap() {
        return Flux.fromIterable(List.of("Mango","Apple","Banana"))
                .map(String::toUpperCase)
                .log();
    }

    public Mono<String> fruitMono(){
        return Mono.just("mango").log();
    }

    public Flux<String> fruitsFluxFilter(int number){
        return Flux.fromIterable(List.of("Mango","Apple","Banana")).filter(s->s.length()>number).log();
    }


    public Flux<String> fruitsFluxFilterAndMap(int number){
        return Flux.fromIterable(List.of("Mango","Apple","Banana")).filter(s->s.length()>number).map(String::toUpperCase).log();
    }

    public static void main(String[] args) {
        FluxAndMoniServices fluxAndMoniServices=new FluxAndMoniServices();
        fluxAndMoniServices.fruitsFlux().subscribe(s -> {
            System.out.println("s = "+s);
        });

        fluxAndMoniServices.fruitMono().subscribe(s ->{
            System.out.println("s MONO= "+s);
        });

        fluxAndMoniServices.fruitsFluxMap().subscribe(s->{
            System.out.println("s= "+s);
        });

        fluxAndMoniServices.fruitsFluxFilter(5).subscribe(s -> {
            System.out.println("s = "+s);
        });

        fluxAndMoniServices.fruitsFluxFilterAndMap(5).subscribe(s -> {
            System.out.println("s= "+s);
        });
    }
}
