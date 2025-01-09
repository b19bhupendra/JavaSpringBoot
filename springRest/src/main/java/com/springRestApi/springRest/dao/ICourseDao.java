package com.springRestApi.springRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springRestApi.springRest.entities.Course;

public interface ICourseDao extends JpaRepository<Course, Long> {

}
