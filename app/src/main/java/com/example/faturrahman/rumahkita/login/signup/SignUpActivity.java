package com.example.faturrahman.rumahkita.login.signup;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.faturrahman.rumahkita.R;
import com.example.faturrahman.rumahkita.main.MainActivity2;
import com.example.faturrahman.rumahkita.utils.DialogFactory;
import com.example.faturrahman.rumahkita.utils.FirebaseUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity {
    private static final String TAG = "SignUpActivity";

    @BindView(R.id.input_name) EditText _nameText;
    @BindView(R.id.input_email) EditText _emailText;
    @BindView(R.id.input_password) EditText _passwordText;
    @BindView(R.id.input_password_confirm) EditText passwordConfirmText;
    @BindView(R.id.btn_signup) Button _signupButton;
    @BindView(R.id.link_login) TextView _loginLink;

    FirebaseAuth firebaseAuth;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        initActivity();
    }

    private void initActivity() {
        firebaseAuth = FirebaseUtils.getFirebaseAuth();

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                finish();
            }
        });
    }

    public void signup() {
        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();
        String passwordConfirm = passwordConfirmText.getText().toString();


        if(!name.equals("") && !email.equals("") && !password.equals("") && !passwordConfirm.equals("")){
            if(password.equals(passwordConfirm)){
                Log.d(TAG, "Signup");

                _signupButton.setEnabled(false);

                final ProgressDialog progressDialog = DialogFactory.showProgressDialog("Creating Account...", this);

                // Implement your own signup logic here.
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Log.d(TAG, "createUserWithEmail:success");
                                    DialogFactory.cancelProgressDialog(progressDialog);
                                    FirebaseUser user = firebaseAuth.getCurrentUser();
                                    startActivity(new Intent(SignUpActivity.this, MainActivity2.class));
                                    finish();
                                } else {
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    DialogFactory.cancelProgressDialog(progressDialog);
                                    Toast.makeText(getBaseContext(), "Login gagal, email telah digunakan atau gangguan jaringan!", Toast.LENGTH_LONG).show();
                                    _signupButton.setEnabled(true);
                                }
                            }
                        });
            }
            else {
                DialogFactory.showAlertDialog("Password tidak cocok dengan konfirmasi password!", this);
            }
        }
        else {
            DialogFactory.showAlertDialog("Pastikan seluruh kolom terisi dengan benar!", this);
        }

    }

    public boolean validate() {
        boolean valid = true;

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            _nameText.setError("at least 3 characters");
            valid = false;
        } else {
            _nameText.setError(null);
        }

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