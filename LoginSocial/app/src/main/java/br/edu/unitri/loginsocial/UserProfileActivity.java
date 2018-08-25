package br.edu.unitri.loginsocial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONObject;

/**
 * Created by viniciusdepaula on 24/03/18.
 */

public class UserProfileActivity extends AppCompatActivity {

    JSONObject response, profile_pic_data, profile_pic_url;
    static String TAG = UserProfileActivity.class.getName();

    TextView userName, userEmail;
    ImageView userPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);

        /*
         * Instanciamos os componentes de tela do layout
         */

        userName = findViewById(R.id.UserName);
        userPicture = findViewById(R.id.profilePic);
        userEmail = findViewById(R.id.email);

        getUserData();
    }

    private void getUserData() {

        /*
         * Inicialmente recuperamos os dados do usuário que foram enviados via Intent
         */

        Intent intent = getIntent();
        String jsondata = intent.getStringExtra("userProfile");

        Log.d(TAG, "JSON: " + jsondata);

        try {

            response = new JSONObject(jsondata);

            /*
             * Recuperamos os respectivos campos retornados no JSON e os setamos nos componentes de tela
             */

            userEmail.setText(response.get("email").toString());
            userName.setText(response.get("name").toString());
            profile_pic_data = new JSONObject(response.get("picture").toString());
            profile_pic_url = new JSONObject(profile_pic_data.getString("data"));

            Picasso.with(this).load(profile_pic_url.getString("url")).into(userPicture);

        } catch(Exception e){

            e.printStackTrace();
        }
    }
}