package marekbodziony.warsawforkids;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private ImageButton eventsBtn;
    private ImageButton attractionsBtn;
    private ImageButton placesBtn;
    private ImageButton parksBtn;
    private ImageButton playgroundsBtn;
    private ImageButton restaurantsBtn;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         eventsBtn = (ImageButton)findViewById(R.id.events_btn);
         attractionsBtn = (ImageButton) findViewById(R.id.attractions_btn);
         placesBtn = (ImageButton) findViewById(R.id.places_btn);
         parksBtn = (ImageButton) findViewById(R.id.parks_btn);
         playgroundsBtn = (ImageButton) findViewById(R.id.playgrounds_btn);
         restaurantsBtn = (ImageButton) findViewById(R.id.restaurants_btn);

         OnTouristItemClickListener clickListener = new OnTouristItemClickListener();

         eventsBtn.setOnClickListener(clickListener);
         attractionsBtn.setOnClickListener(clickListener);
         placesBtn.setOnClickListener(clickListener);
         parksBtn.setOnClickListener(clickListener);
         playgroundsBtn.setOnClickListener(clickListener);
         restaurantsBtn.setOnClickListener(clickListener);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    // Listener for TouristItem click
    private class OnTouristItemClickListener implements View.OnClickListener{

        @Override
        public void onClick(View button) {
            Intent intent = new Intent(getApplicationContext(),TouristObjectsListActivity.class);
            int id = button.getId();
            if (id == eventsBtn.getId()){
                intent.putExtra("type",TouristObjectType.EVENT);
                Log.i("W4K","User selected: " + TouristObjectType.EVENT + " list");
            }
            else if (id == attractionsBtn.getId()){
                intent.putExtra("type",TouristObjectType.ATTRACTION);
                Log.i("W4K","User selected: " + TouristObjectType.ATTRACTION + " list");
            }
            else if (id == placesBtn.getId()){
                intent.putExtra("type",TouristObjectType.PLACE);
                Log.i("W4K","User selected: " + TouristObjectType.PLACE + " list");
            }
            else if (id == parksBtn.getId()) {
               intent.putExtra("type",TouristObjectType.PARK);
               Log.i("W4K","User selected: " + TouristObjectType.PARK + " list");
            }
            else if (id == playgroundsBtn.getId()){
                    intent.putExtra("type",TouristObjectType.PLAYGROUND);
                    Log.i("W4K","User selected: " + TouristObjectType.PLAYGROUND + " list");
            }
            else if (id == restaurantsBtn.getId()){
                intent.putExtra("type",TouristObjectType.RESTAURANT);
                Log.i("W4K","User selected: " + TouristObjectType.RESTAURANT+ " list");
            }
            startActivity(intent);
        }
    }

}
