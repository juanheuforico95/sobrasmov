
package com.example.pc.tarea1;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
        private static final int REQUEST_CODE_friends = 2;
    private static final int REQUEST_CODE_MESSAGE = 0;
    private static final int REQUEST_CODE_HOBBY = 1;
    private ImageButton buttonh, buttonf, buttonm;

    private TextView textView2, textView3, textView4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);
        //textView4 = (TextView)findViewById(R.id.textView4);
        Intent intent = getIntent();

        textView2.setText("hi "+ (intent.getStringExtra("helo")));
        buttonh = (ImageButton)findViewById(R.id.imageButton);
        buttonf = (ImageButton)findViewById(R.id.imageButton2);
        buttonm = (ImageButton)findViewById(R.id.imageButton3);
        buttonm.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                messageActivity(v);
            }
        });

        buttonh.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
             hobbyActivity(v);
            }
        });
        buttonf.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, FriendsActivity.class);

                startActivityForResult(intent, REQUEST_CODE_friends);
                finish();

            }
        });

    }


           public void messageActivity(View view) {

           Intent intent = new Intent(this, MessageActivity.class);
           startActivityForResult(intent, REQUEST_CODE_MESSAGE);
       }



 /*public void friendsActivity(View view) {

        Intent intent = new Intent(this, FriendsActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }*/

    public void hobbyActivity(View view) {

        Intent intent = new Intent(this, HobbyActivity.class);
        startActivityForResult(intent, REQUEST_CODE_HOBBY);
    }

    public void getBack(View view){

        Intent intent = new Intent();
        intent.putExtra("regreso", "OK");
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        if(requestCode == REQUEST_CODE_MESSAGE && resultCode == Activity.RESULT_OK){

            Toast.makeText(this, data.getStringExtra("regreso"), Toast.LENGTH_SHORT).show();
            this.textView4.setText(data.getStringExtra("message"));
        }
        else if(requestCode == REQUEST_CODE_HOBBY && resultCode == Activity.RESULT_OK) {

            Toast.makeText(this, data.getStringExtra("regreso"), Toast.LENGTH_SHORT).show();
            this.textView3.setText(data.getStringExtra("hobby"));
        }
        else if(requestCode == REQUEST_CODE_friends && resultCode == Activity.RESULT_OK) {

            Toast.makeText(this, data.getStringExtra("regreso"), Toast.LENGTH_SHORT).show();
        }
    }
}