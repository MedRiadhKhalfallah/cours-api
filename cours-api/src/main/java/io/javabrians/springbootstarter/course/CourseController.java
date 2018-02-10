package io.javabrians.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrians.springbootstarter.topic.Topic;

@RestController
public class CourseController {
	@Autowired
	private CourseService CourseService;
//	@Secured(value= {"ROLE_ADMIN","ROLE_USER"})
	@RequestMapping("/topics/{id}/courses")
	public List<Course>getAllCourses(@PathVariable Integer id)
	{
		return CourseService.getAllCourse(id);
	}
//	@Secured(value= {"ROLE_ADMIN","ROLE_USER"})
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable Integer id)
	{
		return CourseService.getCourse(id);
	}
//	@Secured(value= {"ROLE_ADMIN","ROLE_USER"})
	@RequestMapping(method=RequestMethod.POST,value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course ,@PathVariable Integer topicId)
	{
			course.setTopic(new Topic(topicId,"",""));
		 CourseService.addCourse(course); 
	}
//	@Secured(value= {"ROLE_ADMIN","ROLE_USER"})
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable Integer id,@PathVariable Integer topicId)
	{
		course.setTopic(new Topic(topicId,"",""));
		 CourseService.updateCourse(course);
	}
//	@Secured(value= {"ROLE_ADMIN","ROLE_USER"})
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{topicId}/courses/{id}")
	public void deleteCourse( @PathVariable Integer id)
	{
		 CourseService.deleteCourse(id);
	}
}
