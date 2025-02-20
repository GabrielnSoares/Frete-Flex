package br.gabnsoares.dev.freteflex.domain;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component(value = "standardShippingCalculator")
@Primary // implementacao padrão
public class StandardShippingCalculator implements ShippingCalculator {

    @Override
    public Double calculate(Double distance, Double weight) {
        return weight * 1.0 + distance * 0.5;
    }
}
