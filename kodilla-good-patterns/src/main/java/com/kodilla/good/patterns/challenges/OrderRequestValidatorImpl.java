package com.kodilla.good.patterns.challenges;

/**
 * OrderService interface implementation.
 */
class OrderRequestValidatorImpl implements OrderRequestValidator {
    private final OrderValidator orderValidator = new OrderValidatorImpl();
    private final UserValidator userValidator = new UserValidatorImpl();

    @Override
    public boolean validate(final OrderRequest orderRequest) {
        return orderValidator.validate(orderRequest.getOrder())
                && userValidator.validate(orderRequest.getUser());
    }
}
