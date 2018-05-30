package com.example.faturrahman.rumahkita.utils;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.example.faturrahman.rumahkita.login.signup.SignUpActivity;

public class DialogFactory {

    public static void showAlertDialog(String msg, Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(msg);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public static ProgressDialog showProgressDialog(String message, Context context){
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(message);
        progressDialog.show();
        return progressDialog;
    }

    public static void cancelProgressDialog(ProgressDialog progressDialog){
        if(progressDialog.isShowing()){
            progressDialog.cancel();
        }
    }
}
