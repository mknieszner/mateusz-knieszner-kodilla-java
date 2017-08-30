package com.kodilla.good.patterns.challenges;

/**
 * Order Service class.
 */
public class ProductOrderService {

    private InformationService informationService;
    private OrderRequestValidator orderRequestValidator;
    private ProductRegistry productRegistry;

    public ProductOrderService(final InformationService informationService,
                               final OrderRequestValidator orderRequestValidator,
                               final ProductRegistry productRegistry) {
        this.informationService = informationService;
        this.orderRequestValidator = orderRequestValidator;
        this.productRegistry = productRegistry;
    }

    public OrderDto process(final Request orderRequest) {
        boolean isOrderValid = orderRequestValidator
                .validate(orderRequest);

        if (isOrderValid) {
            informationService.inform(orderRequest);
            productRegistry.createOrder(orderRequest);
            return new OrderDto(orderRequest.getUserName(), true);
        } else {
            return new OrderDto(orderRequest.getUserName(), false);
        }
    }
}

