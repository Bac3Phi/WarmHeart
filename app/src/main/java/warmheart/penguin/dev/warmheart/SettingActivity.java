package warmheart.penguin.dev.warmheart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SettingActivity extends AppCompatActivity {

    ListView listSetting;
    ArrayAdapter<String> adapter;
    String setting[]={"Language", "Notifications", "Help Center", "Report Problem", "About App"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        listSetting = (ListView) findViewById(R.id.List_setting);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,setting);
        listSetting.setAdapter(adapter);

    }
}
