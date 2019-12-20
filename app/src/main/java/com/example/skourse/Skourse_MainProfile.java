package com.example.skourse;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class Skourse_MainProfile extends Fragment{

    public Skourse_MainProfile() {
        // Required empty public constructor
    }

        TextView textView_nama;
        RequestQueue requestQueue;
        String nama = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_main, container, false);

        textView_nama = view.findViewById(R.id.textView_Nama);

        requestQueue = Volley.newRequestQueue(getActivity());

        load_profile();

        return view;
    }

        public void load_profile() {
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
                                    nama = obj.getString("name");

                                    //show in textView
                                    textView_nama.setText(nama);

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
