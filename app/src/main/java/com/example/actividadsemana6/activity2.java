package com.example.actividadsemana6;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activity2 extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_2);

        // Inicializa los componentes
        imageView = findViewById(R.id.imageView2);
        textView = findViewById(R.id.textView2);

        // Configura la visualización de los insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loadDataFromIntent();
    }

    private void loadDataFromIntent() {
        // Recupera los datos del Intent
        byte[] byteArray = getIntent().getByteArrayExtra("image");
        String text = getIntent().getStringExtra("text");

        // Verifica si se recibieron los datos
        if (byteArray != null && text != null) {
            setImageAndText(byteArray, text);
        } else {
            handleMissingData();
        }
    }

    private void setImageAndText(byte[] byteArray, String text) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        imageView.setImageBitmap(bitmap);
        textView.setText(text);
    }

    private void handleMissingData() {
        textView.setText("No se recibió ningún dato.");
        imageView.setImageResource(R.drawable._64649_luna_luna_negra_ambiente_de_la_media_luna_naturaleza_3840x2160);
    }
}
