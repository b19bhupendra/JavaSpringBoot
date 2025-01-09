package com.springRestApi.springRest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springRestApi.springRest.dao.ICourseDao;
import com.springRestApi.springRest.entities.Course;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CourseServiceImpl implements IcourseService {

//	List<Course> list;
	
	/**
	 * AS we can not create the object on interface then we will use @Autowired annotation.
	 * That will create the object of implementation class (inject the dependency).
	 * so we will simplly create an variable 
	 * 
	 */
	
	@Autowired
	private ICourseDao courseDao;
	
	public CourseServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Course(155,"Java Core Course", "this course contains basics of springboot"));
//		list.add(new Course(27,"Spring Boot Course", "Creating RestAPi using spring Boot"));
	}
	
	@Override
	public List<Course> getCourses() {
//		return list;
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
		
//		Course c = null;
//		
//		for(Course course:list) {
//			
//			if(course.getId() == courseId) {
//				c = course;
//				break;
//			}
//		}
//		return c;
		
//		return courseDao.getOne(courseId);
	    return courseDao.findById(courseId).orElseThrow(() -> new EntityNotFoundException("Course not found with ID: " + courseId));
	}

	@Override
	public Course addCourse(Course course) {
		
//		list.add(course);
		courseDao.save(course);
		return course;
	}
	/**
	 * e-> is an lambda that we have use in the foreach loop
	 */
	@Override
	public Course updateCourse(Course course) {
//		list.forEach(e-> {
//			if(e.getId() == course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
//		list = this.list.stream().filter(e->e.getId()!= parseLong).collect(Collectors.toList());
		Course entity = courseDao.getOne(parseLong);
		courseDao.delete(entity);
	}
}
