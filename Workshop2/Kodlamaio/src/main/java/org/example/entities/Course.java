package org.example.entities;

import org.example.core.Entity;

import java.util.List;

public class Course implements Entity {
    private int id;
    private String header;
    private String description;
    private double price;
    private String path;
    private Instructor instructor;
    private List<Category> categories;

    public Course(int id, String header, String description, double price, String path, Instructor instructor, List<Category> categories) {
        this.id = id;
        this.header = header;
        this.description = description;
        this.price = price;
        this.path = path;
        this.instructor = instructor;
        this.categories = categories;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }


}
