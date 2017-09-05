package com.app.repository;

import com.app.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by LukeMcDermott on 8/30/17.
 */
@Repository
public interface UserRepository extends GraphRepository<User> {

    @Query("MATCH (user:User) WHERE user.app_id = {app_id} RETURN user")
    User findUserByAppid(@Param("app_id") Long app_id);
}
