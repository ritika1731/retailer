package com.cg.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.entity.AuditLog;

@Service
public class AuditService {

	public AuditLog generateAudit(AuditLog audit) {

		RestTemplate restTemplate = new RestTemplate();
		final String uri = "http://localhost:8282/audit/create";

		AuditLog audits = restTemplate.postForObject(uri, audit, AuditLog.class);

		return audits;

	}
}
