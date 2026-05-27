package com.orderservice.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {

    private Long addressId;

    private String streetName;

    private String cityName;

    private String stateName;

    private Integer pinCode;
}
