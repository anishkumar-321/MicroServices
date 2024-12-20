package com.services.employee_service.model;

public class Employee {
    private Long id;
    private Long departmentId;
    private String name;
    private int age;
    private String position;

    public Employee(){}

    public Employee(Long id, Long departmentId, String name, int age, String position) {
        this.id = id;
        this.departmentId = departmentId;
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }
}
