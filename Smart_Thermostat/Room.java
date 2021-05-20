
//package tema2;

import java.util.ArrayList;
import java.io.IOException;

public class Room {
    private final String name;
    private final static long refTime = House.GetRefTime();
    private final String deviceID;
    private final int area;
    private final ArrayList<Interval> timeSeries;
    
    public Room (String name, long refTime, String deviceID, int area) {
        this.name = name;
        //this.refTime = refTime;
        this.deviceID = deviceID;
        this.area = area;
        this.timeSeries = new ArrayList();
        for(int i = 0; i < 24; i++) {
            timeSeries.add(new Interval(refTime - (i + 1) * 3600));
        }
    }
    
    public String GetName () {
        return this.name;
    }
    
    public String GetDeviceID () {
        return this.deviceID;
    }
    
    public int GetArea () {
        return this.area;
    }
    
    public void AddObs (long time, double temp) {
        for (Interval i: timeSeries) {
            if(time > i.GetStart() && time < refTime) {
                i.AddObs(time, temp);
                break;
            }
        }
    }
    
    public void AddObsH (long time, double h) {
        for (Interval i: timeSeries) {
            if(time > i.GetStart() && time < refTime) {
                i.AddObsH(time, h);
                break;
            }
        }
    }
    
    public void ListRoom (long start, long stop) {
        Interval.ok = false;
        //try {
        Tema2.out.print(name);
        for (Interval i: timeSeries) {
            if(stop > i.GetStart()) {
                if(start > i.GetStart()) {
                    //Tema2.out.write(name);
                    i.ListInterval(start, stop);
                    break;
                }
                else
                    //Tema2.out.write(name);
                    i.ListInterval(start, stop);
            }
        }
        //}
        //catch(IOException ex) {}
    }
    
    public double GetMin () {
        for(Interval i: timeSeries) {
            if(!i.bucket.isEmpty()) {
                //System.out.println(i.bucket.get(0).GetTemp());
                return i.bucket.get(0).GetTemp();
            }
        }
        return 0;
    }
    
    public double GetMinH () {
        for(Interval i: timeSeries) {
            if(!i.bucketH.isEmpty()) {
                //System.out.println(i.bucket.get(0).GetTemp());
                return i.bucketH.get(0).GetH();
            }
        }
        return 0;
    }
}
