package com.example.skourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.skourse.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Skourse_Profile extends AppCompatActivity {
    TextView textView_nama, textView_role, textView_showFullName, textView_showBirthday, textView_showEmail,
            textView_showGender, textView_showPhone, textView_showCity,
            textView_showAddress, textView_showFavourite;
    RequestQueue requestQueue;
    String username = "", role = "", name = "", birthday = "", email = "",
            gender = "", phone = "", city = "", address = "", favourite = "";
    ProgressBar progressBar_loading;
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

        progressBar_loading.setVisibility(View.VISIBLE);

        requestQueue = Volley.newRequestQueue(Skourse_Profile.this);
        load_data();
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
