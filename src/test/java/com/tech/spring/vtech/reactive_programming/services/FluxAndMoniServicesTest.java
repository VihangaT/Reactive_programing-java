package com.tech.spring.vtech.reactive_programming.services;

//import lombok.var;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class FluxAndMoniServicesTest {

    FluxAndMoniServices fluxAndMoniServices = new FluxAndMoniServices();

    @Test
    void fruitsFlux() {
        var fruitFlux = fluxAndMoniServices.fruitsFlux();
        StepVerifier.create(fruitFlux).expectNext("Mango", "Apple", "Banana").verifyComplete();
    }

    @Test
    void fruitMono() {
        var fruitMono = fluxAndMoniServices.fruitMono();

        StepVerifier.create(fruitMono).expectNext("mango").verifyComplete();
    }

    @Test
    void fruitsFluxMap() {
        var fruitFluxMap = fluxAndMoniServices.fruitsFluxMap();
        StepVerifier.create(fruitFluxMap).expectNext("MANGO", "APPLE", "BANANA").verifyComplete();
    }

    @Test
    void fruitsFluxFilter() {
        var fruitsFluxFilter = fluxAndMoniServices.fruitsFluxFilter(5);
        StepVerifier.create(fruitsFluxFilter).expectNext("Banana").verifyComplete();
    }

    @Test
    void fruitsFluxFilterAndMap() {
        var fruitsFluxMapAndFilter = fluxAndMoniServices.fruitsFluxFilterAndMap(5);
        StepVerifier.create(fruitsFluxMapAndFilter).expectNext("BANANA").verifyComplete();
    }

    @Test
    void fruitsFluxFlatMap() {
        var fruitsFluxFlatMap = fluxAndMoniServices.fruitsFluxFlatMap();
        StepVerifier.create(fruitsFluxFlatMap).expectNextCount(16).verifyComplete();
    }

    @Test
    void fruitsFluxFlatMapAsync() {
        var fruitsFluxFlatMapAsync = fluxAndMoniServices.fruitsFluxFlatMapAsync();
        StepVerifier.create(fruitsFluxFlatMapAsync).expectNextCount(16).verifyComplete();
    }

    @Test
    void fruitsFluxConcatMap() {
        var fruitsFluxConcatMap = fluxAndMoniServices.fruitsFluxConcatMap();
        StepVerifier.create(fruitsFluxConcatMap).expectNextCount(16).verifyComplete();

    }

    @Test
    void fruitsFluxFlatMapMany() {
        var fruitsFluxFlatMapMany = fluxAndMoniServices.fruitsFluxFlatMapMany();
        StepVerifier.create(fruitsFluxFlatMapMany).expectNextCount(5).verifyComplete();
    }

    @Test
    void fruitsFluxTransform() {
        Flux<String> fruitsFluxFilter;
        fruitsFluxFilter = fluxAndMoniServices.fruitsFluxTransform(5);
        StepVerifier.create( fruitsFluxFilter).expectNext("Banana").verifyComplete();
    }

    @Test
    void main() {
    }

    @Test
    void fruitsFluxTransformDefaultIFEmplty() {
        Flux<String> fruitsFluxFilter;
        fruitsFluxFilter = fluxAndMoniServices.fruitsFluxTransformDefaultIFEmplty(15);
        StepVerifier.create( fruitsFluxFilter).expectNext("Default").verifyComplete();
    }

    @Test
    void fruitsFluxTransformSwitchIfEmpty() {
        Flux<String> fruitsFluxFilter = fluxAndMoniServices.fruitsFluxTransformSwitchIfEmpty(8);
        StepVerifier.create( fruitsFluxFilter).expectNext("Cake Curry Pasta","Orange Shake").verifyComplete();
    }
}