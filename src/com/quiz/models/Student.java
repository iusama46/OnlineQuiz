package com.quiz.models;

/**
 * Created by Ussama Iftikhar on 27-Jan-2021.
 * Email iusama46@gmail.com
 * Email iusama466@gmail.com
 * Github https://github.com/iusama46
 */

public class Student extends Person {
    private String age;
    private String rollNo;

    public Student(String personId, String name, String phoneNo, String email, String password, String age, String rollNo) {
        super(personId, name, phoneNo, email, password);
        this.age = age;
        this.rollNo = rollNo;
    }


    public Student(String personId, String name, String phoneNo, String email, String password) {
        super(personId, name, phoneNo, email, password);
    }

    public Student(String age, String rollNo) {
        this.age = age;
        this.rollNo = rollNo;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }
}
