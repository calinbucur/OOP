/**
 * TEMA 1
 * BUCUR CALIN-ANDREI
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
/**
 * This is the main class which will solve the homework
 * It's abstract because it just runs the homework
 * I don't need or want it to ever be instanced
 * @author Calin
 */
public abstract class PriorityQueue {
    /**
     * This main class has the following attributes
     * h is the heap through which the priority queue is represented
     * p is an array holding passengers before they are inserted in the queue
     * nr is the number of inputs
     * members is the number of members that have been read
     * (a family/group is considered one member)
     * in is the file from which the inputs are read
     * s is the scanner which will read the input
     */
    public static Heap h;
    public static Passenger[] p;
    public static int nr;
    public static int members = 0;
    public static File in = new File("queue.in");
    public static Scanner s;
    /**
     * This method reads all the passengers and places them in the p array
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static void ReadMembers () throws FileNotFoundException, IOException{
        int i, k;
        /**
         * Initializing the scanner, the heap and the array
         */
        s = new Scanner(in);
        nr = s.nextInt();
        h = new Heap(nr);
        p = new Passenger[nr];
        String id;
        /**
         * Reads nr lines of input
         */
        for (i = 0; i < nr; i++) {
            id = s.next();
            /**
             * Identifies what type of passenger has been read
             * and adds it accordingly
             */
            if(id.contains("s")) {
                p[members] = new Single(id, s.next(), s.nextInt(), s.next(),
                 s.nextBoolean(), s.nextBoolean());
                members++;
                }
            /**
             * For families and groups
             * It checks if that family already exists and adds the passenger
             * If not, it creates the family/group
             */
            if(id.contains("g")) {
                Single g = new Single(id, s.next(), s.nextInt(), s.next(),
                  s.nextBoolean(), s.nextBoolean());
                for(k = 0; k < members; k++) {
                    if(id.equals(p[k].id)) {
                        ((Group)p[k]).Add(g);
                        break;
                    }
                }
                if(k == members) {
                    p[members] = new Group(nr, id);
                    ((Group)p[members]).Add(g);
                    members++;
                }
            }
            if(id.contains("f")) {
                Single f = new Single(id, s.next(), s.nextInt(), s.next(),
                 s.nextBoolean(), s.nextBoolean());
                for(k = 0; k < members; k++) {
                    if(id.equals(p[k].id)) {
                        ((Family)p[k]).Add(f);
                        break;
                    }
                }
                if(k == members) {
                    p[members] = new Family(nr, id);
                    ((Family)p[members]).Add(f);
                    members++;
                }
            }
        }
    }
    /**
     * This method is reading the rest of the lines in the input
     * and performing the requested operations
     * @throws IOException 
     */
    public static void Solve () throws IOException {
        String id;
        int i;
        while(s.hasNextLine()) {
            try {
                id = s.next();
                if(id.equals("insert")) {
                    id = s.next();
                    for(i = 0; i < members; i++) {
                        if(id.equals(p[i].id)) {
                            p[i].ComputePrio();
                            h.Insert(p[i], p[i].prio);
                            break;
                        }
                    }
                }
                if(id.equals("embark")) {
                    h.Embark();
                }
                if(id.equals("list")) {
                    h.List();
                    if(s.hasNext())
                        h.w.append('\n');
                }
                if(id.equals("delete")) {
                    id = s.nextLine();
                    if(id.length() == 3) {
                        id = id.strip();
                        if(id.contains("s")) {
                            h.delete(new Single(id, ""));
                        }
                        if(id.contains("g")||id.contains("f")) {
                            h.delete(new Group(0,id));
                        }
                    }
                    else {
                        String[] tok = id.split(" ");
                        h.delete(new Single(tok[1], tok[2]));
                    }
                }
            }
            catch (NoSuchElementException ex) {
                break;
            }
        }
        h.w.close();
    }
    /**
     * The main method is simply split into the previous 2 methods
     * @see ReadMembers
     * @see Solve
     * @param args
     * @throws IOException 
     */
    public static void main (String args[]) throws IOException {
        ReadMembers();
        Solve();
    }
}