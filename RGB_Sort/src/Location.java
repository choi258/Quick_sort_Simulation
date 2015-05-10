public class Location { 
    private String name;
    private double longitude;
    private double latitude;   
   
    /*
     create and initialize a point with given name and
     (latitude, longitude) specified in degrees
    */
    public Location(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude  = latitude;
        this.longitude = longitude;
    }
    
    public String getName(){
    	return name;
    }
    
    public double getLatitude(){
    	return latitude;
    }
    
    public double getLongitude(){
    	return longitude;
    }
    
    public double distanceTo(Location that) {// return distance between this location and that location
        double lat1,lon1,lat2,lon2; 
        double STATUTE_MILES_PER_NAUTICAL_MILE = 1.15077945;
        double angle,nauticalMiles, statuteMiles;
        
        lat1 = Math.toRadians(this.latitude);
        lon1 = Math.toRadians(this.longitude);
        lat2 = Math.toRadians(that.latitude);
        lon2 = Math.toRadians(that.longitude);
        
        // distance in radians, using law of cosines formula
        angle= Math.acos(Math.sin(lat1) * Math.sin(lat2)
                               + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));
        
        nauticalMiles= 60 * Math.toDegrees(angle);
        statuteMiles = STATUTE_MILES_PER_NAUTICAL_MILE * nauticalMiles;
        return statuteMiles;
    }

    // return string representation of this point
    public String toString() {
        return name + " (" + latitude + ", " + longitude + ")";
    }
    
    // test Object
    /*
    public static void main(String[] args) {
        Location loc1 = new Location("PRINCETON_NJ", 40.366633, 74.640832);
        Location loc2 = new Location("ITHACA_NY",    42.443087, 76.488707);  
        double distance = loc1.distanceTo(loc2);
        System.out.printf("%6.3f miles from\n", distance);
        System.out.println(loc1 + " to " + loc2);
    }*/
}
