
//package tema2;

import java.util.ArrayList;
import java.io.IOException;

public class Interval {
    private final long start;
    public final ArrayList<Obs> bucket;
    public final ArrayList<ObsH> bucketH;
    public static boolean ok = false;
    public Interval (long start) {
        this.start = start;
        bucket = new ArrayList();
        bucketH = new ArrayList();
    }
    
    public long GetStart () {
        return this.start;
    }
    
    public void AddObs (long time, double temp) {
        bucket.add(new Obs(time, temp));
        bucket.sort(null);
    }
    
    public void AddObsH (long time, double h) {
        bucketH.add(new ObsH(time, h));
        bucketH.sort(null);
    }
    
    public void ListInterval (long start, long stop) {
        //boolean ok = false;
        //try {
        for (int i = 0; i < bucket.size(); i++) {
            if(bucket.get(i).GetTime() < stop && bucket.get(i).GetTime() > start) {
                //System.out.print(o.GetTemp());
                //if(ok)
                if(i == 0) {
                Tema2.out.print(" ");
                //else
                    //ok = true;
                Tema2.out.print(String.format("%.2f", bucket.get(i).GetTemp()));
                }
                else if(bucket.get(i).GetTemp() != bucket.get(i-1).GetTemp()) {
                    Tema2.out.print(" ");
                    Tema2.out.print(String.format("%.2f", bucket.get(i).GetTemp()));
                }
            }
        }
        //}
        //catch (IOException ex) {
            
        //}
    }
}
