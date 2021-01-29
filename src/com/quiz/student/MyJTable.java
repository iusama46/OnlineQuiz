package com.quiz.student;

import com.quiz.models.Quiz;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Ussama Iftikhar on 27-Jan-2021.
 * Email iusama46@gmail.com
 * Email iusama466@gmail.com
 * Github https://github.com/iusama46
 */

public class MyJTable {
    JFrame jFrame;
    JTable jTable;

    public MyJTable(ArrayList<Quiz> quizArrayList) {

        jFrame = new JFrame();
        jFrame.setTitle("Result");

        /*Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - jFrame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - jFrame.getHeight()) /2 );
        jFrame.setLocation(x, y);*/
        jFrame.setLocationRelativeTo(null);
        String[][] dataList = new String[quizArrayList.size() + 1][3];
        int count = 0;
        int i;
        for (i = 0; i < quizArrayList.size(); i++) {
            dataList[i][0] = "Q" + String.valueOf(quizArrayList.get(i).getId());
            if (quizArrayList.get(i).isCorrect()) {
                dataList[i][1] = "Correct";
                count++;
            } else
                dataList[i][1] = "Incorrect";

        }

        dataList[i][0] = "Total Score";
        dataList[i][1] = count + "/" + (quizArrayList.size());
        String[] columnNames = {"Question#", "Result"};

        jTable = new JTable(dataList, columnNames);
        jTable.setBounds(30, 40, 300, 400);


        JScrollPane sp = new JScrollPane(jTable);
        jFrame.add(sp);

        jFrame.setSize(500, 400);
        jFrame.setVisible(true);
    }
}