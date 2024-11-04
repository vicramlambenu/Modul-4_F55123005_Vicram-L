package com.example.vicraml_f55123005;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast; // Import untuk Toast
import androidx.annotation.NonNull; // Pastikan untuk menambahkan import ini
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextPanjang, editTextLebar, editTextTinggi;
    private TextView textViewHasil;
    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPanjang = findViewById(R.id.editTextPanjang);
        editTextLebar = findViewById(R.id.editTextLebar);
        editTextTinggi = findViewById(R.id.editTextTinggi);
        Button buttonHitung = findViewById(R.id.buttonHitung);
        textViewHasil = findViewById(R.id.textViewHasil);


        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            textViewHasil.setText(result);
        }

        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungVolume();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, textViewHasil.getText().toString()); // Simpan hasil
    }

    private void hitungVolume() {
        String panjangString = editTextPanjang.getText().toString();
        String lebarString = editTextLebar.getText().toString();
        String tinggiString = editTextTinggi.getText().toString();

        // Cek apakah ada field yang kosong
        if (panjangString.isEmpty()) {
            Toast.makeText(this, "Panjang tidak boleh kosong", Toast.LENGTH_SHORT).show();
            editTextPanjang.requestFocus(); // Memindahkan fokus ke EditText yang kosong
            return;
        }

        if (lebarString.isEmpty()) {
            Toast.makeText(this, "Lebar tidak boleh kosong", Toast.LENGTH_SHORT).show();
            editTextLebar.requestFocus();
            return;
        }

        if (tinggiString.isEmpty()) {
            Toast.makeText(this, "Tinggi tidak boleh kosong", Toast.LENGTH_SHORT).show();
            editTextTinggi.requestFocus();
            return;
        }

        double panjang = Double.parseDouble(panjangString);
        double lebar = Double.parseDouble(lebarString);
        double tinggi = Double.parseDouble(tinggiString);
        double volume = panjang * lebar * tinggi;

        textViewHasil.setText(getString(R.string.hasil_volume, volume));
    }
}
