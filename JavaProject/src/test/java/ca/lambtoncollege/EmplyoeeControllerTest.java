package ca.lambtoncollege;


import static org.mockito.ArgumentMatchers.eq;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeRepository employeeRepo;

	@Test
	public void createEmployeeTest() throws Exception {
		mockMvc.perform(get("/createmployee"))
				// .andDo(print());
				.andExpect(status().isOk()).andExpect(view().name("employeeform"))
				.andExpect(model().attribute("employee", new Employee()));
	}

	@Test
	public void createPostTest() throws Exception {
		Employee expectedEmployee = new Employee(null, "VinodKumar@gmail.com", "VinodKumar", 26);
		mockMvc.perform(post("/createuser").param("name", "VinodKumar").param("email", "VinodKumar@gmail.com")
				.param("age", "26")).andExpect(status().isOk()).andExpect(view().name("saved"))
				.andExpect(model().attribute("employee", expectedEmployee));

		Mockito.verify(employeeRepo).save(eq(expectedEmployee));
	}

	@Test
	public void createPostTest_InvalidEmployee() throws Exception {
		Employee expectedemployee = new Employee(null, "Vinod", "VinodKumar", 26);

		mockMvc.perform(post("/createemployee").param("name", "VinodKumar").param("email", "VinodKumar@gmail.com")
				.param("age", "26")).andExpect(status().isOk()).andExpect(view().name("employeeform"))
				.andExpect(model().attribute("employee", expectedemployee));

		Mockito.verifyNoInteractions(employeeRepo);
	}

	@Test
	public void listEmployeeTest() throws Exception {
		List<Employee> expectedList = new ArrayList<>();
		expectedList.add(new Employee(null, "VinodKumar@gmail.com", "VinodKumar", 26));

		Mockito.when(employeeRepo.findAll()).thenReturn(expectedList);

		mockMvc.perform(get("/allemployees")).andExpect(status().isOk()).andExpect(view().name("listemployees"))
				.andExpect(model().attribute("employees", expectedList));
	}
}
