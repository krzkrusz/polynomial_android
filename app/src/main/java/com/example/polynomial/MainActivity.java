package com.example.polynomial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MAIN";
    @BindView(R.id.editText1)
    EditText a_factor;

    @BindView(R.id.editText2)
    EditText b_factor;

    @BindView(R.id.editText3)
    EditText c_factor;

    @BindView(R.id.button)
    Button button;

    @BindView(R.id.textView5)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    void submit() {

        Intent intent = new Intent(this, ChartActivity.class);
        int a = Integer.parseInt(a_factor.getText().toString());
        int b = Integer.parseInt(b_factor.getText().toString());
        int c = Integer.parseInt(c_factor.getText().toString());

        intent.putExtra("a", a);
        intent.putExtra("b", b);
        intent.putExtra("c", c);

        PackageManager packageManager = MainActivity.this.getPackageManager();
        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, 2);
        } else {
            Log.d(TAG, "Activity not handled for: " + intent.getData());
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            String roots = data.getStringExtra("roots");
            textView.setText("Roots: " + roots);
        }
    }
}