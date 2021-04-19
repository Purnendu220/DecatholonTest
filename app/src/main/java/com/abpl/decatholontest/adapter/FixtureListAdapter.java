package com.abpl.decatholontest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.abpl.decatholontest.R;
import com.abpl.decatholontest.adapter.viewholder.FixtureViewHolder;
import com.abpl.decatholontest.adapter.viewholder.TeamViewHolder;
import com.abpl.decatholontest.models.FixtureModel;
import com.abpl.decatholontest.utils.AdapterCallbacks;

import java.util.ArrayList;
import java.util.List;





public class FixtureListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_FIXTURE = 1;


    private final AdapterCallbacks<Object> adapterCallbacks;

    private List<Object> list;
    private Context context;



    public FixtureListAdapter(Context context, AdapterCallbacks<Object> adapterCallbacks) {
        this.adapterCallbacks = adapterCallbacks;
        this.context = context;
        list = new ArrayList<>();

    }

    public List<Object> getList() {
        return list;
    }

    public void addFixture(FixtureModel model) {
        list.add(model);
    }

    public void addAllFixture(List<FixtureModel> models) {
        list.addAll(models);
    }



    public void clearAll() {
        list.clear();
    }






    @Override
    public int getItemViewType(int position) {

        int itemViewType = -1;
        Object item = getItem(position);
        if (item instanceof FixtureModel) {
            itemViewType = VIEW_TYPE_FIXTURE;
        }


        return itemViewType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_FIXTURE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_vs, parent, false);
            return new FixtureViewHolder(view);

        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof FixtureViewHolder) {
            if (getItem(position) != null)
                ((FixtureViewHolder) holder).bind(getItem(position), adapterCallbacks, position);

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public Object getItem(int position) {
        if (list != null && list.size() > 0)
            return list.get(position);
        else
            return null;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}