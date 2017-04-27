package marekbodziony.warsawforkids;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TouristObjectsListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TouristObjectAdapter adapter;
    List<TouristObject> touristObjectList;

    boolean readFromFirebase = true;

    DatabaseReference firebaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_objects_list);

        firebaseRef = FirebaseDatabase.getInstance().getReference();
        touristObjectList = new ArrayList<>();

        // get data from Firebase
        getTouristObjectListFromFirebase();

        recyclerView = (RecyclerView) findViewById(R.id.tourist_object_list_recyclerView);
        recyclerView.setHasFixedSize(true);     //  for better performance
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TouristObjectAdapter(this,touristObjectList);
        recyclerView.setAdapter(adapter);
    }

    // get data from Firebase
    private void getTouristObjectListFromFirebase(){

        final TouristObjectType type = (TouristObjectType)getIntent().getSerializableExtra("type");
        firebaseRef.child(type.name()).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                TouristObject t = getTouristObjectFromDataSnapsot(dataSnapshot, type);
                touristObjectList.add(t);

                adapter.notifyDataSetChanged();     // refresh view when there is new data
                Log.i("W4K","onChildAdded() => " + dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                String data = dataSnapshot.getValue().toString();
                Log.i("W4K","onChildChanged() => " + data);

                TouristObject t = getTouristObjectFromDataSnapsot(dataSnapshot, type);
                touristObjectList.remove(Integer.parseInt(dataSnapshot.getKey())-1);
                touristObjectList.add(t);
                adapter.notifyDataSetChanged();     // refresh view when there is new data update
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                touristObjectList.remove(Integer.parseInt(dataSnapshot.getKey())-1);
                adapter.notifyDataSetChanged();     // refresh view when there was item removed
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }


    private TouristObject getTouristObjectFromDataSnapsot(DataSnapshot dataSnapshot, TouristObjectType type){

        Map touristItem = (HashMap)dataSnapshot.getValue();
        String name = "", description = "", www = "";
        Float gpsLat = 0.0f, gpsLon = 0.0f, rating = 0.0f;
        Long likes = 0L;

        if (touristItem.get("name")                 != null) name = (String)touristItem.get("name");
        if (touristItem.get("description") != null) description = (String)touristItem.get("description");
        if (touristItem.get("gpsLat") != null )     gpsLat = Float.parseFloat(""+touristItem.get("gpsLat"));
        if (touristItem.get("gpsLon") != null)      gpsLon = Float.parseFloat(""+touristItem.get("gpsLon"));
        if (touristItem.get("rating") != null)      rating = Float.parseFloat(""+touristItem.get("rating"));
        if (touristItem.get("likes") != null)       likes = (long)touristItem.get("likes");


//                Log.i("W4K","\nNew child added to Firebase:\n" + touristItem.toString());
//                Log.i("W4K","Name = " + name + "(" + name.getClass() + ")");
//                Log.i("W4K","Description = " + description + "(" + description.getClass() + ")");
//                Log.i("W4K","www = " + www + "(" + www.getClass() + ")");
//                Log.i("W4K","gpsLat = " + gpsLat + "(" + gpsLat.getClass() + ")");;
//                Log.i("W4K","gpsLon = " + gpsLon + "(" + gpsLon.getClass() + ")");
//                Log.i("W4K","rating = " + rating + "(" + rating.getClass() + ")");
//                Log.i("W4K","likes = " + likes + "(" + likes.getClass() + ")");

        TouristObject t = new TouristObject(type,name,new GregorianCalendar(),description,www,gpsLat,gpsLat,rating,likes);

        return t;
    };
}
