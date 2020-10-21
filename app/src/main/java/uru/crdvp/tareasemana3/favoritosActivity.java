package uru.crdvp.tareasemana3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class favoritosActivity extends AppCompatActivity {

    RecyclerView rvMascotas;
    String s1[],s2[];
    int imagenes [] = {R.drawable.perro,R.drawable.gato,R.drawable.conejo,R.drawable.hamster, R.drawable.tigre};
    int imgHueso = R.id.imgHueso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        rvMascotas = findViewById(R.id.rvMascotasFavoritas);

        s1 = getResources().getStringArray(R.array.mascotasFavoritas);
        s2 = getResources().getStringArray(R.array.descripcionFavoritas);
        imgHueso =  R.id.imgHueso;

        MiAdaptador miAdaptador = new MiAdaptador(this, s1,s2,imagenes,imgHueso);
        rvMascotas.setAdapter(miAdaptador);
        rvMascotas.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.idFavoritos){
            Toast.makeText(getApplicationContext(),"Seleccionaste Favoritos",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
