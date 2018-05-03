package com.thorn.wego.PositionDetail;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.thorn.wego.R;

public class PositionDetailActivity extends AppCompatActivity {
    private TextView position_name, position_address, position_category;
    private ImageView position_pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.position_detail_fragment);

        position_name = (TextView) findViewById(R.id.position_detail_name);
        position_address = (TextView) findViewById(R.id.position_detail_address);
        position_category = (TextView) findViewById(R.id.position_detail_category);
        position_pic = (ImageView) findViewById(R.id.position_detail_pic);

//        String position_id = getIntent().getExtras().get("position_id").toString();
//        Toast.makeText(PositionDetailActivity.this, position_id, Toast.LENGTH_SHORT).show();

        position_name.setText("Los Angeles International Airport");
        position_address.setText("1 World Way");
        position_category.setText("Airport");

        position_pic.setImageDrawable(ContextCompat.getDrawable(PositionDetailActivity.this,R.drawable.lax));
    }
}
