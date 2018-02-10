package io.javabrians.springbootstarter.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.javabrians.springbootstarter.dao.Role;
@Repository
public interface RoleRepository extends CrudRepository<Role,String> {
//	public List<Role> findByTopicId(Integer topicId);
//	public List<Course> findByName(String name);

}
