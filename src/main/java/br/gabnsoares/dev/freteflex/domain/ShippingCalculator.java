package br.gabnsoares.dev.freteflex.domain;

public interface ShippingCalculator {

    Double calculate(Double distance, Double weight);
}
