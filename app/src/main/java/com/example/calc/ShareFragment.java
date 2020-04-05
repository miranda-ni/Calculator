package com.example.calc;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ShareFragment extends Fragment {
    private View view;
    private  TextView textView;

    public ShareFragment() {
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_display, container, false);
        initView();
        Bundle bundle = this.getArguments();
        if (bundle != null){
            textView.setText(bundle.getString("share"));
            Log.d("ololo", "onCreateView: ");




        }
        return view;
    }
    private void initView(){
        textView = view.findViewById(R.id.secondResult);
    }
}


