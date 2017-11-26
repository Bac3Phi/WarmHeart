package warmheart.penguin.dev.warmheart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SettingActivity extends AppCompatActivity {

    ListView listSetting;
    ArrayAdapter<String> adapter;
    String setting[]={"Ngôn ngữ", "Thông báo", "Hỗ trợ", "Báo lỗi", "Giới thiệu"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbarSetting);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        listSetting = (ListView) findViewById(R.id.List_setting);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,setting);
        listSetting.setAdapter(adapter);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home)
            this.finish();
        return super.onOptionsItemSelected(item);
    }
}
