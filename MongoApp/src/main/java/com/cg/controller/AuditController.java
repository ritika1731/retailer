package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.entity.AuditLog;
import com.cg.service.AuditService;

@Controller
@RequestMapping("/audit")
public class AuditController {

	@Autowired
	AuditService auditSer;

	@PostMapping(path = "/create")
	public ResponseEntity<AuditLog> createAudit(@RequestBody AuditLog audit) {

		AuditLog audits = auditSer.createAudit(audit);

		return new ResponseEntity<AuditLog>(audits, HttpStatus.CREATED);

	}

	@GetMapping(path = "/view/{eventId}")
	public ResponseEntity<Object> viewById(@PathVariable String eventId) {

		Object audits = auditSer.findById(eventId);

		return new ResponseEntity<Object>(audits, HttpStatus.OK);
	}

	@GetMapping(path = "/delete/{eventId}")
	public ResponseEntity<AuditLog> deleteAudit(@PathVariable String eventId) {

		AuditLog audits = auditSer.removeAudit(eventId);

		return new ResponseEntity<AuditLog>(audits, HttpStatus.OK);
	}

	@GetMapping(path = "/all")
	public ResponseEntity<?> viewAllCustomer() {

		List<AuditLog> auditlog = auditSer.getDetails();
		return new ResponseEntity<List<AuditLog>>(auditlog, HttpStatus.OK);
	}

	@GetMapping(path = "/update/{eventId}/{eventName}")
	public ResponseEntity<AuditLog> updateAudit(@PathVariable String eventId, @PathVariable String eventName) {

		AuditLog audits = auditSer.updateAudit(eventId, eventName);

		return new ResponseEntity<AuditLog>(audits, HttpStatus.OK);
	}
}
