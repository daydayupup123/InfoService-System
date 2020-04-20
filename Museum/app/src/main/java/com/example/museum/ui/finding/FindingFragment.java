package com.example.museum.ui.finding;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.museum.MuseumActivity;
import com.example.museum.R;


public class FindingFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_findingpage, container, false);
        final TextView textView = root.findViewById(R.id.text_findingTitle);
        textView.setText("发现");
        LinearLayout linearLayout = root.findViewById(R.id.findingsearch1);
        linearLayout.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), MuseumActivity.class));
        });
        return root;
    }
}
