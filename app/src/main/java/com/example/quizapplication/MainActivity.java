package com.example.quizapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView Question;
    Button yes,no;


    public String[] questions = {" Q1. Can constructors be synchronized in Java ?","Q2. Can we use null as a key for a map collection ?","Q3. Can we overload main method in Java ??"
            ," Q4. Can we override static methods ? Why ?","Q5. Can we reduce the visibility of the inherited or overridden method ?","Q6. Can we declare interface methods as private ?"
    ,"Q7. Can we have multiple servlets in a web application and How can we do that ?","Q8. Can we instantiate the object of derived class if parent constructor is protected ?",
    "Q9. Can we call constructor explicitly ?","Q10. Is it possible to compile and run a Java program without writing main( ) method?"," Q11. Does java allow implementation of multiple interfaces having Default methods with Same name and Signature ?"
    ,"Q12. Can we use static method definitions in Interfaces ?","Q13. Can we reduce the visibility of the overridden method ?","Q14. Does Java provides default copy constructor ?"
    ,"Q15. Is runnable a Marker interface ?","Q16. Will Compiler creates a default no argument constructor if we specify only multi argument constructor ?","Q17. Can we overload constructors ?",
   "Q18. Do we need to import java.lang package ?"," Q19. Can finally block be used without catch ?"," Q20. Can we declare an abstract method private ?"};
    public boolean answers[] ={false,true,true,false,false,true,true,true,true,true,false,true,false,false,false,false,true,false,true,false};
    int i=0;
    int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Question=findViewById(R.id.Question);
        yes=findViewById(R.id.yes);
        no=findViewById(R.id.no);

        Question.setText(questions[i]);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if the array is not going out of bound
                if (i<=questions.length-1){
                    //if you have given correct answer
                    if (answers[i]==true){
                        score++;
                    }
                    i++;
                }

                if (i<=questions.length-1){
                    Question.setText(questions[i]);

                }
                else {
                    Toast.makeText(MainActivity.this,"Your score is: "+score,Toast.LENGTH_SHORT).show();
                }



            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if the array is not going out of bound
                if (i<=questions.length-1){
                    //if you have given correct answer
                    if (answers[i]==false){
                        score++;
                    }
                    i++;


                }

                if (i<=questions.length-1){
                    Question.setText(questions[i]);

                }
                else {
                    Toast.makeText(MainActivity.this,"Your score is: "+score,Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.replay:
                i=0;
                score=0;
                Question.setText(questions[i]);
        }
        return true;
    }
}