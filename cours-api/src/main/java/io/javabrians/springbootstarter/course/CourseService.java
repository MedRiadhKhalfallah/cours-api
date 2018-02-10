package io.javabrians.springbootstarter.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourse(Integer topicId)
	{
		List<Course> courses= new ArrayList<>();
			courseRepository.findByTopicId(topicId).forEach(courses::add);
			return courses;
	}
	
	public Course getCourse(Integer id)
	{
		return courseRepository.findById(id).get();
	}
	
	public void addCourse(Course course)
	{
		courseRepository.save(course);
	}
	public void updateCourse(Course course)
	{
		courseRepository.save(course);
	}
	public void deleteCourse(Integer id) {
		courseRepository.deleteById(id);
	}
}
