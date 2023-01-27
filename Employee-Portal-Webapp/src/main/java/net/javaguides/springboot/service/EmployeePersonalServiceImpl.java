package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.EmployeePersonal;
import net.javaguides.springboot.repository.EmployeePersonalRepository;
//import net.javaguides.springboot.repository.EmployeeRepository;
@Service
public class EmployeePersonalServiceImpl implements EmployeePersonalService {
	@Autowired
	private EmployeePersonalRepository employeePersonalRepository;

	@Override
	public List<EmployeePersonal> findAllByEmpid(String empid) {
		return employeePersonalRepository.findAll();
	}

	@Override
	public void saveEmployeePersonal(EmployeePersonal employeePersonal) {
		this.employeePersonalRepository.save(employeePersonal);
	}

	@Override
	public EmployeePersonal getEmployeePersonalByEmpid(String empid) {
		Optional<EmployeePersonal> optional = employeePersonalRepository.findById(empid);
		EmployeePersonal employeePersonal = null;
		if (optional.isPresent()) {
			employeePersonal = optional.get();
		} else {
			throw new RuntimeException(" EmployeePersonal not found for empid :: " + empid);
		}
		return employeePersonal;
	}

//	@Override
//	public void deleteEmployeeById(long id) {
//		this.employeeRepository.deleteById(id);
//	}

	@Override
	public Page<EmployeePersonal> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.employeePersonalRepository.findAll(pageable);
	}
}



