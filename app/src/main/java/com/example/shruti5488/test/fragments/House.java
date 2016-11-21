package com.example.shruti5488.test.fragments;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shruti5488.test.R;
import com.example.shruti5488.test.Services.DataService;
import com.example.shruti5488.test.adapters.LegislatorAdapter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.
 * Use the {@link House#newInstance} factory method to
 * create an instance of this fragment.
 */
public class House extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;



    public House() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment House.
     */
    // TODO: Rename and change types and number of parameters
    public static House newInstance(String param1) {
        House fragment = new House();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_house, container, false);
        Log.d("Hello House Fragment","house view created");
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler_layout);
        recyclerView.setHasFixedSize(true);

        final LegislatorAdapter legislatorAdapter;
        legislatorAdapter = new LegislatorAdapter(DataService.getInstance().getHouseList(),this);
        Log.d("Hello house adapter","house list size 12 "+ DataService.getInstance().getHouseList().size());
            // recyclerView.setBackgroundResource(R.drawable.side_nav_bar);

//           legislatorAdapter = new LegislatorAdapter(DataService.getInstance().getSenateList(),this);
//            //  recyclerView.setBackgroundResource(R.drawable.side_nav_bar_mood);


       // recyclerView.addItemDecoration(new HorizontalSpaceItemDecorator(30));
       /* getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {

                legislatorAdapter.notifyDataSetChanged();
            }
        });*/
        recyclerView.setAdapter(legislatorAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
}
