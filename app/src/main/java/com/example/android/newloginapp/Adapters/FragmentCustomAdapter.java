package com.example.android.newloginapp.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.newloginapp.GetterSetters.HomeFragmentRowItem;
import com.example.android.newloginapp.R;

import java.util.List;

/**
 * Created by omar on 08-02-2017.
 */
public class FragmentCustomAdapter extends BaseAdapter {

    Context context;
    List<HomeFragmentRowItem> rowItems;


    public FragmentCustomAdapter(Context context, List<HomeFragmentRowItem> rowItems) {

        this.context = context;
        this.rowItems = rowItems;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    /* private view holder class */
    private class ViewHolder {
        ImageView profile_pic;
        TextView member_name;
        TextView status;
        TextView contactType;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);


        if (convertView == null) {

            convertView = mInflater.inflate(R.layout.home_fragment_list_item, null);
            holder = new ViewHolder();

            holder.member_name = (TextView) convertView
                    .findViewById(R.id.name);
            holder.profile_pic = (ImageView) convertView
                    .findViewById(R.id.pic);
            holder.status = (TextView) convertView.findViewById(R.id.sta);
            holder.contactType = (TextView) convertView
                    .findViewById(R.id.contact);

            HomeFragmentRowItem row_pos = rowItems.get(position);

            holder.profile_pic.setImageResource(row_pos.getProfile_pic_id());
            holder.member_name.setText(row_pos.getMember_name());
            holder.status.setText(row_pos.getStatus());
            holder.contactType.setText(row_pos.getContactType());

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }

}

