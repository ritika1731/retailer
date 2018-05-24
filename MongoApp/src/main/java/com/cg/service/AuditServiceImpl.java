package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.AuditLog;
import com.cg.exception.AuditException;
import com.cg.repository.AuditRepository;

@Service
public class AuditServiceImpl implements AuditService {

	@Autowired
	AuditRepository auditRepo;

	@Override
	public AuditLog createAudit(AuditLog audit) {

		return auditRepo.insert(audit);
	}

	@Override
	public AuditLog removeAudit(String eventId) {
		AuditLog audit = new AuditLog(eventId);

		auditRepo.deleteById(eventId);
		return audit;

	}

	@Override
	public Object findById(String eventId) {
		// TODO Auto-generated method stub

		Optional<AuditLog> auditlog = auditRepo.findById(eventId);
		// System.out.println("***********"+auditlog);
		if (auditlog.isPresent()) {
			AuditLog audits = auditlog.get();
			return audits;
		} else {
			throw new AuditException("Id not found");
		}
	}

	@Override
	public AuditLog updateAudit(String eventId, String eventName) {

		Optional<AuditLog> auditlog = auditRepo.findById(eventId);
		if (auditlog.isPresent()) {
			AuditLog audit = auditlog.get();
			audit.setEventName(eventName);
			return auditRepo.save(audit);
		} else {
			throw new AuditException("Id not found");

		}
	}

	@Override
	public List<AuditLog> getDetails() {
		// TODO Auto-generated method stub
		return auditRepo.findAll();
	}

}
