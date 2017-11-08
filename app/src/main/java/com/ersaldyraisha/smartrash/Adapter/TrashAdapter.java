package com.ersaldyraisha.smartrash.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ersaldyraisha.smartrash.Model.Distance;
import com.ersaldyraisha.smartrash.R;

import java.util.List;

/**
 * Created by A.I on 08/11/2017.
 */

public class TrashAdapter extends RecyclerView.Adapter<TrashViewHolder> {

    private List<Distance> distanceList;
    private int layout;
    private Context context;

    public TrashAdapter(List<Distance> distanceList, int layout, Context context){
        this.distanceList = distanceList;
        this.layout = layout;
        this.context = context;
    }

    @Override
    public TrashViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.trash_list, parent, false);
        return new TrashViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TrashViewHolder holder, int position) {

        holder.tvTime.setText("Time: " + distanceList.get(position).getCreated_at().toString());
        holder.tvStatus.setText("Status: " + distanceList.get(position).getStatus());
        holder.tvDistance.setText("Distance: " + distanceList.get(position).getDistance());

    }

    @Override
    public int getItemCount() {
        return distanceList.size();
    }



}
