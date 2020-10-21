package uru.crdvp.tareasemana3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvMascotas;
    String s1[],s2[];
    int imagenes [] = {R.drawable.perro,R.drawable.gato,R.drawable.pajaro,R.drawable.conejo,R.drawable.pez,R.drawable.castor,R.drawable.girafa, R.drawable.hamster, R.drawable.mono, R.drawable.tigre, R.drawable.tortuga, R.drawable.vaca};
    int imgHueso = R.id.imgHueso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //android.widget.Toolbar barraPrueba = findViewById(R.id.tbToolbar);
        //setSupportActionBar(barraPrueba);

        rvMascotas = findViewById(R.id.rvMascotas);

        s1 = getResources().getStringArray(R.array.mascotas);
        s2 = getResources().getStringArray(R.array.descripcion);
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
            favoritos();
        }
        return true;
    }

    public void favoritos(){
        Intent intent = new Intent(this, favoritosActivity.class);
        startActivity(intent);
    }
}