package ca.lambtoncollege;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class EmployeeController {


	
	@Autowired
	private EmployeeRepository employeeRepo;

	@GetMapping("/createemployee")
	public String EmployeeForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "Employeeform";
	}
	
	@PostMapping("/createemployee")
	public String createEmployee(@Valid Employee toSave, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "Employeeform";
		} else {
			this.employeeRepo.save(toSave);
			return "saved";
		}
	}
	
	
	@GetMapping("/allemployees")
	public String listAllEmployees(Model model) {
		model.addAttribute("employees", this.employeeRepo.findAll());
		return "listEmployees";
	}
}
