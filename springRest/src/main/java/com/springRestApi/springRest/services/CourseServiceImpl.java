package com.springRestApi.springRest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springRestApi.springRest.entities.Course;

@Service
public class CourseServiceImpl implements IcourseService {

	List<Course> list;
	
	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(155,"Java Core Course", "this course contains basics of springboot"));
		list.add(new Course(27,"Spring Boot Course", "Creating RestAPi using spring Boot"));
	}
	
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return list;
	}

}
