package com.example.museum.ui.first;
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


public class FirstFragment extends Fragment {

    private FirstViewModel firstViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        firstViewModel =
                ViewModelProviders.of(this).get(FirstViewModel.class);
        View root = inflater.inflate(R.layout.fragment_firstpage, container, false);
        final TextView textView = root.findViewById(R.id.text_firstTitle);
        firstViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
