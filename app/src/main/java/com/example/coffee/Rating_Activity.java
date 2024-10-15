package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;


public class Rating_Activity extends AppCompatActivity {

    private String userName;
    private String comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        Button submitBtn = findViewById(R.id.submit);

        TextInputEditText nameFeild = findViewById(R.id.nameInput);
        TextInputEditText commentMessage = findViewById(R.id.commentMessage);


        nameFeild.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
//                Log.i("myApp", "name: " + s.toString());
                userName = s.toString();
            }
        } );

        commentMessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable t) {
//                    Log.i("myApp", "comment: " + t.toString());
                    comment = t.toString();
            }
        });


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                return intent with rating data

                Intent i = new Intent();
                Log.i("myApp", "comment: \"" +comment+"\" from "+userName);
                i.putExtra("username", userName);
                i.putExtra("usercomment", comment);
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}