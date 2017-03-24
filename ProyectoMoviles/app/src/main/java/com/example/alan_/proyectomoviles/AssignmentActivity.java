package com.example.alan_.proyectomoviles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class AssignmentActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView crsDetails;
    private EditText inputName, inputGrade, inputDuedate;
    private Button btnSave;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    //  private String userId;
    private String AssignmentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);
        Intent intent = getIntent();

        // Displaying toolbar icon
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        crsDetails = (TextView) findViewById(R.id.txt_Assignment);
        inputName = (EditText) findViewById(R.id.AssignmentTitle);
        inputGrade = (EditText) findViewById(R.id.AssignmentDay);
        inputDuedate = (EditText) findViewById(R.id.AssignmentTime);

        btnSave = (Button) findViewById(R.id.btn_saveAssignment);

        mFirebaseInstance = FirebaseDatabase.getInstance();

        // get reference to 'users' node
        mFirebaseDatabase = mFirebaseInstance.getReference("assignments");

        // store app title to 'app_title' node
        mFirebaseInstance.getReference("app_title").setValue("Realtime Database");

        // app_title change listener
        mFirebaseInstance.getReference("app_title").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e(TAG, "App title updated");

                String appTitle = dataSnapshot.getValue(String.class);

                // update toolbar title
                getSupportActionBar().setTitle(appTitle);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e(TAG, "Failed to read app title value.", error.toException());
            }
        });

        // Save / update the user
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Title = inputName.getText().toString();
                String Grade = (int)inputGrade.getText();
                String DueDate = inputDuedate.getText().toString();

                // Check for already existed userId
                if (TextUtils.isEmpty(AssignmentId)) {
                    createAssignment(Title, Grade, DueDate);
                } else {
                    updateAssignment(Title, Grade, DueDate);
                }
            }
        });

        toggleButton();
    }

    // Changing button text
    private void toggleButton() {
        if (TextUtils.isEmpty(AssignmentId)) {
            btnSave.setText("Save Assignment");
        } else {
            btnSave.setText("Update");
        }
    }

    /**
     * Creating new user node under 'users'
     */
   /* private void createUser(String name, String email) {
        // TODO
        // In real apps this userId should be fetched
        // by implementing firebase auth
        if (TextUtils.isEmpty(userId)) {
            userId = mFirebaseDatabase.push().getKey();
        }

        User user = new User(name, email);

        mFirebaseDatabase.child(userId).setValue(user);

        addUserChangeListener();
    }
*/
    private void createAssignment(String AssignmentTittle, String AssignmentDay, String AssignmentTime) {
        // TODO
        // In real apps this userId should be fetched
        // by implementing firebase auth
        if (TextUtils.isEmpty(AssignmentId)) {
            AssignmentId = mFirebaseDatabase.push().getKey();
        }

        Assignment Assignment = new Assignment(AssignmentTittle, AssignmentDay, AssignmentTime);

        mFirebaseDatabase.child(AssignmentId).setValue(Assignment);

        addAssignmentChangeListener();
    }

  /*  private void createAssignment(String assignmentName, String assignmentGrade, String assignmentDueDate) {
        // TODO
        // In real apps this userId should be fetched
        // by implementing firebase auth
        if (TextUtils.isEmpty(userId)) {
            userId = mFirebaseDatabase.push().getKey();
        }

        Assignment assignment = new Assignment(assignmentName, assignmentGrade, assignmentDueDate);

        mFirebaseDatabase.child(userId).setValue(assignment);

        addUserChangeListener();
    }
*/
    /**
     * User data change listener
     */
    private void addAssignmentChangeListener() {
        // User data change listener
        mFirebaseDatabase.child(AssignmentId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Assignment Assignment = dataSnapshot.getValue(Assignment.class);

                // Check for null
                if (Assignment == null) {
                    Log.e(TAG, "User data is null!");
                    return;
                }

                Log.e(TAG, "Assignment data is changed!" + Assignment.AssignmentTittle + ", " + Assignment.AssignmentDay + ", " + Assignment.AssignmentTime);

                // Display newly updated name and email
                crsDetails.setText(Assignment.AssignmentTittle + ", " + Assignment.AssignmentDay + ", " + Assignment.AssignmentTime);

                // clear edit text
                inputName.setText("");
                inputGrade.setText("");
                inputDuedate.setText("");


                toggleButton();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e(TAG, "Failed to read user", error.toException());
            }
        });
    }

    private void updateAssignment(String AssignmentTittle, String AssignmentDay, String AssignmentTime) {
        // updating the user via child nodes
        if (!TextUtils.isEmpty(AssignmentTittle))
            mFirebaseDatabase.child(AssignmentId).child("title").setValue(AssignmentTittle);

        if (!TextUtils.isEmpty(AssignmentDay))
            mFirebaseDatabase.child(AssignmentId).child("day").setValue(AssignmentDay);
        if (!TextUtils.isEmpty(AssignmentTime))
            mFirebaseDatabase.child(AssignmentId).child("time").setValue(AssignmentTime);


    }


    public void findItem (View view){
        String child = "";
        String Assignment = "";
        Query query =;
        query.addChildEventListener(childEventListener);

    }
}