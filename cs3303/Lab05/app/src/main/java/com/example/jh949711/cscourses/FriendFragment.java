package com.example.jh949711.cscourses;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * This deals with the orientation of the screen for the app
 */

public class FriendFragment extends ListFragment {
    boolean mDualPane;
    int position = 0;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> connectArrayToListView = new
                ArrayAdapter<String>(getActivity(), R.layout.row_label, CSinfo.Courses);
        setListAdapter(connectArrayToListView);
        View detailFrame = getActivity().findViewById(R.id.details);
        mDualPane = (detailFrame != null) && (detailFrame.getVisibility() == View.VISIBLE);
        if (savedInstanceState != null){
            position = savedInstanceState.getInt("curChoice", 0);
        }
        if (mDualPane){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showDetails(position);
        }
        else{
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            getListView().setItemChecked(position,true);

        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curChoice",position);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        //super.onListItemClick(l, v, position, id);
        showDetails(position);
    }

    public void showDetails(int index){
        position = index;
        if(mDualPane){
            getListView().setItemChecked(index,true);
            DetailsFragment detailsFragment = (DetailsFragment)getFragmentManager().
                    findFragmentById(R.id.details);
            if(detailsFragment == null || detailsFragment.getShowIndex() != index){
                detailsFragment = DetailsFragment.newInstance(index);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.details,detailsFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }

        }
        else{
            Intent intent = new Intent();
            intent.setClass(getActivity(), DetailsActivity.class);
            intent.putExtra("index", index);
            startActivity(intent);
        }
    }
}
