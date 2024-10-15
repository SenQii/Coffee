package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
    }
    @Override
    protected void onActivityResult(int reqCode, int resCode, Intent data) {
        super.onActivityResult(reqCode, resCode, data);
        onActRes(reqCode, resCode, data);
    }

    public void goMakeOrder(View view){
        Intent i = new Intent(this, Order_Activity.class);
         startActivityForResult(i, 1);
    }


    public void goToRating(View view) {
        Intent i = new Intent(this, Rating_Activity.class);
        startActivityForResult(i, 2);
    }

    public void onActRes(int reqCode, int resCode, Intent data) {

        if (resCode == RESULT_OK && reqCode == 1) {

            String order = data.getStringExtra("type") +
                    data.getStringExtra("adds");
//            Log.i("myApp", "Order: " + order);
            showToast(order);

    } else if (resCode == RESULT_OK && reqCode == 2) {

//            Log.i("myApp", "Rating: " + data.getIntExtra("rating", 0));
//            Log.i("myApp", "Comment: " + data.getStringExtra("usercomment"));
            showToast("Thank you " + data.getStringExtra("username") + " for your comment!");

        }

    } // actRes


    public void showToast(String message ) {
        Toast.makeText(
                getApplicationContext(),
                message,
                Toast.LENGTH_SHORT
        ).show();
    }
}