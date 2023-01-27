package net.javaguides.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.EmployeePersonal;
@Repository
public interface EmployeePersonalRepository extends JpaRepository<EmployeePersonal, String> {
	List<EmployeePersonal> findAllByEmpid(String empid);
	//static List<Employee> findAllByEmpId(Long empId) {
		// TODO Auto-generated method stub
		//return "emp_personal_details_index";
	//}

	EmployeePersonal getEmployeePersonalByEmpid(String empid);

	//Object findById(String empid);

	//static Employee getEmployeeByEmpId(long empId) {
		// TODO Auto-generated method stub
		//return "empS;
	//}
}
 
