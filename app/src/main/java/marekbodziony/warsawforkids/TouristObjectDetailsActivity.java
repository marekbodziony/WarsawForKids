package marekbodziony.warsawforkids;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.Date;
import java.util.GregorianCalendar;

public class TouristObjectDetailsActivity extends AppCompatActivity {

    private TextView name;
    private TextView likes;
    private TextView dateTxt;
    private TextView dateValue;
    private RatingBar rating;
    private TextView description;
    private TextView www;
    private ImageButton mapBtn;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_object_details);

        name = (TextView) findViewById(R.id.tourist_object_details_name_txt);
        likes = (TextView) findViewById(R.id.tourist_object_details_likes_txt);
        dateTxt = (TextView) findViewById(R.id.tourist_object_details_date_txt);
        dateValue = (TextView) findViewById(R.id.tourist_object_details_date__value_txt);
        rating = (RatingBar) findViewById(R.id.tourist_object_details_rating_bar);
        description = (TextView) findViewById(R.id.tourist_object_details_description_txt);
        description.setMovementMethod(new ScrollingMovementMethod());
        www = (TextView) findViewById(R.id.tourist_object_details_www_txt);
        mapBtn = (ImageButton) findViewById(R.id.tourist_object_details_map_btn);
        fab = (FloatingActionButton) findViewById(R.id.tourist_object_details_fab);

        // get TouristObject form Intent
        TouristObject t = (TouristObject)getIntent().getSerializableExtra("touristObject");
        setDetailsValuesWithDataFromTouristObject(t);

    }

    private void setDetailsValuesWithDataFromTouristObject(TouristObject t) {

        name.setText(t.getName());
        likes.setText(""+t.getLikes());
        long dateInMilis = t.getDate();
        if (dateInMilis == 0){
            dateTxt.setVisibility(View.INVISIBLE);
            dateValue.setVisibility(View.INVISIBLE);
        }
        else { dateValue.setText(new Date(dateInMilis).toString());}
        rating.setRating(t.getRating());
        description.setText(t.getDescription());
        www.setText(t.getWww());
    }
}
