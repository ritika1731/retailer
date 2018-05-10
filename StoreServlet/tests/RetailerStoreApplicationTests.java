

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.cg.controller.ApplicationConfiguration;
import com.cg.entity.Customer;
import com.cg.service.CustomerService;
import com.cg.service.RetailerService;


public class RetailerStoreApplicationTests {

		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

		CustomerService custService = (CustomerService) context.getBean("customerService");
	
		RetailerService retailerService = (RetailerService) context.getBean("retailerService");
	


	@Test
	public void customerTest() {

		Customer customer = new Customer(13, "rahul", "mumbai", "card");
		//	CustomerDao customerService;
		Customer value=custService.addCustomer(customer);
		assertEquals(customer, value);
	}
	
	@Test
	public void retrieveCustomerTest() {
		 
		List<Customer> value=retailerService.retrieveCustomer();
		assertTrue(value.contains(value.get(1)));
	}
	
	
}
