package com.quiz;

import com.quiz.database.MySQL;

/**
 * Created by Ussama Iftikhar on 27-Jan-2021.
 * Email iusama46@gmail.com
 * Email iusama466@gmail.com
 * Github https://github.com/iusama46
 */

public class Main {

    public static MySQL mySQL;

    public static void main(String[] args) {
        mySQL= new MySQL();
        new SignUpScreen().setVisible(true);
    }

}
