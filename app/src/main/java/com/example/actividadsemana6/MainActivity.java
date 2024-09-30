package com.example.actividadsemana6;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    private EditText ETNombre;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Inicializa los componentes
        ETNombre = findViewById(R.id.editText);
        imageView = findViewById(R.id.idImageView);
        Button BTAceptar = findViewById(R.id.btnAceptar);

        // Configura el listener para el botón
        BTAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String StNombre = ETNombre.getText().toString();

                // Captura el bitmap de la imagen
                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                Intent intent = new Intent(MainActivity.this, activity2.class);
                intent.putExtra("image", byteArray);
                intent.putExtra("text", StNombre);
                startActivity(intent);
            }
        });

        // Configura la visualización de los insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
