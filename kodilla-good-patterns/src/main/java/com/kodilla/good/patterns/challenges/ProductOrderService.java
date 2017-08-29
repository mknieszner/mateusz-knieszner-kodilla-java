package com.kodilla.good.patterns.challenges;

/**
 * Order Service class.
 */
public class ProductOrderService {

    private InformationService informationService;
    private OrderService orderService;
    private ProductRegistry productRegistry;

    public ProductOrderService(InformationService informationService,
                               OrderService orderService,
                               ProductRegistry productRegistry) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.productRegistry = productRegistry;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isOrderValid = orderService
                .validate(orderRequest);

        if (isOrderValid) {
            informationService.inform(orderRequest);
            productRegistry.createOrder(orderRequest);
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}

