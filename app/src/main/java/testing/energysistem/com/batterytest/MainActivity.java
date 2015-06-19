package testing.energysistem.com.batterytest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {


    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<Ficha> items = new ArrayList<>();

        items.add(new Ficha(R.drawable.fabricante_logo, "Modo Fabricante", 0));
        items.add(new Ficha(R.drawable.usuario, "Modo Usuario", 0));
        items.add(new Ficha(R.drawable.valoracion, "Valoracion Test", 0));
        items.add(new Ficha(R.drawable.detail_battery2, "Registro Bateria", 0));
        items.add(new Ficha(R.drawable.detail_battery, "Caracteristicas Bateria", 0));
        items.add(new Ficha(R.drawable.device_features, "Datos dispositivo", 0));

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adapter = new CartaAdapdater(items, this);
        recycler.setAdapter(adapter);

    }
}
