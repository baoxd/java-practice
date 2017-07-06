package com.test.maven.model;

import java.util.Date;

public class User {
    private String id;

    private String name;

    private String password;

    private String role;

    private String createtime;
    
    private Date createtimeForPage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

	public Date getCreatetimeForPage() {
		return createtimeForPage;
	}

	public void setCreatetimeForPage(Date createtimeForPage) {
		this.createtimeForPage = createtimeForPage;
	}
    
    
}