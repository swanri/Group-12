package net.javaguides.springboot.controller;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.model.EmployeePersonal;
import net.javaguides.springboot.repository.EmployeePersonalRepository;
//import net.javaguides.springboot.service.EmployeeService;

@Controller
@RequestMapping("/empworkdetails")

public class EmployeeWorkController {
	@Autowired
	EmployeePersonalRepository employeePersonalRepository;
	@GetMapping("/emp")
	public String home(Model model) {
		return "employee_details_index";		
	}
	@PostMapping("/getempwork")
	public String empdetails(@RequestParam(name = "emp_id", required = true) String empid,  Model model) {


		model.addAttribute("workdetails", employeePersonalRepository.findById(empid));

		return "emp_work_details_index";
	}	
	@GetMapping("/showFormForEmpUpdate/{empid}")
	public String showFormForEmpUpdate(@PathVariable ( value = "emp_id") String empid, Model model) {
		
		// get employee from the service
		EmployeePersonal employeePersonal = employeePersonalRepository.getEmployeePersonalByEmpid(empid);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("employeePersonal", employeePersonal);
		return "emp_update_work_details";
	}

}



