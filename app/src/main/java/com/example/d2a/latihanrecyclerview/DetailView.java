package com.example.d2a.latihanrecyclerview;

import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailView extends AppCompatActivity {

    TextView title, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        this.title = findViewById(R.id.recipe_title);
        this.description = findViewById(R.id.recipe_description);

        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            title.setText(mBundle.getString("title"));
            description.setText(mBundle.getString("description"));
        }
    }
}
