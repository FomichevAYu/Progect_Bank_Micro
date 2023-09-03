package com.bank.account.service.Impl;

import com.bank.account.entity.Audit;
import com.bank.account.repository.AuditRepository;
import com.bank.account.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * implementation of the service for working with the Account details entity
 */

@Service
@Transactional
public class AuditServiceImpl implements AuditService {
    private AuditRepository auditRepository;

    @Autowired
    public AuditServiceImpl(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @Override
    public List<Audit> getAllAudits() {
        return auditRepository.findAll();
    }

    @Override
    public void createAudit(Audit audit) {
        auditRepository.save(audit);
    }

    @Override
    public Optional<Audit> getSingleAuditById(long id) {
        return auditRepository.findById(id);
    }

    @Override
    public void deleteSingleAudit(Audit audit) {
        auditRepository.delete(audit);

    }

    @Override
    public void updateSingleAudit(Audit audit) {
        auditRepository.save(audit);
    }
}
