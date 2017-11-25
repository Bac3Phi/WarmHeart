package warmheart.penguin.dev.warmheart.Login;

import android.content.Intent;
import android.service.carrier.CarrierIdentifier;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String AccName = "name";
    public static final String AccEmail = "email";
    public static final String Url_profile = "url";
    public static final String BUNDLE = "bundle";
    GoogleSignInClient mGoogleSignInClient;
    TextView txtMail, txtName;
    String profile_url;
    ImageView imgAva;
    Button btnSignout;
    CircleImageView profile_image_login;
    int RC_SIGN_IN = 001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtMail = (TextView) findViewById(R.id.txtEmail);
        txtName = (TextView) findViewById(R.id.txtHoTen);
        imgAva = (ImageView) findViewById(R.id.imgAva);
        profile_image_login = (CircleImageView) findViewById(R.id.profile_image);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        // Set the dimensions of the sign-in button.
        SignInButton signInButton = (SignInButton) findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        findViewById(R.id.sign_in_button).setOnClickListener(this);
       // findViewById(R.id.btnSignout).setOnClickListener(this);
    }

    public void AccInfo(){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(AccName, txtName.getText().toString());
        bundle.putString(AccEmail, txtMail.getText().toString());
        bundle.putString(Url_profile, profile_url);
        intent.putExtra(BUNDLE,bundle);
        startActivity(intent);
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            txtMail.setText(account.getEmail().toString());
            txtName.setText(account.getDisplayName().toString());
            Picasso.with(this).load(account.getPhotoUrl()).into(imgAva);
            Toast.makeText(this, "a", Toast.LENGTH_SHORT).show();
        } catch (ApiException e) {
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
            Intent inten = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(inten);
        }
    }



    public void onClick(View view) {
        switch (view.getId()){

            case R.id.sign_in_button:
                signIn();
                break;
          //  case R.id.btnSignout:
           //     signOut();
            //    break;
        }
    }
}


