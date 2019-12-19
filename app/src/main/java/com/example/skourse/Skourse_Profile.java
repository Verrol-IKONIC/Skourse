package com.example.skourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.KeyListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.skourse.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Skourse_Profile extends AppCompatActivity {
    EditText textView_showFullName, textView_showBirthday, textView_showEmail,
            textView_showGender, textView_showPhone, textView_showCity,
            textView_showAddress, textView_showFavourite;
    TextView textView_nama, textView_role;
    RequestQueue requestQueue;
    String username = "", role = "", name = "", birthday = "", email = "",
            gender = "", phone = "", city = "", address = "", favourite = "", imagee="";
    ProgressBar progressBar_loading;
    Button button_editProfile, button_saveProfile;
    KeyListener listener1, listener2, listener3, listener4, listener5, listener6, listener7, listener8;
    ImageView image;
    int loader = R.drawable.sihun;
    ImageLoader imgLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skourse__profile);
        textView_nama = findViewById(R.id.textView_nama);
        textView_role = findViewById(R.id.textView_role);
        textView_showFullName = findViewById(R.id.textView_showFullName);
        textView_showBirthday = findViewById(R.id.textView_showBirthday);
        textView_showEmail = findViewById(R.id.textView_showEmail);
        textView_showGender = findViewById(R.id.textView_showGender);
        textView_showPhone = findViewById(R.id.textView_showPhone);
        textView_showCity = findViewById(R.id.textView_showCity);
        textView_showAddress = findViewById(R.id.textView_showAddress);
        textView_showFavourite = findViewById(R.id.textView_showFavourite);
        progressBar_loading = findViewById(R.id.progressBar_loading);
        button_editProfile = findViewById(R.id.button_editProfile);
        button_saveProfile = findViewById(R.id.button_saveProfile);
        image = (ImageView) findViewById(R.id.imageView_profilePic);
        imgLoader = new ImageLoader(getApplicationContext());


        button_saveProfile.setVisibility(View.INVISIBLE);

        progressBar_loading.setVisibility(View.VISIBLE);

        listener1 = textView_showFullName.getKeyListener();
        textView_showFullName.setKeyListener(null);
        textView_showFullName.setBackgroundColor(Color.TRANSPARENT);

        listener2 = textView_showBirthday.getKeyListener();
        textView_showBirthday.setKeyListener(null);
        textView_showBirthday.setBackgroundColor(Color.TRANSPARENT);


        listener3 = textView_showEmail.getKeyListener();
        textView_showEmail.setKeyListener(null);
        textView_showEmail.setBackgroundColor(Color.TRANSPARENT);

        listener4 = textView_showGender.getKeyListener();
        textView_showGender.setKeyListener(null);
        textView_showGender.setBackgroundColor(Color.TRANSPARENT);

        listener5 = textView_showPhone.getKeyListener();
        textView_showPhone.setKeyListener(null);
        textView_showPhone.setBackgroundColor(Color.TRANSPARENT);

        listener6 = textView_showCity.getKeyListener();
        textView_showCity.setKeyListener(null);
        textView_showCity.setBackgroundColor(Color.TRANSPARENT);

        listener7 = textView_showAddress.getKeyListener();
        textView_showAddress.setKeyListener(null);
        textView_showAddress.setBackgroundColor(Color.TRANSPARENT);

        listener8 = textView_showFavourite.getKeyListener();
        textView_showFavourite.setKeyListener(null);
        textView_showFavourite.setBackgroundColor(Color.TRANSPARENT);


        button_saveProfile.setText("Save Changes");

        requestQueue = Volley.newRequestQueue(Skourse_Profile.this);
        load_data();

        button_editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                button_editProfile.setVisibility(View.INVISIBLE);
                button_saveProfile.setVisibility(View.VISIBLE);

                textView_showFullName.setKeyListener(listener1);
                textView_showFullName.setBackgroundColor(Color.TRANSPARENT);

                textView_showBirthday.setKeyListener(listener2);
                textView_showBirthday.setBackgroundColor(Color.TRANSPARENT);


                textView_showEmail.setKeyListener(listener3);
                textView_showEmail.setBackgroundColor(Color.TRANSPARENT);

                textView_showGender.setKeyListener(listener4);
                textView_showGender.setBackgroundColor(Color.TRANSPARENT);

                textView_showPhone.setKeyListener(listener5);
                textView_showPhone.setBackgroundColor(Color.TRANSPARENT);

                textView_showCity.setKeyListener(listener6);
                textView_showCity.setBackgroundColor(Color.TRANSPARENT);

                textView_showAddress.setKeyListener(listener7);
                textView_showAddress.setBackgroundColor(Color.TRANSPARENT);

                textView_showFavourite.setKeyListener(listener8);
                textView_showFavourite.setBackgroundColor(Color.TRANSPARENT);


            }
        });
        button_saveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = textView_showFullName.getText().toString();
                birthday = textView_showBirthday.getText().toString();
                email = textView_showEmail.getText().toString();
                gender = textView_showGender.getText().toString();
                phone = textView_showPhone.getText().toString();
                city = textView_showCity.getText().toString();
                address = textView_showAddress.getText().toString();
                favourite = textView_showFavourite.getText().toString();
                String url = "https://verrol-mad.000webhostapp.com/skourse/edit_profile.php";
                progressBar_loading.setVisibility(View.VISIBLE);
                Map<String, String> params = new HashMap<>();
                params.put("nama", name);
                params.put("birthday", birthday);
                params.put("email", email);
                params.put("gender", gender);
                params.put("phone", phone);
                params.put("city", city);
                params.put("address", address);
                params.put("favourite", favourite);
                JSONObject parameters = new JSONObject(params);
                JsonObjectRequest jor = new JsonObjectRequest(Request.Method.POST, url, parameters,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                //get json data from server
                                JSONArray hasil = null;
                                try {
                                    hasil = response.getJSONArray("profile");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                if(hasil.length()==0){

                                }else{
                                    try {
                                        JSONObject obj = hasil.getJSONObject(0);
                                        String msg = "";
                                        msg = obj.getString("msg");
                                        if(msg.equalsIgnoreCase("success")){
                                            progressBar_loading.setVisibility(View.INVISIBLE);
                                            button_editProfile.setVisibility(View.VISIBLE);
                                            button_saveProfile.setVisibility(View.INVISIBLE);
                                            Toast.makeText(Skourse_Profile.this, "Berhasil update data mahasiswa", Toast.LENGTH_SHORT).show();
                                        }else if(msg.equalsIgnoreCase("failed")) {
                                            Toast.makeText(Skourse_Profile.this, "Gagal update data mahasiswa", Toast.LENGTH_SHORT).show();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                        progressBar_loading.setVisibility(View.INVISIBLE);
                                        button_editProfile.setVisibility(View.VISIBLE);
                                        button_saveProfile.setVisibility(View.INVISIBLE);

                                        load_data();
                                    }
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                progressBar_loading.setVisibility(View.INVISIBLE);
                                button_editProfile.setVisibility(View.VISIBLE);
                                button_saveProfile.setVisibility(View.INVISIBLE);
                            }
                        }
                );
                requestQueue.add(jor);
                listener1 = textView_showFullName.getKeyListener();
                textView_showFullName.setKeyListener(null);
                textView_showFullName.setBackgroundColor(Color.TRANSPARENT);

                listener2 = textView_showBirthday.getKeyListener();
                textView_showBirthday.setKeyListener(null);
                textView_showBirthday.setBackgroundColor(Color.TRANSPARENT);


                listener3 = textView_showEmail.getKeyListener();
                textView_showEmail.setKeyListener(null);
                textView_showEmail.setBackgroundColor(Color.TRANSPARENT);

                listener4 = textView_showGender.getKeyListener();
                textView_showGender.setKeyListener(null);
                textView_showGender.setBackgroundColor(Color.TRANSPARENT);

                listener5 = textView_showPhone.getKeyListener();
                textView_showPhone.setKeyListener(null);
                textView_showPhone.setBackgroundColor(Color.TRANSPARENT);

                listener6 = textView_showCity.getKeyListener();
                textView_showCity.setKeyListener(null);
                textView_showCity.setBackgroundColor(Color.TRANSPARENT);

                listener7 = textView_showAddress.getKeyListener();
                textView_showAddress.setKeyListener(null);
                textView_showAddress.setBackgroundColor(Color.TRANSPARENT);

                listener8 = textView_showFavourite.getKeyListener();
                textView_showFavourite.setKeyListener(null);
                textView_showFavourite.setBackgroundColor(Color.TRANSPARENT);
            }
        });
    }

    public void load_data() {
        String url = "https://verrol-mad.000webhostapp.com/skourse/fetch_data_user.php";
        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.POST, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //get json data from server
                        JSONArray hasil = null;
                        try {
                            hasil = response.getJSONArray("profile");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        if (hasil.length() == 0) {

                        } else {
                            try {
                                JSONObject obj = hasil.getJSONObject(0);
                                username = obj.getString("username");
                                role = obj.getString("role");
                                name = obj.getString("name");
                                birthday = obj.getString("birthday");
                                email = obj.getString("email");
                                gender = obj.getString("gender");
                                phone = obj.getString("phone");
                                city = obj.getString("city");
                                address = obj.getString("address");
                                favourite = obj.getString("favourite");
                                imagee = obj.getString("image");
                                String image_url = "https://verrol-mad.000webhostapp.com/skourse/image/"+imagee;

                                // whenever you want to load an image from url
                                // call DisplayImage function
                                // url - image url to load
                                // loader - loader image, will be displayed before getting image
                                // image - ImageView
                                imgLoader.DisplayImage(image_url, loader, image);

                                progressBar_loading.setVisibility(View.INVISIBLE);
                                //show in textView
                                textView_nama.setText(username);
                                textView_role.setText(role);
                                textView_showFullName.setText(name);
                                textView_showBirthday.setText(birthday);
                                textView_showEmail.setText(email);
                                textView_showGender.setText(gender);
                                textView_showPhone.setText(phone);
                                textView_showCity.setText(city);
                                textView_showAddress.setText(address);
                                textView_showFavourite.setText(favourite);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        requestQueue.add(jor);
    }
}
