package com.app.repository;

import com.app.model.User;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by LukeMcDermott on 8/30/17.
 */
@Repository
public interface UserRepository extends GraphRepository<User> {
}
