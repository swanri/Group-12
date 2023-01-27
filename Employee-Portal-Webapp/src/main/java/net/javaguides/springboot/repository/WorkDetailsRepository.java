package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import net.javaguides.springboot.model.WorkDetails;

@Repository

public interface WorkDetailsRepository extends JpaRepository<WorkDetails, Long> {

}
