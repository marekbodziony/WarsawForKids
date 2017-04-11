package marekbodziony.warsawforkids;

import android.widget.ImageView;

/**
 * Created by mbodziony on 2017-04-10.
 */

public class Place {

    private String name;
    private String www;
    private String description;
    private Gps gps;
    private float rating;
    private int likes;
    private int image;

    public Place(String name, float rating, int image, String description){
        this.name = name;
        this.rating = rating;
        this.image = image;
        this.description = description;
    }

    public Place(String name, String www, String description, Gps gps, float rating, int likes, int image){
        this.name = name;
        this.www = www;
        this.description = description;
        this.gps = gps;
        this.rating = rating;
        this.likes = likes;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWww() {
        return www;
    }

    public void setWww(String www) {
        this.www = www;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Gps getGps() {
        return gps;
    }

    public void setGps(Gps gps) {
        this.gps = gps;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getImage() { return image;}

    public void setImage (int image) { this.image = image;}
}
