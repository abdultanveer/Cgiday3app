package com.example.cgiday3app;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class HeadlinesFragment extends Fragment implements AdapterView.OnItemClickListener {

    ListView headlinesListView;

    public HeadlinesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_headlines, container, false);
    headlinesListView = view.findViewById(R.id.headlineslv);
    headlinesListView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        String itemClicked = adapterView.getItemAtPosition(position).toString();
        Toast.makeText(getContext(), itemClicked, Toast.LENGTH_SHORT).show();

    }
}
