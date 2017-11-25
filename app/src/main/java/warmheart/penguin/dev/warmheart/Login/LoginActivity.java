package warmheart.penguin.dev.warmheart.Login;

import android.content.Intent;
import android.service.carrier.CarrierIdentifier;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import de.hdodenhof.circleimageview.CircleImageView;
import warmheart.penguin.dev.warmheart.MainActivity;
import warmheart.penguin.dev.warmheart.R;

public class LoginActivity extends AppCompatActivity {
    GoogleSignInClient mGoogleSignInClient;
    TextView txtMail, txtName;
    ImageView imgAva;
    Button btnSignout;
    CircleImageView profile_image_login;
    int RC_SIGN_IN = 001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMail = (TextView) findViewById(R.id.txtEmail);
        txtName = (TextView) findViewById(R.id.txtHoTen);
        imgAva = (ImageView) findViewById(R.id.imgAva);
        profile_image_login = (CircleImageView) findViewById(R.id.profile_image);
      //  btnSignout = (Button) findViewById(R.id.btnSignout);
        // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        // Set the dimensions of the sign-in button.
        SignInButton signInButton = (SignInButton) findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
       // findViewById(R.id.sign_in_button).setOnClickListener(this);
       // findViewById(R.id.btnSignout).setOnClickListener(this);
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
            Picasso.with(this).load(account.getPhotoUrl()).into(profile_image_login);
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            Bundle bundle = new Bundle();

        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information
        }
    }

  /*  private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        txtmail.setText("signOut");
                        txtHoten.setText(".-.");
                        imgAva.setImageResource(R.mipmap.ic_launcher);
                        Toast.makeText(login.this, "signout", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    */

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
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                break;
          //  case R.id.btnSignout:
           //     signOut();
            //    break;
        }
    }
}


