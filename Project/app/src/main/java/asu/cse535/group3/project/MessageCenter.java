package asu.cse535.group3.project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static asu.cse535.group3.project.R.id.EditText02;

/**
 * Created by ajain64 on 4/20/2017.
 */

public class MessageCenter extends AppCompatActivity {
    private DatabaseHandler dh;
    private String username = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_center);

        Bundle extras = getIntent().getExtras();
        if(extras!=null)
        {
            username = getIntent().getStringExtra("USERNAME");
        }

        final Button feedback = (Button) findViewById(R.id.submitFeedback);
        final EditText message = (EditText) findViewById(R.id.EditText02);

        dh = new DatabaseHandler(this);

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageText = message.getText().toString();
                AlertDialog.Builder builder = new AlertDialog.Builder(MessageCenter.this);

               dh.addFeedback(username, messageText);


                builder.setMessage("Your message has been sent. Thank you for your feedback!")
                        .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                message.setText("");
                                finish();
                            }
                        })
                        .create()
                        .show();



                }





        });
    }
}

