package com.example.joshpotterton.iotcontroller;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by josh.potterton on 10/08/2015.
 */
public class ScreenSlidePageFragment extends Fragment {

    private int pos;
    private TextView textView;
    private SeekBar seekBar;
    private LinearLayout linearLayout;
    private View view;

    public static ScreenSlidePageFragment create(int i){
        ScreenSlidePageFragment frag = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt("position", i);
        frag.setArguments(args);
        return frag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = (View) inflater.inflate(R.layout.function_frag, container, false);
        textView = (TextView) rootView.findViewById(R.id.text);
        seekBar = (SeekBar) rootView.findViewById(R.id.seekBar);
        linearLayout = (LinearLayout) rootView.findViewById(R.id.linear);
        pos = getArguments().getInt("position");
        view = rootView;
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Set up pages
        switch(pos){
            case 0:
                textView.setText("On");
                seekBar.setVisibility(View.GONE);
                view.setBackgroundColor(Color.CYAN);
                break;
            case 1:
                textView.setText("Off");
                textView.setTextColor(Color.WHITE);
                seekBar.setVisibility(View.GONE);
                view.setBackgroundColor(Color.RED);
                break;
            case 2:
                textView.setText("Flicker");
                textView.setTextColor(Color.DKGRAY);
                seekBar.setVisibility(View.GONE);
                break;
            case 3:
                textView.setText("Blink (1/sec)");
                textView.setTextSize(25);
                textView.setTextColor(Color.WHITE);
                seekBar.setVisibility(View.VISIBLE);
                view.setBackgroundColor(Color.MAGENTA);
                break;
            case 4:
                textView.setText("Flash (1/sec)");
                textView.setTextSize(25);
                textView.setTextColor(Color.WHITE);
                seekBar.setVisibility(View.VISIBLE);
                view.setBackgroundColor(Color.GREEN);
                break;
        }

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String str = textView.getText().toString();

                if(str.contains("Blink")){
                    textView.setText("Blink (" + Integer.toString(progress + 1) + "/sec)");
                }
                else{
                    textView.setText("Flash (" + Integer.toString(progress + 1) + "/sec)");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Nothing
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Nothing
            }
        });

        //Click on text to send datagram
        textView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), textView.getText().toString(), Toast.LENGTH_SHORT).show();

                //Deal with udp datagrams to send here

            }
        });

    }
}
