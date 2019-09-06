package com.alexcompany.springsecurity.validator;

import com.alexcompany.springsecurity.dto.ProductDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductValidator implements ConstraintValidator<ProductValid, ProductDto> {
    @Override
    public boolean isValid(ProductDto productDto, ConstraintValidatorContext constraintValidatorContext) {
        if (productDto.getProductName().isEmpty()) {
            productDto.setInvalidProductName("Product Name cannot be empty!");
            return false;
        }
        if (productDto.getAmount() < 0) {
            productDto.setInvalidAmount("Amount cannot be negative");
            return false;
        }
        if (productDto.getPrice() <= 0) {
            productDto.setInvalidPrice("Price cannot be negative or zero");
        }
        return true;
    }

    @Override
    public void initialize(ProductValid constraintAnnotation) {

    }
}
