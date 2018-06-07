package com.cg.service;

import java.util.List;

import com.cg.entity.AuditLog;

public interface AuditService {

	public AuditLog createAudit(AuditLog audit);

	public AuditLog removeAudit(String eventId);

	public Object findById(String eventId);

	public AuditLog updateAudit(String eventId, String eventName);

	public List<AuditLog> getDetails();

}
