package com.springRestApi.springRest.services;

import java.util.List;

import com.springRestApi.springRest.entities.Course;


public interface IcourseService {
	
	public List<Course> getCourses();//this will call its child class body
	
	public Course getCourse(long courseId);
	
	public Course addCourse(Course course);
	
	public Course updateCourse(Course course);
	
	public void deleteCourse(long parseLong);
 
}
