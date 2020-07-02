package com.transpo02.portus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Submit Button
        Button submitButton = (Button) findViewById(R.id.submitTicket);
        //Ticket number text input box
        EditText ticketNumber = (EditText) findViewById(R.id.ticketNumber);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //here is where we query the database
                Toast.makeText(getApplicationContext(), "Need to add db query",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}