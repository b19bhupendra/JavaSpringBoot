package com.springRestApi.springRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	 /**
	  * This Method is to get the specific course based on the ID
	  * Using @PathVariable in the parameter will help to take the value of courseID that we will pass in function calling.
	  * Long.parseLong is use to convert the string value into Long data type
	  * @param courseId
	  * @return
	  */
	@GetMapping("/course/{courseId}") 
	public Course getCourse(@PathVariable String courseId) //To get the courseId we will use PathVariable in params
	{	
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	/**
	 * This method is for adding new course
	 * In parameter we need the object of the Course 
	 * But this object will come from the request body so we will write @RequestBody
	 * We have defined consumes that is only to tell that data is in JSON format.
	 * @return
	 */
	@PostMapping(path = "/addCourse", consumes = "application/json")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}
	
	
	/**
	 * This Method is for updating the course
	 * @return
	 */
	@PutMapping("/update")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
		
	}
	
	/**
	 * This method id for delete
	 * 
	 */
	@DeleteMapping("/delete/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	
}






 





