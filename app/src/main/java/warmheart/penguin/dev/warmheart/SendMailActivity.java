package warmheart.penguin.dev.warmheart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class SendMailActivity extends AppCompatActivity {

    EditText edtTile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_mail);

        edtTile = (EditText) findViewById(R.id.ed_tilte_mail);

        //Intent intent = getIntent();
       // Bundle bundle = intent.getBundleExtra("item");
      // edtTile.setText("[Giúp Đở][Chủ Đề: "+bundle.getString("Name")+" ]");
    }
}
