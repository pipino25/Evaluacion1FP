package com.pipepino.evaluacion1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class CrearTarea extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crear_tarea);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
        EditText editTextNombre = findViewById(R.id.editTextNombre);
        DatePicker datePickerFecha = findViewById(R.id.datePickerFecha);
        Spinner spinnerHora = findViewById(R.id.spinnerHora);
        Button buttonGuardarTarea = findViewById(R.id.buttonGuardarTarea);

        // Configurar el Spinner con las horas
        List<String> horas = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 60; j += 15) {
                String hora = String.format("%02d:%02d", i, j);
                horas.add(hora);
            }
        }

        // Configurar el ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, horas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHora.setAdapter(adapter);

        buttonGuardarTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = editTextNombre.getText().toString();
                int day = datePickerFecha.getDayOfMonth();
                int month = datePickerFecha.getMonth() + 1;
                int year = datePickerFecha.getYear();
                String fecha = day + "/" + month + "/" + year;
                String hora = spinnerHora.getSelectedItem().toString();

                Tarea tarea = new Tarea(nombre, fecha, hora);
                ListaTareas.getInstance().addTarea(tarea);
                showAlert();
            }
        });

        Button botonVolver=findViewById(R.id.volver);
        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CrearTarea.this,Home.class);
                startActivity(intent);
            }
        });
    }

    private void showAlert() {
        // Crear la alerta
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Listo!");
        builder.setMessage("La tarea ha sido creada");

        // Botón de OK para cerrar la alerta
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
}
