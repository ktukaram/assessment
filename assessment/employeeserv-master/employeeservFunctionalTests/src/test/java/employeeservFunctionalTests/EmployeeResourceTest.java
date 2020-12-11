package employeeservFunctionalTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paypal.bfs.test.employeeserv.EmployeeservApplication;
import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EmployeeservApplication.class)
@WebAppConfiguration
public class EmployeeResourceTest {

	private MockMvc mvc;

	@Mock
	private EmployeeService employeeService;

	@Autowired
	WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testAshouldReturnNotFoundOnNonExistingEmployee() throws Exception {
		String uri = "/v1/bfs/employees/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(404, status);
	}

	@Test
	public void testBshoudlReturnOkSaveEmployee() throws Exception {
		Employee employee = new Employee();
		Address address = new Address();
		address.setCity("NYC");
		address.setState("NY");
		address.setZip_code("14221");

		employee.setFirstName("test");
		employee.setLastName("user");
		employee.setDob(new Date());
		employee.setAddress(address);

		String uri = "/v1/bfs/employees";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(mapToJson(employee))).andReturn();

		int status = mvcResult.getResponse().getStatus();
		Employee actual = mapFromJson(mvcResult.getResponse().getContentAsString(), Employee.class);
		assertEquals(200, status);
		assertNotNull(actual.getId());
	}

	@Test
	public void testCshouldReturnFoundEmployee() throws Exception {
		String uri = "/v1/bfs/employees/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		Employee actual = mapFromJson(mvcResult.getResponse().getContentAsString(), Employee.class);
		assertEquals(200, status);
		assertNotNull(actual);
		assertNotNull(actual.getId());
	}

	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	protected <T> T mapFromJson(String json, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}
}
