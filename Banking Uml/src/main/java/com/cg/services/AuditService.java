package com.cg.services;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import com.cg.entity.AuditLog;



@FeignClient("zuul-service")
public interface AuditService{
	
	@PostMapping(path="/audit/audit/create")
	ResponseEntity<AuditLog> createAudit( AuditLog audit);


}
/*@Service
public class AuditService {
	
	@Autowired
	private DiscoveryClient discoveryClient;

	public AuditLog generateAudit(AuditLog audit) {

		List<ServiceInstance> serInstance=discoveryClient.getInstances("mongo-service");
		ServiceInstance instance=serInstance.get(0);
		RestTemplate restTemplate = new RestTemplate();
		//final String uri = "http://localhost:8282/audit/create";
		String BankURL = instance.getUri().toString();
		BankURL=BankURL+"/audit/create";
		AuditLog audits = restTemplate.postForObject(BankURL, audit, AuditLog.class);

		return audits;

	}
}
*/
