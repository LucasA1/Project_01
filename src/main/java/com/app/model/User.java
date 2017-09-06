package com.app.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;


/**
 * Created by LukeMcDermott on 8/30/17.
 */
@NodeEntity
public class User {

    @GraphId
    @Property
    //For Neo4j
    private Long id;

    @Property(name = "app_id")
    //Fot this application
    private Long appid;
    @Property(name = "username")
    private String username;
    @Property(name = "fullname")
    private String fullname;
    @Property(name = "role")
    private String role;
    @Property(name = "password")
    private String password;

    public User() {

    };

    public User(Long id, Long appid, String username, String fullname, String role, String password) {
        this.id = id;
        this.appid = appid;
        this.username = username;
        this.fullname = fullname;
        this.role = role;
        this.password = password;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getAppid() {
        return appid;
    }

    public void setAppid(Long appid) {
        this.appid = appid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "graphid=" + id +
                ", appid=" + appid +
                ", username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
