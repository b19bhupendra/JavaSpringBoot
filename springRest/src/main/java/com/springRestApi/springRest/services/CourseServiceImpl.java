package com.springRestApi.springRest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

	@Override
	public Course getCourse(long courseId) {
		
		Course c = null;
		
		for(Course course:list) {
			
			if(course.getId() == courseId) {
				c = course;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		
		list.add(course);
		// TODO Auto-generated method stub
		return course;
	}
	/**
	 * e-> is an lambda that we have use in the foreach loop
	 */
	@Override
	public Course updateCourse(Course course) {
		list.forEach(e-> {
			if(e.getId() == course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
		});
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		// TODO Auto-generated method stub
		list = this.list.stream().filter(e->e.getId()!= parseLong).collect(Collectors.toList());
	}
}
