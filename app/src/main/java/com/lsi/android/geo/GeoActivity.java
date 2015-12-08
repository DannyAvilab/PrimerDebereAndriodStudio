package com.lsi.android.geo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class GeoActivity extends AppCompatActivity {
    private Button btnTrue;
    private Button btnFalse;
    private ImageButton btnNext;
    private ImageButton btnAnter;
    private TextView txtQuestion;
    private int currentIndex=0;

    private Question[] questions=new Question[]{
         new Question(R.string.question_barce,true),
         new Question(R.string.question_sema,false),
         new Question(R.string.question_ecuador,true),
         new Question(R.string.question_bill,false),
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo);

        btnTrue = (Button) findViewById(R.id.btnTrue);
        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });
        btnFalse = (Button) findViewById(R.id.btnFalse);
        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });


        txtQuestion=(TextView)findViewById(R.id.textQuestion);
        updateQuestion();


        btnNext = (ImageButton) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex=currentIndex+1%questions.length;
                updateQuestion();



            }
        });
        btnAnter = (ImageButton) findViewById(R.id.btnAnter);
        btnAnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex=currentIndex-1%questions.length;
                updateQuestion();
            }
        });

     }


    private void updateQuestion()
        {
            int question=questions[currentIndex].getQuestionId();
            txtQuestion.setText(question);
        }


    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue=questions[currentIndex].isTrue();
        int messageResId=0;
        if(userPressedTrue==answerIsTrue){
            messageResId=R.string.correct_toast;
        }else {
            messageResId=R.string.incorrect_toast;
        }
        Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_geo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
