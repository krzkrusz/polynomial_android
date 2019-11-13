package com.example.polynomial;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChartActivity extends AppCompatActivity {

    @BindView(R.id.textView4)
    TextView text1;

    @BindView(R.id.textView5)
    TextView text2;

    @BindView(R.id.textView6)
    TextView text3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart_activity);
        ButterKnife.bind(this);

        Integer a = getIntent().getIntExtra("a", 0);
        Integer b = getIntent().getIntExtra("b", 0);
        Integer c = getIntent().getIntExtra("c", 0);

        text1.setText(a.toString());
        text2.setText(b.toString());
        text3.setText(c.toString());

    }

}
