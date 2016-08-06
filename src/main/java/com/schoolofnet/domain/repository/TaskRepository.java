package com.schoolofnet.domain.repository;

import com.schoolofnet.domain.entity.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Integer> {

    @Query("select t from Task t")
    Iterable<Task> findAllQuery();

    @Query(value = "SELECT * FROM task", nativeQuery = true)
    Iterable<Task> findAllNativeQuery();
}
