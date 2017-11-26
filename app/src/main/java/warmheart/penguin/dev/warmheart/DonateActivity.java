package warmheart.penguin.dev.warmheart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

import morxander.editcard.EditCard;

public class DonateActivity extends AppCompatActivity {
    EditCard editCard;
    EditText editEvent;
    TextView cardName,cardType;
    android.support.v7.widget.Toolbar toolbar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        editCard = (EditCard) findViewById(R.id.card);
        editEvent = (EditText) findViewById(R.id.ed_event_donate);
        cardName = (TextView) findViewById(R.id.cardnumber);
        cardType = (TextView) findViewById(R.id.cardtype);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbarDonate);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        editCard.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                    cardName.setText( editCard.getCardNumber());
                    cardType.setText(editCard.getCardType());


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home)
            this.finish();
        return super.onOptionsItemSelected(item);
    }
}
