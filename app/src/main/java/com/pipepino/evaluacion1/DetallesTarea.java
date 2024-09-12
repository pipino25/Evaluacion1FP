package com.pipepino.evaluacion1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import java.util.List;

public class DetallesTarea extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalles_tarea);
        /*iewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
        List<Tarea> Tareas=ListaTareas.getInstance().getListaTareas();

        RecyclerView reciclerView=findViewById(R.id.reciclerView);
        reciclerView.setLayoutManager(new LinearLayoutManager(this));
        reciclerView.setAdapter(new DetallesAdapter(getApplicationContext(),Tareas));

        Button botonVolver=findViewById(R.id.buttonBackToTareas);
        botonVolver.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(DetallesTarea.this,Tareas.class);
                startActivity(intent);
            }
        });
    }
}