package com.cihangul.retrofit;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Cihan on 15.11.2016.
 */

public class ItemAdapter extends BaseAdapter {
    LayoutInflater layoutInflater;
    List<Item> itemList;
    Activity activity;

    public ItemAdapter(List<Item> mItemList, Activity mActivity) {
        layoutInflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemList = mItemList;
        this.activity = mActivity;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.item_view, null);

        ImageView item_image = (ImageView) view.findViewById(R.id.item_image);
        TextView item_name = (TextView) view.findViewById(R.id.item_name);
        TextView item_desc = (TextView) view.findViewById(R.id.item_desc);

        Item item = itemList.get(position);

        item_name.setText("" + item.getItemIsim());
        item_desc.setText("" + item.getItemAciklama());
        Picasso.with(activity).load(item.getItemResim()).into(item_image);

        return view;
    }
}
