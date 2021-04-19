package com.abpl.decatholontest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.abpl.decatholontest.adapter.TeamListAdapter;
import com.abpl.decatholontest.databinding.ActivityMainBinding;
import com.abpl.decatholontest.models.TeamModel;
import com.abpl.decatholontest.utils.AdapterCallbacks;
import com.abpl.decatholontest.utils.Helper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterCallbacks<Object> {
ActivityMainBinding binding;
Context context;
    TeamListAdapter teamListAdapter;
    private List<TeamModel> teamList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context = this;
        setupTeamList();
        binding.btnStart.setOnClickListener(view -> {
            Intent i = new Intent(this,FixtureActivity.class);
            startActivity(i);
            finish();
        });
    }

    private void setupTeamList()
    {
        teamListAdapter=new TeamListAdapter(context,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.recyclerViewList.setLayoutManager(mLayoutManager);
        binding.recyclerViewList.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerViewList.setAdapter(teamListAdapter);
        teamListAdapter.addAllTeams(getAllTeams());
        teamListAdapter.notifyDataSetChanged();




    }

    private List<TeamModel> getAllTeams(){
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