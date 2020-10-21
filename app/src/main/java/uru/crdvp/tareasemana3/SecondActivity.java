package uru.crdvp.tareasemana3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    ImageView mainImageView;
    TextView titulo, descripicon;

    String data1, data2;
    int imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mainImageView = findViewById(R.id.imgMain);
        titulo = findViewById(R.id.tvTituloMain);
        descripicon = findViewById(R.id.tvDescripcionMain);

        getData();
        setData();
    }

    private void getData(){
        if(getIntent().hasExtra("imagen") && getIntent().hasExtra("data1") && getIntent().hasExtra("data2")){
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            imagen = getIntent().getIntExtra("imagen", 1);
        } else{
            Toast.makeText(this,"no Data.",Toast.LENGTH_SHORT).show();
        }
    }
    private void setData(){
        titulo.setText(data1);
        descripicon.setText(data2);
        mainImageView.setImageResource(imagen);
    }
}