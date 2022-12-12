package com.example.electroapp.ui.points;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.electroapp.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class newPoint extends AppCompatActivity {
    Button add_point;
    EditText nameET, emailET, latitudET, longitudET;
    private FirebaseFirestore mfirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_point);

        this.setTitle("Crear punto");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mfirestore = FirebaseFirestore.getInstance();

        nameET = findViewById(R.id.name);
        emailET = findViewById(R.id.email);
        latitudET = findViewById(R.id.latitud);
        longitudET = findViewById(R.id.longitud);

        add_point = findViewById(R.id.add_point);

        add_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameET.getText().toString().trim();
                String email = emailET.getText().toString().trim();
                String latitud = latitudET.getText().toString().trim();
                String longitud = longitudET.getText().toString().trim();

                if(name.isEmpty() || latitud.isEmpty() || longitud.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Ingrese los datos", Toast.LENGTH_SHORT).show();
                }
                else{
                    postPoint(name, email, latitud, longitud);
                }
            }
        });
    }

    private void postPoint(String name,String email,String latitud,String longitud){
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("email", email);
        map.put("latitud", latitud);
        map.put("longitud", longitud);
        mfirestore.collection("point").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getApplicationContext(), "Punto guardado exitosamente", Toast.LENGTH_SHORT).show();
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Error al guardar el punto", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}