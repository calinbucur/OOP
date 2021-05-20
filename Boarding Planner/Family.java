
/**
 * The class representing the family
 * Inherits the Group class
 * @see Group
 * @author Calin
 */
public class Family extends Group {
    public Family (int nr, String id) {
        super(nr, id);
        prio += 5;
    }
}
