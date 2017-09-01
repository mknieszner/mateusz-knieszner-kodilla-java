package com.kodilla.good.patterns.challenges;

/**
 * Order Service class.
 */
public class ProductOrderService {

  private InformationService informationService;
  private OrderValidator orderValidator;
  private ProductRegistry productRegistry;

  public ProductOrderService(final InformationService informationService,
                             final OrderValidator orderValidator,
                             final ProductRegistry productRegistry) {
    this.informationService = informationService;
    this.orderValidator = orderValidator;
    this.productRegistry = productRegistry;
  }

  public OrderConfirmationDto process(final ProcessOrderDto processOrderDto) {
    boolean isOrderValid = orderValidator.validate(processOrderDto);

    if (isOrderValid) {
      informationService.inform(processOrderDto);
      productRegistry.createOrder(processOrderDto);
      return new OrderConfirmationDto(processOrderDto.getUsername(), true);
    } else {
      return new OrderConfirmationDto(processOrderDto.getUsername(), false);
    }
  }
}

