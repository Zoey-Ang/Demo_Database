package sg.edu.rp.c346.id20046523.demodatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnGetTask;
    TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.buttonInsert);
        btnGetTask = findViewById(R.id.btnGetTasks);
        tvResult = findViewById(R.id.tvResults);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(MainActivity.this);
                dbh.insertTask("Submit RJ", "25 April 2021");

            }
        });

        btnGetTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(MainActivity.this);
                ArrayList<String> tasks = dbh.getTaskContent();

                String text = " ";
                for(int i=0; i<tasks.size(); i++)
                {
                    text += i + ". " + tasks.get(i) + "\n";
                }
                tvResult.setText(text);


            }
        });
    }
}