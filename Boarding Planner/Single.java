
/**
 * This class represents the single passengers
 * Inherits Passenger
 * @see Passenger
 * @author Calin
 */
public class Single extends Passenger {
    /**
     * Each single person has the following attributes
     * The ticket attribute can either be 'e', 'p' or 'b'
     */
    public String name;
    private int age;
    private String ticket;
    private Boolean vip;
    private Boolean special;
    /**
     * Creates a passenger with the priority 0
     * Used in the heap constructor
     * @see Heap
     */
    public Single () {
        prio = 0;
    }
    public Single (String id, String name) {
        this.id = id;
        this.name = name;
    }
    /**
     * This constructor creates a new Single and initializes all the attributes
     * @param id 
     * @param name
     * @param age
     * @param ticket 'e', 'p' or 'b'
     * @param vip
     * @param special 
     */
    public Single (String id, String name, int age, String ticket,
            Boolean vip, Boolean special) {
        prio = 0;
        this.id = id;
        this.name = name;
        this.age = age;
        this.ticket = ticket;
        this.vip = vip;
        this.special = special;
    }
    /**
     * Method for calculating the priority by the rules
     */
    @Override
    public void ComputePrio() {
        if(age < 2)
            prio += 20;
        else
            if(age < 5)
                prio += 10;
            else
                if(age < 10)
                    prio += 5;
                else
                    if(age >= 60)
                        prio += 15;
        if(ticket.equals("b"))
            prio += 35;
        if(ticket.equals("p"))
            prio += 20;
        if(vip)
            prio += 30;
        if(special)
            prio += 100;
    }
}
