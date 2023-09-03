package com.bank.account.controller;

import com.bank.account.dto.AuditDTO;
import com.bank.account.entity.Audit;
import com.bank.account.exception.EmptyListException;
import com.bank.account.exception.EntityNotFoundException;
import com.bank.account.service.AuditService;
import com.bank.account.utill.mapper.AuditMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * CRUD controller for Audit
 */

@RestController
@Tag(name = "Audit", description = "Audit API")
@RequiredArgsConstructor
public class AuditController {
    private AuditService auditService;
    private AuditMapper mapper;

    @Autowired
    public AuditController(AuditService auditService, AuditMapper mapper) {
        this.auditService = auditService;
        this.mapper = mapper;
    }

    @Operation(summary = "Get all record from audit table", tags = "Audit")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = AuditDTO.class)))
    @GetMapping("audits/")
    public ResponseEntity<List<AuditDTO>> getAllAuditRecord() {

        List<AuditDTO> list = auditService.getAllAudits().stream().map(a -> mapper.auditToAuditDto(a)).toList();
        if (list.isEmpty()) {
            throw new EmptyListException("Audit records not found");
        }
        return ResponseEntity.ok().body(list);
    }

    @Operation(summary = "Get audit record by id", tags = "Audit")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = AuditDTO.class)))
    @GetMapping("audits/{id}")
    public ResponseEntity<AuditDTO> getAuditRecordById(@PathVariable("id") long id) {
        Audit optional = auditService.getSingleAuditById(id).orElseThrow(() -> new EntityNotFoundException(id));
        return ResponseEntity.ok().body(mapper.auditToAuditDto(optional));
    }

    @Operation(summary = "Post new audit record", tags = "Audit")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = AuditDTO.class)))
    @PostMapping("audits/")
    public ResponseEntity<AuditDTO> createAuditRecord(@Valid @RequestBody AuditDTO auditDTO) {
        auditService.createAudit(mapper.auditDtoToAudit(auditDTO));
        return ResponseEntity.ok().body(auditDTO);
    }

    @Operation(summary = "Update new audit record", tags = "Audit")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = AuditDTO.class)))
    @PutMapping("audits/{id}")
    public ResponseEntity<AuditDTO> updateAuditRecord(@Valid @RequestBody AuditDTO auditDTO, @PathVariable("id") long id) {
        Audit optional = auditService.getSingleAuditById(id).orElseThrow(() -> new EntityNotFoundException(id));
        auditService.updateSingleAudit(mapper.auditDtoToAudit(auditDTO));
        return ResponseEntity.ok().body(auditDTO);
    }

    @Operation(summary = "Delete audit record", tags = "Audit")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = AuditDTO.class)))
    @DeleteMapping("audits/{id}")
    public ResponseEntity<Void> deleteAuditRecord(@PathVariable("id") long id) {
        Audit optional = auditService.getSingleAuditById(id).orElseThrow(() -> new EntityNotFoundException(id));
        auditService.deleteSingleAudit(optional);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
