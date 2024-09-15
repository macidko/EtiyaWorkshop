package org.example;

import java.util.List;

public class Instructor extends User {

    private List<Course> instructorCourses;
    public Instructor(int id, String fullName, String email, String password, List<Course> instructorCourses) {
        super(id, fullName, email, password);
        
        this.instructorCourses = instructorCourses;
    }
}
