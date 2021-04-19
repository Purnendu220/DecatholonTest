package com.abpl.decatholontest.adapter.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.abpl.decatholontest.R;
import com.abpl.decatholontest.models.TeamModel;
import com.abpl.decatholontest.utils.AdapterCallbacks;


public class TeamViewHolder extends RecyclerView.ViewHolder {
    TextView textViewTeamName;
    private final Context context;

    public TeamViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        itemView.setClickable(true);
        textViewTeamName = itemView.findViewById(R.id.txtTeamName);
    }

    public void bind(final Object data, final AdapterCallbacks adapterCallbacks, final int position) {
        if (data != null && data instanceof TeamModel) {
            final TeamModel model = (TeamModel) data;
            itemView.setVisibility(View.VISIBLE);

            textViewTeamName.setText(model.getName());






            }



         else {
            itemView.setVisibility(View.GONE);
        }
    }




}
