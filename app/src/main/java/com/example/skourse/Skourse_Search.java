package com.example.skourse;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.skourse.adapter.HorizontalCategoryAdapter;
import com.example.skourse.adapter.VerticalSearchResultAdapter;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Skourse_Search extends AppCompatActivity {
    ActionBar bar;
    ImageButton back;
    EditText editText;
    String search;
    Button searchButton;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skourse_search);
        bar =getSupportActionBar();
        bar.hide();
        searchButton = findViewById(R.id.button_search);
        back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            backtoMain();
        }
    });

        RecyclerView list_course = (RecyclerView) findViewById(R.id.course_view);
        list_course.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        list_course.setAdapter(new VerticalSearchResultAdapter(new String[]{"test", "nama","test", "nama","test", "nama"}));

        RecyclerView list_category = (RecyclerView) findViewById(R.id.category_view);
        list_category.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        list_category.setAdapter(new HorizontalCategoryAdapter(new String[]{"test", "category","test", "nama","test", "nama"}));


        editText = findViewById(R.id.editText);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event.getAction()== KeyEvent.ACTION_DOWN) && (actionId == KeyEvent.KEYCODE_ENTER)) {

                    toSearch();
                }
                return false;
            }
        });
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toSearch();
            }
        });






    }

    public void backtoMain(){
        Intent intent = new Intent(this, Skourse_Main.class);
        startActivity(intent);
    }

    public void toSearch(){
        search = editText.getText().toString().trim();
        Intent intent = new Intent(Skourse_Search.this, Skourse_Search_Complete.class);
        intent.putExtra("search", search);
        startActivity(intent);
    }

}
