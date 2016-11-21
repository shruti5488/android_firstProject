package com.example.shruti5488.test.fragments;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shruti5488.test.R;
import com.example.shruti5488.test.Services.DataService;
import com.example.shruti5488.test.adapters.LegislatorAdapter;
import com.example.shruti5488.test.models.Legislator;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link State#newInstance} factory method to
 * create an instance of this fragment.
 */
public class State extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;



    public State() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment State.
     */
    // TODO: Rename and change types and number of parameters
    public static State newInstance(String param1) {
        State fragment = new State();
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
        View view =  inflater.inflate(R.layout.fragment_state, container, false);

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler_layout);
        recyclerView.setHasFixedSize(true);

        final LegislatorAdapter legislatorAdapter;

        legislatorAdapter = new LegislatorAdapter(DataService.getInstance().getStateList(),this);
            // recyclerView.setBackgroundResource(R.drawable.side_nav_bar_featured);

        /*getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {

                legislatorAdapter.notifyDataSetChanged();
            }
        });*/
       // recyclerView.addItemDecoration(new HorizontalSpaceItemDecorator(30));
        recyclerView.setAdapter(legislatorAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }

//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
//        mListener = null;
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
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}

class HorizontalSpaceItemDecorator extends RecyclerView.ItemDecoration {
    private final int spacer;

    public HorizontalSpaceItemDecorator(int spacer) {
        this.spacer = spacer;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.right = spacer;
    }
}