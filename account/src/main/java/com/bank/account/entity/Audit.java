package com.bank.account.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * Account details entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "audit")
public class Audit {

    public static final int COMMON_FIELD_LENGTH = 255;

    public static final int ENTITY_TYPE_FIELD_LENGTH = 40;

    /**
     * identification entity field
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * entity type entity field
     */
    @NotBlank(message = "Entity type cannot be empty")
    @Length(max = ENTITY_TYPE_FIELD_LENGTH)
    @Column(name = "entity_type")
    private String entityType;

    /**
     * operation type entity field
     */
    @NotBlank(message = "Operation type cannot be empty")
    @Length(max = COMMON_FIELD_LENGTH)
    @Column(name = "operation_type")
    private String operationType;

    /**
     * created by entity field
     */
    @NotBlank(message = "CreatedBy field cannot be empty")
    @Length(max = COMMON_FIELD_LENGTH)
    @Column(name = "created_by")
    private String createdBy;

    /**
     * modified by entity field
     */
    @Nullable
    @Length(max = COMMON_FIELD_LENGTH)
    @Column(name = "modified_by")
    private String modifiedBy;

    /**
     * created at entity field
     */
    @NotBlank(message = "CreatedAt field cannot be empty")
    @Column(name = "created_at")
    private Date createdAt;

    /**
     * modified at entity field
     */
    @Nullable
    @Column(name = "modified_at")
    private Date modifiedAt;

    /**
     * new json
     */
    @Nullable
    @Column(name = "new_entity_json")
    private String newEntityJSON;

    /**
     * current json
     */
    @Column(name = "entity_json")
    private String entityJSON;

}
