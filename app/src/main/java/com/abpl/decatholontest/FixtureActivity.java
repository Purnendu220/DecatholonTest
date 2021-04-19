package com.abpl.decatholontest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.abpl.decatholontest.adapter.FixtureListAdapter;
import com.abpl.decatholontest.adapter.TeamListAdapter;
import com.abpl.decatholontest.databinding.ActivityFixtureBinding;
import com.abpl.decatholontest.databinding.ActivityMainBinding;
import com.abpl.decatholontest.models.FixtureModel;
import com.abpl.decatholontest.models.TeamModel;
import com.abpl.decatholontest.utils.AdapterCallbacks;
import com.abpl.decatholontest.utils.Helper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class FixtureActivity extends AppCompatActivity implements AdapterCallbacks<Object> {

    ActivityFixtureBinding binding;
    Context context;
    List<FixtureModel> fixtures = new ArrayList<>();
    FixtureListAdapter fixtureListAdapter;
    List<TeamModel> teamList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFixtureBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context = this;
        teamList = getAllTeams();

        setupFixtureListView();
        binding.btnStart.setOnClickListener(view -> {
            if(fixtures.size()>1){
                simulate();

            }else{
                Intent i = new Intent(this,FixtureResult.class);
                i.putExtra("final_fixture",fixtures.get(0));
                startActivity(i);
                finish();
            }
        });

    }

    private void setupFixtureListView(){
        getAllFixtureList();
        fixtureListAdapter=new FixtureListAdapter(context,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.recyclerViewList.setLayoutManager(mLayoutManager);
        binding.recyclerViewList.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerViewList.setAdapter(fixtureListAdapter);
        fixtureListAdapter.addAllFixture(fixtures);
        fixtureListAdapter.notifyDataSetChanged();


    }

    private void getAllFixtureList(){
        fixtures = new ArrayList<>();

        for(int i=0;i<teamList.size();i += 2){
           fixtures.add(new FixtureModel(teamList.get(i),teamList.get(i+1)));
        }

    }
    private void simulate(){
       if(teamList.size()>2){
           int teama = getLoosingTeam(0,teamList.size());
           teamList.remove(teama);
           int teamb = getLoosingTeam(0,teamList.size());
           teamList.remove(teamb);

           setupFixtureListView();


       }

    }


    public int getLoosingTeam(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }


    private List<TeamModel> getAllTeams(){
         List<TeamModel> teamList = new ArrayList<>();

        try {
            teamList = new Gson().fromJson(Helper.getTeamsFileFromAsset(context), new TypeToken<List<TeamModel>>(){}.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teamList;
    }

    @Override
    public void onAdapterItemClick(RecyclerView.ViewHolder viewHolder, View view, Object model, int position) {

    }

    @Override
    public void onAdapterItemLongClick(RecyclerView.ViewHolder viewHolder, View view, Object model, int position) {

    }

    @Override
    public void onShowLastItem() {

    }
}