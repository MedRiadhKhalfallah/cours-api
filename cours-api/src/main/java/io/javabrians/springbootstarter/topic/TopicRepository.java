package io.javabrians.springbootstarter.topic;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface TopicRepository extends CrudRepository<Topic,Integer> {
	@Query("select t from Topic t where t.name like %:x%")
	public List<Topic>cherche(@Param("x") String nt);

}
