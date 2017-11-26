package warmheart.penguin.dev.warmheart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendMailActivity extends AppCompatActivity {

    Button btnGui;
    EditText edtTile,edtMess, edtEdSend, edtReceive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_mail);

        edtTile = (EditText) findViewById(R.id.ed_tilte_mail);
        edtEdSend = (EditText) findViewById(R.id.ed_send_mail);
        edtMess = (EditText) findViewById(R.id.ed_mess_mail);
        edtReceive = (EditText) findViewById(R.id.ed_receive_mail);
        btnGui = (Button)findViewById(R.id.btnGui);

        String s= getIntent().getStringExtra("name");
        edtEdSend.setText(s);
        edtReceive.setText("PenguinTheJoker2017@gmail.com");
        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtMess.getText();
                edtTile.getText();
            }
        });




        //Intent intent = getIntent();
        // Bundle bundle = intent.getBundleExtra("item");
        // edtTile.setText("[Giúp Đở][Chủ Đề: "+bundle.getString("Name")+" ]");
    }
}

