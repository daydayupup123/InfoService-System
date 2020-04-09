package com.example.museum.ui.finding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.museum.R;


public class FindingFragment extends Fragment {

    private FindingViewModel findingViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        findingViewModel =
                ViewModelProviders.of(this).get(FindingViewModel.class);
        View root = inflater.inflate(R.layout.fragment_findingpage, container, false);
        final TextView textView = root.findViewById(R.id.text_findingTitle);
        findingViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
