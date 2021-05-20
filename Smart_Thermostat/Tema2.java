
//package tema2;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.PrintWriter;

public class Tema2 {
    public static PrintWriter out;
    public static boolean bonus = true;
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String command;
        Scanner s = new Scanner(new File("therm.in"));
        out = new PrintWriter(new FileWriter("therm.out"));
        House.SetRoomNr(s.nextInt());
        House.SetRefTemp(Double.parseDouble(s.next().replaceAll(",", ".")));
        String [] a = s.nextLine().split(" ");
        if(a.length == 2)
            House.SetRefTime(Long.parseLong(a[1]));
        else {
            House.SetRefH(Double.parseDouble(a[1]));
            House.SetRefTime(Long.parseLong(a[2]));
            bonus = true;
        }
        ArrayList<Integer> bla = new ArrayList();
        for(int i = 0; i < House.GetRoomNr(); i++) {
            House.AddRoom(new Room(s.next(), House.GetRefTime(), s.next(), s.nextInt()));
        }
        House.SetArea();
        while(s.hasNext()) {
            command = s.next();
            if(command.equals("OBSERVE")) {
                House.Observe(s.next(), s.nextLong(), Double.parseDouble(s.next().replaceAll(",", ".")));
            }
            if(command.equals("OBSERVEH")) {
                House.ObserveH(s.next(), s.nextLong(), Double.parseDouble(s.next().replaceAll(",", ".")));
            }
            if(command.equals("LIST")) {
                House.List(s.next(), s.nextLong(), s.nextLong());
                if(s.hasNext())
                    out.print("\n");
            }
            if(command.equals("TEMPERATURE")) {
                House.Temperature(Double.parseDouble(s.next().replaceAll(",", ".")));
            }
            if(command.equals("TRIGGER")) {
                s.next();
                if(House.Trigger())
                    out.print("YES");
                else
                    out.print("NO");
                if(s.hasNext())
                    out.print("\n");
            }
        }
        out.close();
    }
}
