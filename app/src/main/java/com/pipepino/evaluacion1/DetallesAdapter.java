package com.pipepino.evaluacion1;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class DetallesAdapter extends RecyclerView.Adapter<MyViewHolder>{

    Context context;
    List<Tarea> Tareas;

    public DetallesAdapter(Context context,List<Tarea> tareas) {
        this.context=context;
        this.Tareas = tareas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.detalles_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nombre.setText(Tareas.get(position).getNombre());
        holder.fecha.setText(Tareas.get(position).getFecha());
        holder.hora.setText(Tareas.get(position).getHora());

        holder.foto.setImageResource(R.drawable.bot);
    }

    @Override
    public int getItemCount() {
        return Tareas.size();
    }
}
