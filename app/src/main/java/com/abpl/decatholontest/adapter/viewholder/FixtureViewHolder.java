package com.abpl.decatholontest.adapter.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.abpl.decatholontest.R;
import com.abpl.decatholontest.models.FixtureModel;
import com.abpl.decatholontest.models.TeamModel;
import com.abpl.decatholontest.utils.AdapterCallbacks;

public class FixtureViewHolder extends RecyclerView.ViewHolder {
    TextView textViewTeamA;
    TextView textViewTeamB;

    private final Context context;

    public FixtureViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        itemView.setClickable(true);
        textViewTeamA = itemView.findViewById(R.id.txtTeamNameA);
        textViewTeamB = itemView.findViewById(R.id.txtTeamNameB);

    }

    public void bind(final Object data, final AdapterCallbacks adapterCallbacks, final int position) {
        if (data != null && data instanceof FixtureModel) {
            final FixtureModel model = (FixtureModel) data;
            itemView.setVisibility(View.VISIBLE);
            textViewTeamA.setText(model.getTeamA().getName());
            textViewTeamB.setText(model.getTeamB().getName());






        }



        else {
            itemView.setVisibility(View.GONE);
        }
    }




}
