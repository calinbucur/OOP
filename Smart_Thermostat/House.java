
//package tema2;

import java.util.ArrayList;
import java.sql.Timestamp;

public class House {
    private static int roomNr;
    private static double refTemp;
    private static long refTime;
    private static double refH;
    private static final ArrayList<Room> ROOMS = new ArrayList();
    private static int area; 
    
    public static void SetRefH (double h) {
        House.refH = h;
    }
    
    public static double GetRefH () {
        return House.refH;
    }
    
    public static void SetRoomNr (int roomNr) {
        House.roomNr = roomNr;
    }
    public static int GetRoomNr () {
        return House.roomNr;
    }
    
    public static void SetRefTemp (double refTemp) {
        House.refTemp = refTemp;
    }
    public static double GetRefTemp () {
        return House.refTemp;
    }
    
    public static void SetRefTime (long refTime) {
        House.refTime = refTime;
    }
    public static long GetRefTime () {
        return House.refTime;
    }
    
    public static void AddRoom (Room r) {
        ROOMS.add(r);
    }
    
    public static void Observe (String deviceID, long time, double temp) {
        for(Room r: ROOMS) {
            if(deviceID.equals(r.GetDeviceID())) {
                r.AddObs(time, temp);
                break;
            }
        }
    }
    
    public static void ObserveH (String deviceID, long time, double h) {
        for(Room r: ROOMS) {
            if(deviceID.equals(r.GetDeviceID())) {
                r.AddObsH(time, h);
                break;
            }
        }
    }
    
    public static void List (String name, long start, long stop) {
        for(Room r: ROOMS) {
            if(name.equals(r.GetName())) {
                r.ListRoom(start, stop);
                break;
            }
        }
    }
    
    public static void Temperature (double newTemp) {
        House.SetRefTemp(newTemp);
    }
    
    public static void SetArea () {
        area = 0;
        for(Room r: ROOMS) {
            area += r.GetArea();
        }
    }
    
    public static boolean Trigger () {
        double sum = 0;
        for(Room r: ROOMS) {
            sum += r.GetMin() * r.GetArea();
        }
        //System.out.println(sum);
        sum /= area;
        //System.out.println(area);
        //System.out.println(sum);
        if(!Tema2.bonus)
            return sum <= refTemp;
        else {
            double sumH = 0;
            for(Room r : ROOMS) {
                sumH += r.GetMinH() * r.GetArea();
            }
            sumH /= area;
            if(sumH <= refH)
                return sum <= refTemp;
            else
                return false;
        }
    }
}