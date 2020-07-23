package com.treecode.tassbih;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.MyViewHolder> {

    private Context mContext;
    private List<tasbih> bill_clients;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_item_title, tv_item_detail, tv_item_number;


        public MyViewHolder(View view) {
            super(view);
            tv_item_title = (TextView) view.findViewById(R.id.tv_item_title);
            tv_item_detail = (TextView) view.findViewById(R.id.tv_item_detail);
            tv_item_number = (TextView) view.findViewById(R.id.tv_item_number);

        }
    }



    public adapter(Context mContext, List<tasbih> bill_clients) {
        this.mContext = mContext;

        this.bill_clients = bill_clients;

    }

    @Override
    public adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_tasbih, parent, false);

        return new adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final adapter.MyViewHolder holder, final int position) {
        tasbih tasbih = bill_clients.get(position);
        holder.tv_item_title.setText(tasbih.getTitle());
        holder.tv_item_detail.setText(tasbih.getDetaill());
        holder.tv_item_number.setText(""+(position+1));





    }




    @Override
    public int getItemCount() {
        return bill_clients.size();
    }
}
