package com.quiz.database;

import com.quiz.models.Instructor;
import com.quiz.models.Question;
import com.quiz.models.Student;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Ussama Iftikhar on 27-Jan-2021.
 * Email iusama46@gmail.com
 * Email iusama466@gmail.com
 * Github https://github.com/iusama46
 */

public class MySQL {
    private Connection connection;
    private String url = "jdbc:mysql://remotemysql.com:3306/";
    private String user = "ylO5Spv5hX", pass = "G1ur9pS6pu";
    private String db = "ylO5Spv5hX";
    private String instructorTable = "Instructors";
    private String studentTable = "Students";
    private String questionTable = "Questions";

    public MySQL() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url + db, user, pass);
            if (connection != null) {
                System.out.println("Connected.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "Database Connection Error " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

/*    CREATE TABLE `Instructors`  (
            `InstructorId` int(11) NOT NULL AUTO_INCREMENT,
            `name` varchar(15) NOT NULL,
            `phoneNo` varchar(15) NOT NULL,
            `email` varchar(15) NOT NULL,
            `password` varchar(15) NOT NULL,
    PRIMARY KEY (`InstructorId`)
);*/

    /*CREATE TABLE `Students`  (
            `StudentId` int(11) NOT NULL AUTO_INCREMENT,
            `name` varchar(15) NOT NULL,
            `phoneNo` varchar(15) NOT NULL,
            `email` varchar(15) NOT NULL,
            `password` varchar(15) NOT NULL,
            `age` varchar(4) NOT NULL,
            `rollNo` varchar(15) NOT NULL,
    PRIMARY KEY (`StudentId`)
);*/

    /*    CREATE TABLE `Questions`  (
                `QuestionId` int(11) NOT NULL AUTO_INCREMENT,
                `Question` varchar(45) NOT NULL,
                `Option1` varchar(15) NOT NULL,
                `Option2` varchar(15) NOT NULL,
                `Option3` varchar(15) NOT NULL,
                `Option4` varchar(15) NOT NULL,
                `CorrectOption` int(5) NOT NULL,
        PRIMARY KEY (`QuestionId`)
    );*/
    public boolean signUpInstructor(Instructor instructor) {
        System.out.println("adding...");
        String sqlInsert = "INSERT INTO " + instructorTable + "(name, phoneNo, email,password) ";
        sqlInsert = sqlInsert + "VALUES (?, ?, ?, ?)";
        int rowsInserted = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sqlInsert);
            statement.setString(1, instructor.getName());
            statement.setString(2, instructor.getPhoneNo());
            statement.setString(3, instructor.getEmail());
            statement.setString(4, instructor.getPassword());
            rowsInserted = statement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(new JFrame(), "Error in inserting data " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (rowsInserted > 0) {
            System.out.println("Instructor is signed up successfully!");
            return true;
        } else {
            System.out.println("Insertion Failed!");
            return false;
        }
    }

    public boolean signUpStudent(Student student) {
        System.out.println("adding...");
        String sqlInsert = "INSERT INTO " + studentTable + "(name, phoneNo, email,password, age,rollNo) ";
        sqlInsert = sqlInsert + "VALUES (?, ?, ?, ?, ?, ?)";
        int rowsInserted = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sqlInsert);
            statement.setString(1, student.getName());
            statement.setString(2, student.getPhoneNo());
            statement.setString(3, student.getEmail());
            statement.setString(4, student.getPassword());
            statement.setString(5, student.getAge());
            statement.setString(6, student.getRollNo());
            rowsInserted = statement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(new JFrame(), "Error in inserting data " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (rowsInserted > 0) {
            System.out.println("Student is signed up successfully!");
            return true;
        } else {
            System.out.println("Insertion Failed!");
            return false;
        }
    }

    public boolean addQuestion(Question question) {
        System.out.println("adding...");
        String sqlInsert = "INSERT INTO " + questionTable + "(Question, Option1, Option2,Option3, Option4,CorrectOption) ";
        sqlInsert = sqlInsert + "VALUES (?, ?, ?, ?, ?, ?)";
        int rowsInserted = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sqlInsert);
            statement.setString(1, question.getQuestion());
            statement.setString(2, question.getOption1());
            statement.setString(3, question.getOption2());
            statement.setString(4, question.getOption3());
            statement.setString(5, question.getOption4());
            statement.setInt(6, question.getCorrectOption());
            rowsInserted = statement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            //JOptionPane.showMessageDialog(new JFrame(), "Error in inserting data " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (rowsInserted > 0) {
            System.out.println("Question added successfully!");
            return true;
        } else {
            System.out.println("Insertion Failed!");
            return false;
        }
    }

    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> list = new ArrayList<>();
        try {
            System.out.println("Getting questions...");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select * from " + questionTable);
            while (resultSet.next()) {
                //    resultSet.getString(1),
                Question question = new Question();
                question.setQuestionId(resultSet.getInt(1));
                question.setQuestion(resultSet.getString(2));
                question.setOption1(resultSet.getString(3));
                question.setOption2(resultSet.getString(4));
                question.setOption3(resultSet.getString(5));
                question.setOption4(resultSet.getString(6));
                question.setCorrectOption(resultSet.getInt(7));
                list.add(question);
                System.out.println("question id " + resultSet.getString(5));
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(new JFrame(), "Error in getting data " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }

        return list;
    }
}
