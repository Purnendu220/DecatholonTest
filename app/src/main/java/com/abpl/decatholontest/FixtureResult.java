package com.abpl.decatholontest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.abpl.decatholontest.databinding.ActivityFixtureBinding;
import com.abpl.decatholontest.databinding.ActivityFixtureResultBinding;
import com.abpl.decatholontest.models.FixtureModel;

public class FixtureResult extends AppCompatActivity {
     ActivityFixtureResultBinding binding;
     Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFixtureResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context  = this;
        FixtureModel model = (FixtureModel) getIntent().getSerializableExtra("final_fixture");
        binding.txtTeamNameA.setText(model.getTeamA().getName());
        binding.txtTeamNameB.setText(model.getTeamB().getName());
        binding.btnStart.setOnClickListener(view -> {
            Intent i = new Intent(context,MainActivity.class);
            startActivity(i);
            finish();
        });

    }
}