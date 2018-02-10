package io.javabrians.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CourseRepository extends CrudRepository<Course,Integer> {
	public List<Course> findByTopicId(Integer topicId);
//	public List<Course> findByName(String name);

}
