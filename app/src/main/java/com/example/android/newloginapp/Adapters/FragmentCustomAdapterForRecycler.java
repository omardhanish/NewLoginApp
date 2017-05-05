package com.example.android.newloginapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import com.example.android.newloginapp.GetterSetters.HomeFragmentRowItem;
import com.example.android.newloginapp.R;

import java.util.List;

/**
 * Created by omar on 09-03-2017.
 */

public class FragmentCustomAdapterForRecycler extends RecyclerView.Adapter<FragmentCustomAdapterForRecycler.MyViewHolder> {

    private List<HomeFragmentRowItem> homeFragmentRowItemList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView profile_pic;
        TextView member_name;
        TextView status;
        TextView contactType;

        public MyViewHolder(View view) {
            super(view);
            profile_pic = (ImageView) view.findViewById(R.id.pic);
            member_name = (TextView) view.findViewById(R.id.name);
            status = (TextView) view.findViewById(R.id.sta);
            contactType = (TextView) view.findViewById(R.id.contact);
        }
    }


    public FragmentCustomAdapterForRecycler(List<HomeFragmentRowItem> moviesList) {
        this.homeFragmentRowItemList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_fragment_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        HomeFragmentRowItem itematpos = homeFragmentRowItemList.get(position);
        holder.profile_pic.setImageResource(itematpos.getProfile_pic_id());
        holder.member_name.setText(itematpos.getMember_name());
        holder.status.setText(itematpos.getStatus());
        holder.contactType.setText(itematpos.getContactType());
    }

    @Override
    public int getItemCount() {
        return homeFragmentRowItemList.size();
    }



}
