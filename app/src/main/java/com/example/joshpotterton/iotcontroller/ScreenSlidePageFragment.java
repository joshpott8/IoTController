package com.example.joshpotterton.iotcontroller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by josh.potterton on 10/08/2015.
 */
public class ScreenSlidePageFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = (View) inflater.inflate(R.layout.function_frag, container, false);

        return rootView;
    }
}
