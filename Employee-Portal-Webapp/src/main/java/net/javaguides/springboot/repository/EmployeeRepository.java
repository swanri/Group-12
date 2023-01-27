package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	List<Employee> findAllById(Long id);
	Employee getEmployeeById(long id);
}
//public interface EmployeeRepository extends CrudRepository<Employee, Long>{

//}
