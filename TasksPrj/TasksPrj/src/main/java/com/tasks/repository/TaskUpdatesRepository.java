package com.tasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tasks.model.TUsers;
import com.tasks.model.TaskUpdates;
import com.tasks.model.Tasks;
import com.tasks.model.Template;
@Repository
public interface TaskUpdatesRepository extends JpaRepository<TaskUpdates, Integer> {
	
	
}
