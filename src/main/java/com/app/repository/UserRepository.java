package com.app.repository;

import com.app.model.User;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by LukeMcDermott on 8/30/17.
 */
public interface UserRepository extends GraphRepository<User> {
}
