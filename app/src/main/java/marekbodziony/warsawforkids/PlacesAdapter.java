package marekbodziony.warsawforkids;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by mbodziony on 2017-04-10.
 */

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.PlaceViewHolder>{

    private Context context;
    private List<Place> placesList;

    // view holder
    public static class PlaceViewHolder extends RecyclerView.ViewHolder{

        private ImageView image;
        private TextView name;
        private TextView description;
        private RatingBar rating;

        private PlaceViewHolder (View itemView){
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.cardImageView);
            name = (TextView)itemView.findViewById(R.id.cardNameTxtView);
            description = (TextView)itemView.findViewById(R.id.cardDescriptionTxt);
            rating = (RatingBar)itemView.findViewById(R.id.cardRatingBar);
        }
    }

    // constructor
    public PlacesAdapter (Context context, List<Place> placesList){
        this.context = context;
        this.placesList = placesList;
    }

    // implementation of ViewHolder abstract methods
    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_card_view,parent,false);
        PlaceViewHolder placeVh = new PlaceViewHolder(view);
        return placeVh;
    }

    @Override
    public void onBindViewHolder(PlaceViewHolder placeViewHolder, int position) {
        Place place = placesList.get(position);
        placeViewHolder.name.setText(place.getName());
        placeViewHolder.description.setText(place.getDescription());
        placeViewHolder.rating.setRating(place.getRating());

        // loading image using Glide library
        Glide.with(context).load(place.getImage()).into(placeViewHolder.image);
    }

    @Override
    public int getItemCount() {
        return placesList.size();
    }





}

