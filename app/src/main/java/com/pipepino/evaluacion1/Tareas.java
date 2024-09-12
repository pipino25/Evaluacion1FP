package com.pipepino.evaluacion1;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;

public class Tareas extends AppCompatActivity {

    private List<Tarea> listaTareas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tareas);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
        listaTareas=ListaTareas.getInstance().getListaTareas();
        TableLayout tableLayoutTareas = findViewById(R.id.tableLayoutTareas);
        Button buttonBack = findViewById(R.id.buttonBack);

        // Llenando la tabla con las tareas
        for (Tarea tarea : listaTareas) {
            TableRow row = new TableRow(this);

            TextView nombre = new TextView(this);
            nombre.setText(tarea.getNombre());
            row.addView(nombre);

            TextView fecha = new TextView(this);
            fecha.setText(tarea.getFecha());
            row.addView(fecha);

            TextView hora = new TextView(this);
            hora.setText(tarea.getHora());
            row.addView(hora);

            Button buttonVerDetalles = new Button(this);
            buttonVerDetalles.setText("Ver Detalles");
            buttonVerDetalles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Tareas.this, DetallesTarea.class);
                    startActivity(intent);
                }
            });
            row.addView(buttonVerDetalles);

            tableLayoutTareas.addView(row);
        }

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tareas.this, Home.class);
                //intent.putExtra("tarea", tarea); // Pasar el objeto tarea
                startActivity(intent);
            }
        });
    }
}

