package com.example.polynomial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.editText1)
    EditText a_factor;

    @BindView(R.id.editText2)
    EditText b_factor;

    @BindView(R.id.editText3)
    EditText c_factor;

    @BindView(R.id.button)
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    void submit() {
        int a = Integer.parseInt(a_factor.getText().toString());
        int b = Integer.parseInt(b_factor.getText().toString());
        int c = Integer.parseInt(c_factor.getText().toString());





    }

}
