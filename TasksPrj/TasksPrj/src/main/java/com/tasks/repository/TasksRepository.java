package com.tasks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tasks.model.TUsers;
import com.tasks.model.Tasks;
import com.tasks.model.Template;
@Repository
public interface TasksRepository extends JpaRepository<Tasks, Integer> {
	@Query(value="select * from tasks where taskid in (select taskid from taskusers where userid=:userId)", nativeQuery=true)
	public List<Tasks> findAllByUserId(@Param("userId") String userId);
	
}
