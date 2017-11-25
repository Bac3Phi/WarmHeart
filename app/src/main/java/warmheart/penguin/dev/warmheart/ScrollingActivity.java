package warmheart.penguin.dev.warmheart;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import warmheart.penguin.dev.warmheart.Model.SectionDataModel;
import warmheart.penguin.dev.warmheart.Model.SingleItemModel;

public class ScrollingActivity extends AppCompatActivity {

    AppBarLayout appBarLayout;
    CollapsingToolbarLayout toolbarScrolling;
    TextView tvLocation;
    TextView tvTime;
    TextView tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_scrolling);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        toolbarScrolling = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);

        tvLocation = (TextView) findViewById(R.id.tvloction_content_srcolling);
        tvTime = (TextView) findViewById(R.id.tvloction_content_srcolling);
        tvDescription =(TextView) findViewById(R.id.tvdes_content_scrolling);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("item");
        toolbarScrolling.setTitle(bundle.getString("Name"));
        ImageView iv =new ImageView(this);
        Picasso.with(this)
                .load(bundle.getString("AvatarURL"))
                .resize(300, 150)
                .centerCrop()
                .into(iv);
        appBarLayout.setBackground(iv.getDrawable());
        tvTime.setText(bundle.getString("Time"));
        tvDescription.setText(bundle.getString("Description"));
        tvLocation.setText(bundle.getString("Location"));
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent1 = new Intent(ScrollingActivity.this,SendMailActivity.class);
               startActivity(intent1);
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
