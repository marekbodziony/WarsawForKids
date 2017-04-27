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

import java.util.List;

public class TouristObjectAdapter extends RecyclerView.Adapter<TouristObjectAdapter.TouristViewHolder>{

    private Context context;
    private List<TouristObject> list;


    // adapter constructor
    public TouristObjectAdapter(Context context, List<TouristObject> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public TouristViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tourist_object_card_view, parent, false);
        TouristViewHolder touristViewHolder = new TouristViewHolder(view);
        return touristViewHolder;
    }

    @Override
    public void onBindViewHolder(TouristViewHolder touristViewHolder, int position) {
        TouristObject touristObj = list.get(position);
        touristViewHolder.name.setText(touristObj.getName());
        touristViewHolder.description.setText(touristObj.getDescription());
        touristViewHolder.rating.setRating(touristObj.getRating());
        // loading image using Glide library
        //Glide.with(context).load(touristObj.getImg()).into(touristViewHolder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // Provide a reference to the views for each data item
    public static class TouristViewHolder extends RecyclerView.ViewHolder{

        public ImageView img;
        public TextView name;
        public TextView description;
        public RatingBar rating;

        public TouristViewHolder(View view) {
            super(view);
            img = (ImageView)itemView.findViewById(R.id.card_image_view);
            name = (TextView)itemView.findViewById(R.id.card_name_text_view);
            description = (TextView) itemView.findViewById(R.id.card_description_text_view);
            rating = (RatingBar) itemView.findViewById(R.id.card_rating_bar);
        }
    }


}
