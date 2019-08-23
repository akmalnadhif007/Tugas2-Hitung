package com.example.lenovo.konversijarak;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    private Button b_hitung;
    private EditText kon_km;
    private TextView cetak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        this.setTitle("KM ke CM");

        b_hitung = findViewById(R.id.hitung);

        kon_km   = findViewById(R.id.hkm);

        b_hitung.setOnClickListener(this);

        cetak   = findViewById(R.id.cetak);
    }

    @Override
    public void onClick(View v) {
        int rumus = 100000;
        if (v.getId() == R.id.hitung)
        {

            String inp_km = kon_km.getText().toString().trim();

            boolean tidakKosong = false;

            Integer hkm = toInt(inp_km);

            if (inp_km.length() < 0){

                kon_km.setError("Kolom ini harus di isi");

            }

            if (!tidakKosong){

                int hasil = hkm * rumus;
                Intent data = new Intent();
                data.setData(Uri.parse("Hasil: "+String.valueOf(hasil)));
                setResult(RESULT_OK, data);

                finish();

            }
        }
    }

    private Integer toInt(String str) {
        try {
            return Integer.valueOf(str);
        }catch (Exception we){
            return null;
        }
    }
}
