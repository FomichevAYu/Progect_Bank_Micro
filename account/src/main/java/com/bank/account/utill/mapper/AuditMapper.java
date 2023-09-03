package com.bank.account.utill.mapper;

import com.bank.account.dto.AuditDTO;
import com.bank.account.entity.Audit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuditMapper {
    AuditDTO auditToAuditDto(Audit audit);

    Audit auditDtoToAudit(AuditDTO auditDTO);
}
