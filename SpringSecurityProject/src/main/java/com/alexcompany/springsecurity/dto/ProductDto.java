package com.alexcompany.springsecurity.dto;

import com.alexcompany.springsecurity.validator.ProductValid;
import org.springframework.validation.annotation.Validated;

@Validated
@ProductValid
public class ProductDto {

    private String productName;
    private Integer price;
    private Integer amount;
    private String description;
    private String manufacturer;

    private String invalidProductName;
    private String invalidPrice;
    private String invalidAmount;

    public ProductDto() {
    }

    public String getInvalidProductName() {
        return invalidProductName;
    }

    public void setInvalidProductName(String invalidProductName) {
        this.invalidProductName = invalidProductName;
    }

    public String getInvalidPrice() {
        return invalidPrice;
    }

    public void setInvalidPrice(String invalidPrice) {
        this.invalidPrice = invalidPrice;
    }

    public String getInvalidAmount() {
        return invalidAmount;
    }

    public void setInvalidAmount(String invalidAmount) {
        this.invalidAmount = invalidAmount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
