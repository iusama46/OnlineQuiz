package com.quiz.student;

import com.quiz.models.Question;
import com.quiz.models.Quiz;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Ussama Iftikhar on 27-Jan-2021.
 * Email iusama46@gmail.com
 * Email iusama466@gmail.com
 * Github https://github.com/iusama46
 */
public class StudentQuestionsScreen extends javax.swing.JFrame implements Runnable {

    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private int selectedQuestion;
    private final ArrayList<Question> questionList;
    private int questionsCount;
    private final ArrayList<Quiz> quizList;

    /**
     * Creates new form StudentQuestionsScreen
     */
    public StudentQuestionsScreen(ArrayList<Question> questionList) {
        selectedQuestion = 1;
        questionsCount = 1;
        quizList = new ArrayList<>();
        this.questionList = questionList;
        initComponents();
        this.setLocationRelativeTo(null);
    }


    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Online Quiz (Student)");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText(questionsCount + "/" + questionList.size());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText(questionList.get(questionsCount - 1).getQuestion() + "?");


        jCheckBox1.setText(questionList.get(questionsCount - 1).getOption1());
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText(questionList.get(questionsCount - 1).getOption2());
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setText(questionList.get(questionsCount - 1).getOption3());
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jCheckBox4.setText(questionList.get(questionsCount - 1).getOption4());
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jCheckBox3)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jCheckBox4))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jCheckBox1)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jCheckBox2))
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(154, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jCheckBox1)
                                        .addComponent(jCheckBox2))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jCheckBox3)
                                        .addComponent(jCheckBox4))
                                .addGap(31, 31, 31)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (questionsCount == questionList.size() && jButton1.isEnabled()) {
            checkQuestion();
            jButton1.setEnabled(false);

            new MyJTable(quizList);
            //JOptionPane.showMessageDialog(new JFrame(), "All " + questionList.size() + " Question Added", "Done", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        checkQuestion();
        questionsCount++;

        jLabel2.setText(questionsCount + "/" + questionList.size());

        jLabel3.setText(questionList.get(questionsCount - 1).getQuestion() + "?");
        jCheckBox1.setText(questionList.get(questionsCount - 1).getOption1());
        jCheckBox2.setText(questionList.get(questionsCount - 1).getOption2());
        jCheckBox3.setText(questionList.get(questionsCount - 1).getOption3());
        jCheckBox4.setText(questionList.get(questionsCount - 1).getOption4());

        jLabel2.setText(questionsCount + "/" + questionList.size());
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jCheckBox3.setSelected(false);
        jCheckBox4.setSelected(false);
        selectedQuestion = 1;

        // TODO add your handling code here:
    }

    private void checkQuestion() {
        if (questionList.get(questionsCount - 1).getCorrectOption() == selectedQuestion) {
            quizList.add(new Quiz(String.valueOf(questionsCount), true));
            System.out.println("true..");
        } else
            quizList.add(new Quiz(String.valueOf(questionsCount), false));
        System.out.println("false..");
    }

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        JCheckBox jCheckBox = (JCheckBox) evt.getSource();
        if (jCheckBox.isSelected()) {
            jCheckBox2.setSelected(false);
            jCheckBox3.setSelected(false);
            jCheckBox4.setSelected(false);
            selectedQuestion = 1;
        }

    }

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        JCheckBox jCheckBox = (JCheckBox) evt.getSource();
        if (jCheckBox.isSelected()) {
            jCheckBox2.setSelected(false);
            jCheckBox1.setSelected(false);
            jCheckBox4.setSelected(false);
            selectedQuestion = 3;
        }
    }

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        JCheckBox jCheckBox = (JCheckBox) evt.getSource();
        if (jCheckBox.isSelected()) {
            jCheckBox2.setSelected(false);
            jCheckBox3.setSelected(false);
            jCheckBox1.setSelected(false);
            selectedQuestion = 4;
        }
    }

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {
        JCheckBox jCheckBox = (JCheckBox) evt.getSource();
        if (jCheckBox.isSelected()) {
            jCheckBox1.setSelected(false);
            jCheckBox3.setSelected(false);
            jCheckBox4.setSelected(false);
            selectedQuestion = 2;
        }
    }

    @Override
    public void run() {
        if (questionList.get(questionsCount - 1).getCorrectOption() == selectedQuestion) {
            System.out.println("true..");
        } else
            quizList.add(new Quiz(String.valueOf(questionsCount), false));
        System.out.println("false..");
    }
}

