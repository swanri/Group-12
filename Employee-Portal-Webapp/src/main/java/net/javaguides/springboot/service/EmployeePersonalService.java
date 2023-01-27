package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.EmployeePersonal;

public interface EmployeePersonalService {
	List<EmployeePersonal> findAllByEmpid(String empid);
	void saveEmployeePersonal(EmployeePersonal employeePersonal);
	EmployeePersonal getEmployeePersonalByEmpid(String empid);
	//void deleteEmployeeById(long id);
	Page<EmployeePersonal> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	
}
