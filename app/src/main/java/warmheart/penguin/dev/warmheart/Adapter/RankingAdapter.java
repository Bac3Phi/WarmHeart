package warmheart.penguin.dev.warmheart.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import warmheart.penguin.dev.warmheart.Model.RankingModel;
import warmheart.penguin.dev.warmheart.R;

/**
 * Created by Sky Nguyen on 26-Nov-17.
 */

public class RankingAdapter extends BaseAdapter {
    private ArrayList<RankingModel> arrayRanking;
    private Context context;

    public  RankingAdapter(ArrayList<RankingModel> arrayRanking, Context context)
    {
        this.arrayRanking = arrayRanking;

        this.context = context;
    }


    @Override
    public int getCount() {
        return arrayRanking.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayRanking.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    private class ViewHolder
    {
        CircleImageView avatar;
        TextView username;
        TextView money;


    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = null;
        RankingModel ranking = arrayRanking.get(position);
        ViewHolder holder;
        if (convertView == null)
        {
            v = LayoutInflater.from(context).inflate(R.layout.item_ranking, parent, false);
            holder= new ViewHolder();
            holder.avatar= (CircleImageView) v.findViewById(R.id.iv_avatar_ranking);
            holder.username= (TextView) v.findViewById(R.id.tv_username_ranking);
            holder.money =(TextView) v.findViewById(R.id.tv_money_ranking);

            Picasso.with(context)
                    .load(ranking.getUrl())
                    .resize(200, 200)
                    .centerCrop()
                    .into(holder.avatar);

            holder.username.setText(ranking.getName());
            holder.money.setText(ranking.getMoney());
            v.setTag(holder);

        }
        else
        {
            v = convertView;
            holder = (ViewHolder) v.getTag();
            //holder.avatar= (CircleImageView) v.findViewById(R.id.ivAvatarTab3UserList);
            // holder.username= (TextView) v.findViewById(R.id.tvUserNameTab3UserList);
            //holder.recentchat= (TextView) v.findViewById(R.id.tvRecentChatTab3UserList);
            //holder.time = (TextView) v.findViewById(R.id.tvTimeTab3UserList);

            Picasso.with(context)
                    .load(ranking.getUrl())
                    .resize(200, 200)
                    .centerCrop()
                    .into(holder.avatar);

            holder.username.setText(ranking.getName());
            holder.money.setText(ranking.getMoney());
            v.setTag(holder);
        }
        return v;
    }
}
