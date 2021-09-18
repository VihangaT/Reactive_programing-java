package com.tech.spring.vtech.reactive_programming.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class FluxAndMoniServices {

    public Flux<String> fruitsFlux() {
        return Flux.fromIterable(List.of("Mango", "Apple", "Banana")).log();
    }

    public Flux<String> fruitsFluxMap() {
        return Flux.fromIterable(List.of("Mango", "Apple", "Banana"))
                .map(String::toUpperCase)
                .log();
    }

    public Mono<String> fruitMono() {
        return Mono.just("mango").log();
    }

    public Flux<String> fruitsFluxFilter(int number) {
        return Flux.fromIterable(List.of("Mango", "Apple", "Banana")).filter(s -> s.length() > number).log();
    }


    public Flux<String> fruitsFluxFilterAndMap(int number) {
        return Flux.fromIterable(List.of("Mango", "Apple", "Banana")).filter(s -> s.length() > number).map(String::toUpperCase).log();
    }

    public Flux<String> fruitsFluxFlatMap() {
        return Flux.fromIterable(List.of("Mango", "Apple", "Banana")).flatMap(s -> Flux.just(s.split(""))).log();
    }

    public Flux<String> fruitsFluxFlatMapAsync() {
        return Flux.fromIterable(List.of("Mango", "Apple", "Banana")).flatMap(s -> Flux.just(s.split(""))).delayElements(Duration.ofMillis(new Random().nextInt(1000))).log();
    }

    public Flux<String> fruitsFluxConcatMap() {
        return Flux.fromIterable(List.of("Mango", "Apple", "Banana")).concatMap(s -> Flux.just(s.split("")))
                .delayElements(Duration.ofMillis(new Random().nextInt(1000)))
                .log();
    }

    public Flux<String> fruitsFluxFlatMapMany() {
        return Mono.just("Mango").flatMapMany(s -> Flux.just(s.split("")))
                .log();
    }

    public Flux<String> fruitsFluxTransform(int number) {
        Function<Flux<String>, Flux<String>> filterData = data -> data.filter(s -> s.length() > number);
        return Flux.fromIterable(List.of("Mango", "Apple", "Banana"))
                .transform(filterData).log();
    }

    public Flux<String> fruitsFluxTransformDefaultIFEmplty(int number) {
        Function<Flux<String>, Flux<String>> filterData = data -> data.filter(s -> s.length() > number);
        return Flux.fromIterable(List.of("Mango", "Apple", "Banana"))
                .transform(filterData)
                .defaultIfEmpty("Default")
                .log();
    }


    public Flux<String> fruitsFluxTransformSwitchIfEmpty(int number) {
        Function<Flux<String>, Flux<String>> filterData = data -> data.filter(s -> s.length() > number);
        return Flux.fromIterable(List.of("Mango", "Apple", "Banana"))
                .transform(filterData)
                .switchIfEmpty(Flux.just("Cake Curry Pasta","Orange Shake"))
                .transform(filterData)
                .log();
    }

    public static void main(String[] args) {
        FluxAndMoniServices fluxAndMoniServices = new FluxAndMoniServices();
        fluxAndMoniServices.fruitsFlux().subscribe(s ->System.out.println("s = " + s));

        fluxAndMoniServices.fruitMono().subscribe(s -> System.out.println("s MONO= " + s));

        fluxAndMoniServices.fruitsFluxMap().subscribe(s -> System.out.println("s= " + s));

        fluxAndMoniServices.fruitsFluxFilter(5).subscribe(s -> System.out.println("s = " + s));

        fluxAndMoniServices.fruitsFluxFilterAndMap(5).subscribe(s ->System.out.println("s= " + s));

        fluxAndMoniServices.fruitsFluxFlatMap().subscribe(s -> System.out.println("s= " + s));

        fluxAndMoniServices.fruitsFluxFlatMapAsync().subscribe(s -> System.out.println("s= " + s));

        fluxAndMoniServices.fruitsFluxConcatMap().subscribe(s -> System.out.println("s= " + s));

        fluxAndMoniServices.fruitsFluxFlatMapMany().subscribe(s -> System.out.println("s= " + s));

        fluxAndMoniServices.fruitsFluxTransformSwitchIfEmpty(45).subscribe(s -> System.out.println("s= " + s));
    }
}
