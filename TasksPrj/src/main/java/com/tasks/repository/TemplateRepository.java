package com.tasks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tasks.model.TUsers;
import com.tasks.model.Template;
@Repository
public interface TemplateRepository extends JpaRepository<Template, Integer> {
	
	@Query(value="select * from template where templateid in (select templateid from usertemplates where userid=:userId)", nativeQuery=true)
	public List<Template> findAllByUserId(@Param("userId") String userId);
	
}