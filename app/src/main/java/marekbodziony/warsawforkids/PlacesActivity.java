package marekbodziony.warsawforkids;

import android.support.constraint.solver.ArrayLinkedVariables;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PlacesActivity extends AppCompatActivity {

    private RecyclerView placesRv;
    private PlacesAdapter placesRvAdapter;
    private List<Place> placesList;

    private DatabaseReference dbReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        dbReference = FirebaseDatabase.getInstance().getReference();

        placesList = new ArrayList<Place>();

        placesRv = (RecyclerView)findViewById(R.id.placesRecycleView);
        placesRv.setHasFixedSize(true);
        placesRv.setLayoutManager(new LinearLayoutManager(this));

        placesRvAdapter = new PlacesAdapter(this,placesList);
        placesRv.setAdapter(placesRvAdapter);
    }

    @Override
    public void onStart(){
        super.onStart();

        dbReference.child("places").child("1").child("likes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                long likes = (long)dataSnapshot.getValue();
                Log.d("W4K","Likes = " + likes);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        Place p1 = new Place("PKiN",3.0f,R.drawable.warsaw,"Najwyższy budynek w Polsce, ma 44 piętra. Na 30 piętrze, na wysokości 114 m " +
                "znajduje się taras widokowy. Wieżowiec został wzniesiony jako „Dar narodów radzieckich dla narodu polskiego”. Pomysłodawcą " +
                "projektu był Józef Stalin. W sylwestrową noc z 2000 na 2001 rok na szczycie Pałacu Kultury odsłonięty został drugi co do " +
                "wielkości w Europie zegar, jego cztery tarcze mają średnice po 6 metrów.");
        Place p2 = new Place("Park fontann",4.5f,R.drawable.warsaw,"Multimedialny Park Fontann w Warszawie jest to kompleks czterech fontann " +
                "znajdujący się na Skwerze 1 Dywizji Pancernej WP pomiędzy ulicami Boleść, Wybrzeże Gdańskie, Sanguszki i Rybaki na Nowym " +
                "Mieście w Warszawie. Zespół fontann uruchomiono 7 maja 2011, w związku z jubileuszem 125-lecia Miejskiego Przedsiębiorstwa " +
                "Wodociągów i Kanalizacji (MPWiK). W piątkowe i sobotnie wieczory (a czasami również w inne dni) o 21.00 lub 21.30 od maja do " +
                "września odbywają się tutaj 30-minutowe pokazy multimedialne „woda-światło-dźwięk” z wykorzystaniem reflektorów LED i laserów. " +
                "Obok fontann odsłonięto pomnik Williama Heerleina Lindleya, który zaprojektował sieć kanalizacyjną Warszawy i w 1886 uruchomił " +
                "miejskie wodociągi.");
        Place p3 = new Place("Dworzec Centralny",1.0f,R.drawable.warsaw,"Warszawa Centralna is the primary railway station in Warsaw, Poland. " +
                "The station was constructed as a flagship project of the People's Republic of Poland during the 1970s western-loan fueled " +
                "economic boom, and was meant to replace the inadequate Warsaw Główna.");
        placesList.add(p1);
        placesList.add(p2);
        placesList.add(p1);
        placesList.add(p3);

    }
}
