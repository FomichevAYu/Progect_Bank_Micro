package com.bank.account.service;

import com.bank.account.entity.Audit;

import java.util.List;
import java.util.Optional;

public interface AuditService {
    List<Audit> getAllAudits();

    void createAudit(Audit audit);

    Optional<Audit> getSingleAuditById(long id);

    void deleteSingleAudit(Audit audit);

    void updateSingleAudit(Audit audit);
}
