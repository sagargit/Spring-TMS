package com.sagar.domain;

import com.sagar.domain.PostEnum;

public class Employee {
    
    private int employeeId;
    private String employeeName;
    private PostEnum post;
    private String email;
    private String password;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PostEnum getPost() {
        
        return post;
    }

    public void setPost(PostEnum post) {
        this.post = post;
    }

    
    
}
