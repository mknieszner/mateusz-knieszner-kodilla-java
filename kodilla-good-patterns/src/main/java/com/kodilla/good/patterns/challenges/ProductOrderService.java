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
        boolean isOrderValid = orderService.validate(
                orderRequest.getUser(),
                orderRequest.getItemName());

        if (isOrderValid) {
            informationService.inform(orderRequest.getUser());
            productRegistry.createOrder(orderRequest.getUser(),
                orderRequest.getItemName());
        return new OrderDto(orderRequest.getUser(), true);
    } else {
        return new OrderDto(orderRequest.getUser(), false);
    }
    }
}

