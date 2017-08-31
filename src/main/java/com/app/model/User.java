package com.app.model;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Labels;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.springframework.data.annotation.Id;

import javax.annotation.Generated;
import javax.persistence.*;


/**
 * Created by LukeMcDermott on 8/30/17.
 */
@NodeEntity
public class User {

    @GraphId
    @Property
    private Long graphid;
    @Property
    private Long appid;
    @Property
    private String username;
    @Property
    private String fullname;
    @Property
    private String role;
    @Property
    private String password;

    public User() {

    };

    public User(Long graphid, Long appid, String username, String fullname, String role, String password) {
        this.graphid = graphid;
        this.appid = appid;
        this.username = username;
        this.fullname = fullname;
        this.role = role;
        this.password = password;
    }

    public Long getGraphid() {
        return graphid;
    }

    public void setGraphid(Long graphid) {
        this.graphid = graphid;
    }

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
                "graphid=" + graphid +
                ", appid=" + appid +
                ", username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
