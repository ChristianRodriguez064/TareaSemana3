package uru.crdvp.tareasemana3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.MyViewHolder> {

    String data1[], data2[];
    int imagenes [];
    int imgHuesoTodos;
    Context context;

    public MiAdaptador(Context ct, String s1[], String s2[], int img [], int imgHueso){
        context = ct;
        data1 = s1;
        data2 = s2;
        imagenes = img;
        imgHuesoTodos = imgHueso;
    }

    @NonNull
    @Override
    public MiAdaptador.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.segundo_activity, parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MiAdaptador.MyViewHolder holder, int position) {
        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);
        holder.myImage.setImageResource(imagenes[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("data1", data1[position]);
                intent.putExtra("data2", data2[position]);
                intent.putExtra("imagen", imagenes[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imagenes.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView myText1;
        TextView myText2;
        ImageView myImage;
        ConstraintLayout mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.tvTitulo);
            myText2 = itemView.findViewById(R.id.tvDescripcion);
            myImage = itemView.findViewById(R.id.imgAnimal);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }
}
