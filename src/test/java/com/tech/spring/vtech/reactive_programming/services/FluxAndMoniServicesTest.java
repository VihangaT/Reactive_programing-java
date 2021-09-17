package com.tech.spring.vtech.reactive_programming.services;

//import lombok.var;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class FluxAndMoniServicesTest {

    FluxAndMoniServices fluxAndMoniServices=new FluxAndMoniServices();
    @Test
    void fruitsFlux() {
        var fruitFlux=fluxAndMoniServices.fruitsFlux();
        StepVerifier.create(fruitFlux).expectNext("Mango","Apple","Banana").verifyComplete();
    }

    @Test
    void fruitMono() {
        var fruitMono=fluxAndMoniServices.fruitMono();

        StepVerifier.create(fruitMono).expectNext("mango").verifyComplete();
    }
}