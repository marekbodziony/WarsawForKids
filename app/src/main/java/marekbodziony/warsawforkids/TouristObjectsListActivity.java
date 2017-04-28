package marekbodziony.warsawforkids;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
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
    private List<TouristObject> touristObjectList;

    private DatabaseReference firebaseRef;

    private TextView emptyListText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_objects_list);

        emptyListText = (TextView) findViewById(R.id.tourist_object_list_empty_txt);

        firebaseRef = FirebaseDatabase.getInstance().getReference();
        touristObjectList = new ArrayList<>();

        getTouristObjectListFromFirebase();     // get data from Firebase and populate touristObjectList

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

                TouristObject t = dataSnapshot.getValue(TouristObject.class);
                touristObjectList.add(t);

                adapter.notifyDataSetChanged();     // refresh view when there is new data
                Log.i("W4K","onChildAdded() => " + dataSnapshot);
                emptyListText.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                String data = dataSnapshot.getValue().toString();
                Log.i("W4K","onChildChanged() => " + data);

                int id = Integer.parseInt(dataSnapshot.getKey())-1;
                TouristObject oldTouristObj = touristObjectList.get(id);
                TouristObject newTouristObj = dataSnapshot.getValue(TouristObject.class);
                oldTouristObj.updateTouristObjectWithNewData(newTouristObj);

                adapter.notifyDataSetChanged();     // refresh view when there is new data update
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                touristObjectList.remove(Integer.parseInt(dataSnapshot.getKey())-1);
                if (touristObjectList.size() == 0) emptyListText.setVisibility(View.VISIBLE);      // show "No data to show" text when list is empty
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
}
