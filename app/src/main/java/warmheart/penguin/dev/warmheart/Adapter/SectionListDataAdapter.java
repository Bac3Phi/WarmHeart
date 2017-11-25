package warmheart.penguin.dev.warmheart.Adapter;

/**
 * Created by pratap.kesaboyina on 24-12-2014.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;


import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;

import warmheart.penguin.dev.warmheart.Model.SingleItemModel;
import warmheart.penguin.dev.warmheart.R;
import warmheart.penguin.dev.warmheart.ScrollingActivity;

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder> {

    private ArrayList<SingleItemModel> itemsList;
    private Context mContext;

    public SectionListDataAdapter(Context context, ArrayList<SingleItemModel> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_single_card, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);

        return mh;
    }


    public Bundle bundle = new Bundle();
    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {

        SingleItemModel singleItem = itemsList.get(i);

        holder.tvTitle.setText(singleItem.getName());

        //holder.itemImage.setImageResource(R.drawable.avatar_test2);
        Picasso.with(mContext)
                .load(singleItem.getUrl())
                .resize(300, 150)
                .centerCrop()
                .into(holder.itemImage);
        ////HERE debug

        /*holder.toolbarScrolling.setTitle(singleItem.getName());

        holder.appBarLayout.setBackground(holder.itemImage.getDrawable());

        holder.tvLocation.setText(singleItem.getLocation());

        holder.tvTime.setText(singleItem.getTime());

        holder.tvDescription.setText(singleItem.getDescription());*/


    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvTitle;

        protected ImageView itemImage;

        protected TextView tvLocation;

        protected  TextView tvTime;

        protected TextView tvDescription;

        protected android.support.v7.widget.Toolbar toolbarScrolling;
        protected AppBarLayout appBarLayout;
        public SingleItemRowHolder(View view) {
            super(view);

            this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            this.itemImage = (ImageView) view.findViewById(R.id.itemImage);

           /* this.appBarLayout = (AppBarLayout) view.findViewById(R.id.toolbar_layout);
            this.toolbarScrolling = (android.support.v7.widget.Toolbar) view.findViewById(R.id.toolbar_scrolling);
            this.tvLocation = (TextView) view.findViewById(R.id.tvloction_content_srcolling);
            this.tvTime = (TextView) view.findViewById(R.id.tvloction_content_srcolling);
            this.tvDescription =(TextView) view.findViewById(R.id.tvdes_content_scrolling);*/


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(mContext, ScrollingActivity.class);

                    for(SingleItemModel item: itemsList)
                    {
                        if(tvTitle.getText() == item.getName())
                        {

                            bundle.putString("Name",item.getName());
                            bundle.putString("AvatarURL",item.getUrl());
                            bundle.putString("Location",item.getLocation());
                            bundle.putString("Time",item.getTime());
                            bundle.putString("Description",item.getDescription());

                        }
                    }

                    intent.putExtra("item",bundle);

                    mContext.startActivity(intent);
                    //Toast.makeText(v.getContext(), tvTitle.getText(), Toast.LENGTH_SHORT).show();

                }
            });


        }

    }

}