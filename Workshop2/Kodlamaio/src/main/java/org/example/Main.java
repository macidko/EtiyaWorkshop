package org.example;

import org.example.core.User;
import org.example.dataAccess.CourseDao;
import org.example.dataAccess.InMemoryDao;
import org.example.entities.Category;
import org.example.entities.Course;
import org.example.entities.Instructor;
import org.example.entities.Trainee;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // DAO'ları oluştur
        InMemoryDao<Course> courseDao = new InMemoryDao<>();
        InMemoryDao<User> userDao = new InMemoryDao<>();

        // Kategoriler oluştur
        Category cat1 = new Category(1, "Programming");
        Category cat2 = new Category(2, "Data Science");

        // Eğitmenler oluştur
        Instructor instructor = new Instructor(1, "Dr. John Doe", "john.doe@example.com", "password123", new ArrayList<>());

        // Kurslar oluştur
        Course course1 = new Course(1, "Java Programming", "Learn Java from scratch", 99.99, "/java-programming", instructor, List.of(cat1, cat2));
        Course course2 = new Course(2, "Python Programming", "Learn Python from scratch", 89.99, "/python-programming", instructor, List.of(cat1));

        // Kullanıcılar oluştur
        Trainee trainee = new Trainee(1, "Jane Smith", "jane.smith@example.com", "password456", List.of(course1));

        // Veriyi ekle
        courseDao.add(course1);
        courseDao.add(course2);
        userDao.add(trainee);

        // Veriyi al ve yazdır
        Course fetchedCourse = courseDao.getById(1);
        System.out.println("Fetched Course:");
        System.out.println("Header: " + fetchedCourse.getHeader());
        System.out.println("Description: " + fetchedCourse.getDescription());

        User fetchedUser = userDao.getById(1);
        System.out.println("Fetched User:");
        System.out.println("Full Name: " + fetchedUser.getFullName());
    }
}