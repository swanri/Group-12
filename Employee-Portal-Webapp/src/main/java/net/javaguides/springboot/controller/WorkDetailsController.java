package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import net.javaguides.springboot.model.WorkDetails;
import net.javaguides.springboot.service.WorkDetailsService;

@Controller
@RequestMapping("/workdetails")
public class WorkDetailsController {
	@Autowired
	private WorkDetailsService workdetailsService;
	
    @GetMapping("/viewForm")
	public String viewHomePage(Model model) {
		return findPaginated(1, "empid", "asc", model);		
	}
	
	@GetMapping("/showNewWorkDetailsForm")
	public String showNewWorkDetailsForm(Model model) {
		// create model attribute to bind form data
		WorkDetails workdetails = new WorkDetails();
		model.addAttribute("workdetails", workdetails);
		return "new_work_details";
	}
	
	@PostMapping("/saveWorkDetails")
	public String saveWorkDetails(@ModelAttribute("workdetails") WorkDetails workdetails) {
		// save employee to database
		workdetailsService.saveWorkDetails(workdetails);
		return "redirect:/workdetails/viewForm";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get employee from the service
		WorkDetails workdetails = workdetailsService.getWorkDetailsById(id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("workdetails", workdetails);
		return "update_work_details";
	}
	
	@GetMapping("/deleteWorkDetails/{id}")
	public String deleteWorkDetails(@PathVariable (value = "id") long id) {
		
		// call delete employee method 
		this.workdetailsService.deleteWorkDetailsById(id);
		return "redirect:/workdetails/viewForm";
	}
	
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<WorkDetails> page = workdetailsService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<WorkDetails> listWorkDetails = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listWorkDetails", listWorkDetails);
		return "work_details_index";
	}
}



