
/**
 * The class representing the group
 * Inherits the Passenger class
 * @see Passenger
 * @author Calin
 */
public class Group extends Passenger {
    /**
     * The group is an array of Single objects
     */
    public final Single [] members;
    public int nrMembers;
    /**
     * Constructor which creates an empty group and sets the priority to 5
     * @param nr Maximum number of members
     * @param id The group id
     */
    public Group (int nr, String id) {
        members = new Single[nr];
        nrMembers = 0;
        this.id = id;
        prio = 5;
    }
    /**
     * Adds a new member to the group
     * @param member The member to be added
     */
    public void Add (Single member) {
        members[nrMembers] = member;
        nrMembers++;
    }
    /**
     * Calculates the priority of the whole group
     */
    @Override
    public void ComputePrio () {
        int i;
        for(i = 0; i < nrMembers; i++) {
            members[i].ComputePrio();
            this.prio += members[i].prio;
        }
    }
}
