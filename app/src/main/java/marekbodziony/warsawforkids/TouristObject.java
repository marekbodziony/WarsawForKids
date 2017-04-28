package marekbodziony.warsawforkids;

import android.widget.ImageView;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * Created by MBodziony on 2017-04-25.
 */

public class TouristObject implements Serializable {

    private TouristObjectType type;
    private String name;
    private long date;      // date in milisecond, needed only for EVENT types
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
    public TouristObject(TouristObjectType type, String name, long date, String description, String www, float gpsLat,
                         float gpsLon, float rating, long likes){
        this.type = type;
        this.name = name;
        this.date = date;
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

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
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

    // update TouristObject data with new values form other TouristObject
    public void updateTouristObjectWithNewData(TouristObject newTouristObject){

        this.name = newTouristObject.getName();
        this.date = newTouristObject.getDate();
        this.description = newTouristObject.getDescription();
        this.www = newTouristObject.getWww();
        this.gpsLat = newTouristObject.getGpsLat();
        this.gpsLon = newTouristObject.getGpsLon();
        this.rating = newTouristObject.getRating();
        this.likes = newTouristObject.getLikes();
    }
}
