/**
 * Xia Lin
 * 110732381
 * xia.lin@stonybrook.edu
 * Assignment 1
 * CSE214-01
 * Charles Chen
 * Shilpi Bhattacharyya
 */
package homework2;

public class TripStop {

    private String location;
    private int distance;
    private String activity;
    
    /**
     * Default constructor
     */
    public TripStop() {

    }
    /**
     * Constructor for set the location and activity
     * @param l
     * location string
     * @param a 
     * activity string
     */
    public TripStop(String l, String a) {
        location = l;
        activity = a;
    }
    /**
     * Set location to TripStop
     * @param l 
     * location to be set
     */
    public void setLocation(String l) {
        location = l;
    }
    /**
     * Set distance to TripStop
     * @param d
     * distance to be set
     * @throws IllegalArgumentException 
     * if distance < 0
     */
    public void setDistance(int d) throws IllegalArgumentException {
        if (d < 0) {
            throw new IllegalArgumentException();
        } else {
            distance = d;
        }
    }
    /**
     * Set activity to TripStop
     * @param a 
     * activity to be set
     */
    public void setActivity(String a) {
        activity = a;
    }
    /**
     * Get location from TripStop
     * @return 
     * TripStop object of location
     */
    public String getLocation() {
        return location;
    }
    /**
     * Get distance from TripStop
     * @return 
     * TripStop object of distance
     */
    public int getDistance() {
        return distance;
    }
    /**
     * Get activity from TripStop
     * @return 
     * TripStop object of activity
     */
    public String getActivity() {
        return activity;
    }
    /**
     * Print the information of current TripStop
     * @return 
     * String of information of current TripStop
     */
    public String toString() {
        return String.format("%-21s%-40s%-21s", location, activity, distance + " miles");
    }

}
