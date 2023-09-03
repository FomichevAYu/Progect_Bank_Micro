package com.bank.account.dto;

import lombok.Builder;

import java.util.Date;

/**
 * Audit DTO
 *
 * @param id
 * @param entityType
 * @param operationType
 * @param createdBy
 * @param modifiedBy
 * @param createdAt
 * @param modifiedAt
 * @param entityJSON
 */

@Builder
public record AuditDTO(long id, String entityType, String operationType, String createdBy,
                       String modifiedBy, Date createdAt, Date modifiedAt, String entityJSON) {
}
