package com.pipepino.evaluacion1;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class MyViewHolder extends RecyclerView.ViewHolder{
    ImageView foto;
    TextView nombre,fecha,hora;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        nombre=itemView.findViewById(R.id.textView);
        fecha=itemView.findViewById(R.id.textView2);
        hora=itemView.findViewById(R.id.textView3);
        foto=itemView.findViewById(R.id.imageView2);
    }
}
