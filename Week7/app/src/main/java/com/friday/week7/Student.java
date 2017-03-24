package com.friday.week7;

/**
 * Created by gdaalumno on 3/3/17.
 */
public class Student {

    private String name;
    private float grade;

    public String getName(){ return name; }
    public float getGrade() {return grade;}

    public Student(String name, float grade){
        this.name = name;
        this.grade = grade;
    }
}
