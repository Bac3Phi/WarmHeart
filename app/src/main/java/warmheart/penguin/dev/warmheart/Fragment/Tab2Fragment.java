package warmheart.penguin.dev.warmheart.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import warmheart.penguin.dev.warmheart.Adapter.RankingAdapter;
import warmheart.penguin.dev.warmheart.Model.RankingModel;
import warmheart.penguin.dev.warmheart.R;

/**
 * Created by Administrator on 23/11/2017.
 */

public class Tab2Fragment extends android.support.v4.app.Fragment {
        ListView rankingList;
        RankingAdapter rankingAdapter;
        ArrayList<RankingModel> rankingArray;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab2, container, false);
        rankingArray = new ArrayList<>();
        rankingList = (ListView) rootView.findViewById(R.id.ListView_ranking);
        rankingAdapter = new RankingAdapter(rankingArray,this.getContext());
        rankingList.setAdapter(rankingAdapter);

        addUserToRanking("https://scontent.fsgn2-1.fna.fbcdn.net/v/t1.0-9/10007251_672036346228582_9033516883581386418_n.jpg?oh=6f3fbd3a386657a2552ca3152519c7fb&oe=5AD4C07F",
                    "Tống Trung Thành",
                    "115.000.000 vnđ");
        addUserToRanking("https://scontent.fsgn2-1.fna.fbcdn.net/v/t1.0-9/21432959_970767199796004_6795600132363528206_n.jpg?oh=40b957cb53cba6ab585bdc5ee6d89191&oe=5AA1C1BB",
                "Nguyễn An Vy",
                "90.000.000 vnđ");
        addUserToRanking("https://scontent.fsgn2-1.fna.fbcdn.net/v/t31.0-8/21056151_1638045769600567_1162961595192365933_o.jpg?oh=2f7898aed2ab96d7988a417cd276d9c3&oe=5A9E6CD7",
                "Trần Minh Hoàng Long",
                "25.900.000 vnđ");
        addUserToRanking("https://scontent.fsgn2-1.fna.fbcdn.net/v/t1.0-9/14702470_1016100785182431_6792822070654352595_n.jpg?oh=f4771c1d225a35dbe4ae32d7f5d47282&oe=5AA7AA44",
                "Đặng Trần Hồng Phúc",
                "200.000 vnđ");
        addUserToRanking("https://scontent.fsgn2-1.fna.fbcdn.net/v/t1.0-9/13332827_303251573341233_7051366869239245009_n.jpg?oh=dbad53547e0408266b5d4e22b9e6426e&oe=5A8FF653",
                "Lê Phương Khanh",
                "15.000.000 vnđ");
        addUserToRanking("https://scontent.fsgn2-1.fna.fbcdn.net/v/t1.0-9/21766483_1584508448277132_5638497300171194969_n.jpg?oh=7743bb5975f315e174ac40533421c654&oe=5AD24EB6",
                "Kim Tuyến",
                "3.000.000 vnđ");
        addUserToRanking("https://scontent.fsgn2-1.fna.fbcdn.net/v/t1.0-9/23755308_1665957780121785_44421815620971967_n.jpg?oh=3fbbf40db0ce10b5185a1da6733a95c4&oe=5AA18A08",
                "Hoàng Lê Khoa",
                "5.000.000 vnđ");
        addUserToRanking("https://scontent.fsgn2-1.fna.fbcdn.net/v/t1.0-9/16114389_2010272295866428_968577168448640276_n.jpg?oh=e80ba7b4914fd66076c70d3282c81d4b&oe=5AA23C5A",
                "Ngọc Minh",
                "9.000.000 vnđ");
        addUserToRanking("https://scontent.fsgn2-1.fna.fbcdn.net/v/t1.0-9/23517611_10208221388292167_9022414172631322678_n.jpg?oh=a32de51075d19a74fd6d2f4d850d6dc0&oe=5AD6C49B",
                "Thư Minh Chung",
                "700.000 vnđ");
        return rootView;
    }
    private void addUserToRanking(String url,String userName, String money)
    {
       // String s= (String.format("%,d", money)).replace(',', ' ');
        RankingModel ranking = new RankingModel();
        ranking.setUrl(url);
        ranking.setName(userName);
        ranking.setMoney(money);

        rankingArray.add(ranking);
        if (rankingAdapter!=null)
            rankingAdapter.notifyDataSetChanged();
    }
}