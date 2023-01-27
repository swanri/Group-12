package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.WorkDetails;
@Service
public interface WorkDetailsService {
	List<WorkDetails> getAllWorkDetails();
	void saveWorkDetails(WorkDetails workdetails);
	WorkDetails getWorkDetailsById(long id);
	void deleteWorkDetailsById(long id);
	Page<WorkDetails> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
