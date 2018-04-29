package com.example.faturrahman.rumahkita.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.faturrahman.rumahkita.R;

/**
 * Created by Faturrahman on 4/28/2018.
 */

public class ChatFragment extends android.support.v4.app.Fragment{
    public ChatFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }
}
