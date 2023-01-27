package net.javaguides.springboot.controller;

import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

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

import net.javaguides.springboot.service.EmployeePersonalService;
//import net.javaguides.springboot.service.EmployeeService;

@Controller
@RequestMapping("/emplogin")
public class EmployeePersonalcontroller {
	@Autowired
	EmployeePersonalRepository employeePersonalRepository;
	@Autowired
	EmployeePersonalService employeePersonalService;
//	@GetMapping("/employee")
//	public String home(Model model) {
//		return "emp_details_index";		
//	}
//	@PostMapping("/employee/update_personal_details")
//    @PreAuthorize("hasRole('READ_PRIVILEGE')")
//  public String personalDetailsUpdate(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,@RequestParam("email") String email,
//		  @RequestParam("empId") Long empId,@RequestParam("contactNumber") Long contactNumber, Model model) {
//      Employee employee = employeePersonalRepository.findByEmpId(empId);
//              //SecurityContextHolder.getContext().getAuthentication().getName());
//    employee.setFirstName(firstName);
//    employee.setLastName(lastName);
//    employee.setEmail(email);
//    employee.setEmpId(empId);
//    employee.setContactnumber(contactNumber);
//    employeepersonalRepository.save(employee);
////    model.addAttribute("employeeDetails",employee);
//    
//    return "emp_personal_details_index";
 // }
	@GetMapping("/getemppersonal/{empid}")
	public String empdetails(@PathVariable ( value = "empid") String empid,  Model model) {


		model.addAttribute("listEmployees", employeePersonalRepository.findAllByEmpid(empid));

		return "emp_personal_details_index";
	}	
	@GetMapping("/showFormForEmpUpdate/{empid}")
	public String showFormForEmpUpdate(@PathVariable ( value = "empid") String empid, Model model) {
		
		// get employee from the service
		EmployeePersonal employeePersonal = employeePersonalRepository.getEmployeePersonalByEmpid(empid);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("employeePersonal", employeePersonal);
		return "emp_update_personal_details";
	}
	@PostMapping("/saveEmp/{empid}")
	public String saveEmp(@PathVariable ( value = "empid") String empid, Model model) {
		
		// get employee from the service
		EmployeePersonal employeePersonal = employeePersonalRepository.getEmployeePersonalByEmpid(empid);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("employeePersonal", employeePersonal);
		return "redirect:/getemppersonal/{empid}";
	}
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<EmployeePersonal> page = employeePersonalService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<EmployeePersonal> listEmployees = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");		
		model.addAttribute("listEmployees", listEmployees);
		return "emp_personal_details_index";
	}
}


