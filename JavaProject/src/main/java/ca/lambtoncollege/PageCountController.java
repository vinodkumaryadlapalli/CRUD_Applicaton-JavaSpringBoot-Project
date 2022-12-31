package ca.lambtoncollege;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PageCountController {

	//creating the object 
	@Autowired
	private PageCounter pgcounter;
	
	//URL mapping
	@GetMapping("/currentcount")
	public int Currentcount()
	{
		return pgcounter.getPageCount();
	}
	
}
