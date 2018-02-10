package io.javabrians.springbootstarter.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import io.javabrians.springbootstarter.dao.User;
@Repository
public interface UserRepository extends CrudRepository<User,String> {
//	public List<Role> findByTopicId(Integer topicId);
//	public List<Course> findByName(String name);

}
