import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sagar.domain.Employee;
import com.sagar.domain.PostEnum;
import com.sagar.service.EmployeeService;

@Configuration
@ComponentScan(basePackages ={"com.sagar"})
public class EmployeeTest {
	EmployeeService service;
	@Before
	public void setUp() throws Exception {
		ApplicationContext context= new AnnotationConfigApplicationContext(EmployeeService.class);
		service = context.getBean(EmployeeService.class);
		
		/*ApplicationContext context1 = 
	             new ClassPathXmlApplicationContext("SpringBeans.xml");

	      
	     context1.getBean("studentJDBCTemplate");
	   

	    service = (EmployeeService)context1.getBean("employeeServiceImpl");*/
	}

	@Test
	public void testSaveEmployee() {
		
		System.out.println("save");
		Employee o = new Employee();

		o.setEmployeeName("akshya");
		o.setEmail("ddddd");
		o.setPassword("fsafas");
		o.setPost(PostEnum.getPostEnum("MANAGER"));
		int countBefore = service.row_count();
		service.saveEmployee(o);
		assertTrue(" Sagar Assert statement error",
				service.row_count() == countBefore + 1);
	}

	@Test
	public void testSearch() {
		
		System.out.println("search");
		Employee e = new Employee();
		
		e.setPost(PostEnum.getPostEnum("Developer"));
		

		List<Employee> result = service.search(e);

		for (Employee a : result) {

			System.out.println("Test Search " + a.getEmployeeId() + " "
					+ a.getPost());

		}
		assertTrue("Condition not true", !result.isEmpty());
	}

	@Test
	public void testSearchByPost() {
		
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		
		System.out.println("delete");

		
		int countBefore = service.row_count();
		System.out.println(countBefore);
		int employeeId = 20; // here id with 14 has been already deleted
		service.delete(employeeId);
		int countAfter = service.row_count();
		System.out.println(countAfter);
		assertTrue("Value not equal", (countBefore) == (countAfter));
	}

	@Test
	public void testUpdate() {
		
		System.out.println("update");
		Employee o = new Employee();
		o.setEmployeeName("aaaa");
		o.setPassword("bbbb");
		// o.setPost(PostEnum.getPostEnum("QC"));

		// initially the name was Sagar
		o.setEmployeeId(15);

		
		service.update(o);
		assertTrue("Message Sagar", service.searchById(15).getEmployeeName().equals("messi"));
	}

	@Test
	public void testSearchById() {
		
		System.out.println("searchById");
		int employeeId = 6;
		

		Employee result = service.searchById(employeeId);
		assertTrue(result.getEmployeeId() == 6);
	}

	@Test
	public void testFindAll() {
		
		System.out.println("findAll");
	
		List<Employee> expResult = service.findAll();
		List<Employee> result = service.findAll();
		System.out.println("List exp result");
		for (Employee e : expResult) {

			System.out.println("Find all 1 " + e.getPost());
		}
		System.out.println("List result");

		for (Employee e : result) {

			System.out.println("Find all 2 " + e.getPost());
		}

		assertEquals(expResult.size(), result.size());
	}

	@Test
	public void testRow_count() {
		
		fail("Not yet implemented");
	}

}
