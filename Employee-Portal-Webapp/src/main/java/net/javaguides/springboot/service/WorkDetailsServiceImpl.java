package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import net.javaguides.springboot.model.WorkDetails;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.repository.WorkDetailsRepository;

@Service
public class WorkDetailsServiceImpl implements WorkDetailsService{
	@Autowired
	private WorkDetailsRepository workdetailsRepository;
	
//	public WorkDetailsServiceImpl(WorkDetailsRepository workdetailsRepository) {
//		
//		this.workdetailsRepository = workdetailsRepository;
//	}

	
	

	@Override
	public List<WorkDetails> getAllWorkDetails() {
		return workdetailsRepository.findAll();
	}

	@Override
	public void saveWorkDetails(WorkDetails workdetails) {
		this.workdetailsRepository.save(workdetails);
	}

	@Override
	public WorkDetails getWorkDetailsById(long id) {
		Optional<WorkDetails> optional = workdetailsRepository.findById(id);
		WorkDetails workdetails = null;
		if (optional.isPresent()) {
			workdetails = optional.get();
		} else {
			throw new RuntimeException(" Work Details not found for id :: " + id);
		}
		return workdetails;
	}

	@Override
	public void deleteWorkDetailsById(long id) {
		this.workdetailsRepository.deleteById(id);
	}

	@Override
	public Page<WorkDetails> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.workdetailsRepository.findAll(pageable);
	}
}



