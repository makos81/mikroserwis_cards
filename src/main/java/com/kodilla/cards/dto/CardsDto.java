package com.kodilla.cards.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardsDto {
    private Long id;
    private Long customerId;
    private String currency;
    private String accountNumber;
    private BigDecimal balance;
}
