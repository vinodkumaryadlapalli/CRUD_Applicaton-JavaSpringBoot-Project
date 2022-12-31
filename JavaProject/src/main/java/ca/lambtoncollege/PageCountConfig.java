package ca.lambtoncollege;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//To configure the connections
@Configuration
public class PageCountConfig {

	//create the object 
	PageCounter pgcounter = new PageCounter();
	//create the getpagecounter method
	@Bean
	public PageCounter getPageCounter()
	{
		return pgcounter;
	}
}
