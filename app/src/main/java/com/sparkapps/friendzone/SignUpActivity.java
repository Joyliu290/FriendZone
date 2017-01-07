package com.sparkapps.friendzone;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.*;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {


    private EditText mUsername,mEmail, mPassword;
    private Button  mSignUpButton;
    private ProgressBar mProgressBar;
    private FirebaseAuth mFireBaseAuth;
    protected DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Get Firebase auth instance
        mFireBaseAuth = FirebaseAuth.getInstance();

        mUsername = (EditText) findViewById(R.id.userName_signup);
        mEmail = (EditText) findViewById(R.id.email_signup);
        mPassword = (EditText) findViewById(R.id.password_signup);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mSignUpButton = (Button) findViewById(R.id.sign_up_button);

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {

                                                 String username = mUsername.getText().toString().trim();
                                                 String email = mEmail.getText().toString().trim();
                                                 String password = mPassword.getText().toString().trim();

                                                 if (username.isEmpty() || password.isEmpty() || email.isEmpty())
                                                 {
                                                     AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                                                     builder.setTitle(getString(R.string.signup_error_title));
                                                     builder.setMessage(getString(R.string.signup_error_message));
                                                     builder.setPositiveButton(android.R.string.ok, null);
                                                     AlertDialog dialog = builder.create();
                                                     dialog.show();

                                                 }
                                                 else
                                                 {
                                                     //data is good
                                                     mProgressBar.setVisibility(View.VISIBLE);

                                                     mFireBaseAuth.createUserWithEmailAndPassword(email,password)
                                                             .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                                                                 @Override
                                                                 public void onComplete(@NonNull Task<AuthResult> task) {
                                                                     Toast.makeText(SignUpActivity.this, R.string.signup_success, Toast.LENGTH_SHORT).show();
                                                                     mProgressBar.setVisibility(View.INVISIBLE);

                                                                     // If sign in fails, display a message to the user. If sign in succeeds
                                                                     // the auth state listener will be notified and logic to handle the
                                                                     // signed in user can be handled in the listener.
                                                                     if (!task.isSuccessful()) {
                                                                         Toast.makeText(SignUpActivity.this, "Authentication failed." + task.getException().getMessage(),
                                                                                 Toast.LENGTH_SHORT).show();

                                                                         AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                                                                         builder.setTitle(getString(R.string.signup_error_title));
                                                                         builder.setMessage(task.getException().getMessage());
                                                                         builder.setPositiveButton(android.R.string.ok, null);
                                                                         AlertDialog dialog = builder.create();
                                                                         dialog.show();

                                                                     } else {

                                                                         createAccountWithUsername(task.getResult().getUser());
                                                                         Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                                                                         intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                                         intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                                         startActivity(intent);
                                                                     }
                                                                 }
                                                             });

                                                 }

                                             }
                                         }
        );


    }

    private void createAccountWithUsername(FirebaseUser userfromRegistration)
    {
        String username = mUsername.getText().toString().trim();
        String email = userfromRegistration.getEmail();
        String userId = userfromRegistration.getUid();

        User user = new User (username,email);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("users").child(userId).setValue(user);


    }
}
