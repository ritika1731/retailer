package com.cg.MongoApp;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.entity.AuditLog;
import com.cg.exception.AuditException;
import com.cg.repository.AuditRepository;
import com.cg.service.AuditServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoAppApplicationTests {

	@Mock
	AuditRepository auditRepo;
	@InjectMocks
	AuditServiceImpl auditSer;

	@Test
	public void createAudit() {
		AuditLog audit = new AuditLog("action", "abc", "12", new Object(), new Object());

		when(auditRepo.insert(audit)).thenReturn(audit);
		// System.out.println(bank);
		assertThat(auditSer.createAudit(audit), is(notNullValue()));
	}

	@Test
	public void viewAudit() {
		AuditLog audit = new AuditLog("action", "abc", "12", new Object(), new Object());
		audit.setEventId("1");
		Optional<AuditLog> auditlog = Optional.of(audit);

		when(auditRepo.findByEventId("1")).thenReturn(auditlog);

		assertThat(auditSer.findById("1"), is(notNullValue()));
	}

	@Test(expected = AuditException.class)
	public void viewAudit1() {
		AuditLog audit = new AuditLog("action", "abc", "12", new Object(), new Object());
		audit.setEventId("1");
		Optional<AuditLog> auditlog = Optional.empty();

		when(auditRepo.findByEventId("1")).thenReturn(auditlog);

		auditSer.findById("1");
	}

	@Test
	public void viewAllAudit() {

		AuditLog audit = new AuditLog("action", "abc", "12", new Object(), new Object());
		audit.setEventId("1");
		assertThat(auditSer.getDetails(), is(notNullValue()));
	}

	@Test

	public void deleteAudit() {
		AuditLog audit = new AuditLog("action", "abc", "12", new Object(), new Object());
		audit.setEventId("1");
		// System.out.println(audit);
		Optional<AuditLog> auditlog = Optional.of(audit);
		when(auditRepo.findByEventId("1")).thenReturn(auditlog);

		assertThat(auditSer.removeAudit("1"), is(notNullValue()));
	}

	@Test
	// @Ignore
	public void updateAudit() {
		AuditLog audit = new AuditLog("action", "abc", "12", new Object(), new Object());
		audit.setEventId("1");

		System.out.println(audit);
		Optional<AuditLog> auditlog = Optional.of(audit);
		System.out.println(auditlog);
		when(auditRepo.findByEventId("1")).thenReturn(auditlog);
		System.out.println(">>>>>>>>>" + auditSer.updateAudit("1", "qwe"));
 
		assertThat(auditSer.updateAudit("1", "qwe"), is(notNullValue()));
	}

}
