package marekbodziony.warsawforkids;

import android.widget.ImageView;

import java.util.GregorianCalendar;

/**
 * Created by MBodziony on 2017-04-25.
 */

public class TouristObject {

    private TouristObjectType type;
    private String name;
    private GregorianCalendar eventDate;      // needed only for EVENT types
    private String description;
    private String www;
    private float gpsLat;
    private float gpsLon;
    private float rating;
    private long likes;
    private ImageView img;

    // default constructor required for getting data from Firebase as TouristObject
    public TouristObject(){}

    // constructor
    public TouristObject(TouristObjectType type, String name, GregorianCalendar eventDate, String description, String www, float gpsLat,
                         float gpsLon, float rating, long likes){
        this.type = type;
        this.name = name;
        this.eventDate = eventDate;
        this.description = description;
        this.www = www;
        this.gpsLat = gpsLat;
        this.gpsLon = gpsLon;
        this.rating = rating;
        this.likes = likes;
    }

    // getters and setters
    public TouristObjectType getType() {
        return type;
    }

    public void setType(TouristObjectType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GregorianCalendar getEventDate() {
        return eventDate;
    }

    public void setEventDate(GregorianCalendar eventDate) {
        this.eventDate = eventDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWww() {
        return www;
    }

    public void setWww(String www) {
        this.www = www;
    }

    public float getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(float gpsLat) {
        this.gpsLat = gpsLat;
    }

    public float getGpsLon() {
        return gpsLon;
    }

    public void setGpsLon(float gpsLon) {
        this.gpsLon = gpsLon;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public ImageView getImg(){
        return img;
    }
    public void setImgs(ImageView img){
        this.img = img;
    }
}
