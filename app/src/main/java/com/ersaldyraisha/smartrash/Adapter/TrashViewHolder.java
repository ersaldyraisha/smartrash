package com.ersaldyraisha.smartrash.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ersaldyraisha.smartrash.R;

/**
 * Created by A.I on 08/11/2017.
 */

public class TrashViewHolder extends RecyclerView.ViewHolder{

    public TextView tvDistance, tvStatus, tvTime;

    public TrashViewHolder(View itemView) {
        super(itemView);

//        tvDistance = (TextView) itemView.findViewById(R.id.tvDistance);
        tvStatus = (TextView) itemView.findViewById(R.id.tvStatus);
        tvTime = (TextView) itemView.findViewById(R.id.tvTime);
    }
}
