package br.edu.unitri.loginsocialsession;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.login.LoginManager;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

/**
 * Created by viniciusdepaula on 24/03/18.
 */

public class UserProfileActivity extends AppCompatActivity {

    JSONObject response, profilePicData, profilePicUrl;
    static String TAG = UserProfileActivity.class.getName();

    TextView tvUserName, tvUserEmail;
    ImageView ivUserPicture;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    String userName, userEmail, userPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);

        /*
         * Instanciamos os componentes de tela do layout
         */

        tvUserName = findViewById(R.id.UserName);
        ivUserPicture = findViewById(R.id.profilePic);
        tvUserEmail = findViewById(R.id.email);

        getUserData();
    }

    private void getUserData() {

        /*
         * Inicialmente recuperamos os dados do usuário que foram enviados via Intent
         */

        try {


            /*
             * Recuperamos o objeto USER_DATA, caso ele exista o objeto sharedPreferences será setado
             */

            sharedPreferences = getSharedPreferences("USER_DATA", Context.MODE_PRIVATE);

            /*
             * Se a sessão já tiver sido ininicida, usamos os objetos do sharedPreferences
             */

            if(sharedPreferences.contains("LOGIN_SESSION")){

                userEmail = sharedPreferences.getString("FB_USER_EMAIL", "");
                userName = sharedPreferences.getString("FB_USER_NAME", "");
                userPicture = sharedPreferences.getString("FB_USER_PIC", "");

            } else {

                Intent intent = getIntent();
                String jsondata = intent.getStringExtra("userProfile");

                Log.d(TAG, "JSON: " + jsondata);

                response = new JSONObject(jsondata);

                /*
                 * Recuperamos os respectivos campos retornados no JSON e os setamos nos componentes de tela
                 */

                profilePicData = new JSONObject(response.get("picture").toString());
                profilePicUrl = new JSONObject(profilePicData.getString("data"));

                userEmail = response.get("email").toString();
                userName = response.get("name").toString();
                userPicture = profilePicUrl.getString("url");

                /*
                 * Habilitamos o modo de edição do sharedPreferences
                 */

                editor = sharedPreferences.edit();

                /*
                 * Adicionamos KEYs que representam os dados do usuário ao objeto USER_DATA
                 */

                editor.putString("FB_USER_NAME", userName);
                editor.putString("FB_USER_EMAIL", userEmail);
                editor.putString("FB_USER_PIC", userPicture);
                editor.putBoolean("LOGIN_SESSION", true);

                /*
                 * Salvamos as keys criadas
                 */

                editor.commit();
            }

            /*
             * Setamos os dados dos usuário nos componentes de tela
             */

            tvUserEmail.setText(userEmail);
            tvUserName.setText(userName);
            Picasso.with(this).load(userPicture).into(ivUserPicture);

        } catch(Exception e){

            e.printStackTrace();
        }
    }

    public void logout(View view) {

        Log.d(TAG, "Finalizando sessão do usuário");

        /*
         * Método que encerra a sessão do usuário no Facebook
         */

        LoginManager.getInstance().logOut();

        /*
         * Removemos os dados do usuário que estão no sharedPreferences
         */

        //sharedPreferences.edit().remove("USER_DATA").commit();
        sharedPreferences.edit().clear().commit();

        Intent intent = new Intent(UserProfileActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}