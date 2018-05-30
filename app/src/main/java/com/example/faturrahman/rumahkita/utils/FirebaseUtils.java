package com.example.faturrahman.rumahkita.utils;

import android.content.Context;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.storage.FirebaseStorage;

public class FirebaseUtils {

    private static FirebaseAuth firebaseAuth;
    private static FirebaseDatabase firebaseDatabase;
    private static FirebaseMessaging firebaseMessaging;
    private static FirebaseStorage firebaseStorage;

    public static void setPersistentEnabled() {
        if (firebaseDatabase == null) {
            firebaseDatabase = FirebaseDatabase.getInstance();
            firebaseDatabase.setPersistenceEnabled(true);
        }
    }

    public static FirebaseAuth getFirebaseAuth() {
        if (firebaseAuth == null) {
            firebaseAuth = FirebaseAuth.getInstance();
        }
        return firebaseAuth;
    }

    public static FirebaseAnalytics getFirebaseAnalytic(Context context) {
        return FirebaseAnalytics.getInstance(context);
    }

    public static FirebaseDatabase getFirebaseDatabase() {
        if (firebaseDatabase == null) {
            firebaseDatabase = FirebaseDatabase.getInstance();
            try {
                firebaseDatabase.setPersistenceEnabled(true);
            } catch (Exception ignored) {
            }
        }
        return firebaseDatabase;
    }

    public static FirebaseMessaging getFirebaseMessaging() {
        if (firebaseMessaging == null) {
            firebaseMessaging = FirebaseMessaging.getInstance();
        }
        return firebaseMessaging;
    }

    public static FirebaseStorage getFirebaseStorage() {
        if (firebaseStorage == null) {
            firebaseStorage = FirebaseStorage.getInstance();
        }
        return firebaseStorage;
    }
}
