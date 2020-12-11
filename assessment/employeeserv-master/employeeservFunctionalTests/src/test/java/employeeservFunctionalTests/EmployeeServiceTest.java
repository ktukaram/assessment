package employeeservFunctionalTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.impl.service.EmployeeServiceImpl;
import com.paypal.bfs.test.employeeserv.repository.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmployeeService.class)
public class EmployeeServiceTest {

	@Mock
	private EmployeeRepository employeeRpository;

	EmployeeService employeeService;

	@Before
	public void setUp() {
		employeeService = new EmployeeServiceImpl(employeeRpository);
	}

	@Test
	public void it_should_save_user() {
		Employee employee = new Employee();
		Address address = new Address();
		address.setCity("NYC");
		address.setState("NY");
		address.setZip_code("14221");

		employee.setFirstName("test");
		employee.setLastName("user");
		employee.setDob(new Date());
		employee.setAddress(address);
		when(employeeRpository.save(employee)).thenReturn(employee);

		Employee actual = employeeService.saveEmployee(employee);
		assertEquals(employee, actual);
	}

	@Test
	public void it_should_not_save_user() {
		Employee employee = new Employee();

		employee.setFirstName("test");
		employee.setLastName("user");
		employee.setDob(new Date());
		when(employeeRpository.save(employee)).thenReturn(employee);

		Employee actual = employeeService.saveEmployee(employee);
		assertNull(actual);
	}
}
