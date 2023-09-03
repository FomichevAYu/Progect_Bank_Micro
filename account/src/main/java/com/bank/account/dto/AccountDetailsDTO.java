package com.bank.account.dto;

import lombok.Builder;

import java.math.BigDecimal;

/**
 * DTO account_details
 *
 * @param id
 * @param passportId
 * @param accountNumber
 * @param bankDetailsId
 * @param money
 * @param negativeBalance
 * @param profileId
 */

@Builder
public record AccountDetailsDTO(long id, long passportId, long accountNumber, long bankDetailsId,
                                BigDecimal money, boolean negativeBalance, long profileId) {
}
