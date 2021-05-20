
//package tema2;

public class Obs implements Comparable {
    private final long time;
    private final double temp;
    
    public Obs(long time, double temp) {
        this.time = time;
        this.temp = temp;
    }
    
    public long GetTime () {
        return this.time;
    }
    
    public double GetTemp () {
        return this.temp;
    }
    
    @Override
    public int compareTo (Object x) {
        double aux = this.temp - ((Obs)x).temp;
        if(aux > 0)
            return 1;
        else
            if (aux < 0)
                return -1;
        return 0;
    }
}
