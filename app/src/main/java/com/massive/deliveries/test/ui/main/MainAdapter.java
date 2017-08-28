package com.massive.deliveries.test.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.massive.deliveries.test.data.network.model.Deliveries;
import com.massive.deliveries.test.di.ActivityContext;
import com.massive.deliveries.test.R;

import java.util.List;

/**
 *  Creaated by Balwinder on   26/08/17.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<Deliveries> mItems;

    private Context mContext;
    private IDeliveryClick mItemListener;


    public MainAdapter(List<Deliveries> mItems , @ActivityContext Context context) {
        this.mItems = mItems;
        mContext = context;
    }

    public void setCallback(IDeliveryClick callback) {
        mItemListener = callback;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView titleTv;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTv = (TextView) itemView.findViewById(R.id.dilivery_details);
            imageView = (ImageView) itemView.findViewById(R.id.iv_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Deliveries item = getItem(getAdapterPosition());
               mItemListener.onDeliveryClick(item.getLocation().getLat(),
                       item.getLocation().getLng(),item.getLocation().getAddress());
        }
    }


    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(R.layout.item_delivery, parent, false);

        ViewHolder viewHolder = new ViewHolder(postView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MainAdapter.ViewHolder holder, int position) {
        Deliveries item = mItems.get(position);
        Glide.with(mContext)
                .load(item.getImageUrl())
                .into(holder.imageView);

        holder.titleTv.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void updateDeliveries(List<Deliveries> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    private Deliveries getItem(int adapterPosition) {
        return mItems.get(adapterPosition);
    }

    public interface IDeliveryClick {
        void onDeliveryClick(double lat, double lng, String address );
    }
}
