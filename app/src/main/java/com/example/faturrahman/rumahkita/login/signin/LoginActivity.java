package com.example.faturrahman.rumahkita.login.signin;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.faturrahman.rumahkita.utils.DialogFactory;
import com.example.faturrahman.rumahkita.utils.FirebaseUtils;
import com.example.faturrahman.rumahkita.main.MainActivity2;
import com.example.faturrahman.rumahkita.R;
import com.example.faturrahman.rumahkita.login.signup.SignUpActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;

    @BindView(R.id.input_email) EditText _emailText;
    @BindView(R.id.input_password) EditText _passwordText;
    @BindView(R.id.btn_login) Button _loginButton;
    @BindView(R.id.link_signup) TextView _signupLink;

    FirebaseAuth firebaseAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initActivity();
    }

    private void initActivity() {
        firebaseAuth = FirebaseUtils.getFirebaseAuth();

        //enable loginUser button
        _loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        //enable sign up label
        _signupLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
    }

    public void loginUser() {
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        //check if email or password is empty, if any of this empty, return alert dialog that state thi edit text is currently empty
        if(!email.equals("") && !password.equals("")){
            Log.d(TAG, "Login");

            _loginButton.setEnabled(false);

            final ProgressDialog progressDialog = DialogFactory.showProgressDialog("Authenticating...", this);

            // Implement your own authentication logic here.
            firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Log.d(TAG, "signInWithEmail:success");
                                DialogFactory.cancelProgressDialog(progressDialog);
                                _loginButton.setEnabled(true);
                                startActivity(new Intent(LoginActivity.this, MainActivity2.class));
                                finish();
                            } else {
                                Log.w(TAG,"signInWithEmail:failure", task.getException());
                                DialogFactory.cancelProgressDialog(progressDialog);
                                if(Objects.requireNonNull(task.getException()).getMessage().contains("no user record")){
                                    Toast.makeText(getBaseContext(), "Login gagal, Akun tidak ditemukan!", Toast.LENGTH_LONG).show();
                                }
                                else if(Objects.requireNonNull(task.getException()).getMessage().contains("password is invalid")){
                                    Toast.makeText(getBaseContext(), "Login gagal, Password salah!", Toast.LENGTH_LONG).show();
                                }
                                else {
                                    Toast.makeText(getBaseContext(), "Login gagal, Jaringan bermasalah!", Toast.LENGTH_LONG).show();
                                }
                                _loginButton.setEnabled(true);
                            }
                        }
                    });
        }
        else {
            DialogFactory.showAlertDialog("Pastikan email dan password tidak kosong!", this);
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }
}