package com.kodilla.good.patterns.challenges;

/**
 * OrderService interface implementation.
 */
class OrderValidatorImpl implements OrderValidator {
    private final ProductValidator productValidator = new ProductValidatorImpl();
    private final UserValidator userValidator = new UserValidatorImpl();

    @Override
    public boolean validate(final OrderRequest orderDto) {
        return productValidator.validate(orderDto.getProductList())
                && userValidator.validate(orderDto.getUser());
    }
}