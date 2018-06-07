package com.cg.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.entity.AuditLog;

public interface AuditRepository extends MongoRepository<AuditLog, String> {

	Optional<AuditLog> findByEventId(String eventId);
}
