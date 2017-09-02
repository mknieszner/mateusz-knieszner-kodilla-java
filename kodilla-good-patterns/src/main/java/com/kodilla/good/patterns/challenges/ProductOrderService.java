package com.kodilla.good.patterns.challenges;

/**
 * Order Service class.
 */
public class ProductOrderService {

  private final InformationService informationService;
  private final OrderValidator orderValidator;
  private final ProductRegistry productRegistry;

  public ProductOrderService(final InformationService informationService,
                             final OrderValidator orderValidator,
                             final ProductRegistry productRegistry) {
    this.informationService = informationService;
    this.orderValidator = orderValidator;
    this.productRegistry = productRegistry;
  }

  public OrderConfirmationDto process(final OrderRequest orderRequestDto) {
    final boolean isOrderValid = orderValidator.validate(orderRequestDto);

    if (isOrderValid) {
      informationService.inform(orderRequestDto);
      productRegistry.createOrder(orderRequestDto);
      return new OrderConfirmationDto(orderRequestDto.getUsername(), true);
    } else {
      return new OrderConfirmationDto(orderRequestDto.getUsername(), false);
    }
  }
}

