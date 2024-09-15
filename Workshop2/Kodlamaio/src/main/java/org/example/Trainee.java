package org.example;

import java.util.List;

public class Trainee extends User{

    private List<Course> traineeCourses;
    public Trainee(int id, String fullName, String email, String password, List<Course> traineeCourses) {
        super(id, fullName, email, password);

        this.traineeCourses = traineeCourses;

    }
}
