package br.gabnsoares.dev.freteflex.controller;

import br.gabnsoares.dev.freteflex.controller.dto.ShippingResponse;
import br.gabnsoares.dev.freteflex.service.ShippingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // configurando api para usuários
public class ShippingController {

   // @Autowired // indicando para o spring fazer injecao de dependencia, mas nao a mais recomendada
   // private ShippingService shippingService;

    private final ShippingService shippingService;

    // forma mais recomendada para fazer injeção de dependencia
    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }


    @GetMapping(value ="/shipping/calculate") // consultas metodo
    public ResponseEntity<ShippingResponse> calculate(@RequestParam("type") String shippingType,
                                                      @RequestParam("distance") Double distance,
                                                      @RequestParam("weight") Double weight) {

        var cost = shippingService.calculate(shippingType, distance, weight);

        return ResponseEntity.ok(new ShippingResponse(cost));
    }
}
