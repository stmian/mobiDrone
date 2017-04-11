package asu.cse535.group3.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MapPickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_picker);
        Button reqButton = (Button) findViewById(R.id.requestButton);
        reqButton.setOnClickListener( new android.view.View.OnClickListener() {

            @Override
            public void onClick(View v){
                Intent intent = new Intent(getBaseContext(), DroneMapActivity.class);
                startActivity(intent);
            }});
    }
}
