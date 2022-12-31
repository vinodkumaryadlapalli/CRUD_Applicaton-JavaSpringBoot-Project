package ca.lambtoncollege;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PageCountController.class)
class PageCountController {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PageCountConfig pageCountConfig;

    @Test
	public void currentcount() throws Exception {

		Mockito.when(pageCountConfig.getPageCounter()).thenReturn(new PageCounter());

		MvcResult result = mockMvc.perform(get("/currentcount"))

				.andExpect(status().isOk()).andReturn();
		PageCounter c = pageCountConfig.getPageCounter();

		String content = result.getResponse().getContentAsString();
		//assertEquals(content, c.getPageCount().toString());
	}

}
