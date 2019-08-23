package com.example.lenovo.konversijarak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    int req_code = 1;
    private Button b_KmCm, b_KmM;
    private TextView tResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_KmCm = findViewById(R.id.KmCm);
        b_KmM = findViewById(R.id.KmM);

        b_KmCm.setOnClickListener(this);
        b_KmM.setOnClickListener(this);

        tResult = findViewById(R.id.result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {

            case R.id.KmCm:
                Intent cm = new Intent(this, Main2Activity.class);
                startActivityForResult(cm, req_code);
                break;

            case R.id.KmM:
                Intent m = new Intent(this, Main3Activity.class);
                startActivity(m);
                break;

        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent rtn) {

        if (requestCode == req_code){
            if (resultCode == RESULT_OK){
                tResult.setText(rtn.getData().toString());
            }
        }

    }
}
