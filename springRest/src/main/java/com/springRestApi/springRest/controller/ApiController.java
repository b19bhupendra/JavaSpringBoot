package com.springRestApi.springRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springRestApi.springRest.entities.Course;
import com.springRestApi.springRest.services.IcourseService;

@RestController
public class ApiController {
	
	/**
	 * So We will declare variable type of interface i.e. IcourseService 
	 * IcourseService class that is a parent class interface of CourseServiceImpl and that is being implemented by CourseServiceImpl
	 * Autowired will create the object of the implementation class i.e. CourseServiceImpl and inject it to courseService according to the dependency injection
	 */
	@Autowired
	private IcourseService courseService;
	
	/**
	 * Function just for testing 
	 * @return String 
	 */
	@GetMapping("/home")
	public String home() {
		
		return "In api controller in home method";
	}
	
	/**
	 * Get the courses
	 */
	@GetMapping("/courses")
	public List<Course> getCourses(){
		
		return this.courseService.getCourses(); //so here getCourses method of interface call will be called
	}
	
}












