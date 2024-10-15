package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;


import java.util.Map;

public class Order_Activity extends AppCompatActivity {

    private String coffeType;
    private String coffeAdds;
    private Button confirmOrder;

    private CheckBox milk, sugar, cream, vanilla;

    private RadioButton Ctype;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        milk = findViewById(R.id.a21);
        sugar = findViewById(R.id.a22);
        cream = findViewById(R.id.a23);
        vanilla = findViewById(R.id.a24);


        confirmOrder = findViewById(R.id.confirmBtn);



        confirmOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coffeAdds = "";
//                Log.i("myApp", "Btn Clicked");

                if(milk.isChecked())
                    coffeAdds = "...Milk added";
                if(sugar.isChecked())
                    coffeAdds += "...Sugar added";
                if(cream.isChecked())
                    coffeAdds += "...Cream added";
                if(vanilla.isChecked())
                    coffeAdds += "...Vanilla added";

//                Log.i("myApp", "coffeAdds: " + coffeAdds);
                Intent returnIntent = new Intent();

                returnIntent.putExtra("type", coffeType);
                returnIntent.putExtra("adds", coffeAdds);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });




    }


    public void selectCoffee(View view) {

        if (coffeType != null) {
            Ctype.setChecked(false);
            coffeType = null;
        }

        int id = view.getId();
        Ctype = findViewById(id);

        if (id == R.id.a11) {
            coffeType = "Decaf";
        } else if (id == R.id.a12) {
            coffeType = "Espresso";
        } else if (id == R.id.a13) {
            coffeType = "Colombian";
        } else if (id == R.id.a14) {
            coffeType = "Cappuccino";
        }

    }


}