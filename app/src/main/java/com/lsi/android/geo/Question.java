package com.lsi.android.geo;

/**
 * Created by Danny avila Baque on 06/12/2015.
 */
public class Question {

    private int questionId;
    private boolean isTrue;

    public Question(int questionId,boolean isTrue){
           this.setQuestionId(questionId);
           this.setIsTrue(isTrue);

    }

    public int getQuestionId() { return questionId;}

    public void setQuestionId(int questionId) { this.questionId = questionId; }

    public boolean isTrue() { return isTrue; }

    public void setIsTrue(boolean isTrue) { this.isTrue = isTrue; }
}
