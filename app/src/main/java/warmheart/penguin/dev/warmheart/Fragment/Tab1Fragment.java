package warmheart.penguin.dev.warmheart.Fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import warmheart.penguin.dev.warmheart.Adapter.RecyclerViewDataAdapter;
import warmheart.penguin.dev.warmheart.Model.SectionDataModel;
import warmheart.penguin.dev.warmheart.Model.SingleItemModel;
import warmheart.penguin.dev.warmheart.R;

/**
 * Created by Administrator on 23/11/2017.
 */

public class Tab1Fragment extends android.support.v4.app.Fragment {
    ArrayList<SectionDataModel> allSampleData;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab1, container, false);

        allSampleData = new ArrayList<SectionDataModel>();

        //createDummyData();
        addDummyData();

        RecyclerView my_recycler_view = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);

        my_recycler_view.setHasFixedSize(true);

        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(this.getContext(), allSampleData);

        my_recycler_view.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));

        my_recycler_view.setAdapter(adapter);


        return rootView;
    }

    private void createDummyData() {

        for (int i = 1; i <= 5; i++) {

            SectionDataModel dm = new SectionDataModel();

            dm.setHeaderTitle("Section " + i);

            ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
            for (int j = 0; j <= 5; j++) {
                singleItem.add(new SingleItemModel("Item " + j, "URL " + j));

            }
        //    singleItem.set(1,new SingleItemModel("Phi","https://i.imgur.com/T9j4P5N.jpg"));
            dm.setAllItemsInSection(singleItem);

            allSampleData.add(dm);

        }

    }
    public void addDummyData()
    {
       SectionDataModel dm = new SectionDataModel();
        ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
        dm.setHeaderTitle("Need help");
        singleItem.add(new SingleItemModel("Quân 1","https://i.imgur.com/GnnR8uA.jpg","Đây là Pen gụt","Bình Dương","12AM"));
        singleItem.add(new SingleItemModel("Quân 2","https://i.imgur.com/brJPmoq.jpg","Đây là Pen gụt","Bình Dương","12AM"));



        dm.setAllItemsInSection(singleItem);
        allSampleData.add(dm);

    }

}
