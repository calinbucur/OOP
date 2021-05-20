
/**
 * The parent class of all passengers
 * Single, Group and Family inherit it
 * @author Calin
 */
public abstract class Passenger {
    /**
     * All passengers have a priority and an id
     */
    public int prio;
    public String id;
    /**
     * Abstract method for calculating priorities
     */
    public abstract void ComputePrio();
}
