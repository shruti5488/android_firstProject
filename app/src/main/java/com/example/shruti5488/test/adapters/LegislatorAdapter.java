package com.example.shruti5488.test.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shruti5488.test.R;
import com.example.shruti5488.test.holders.LegislatorViewHolder;
import com.example.shruti5488.test.models.Legislator;

import java.util.ArrayList;

/**
 * Created by shruti5488 on 11/19/16.
 */

public class LegislatorAdapter  extends RecyclerView.Adapter<LegislatorViewHolder> {
    private ArrayList<Legislator> legislatorList = new ArrayList<>();
    private Fragment fragment;

    public LegislatorAdapter(ArrayList<Legislator> legislatorList, Fragment currentFragment) {
        this.fragment = currentFragment;
        this.legislatorList = legislatorList;
    }

    @Override
    public LegislatorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return new LegislatorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LegislatorViewHolder holder, final int position) {
        final Legislator legislator = legislatorList.get(position);
        holder.updateUI(legislator);
        //Log.d("MusicGo"," music station " + legislator.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int p = position;
//
////                Fragment SpotifyPlayerFragment = new SpotifyPlayerFragment();
////                Bundle b = new Bundle();
////                b.putString("songUri",legislator.getSongUri());
////                b.putString("songName",legislator.getSongName());
////                b.putString("artistName",legislator.getSongArtist());
////                b.putString("songImage",stations.getImageUri());
////                SpotifyPlayerFragment.setArguments(b);
////
////                FragmentManager fragmentManager = fragment.getActivity().getSupportFragmentManager();
////                fragmentManager.beginTransaction().replace(R.id.main_container,SpotifyPlayerFragment).addToBackStack(null).commit();
//
            }
        });
    }

    @Override
    public int getItemCount() {
        return legislatorList.size();
    }
}
