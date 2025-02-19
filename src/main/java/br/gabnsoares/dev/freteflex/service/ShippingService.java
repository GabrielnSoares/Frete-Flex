package br.gabnsoares.dev.freteflex.service;

import br.gabnsoares.dev.freteflex.domain.ExpressShippingCalculator;
import br.gabnsoares.dev.freteflex.domain.StandardShippingCalculator;
import org.springframework.stereotype.Service;

@Service  // bean controlado pelo spring container
public class ShippingService {

    private final StandardShippingCalculator standardShippingCalculator;
    private final ExpressShippingCalculator expressShippingCalculator;

    public ShippingService(StandardShippingCalculator standardShippingCalculator, ExpressShippingCalculator expressShippingCalculator) {
        this.standardShippingCalculator = standardShippingCalculator;
        this.expressShippingCalculator = expressShippingCalculator;
    }

    public Double calculate(String shippingType,
                            Double distance,
                            Double weight) {
        if (shippingType.equalsIgnoreCase("standard")) {
            return standardShippingCalculator.calculate(distance, weight);
        } else if (shippingType.equalsIgnoreCase("express")) {
            return expressShippingCalculator.calculate(distance,weight);
        }

        return null;
    }
}
