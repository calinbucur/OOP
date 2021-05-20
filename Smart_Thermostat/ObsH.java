
//package tema2;

public class ObsH implements Comparable{
    private final long time;
    private final double h;
    
    public ObsH(long time, double h) {
        this.time = time;
        this.h = h;
    }
    
    public long GetTime () {
        return this.time;
    }
    
    public double GetH () {
        return this.h;
    }
    
    @Override
    public int compareTo (Object x) {
        double aux = this.h - ((ObsH)x).h;
        if(aux > 0)
            return -1;
        else
            if (aux < 0)
                return 1;
        return 0;
    }
}
