package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.entity.AuditLog;

public interface AuditRepository extends MongoRepository<AuditLog, String> {

}
