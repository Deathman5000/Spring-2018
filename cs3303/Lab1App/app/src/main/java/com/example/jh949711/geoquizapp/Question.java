package com.example.jh949711.geoquizapp;

/**
 * Created by jh949711 on 1/24/2018.
 */

public class Question {
    private String statement;
    private boolean answer;

    public void setStatement(String s){
        statement = s;
    }
    public void setAnswer(boolean b){
        answer = b;
    }
    public String getStatement(){
        return statement;
    }
    public boolean getAnswer(){
        return answer;
    }
}
