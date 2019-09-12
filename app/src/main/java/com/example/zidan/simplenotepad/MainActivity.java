package com.example.zidan.simplenotepad;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edt_memo;
    Button btn_clear, btn_save;
    String memo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_memo = findViewById(R.id.edt_memo);

        btn_clear = findViewById(R.id.btn_clear);
        btn_save = findViewById(R.id.btn_save);

        btn_clear.setOnClickListener(this);
        btn_save.setOnClickListener(this);

        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        memo = preferences.getString("memo", "");

        edt_memo.setText(memo);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_clear:
                edt_memo.setText("");

                Toast.makeText(MainActivity.this, "Memo Cleared", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_save:
                memo = edt_memo.getText().toString();

                SharedPreferences preferences = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("memo", memo);
                editor.commit();

                Toast.makeText(MainActivity.this, "Memo Saved", Toast.LENGTH_SHORT).show();
        }
    }
}
