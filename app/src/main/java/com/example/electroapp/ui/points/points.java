package com.example.electroapp.ui.points;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Debug;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.electroapp.MainActivity;
import com.example.electroapp.R;
import com.example.electroapp.adapter.PointAdapter;
import com.example.electroapp.model.Point;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link points#newInstance} factory method to
 * create an instance of this fragment.
 */
public class points extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View view;
    Button btn_add;
    RecyclerView mRecycler;
    PointAdapter mAdapter;
    FirebaseFirestore mFireStore;
    public points() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment points.
     */
    // TODO: Rename and change types and number of parameters
    public static points newInstance(String param1, String param2) {
        points fragment = new points();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFireStore = FirebaseFirestore.getInstance();
        mRecycler = (RecyclerView) view.findViewById(R.id.recyclerViewSingle);
        mRecycler.setLayoutManager(new LinearLayoutManager(this.getContext()));
        Query query = mFireStore.collection("point");
        FirestoreRecyclerOptions<Point> firestoreRecyclerOptions =
                new FirestoreRecyclerOptions.Builder<Point>().setQuery(query,Point.class).build();
        mAdapter = new PointAdapter(firestoreRecyclerOptions);
        mAdapter.notifyDataSetChanged();
        mRecycler.setAdapter(mAdapter);
        view = inflater.inflate(R.layout.fragment_points, container, false);
        btn_add = (Button) view.findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);
        getActivity().setTitle("Puntos");
        return view;
    }

    @Override
    public void onClick(View v) {
        //do what you want to do when button is clicked
        switch (v.getId()) {
            case R.id.btn_add:
                startActivity(new Intent(getActivity(), newPoint.class));
                break;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        mAdapter.stopListening();
    }
}