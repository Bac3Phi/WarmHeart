package warmheart.penguin.dev.warmheart.Login;

import android.content.Intent;
import android.service.carrier.CarrierIdentifier;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.squareup.picasso.Picasso;

import java.time.Instant;

import de.hdodenhof.circleimageview.CircleImageView;
import warmheart.penguin.dev.warmheart.MainActivity;
import warmheart.penguin.dev.warmheart.R;
import warmheart.penguin.dev.warmheart.SendMailActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String AccName = "name";
    public static final String AccEmail = "email";
    public static final String Url_profile = "url";
    public static final String BUNDLE = "bundle";
    private GoogleSignInClient mGoogleSignInClient;
    private SignInButton signInButton;
    private Animation downtoup;
    private int RC_SIGN_IN = 001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LinearLayout layoutLogo = (LinearLayout) findViewById(R.id.layoutLogoWelcome);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.down);
        layoutLogo.setAnimation(downtoup);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.

       // GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        // Set the dimensions of the sign-in button.
        signInButton = (SignInButton) findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        signInButton.setOnClickListener(this);


    }

    @Override
    protected void onStart() {
        super.onStart();
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            getname = acct.getDisplayName();
            getmail = acct.getEmail();
            geturl = acct.getPhotoUrl().toString();
            bundle.putString("AccName",getname);
            bundle.putString("AccMail",getmail);
            bundle.putString("AccUrl",geturl);

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            Intent intent1 = new Intent(LoginActivity.this, SendMailActivity.class);
            intent1.putExtra("Send",bundle);
            intent.putExtra("ACC",bundle);
            startActivity(intent);


        }
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
   public String getname,getmail,geturl;
    Bundle bundle = new Bundle();
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            getname = account.getDisplayName().toString();
            getmail = account.getEmail().toString();
            geturl = account.getPhotoUrl().toString();
            bundle.putString("AccName",getname);
            bundle.putString("AccMail",getmail);
            bundle.putString("AccUrl",geturl);

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            Intent intent1 = new Intent(LoginActivity.this, SendMailActivity.class);
            intent1.putExtra("Send",bundle);
            intent.putExtra("ACC",bundle);
            startActivity(intent);



            // Picasso.with(this).load(account.getPhotoUrl()).into(imgAva);
        } catch (ApiException e) {
            Toast.makeText(getBaseContext(),"Fail", Toast.LENGTH_LONG).show();
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);

        }
    }



    public void onClick(View view) {
        switch (view.getId()){

            case R.id.sign_in_button:
                signIn();
                break;

        }
    }
}


