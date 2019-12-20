package com.example.skourse.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.skourse.R;
import com.example.skourse.Skourse_Search;
import com.example.skourse.adapters.HorizontalCategoryAdapter;
import com.example.skourse.adapters.HorizontalCourseAdapter;
import com.example.skourse.model.Course;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragment extends Fragment {
    Button btn_searchs;
    TextView courseCount;
    private HomeViewModel homeViewModel;

    ArrayList<Course> listCourse = new ArrayList<>();
    RecyclerView rv_crs;

    String subject_id="", subject_title="", subject_detail="";
    RequestQueue requestQueue;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        courseCount = view.findViewById(R.id.textView_course_count);
        btn_searchs = view.findViewById(R.id.button_search);
        btn_searchs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test();
            }
        });

        rv_crs = view.findViewById(R.id.RecyclerView_course);
        requestQueue = Volley.newRequestQueue(getActivity());
        loadCourse();



        //RecyclerView list_recently = view.findViewById(R.id.RecyclerView_recentlyBooked);
        //list_recently.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        //list_recently.setAdapter(new HorizontalCourseAdapter(new String[]{"MobileApp Course", "Vocal Course"}));

        RecyclerView list_category = view.findViewById(R.id.RecyclerView_category);
        list_category.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        list_category.setAdapter(new HorizontalCategoryAdapter(new String[]{"programming", "music", "art", "social", "programming", "music", "art", "social"}));

        return view;
    }

    public void test(){
        Intent intent = new Intent(getActivity(), Skourse_Search.class);
        startActivity(intent);
        getActivity().finish();
    }

    public void loadCourse(){
        listCourse.clear();
        rv_crs.setAdapter(null);

        String url = "https://verrol-mad.000webhostapp.com/skourse/get_all_course.php";
        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.POST, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //get json data from server
                        JSONArray hasil = null;
                        try {
                            hasil = response.getJSONArray("crs");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        if (hasil.length()==0){

                        }else{
                            for (int i = 0; i < hasil.length(); i++){
                                try {
                                    JSONObject obj = hasil.getJSONObject(i);
                                    subject_id = obj.getString("subject_id");
                                    subject_title = obj.getString("subject_title");
                                    subject_detail = obj.getString("subject_detail");

                                    Course crs = new Course(subject_id,subject_title,subject_detail);
                                    listCourse.add(crs);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (rv_crs.getAdapter()==null){
                                showCourse(listCourse);
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

    public void showCourse(final ArrayList<Course> list){
        rv_crs.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        HorizontalCourseAdapter courseAdapter = new HorizontalCourseAdapter(listCourse);
        courseAdapter.setListCourse(list);
        rv_crs.setAdapter(courseAdapter);
    }
}