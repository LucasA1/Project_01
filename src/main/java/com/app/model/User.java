package com.app.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created by LukeMcDermott on 8/30/17.
 */
@NodeEntity
public class User {

    @GraphId
    private Long id;
    private String username;
    private String fullname;
    private String role;
    private String password;

    public User() {};
}
