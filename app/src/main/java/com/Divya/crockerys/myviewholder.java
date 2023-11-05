package com.Divya.crockerys;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myviewholder extends RecyclerView.ViewHolder
{
    public ImageView img;
    public TextView t1;
    public TextView t2;
    public myviewholder(@NonNull View itemView)
    {
        super(itemView);
        img=(ImageView)itemView.findViewById(R.id.img1);
        t1=(TextView)itemView.findViewById(R.id.t1);
        t2=(TextView)itemView.findViewById(R.id.t2);
    }
}
