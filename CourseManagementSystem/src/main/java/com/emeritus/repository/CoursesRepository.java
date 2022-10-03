package com.emeritus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emeritus.modal.Courses;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Integer>{

}
