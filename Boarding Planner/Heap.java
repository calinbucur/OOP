
import java.io.FileWriter;
import java.io.IOException;
/**
 * This is the class implementing the priority queue using a heap
 * @author Calin
 */
public class Heap {
    /**
     * Arr holds the elements of the heap
     * size is the current size of the heap
     * w is used for writing the output
     */
    private final Passenger[] arr;
    private int size;
    private final int maxsize;
    public FileWriter w;
    /**
     * Constructor which creates an empty heap and opens the output file
     * @param maxsize Maximum size of the heap
     * @throws IOException
     */
    public Heap (int maxsize) throws IOException{
        this.maxsize = maxsize;
        this.size = 0;
        arr = new Passenger[this.maxsize + 1];
        arr[0] = new Single();
        w = new FileWriter("queue.out");
    }
    /**
     * The following methods find the index of the parent or the children
     * @param pos The position of the current node
     * @return The position of the parent/child
     */
    private int Parent(int pos) {
        return pos / 2;
    }
    private int Left (int pos) {
        return 2 * pos;
    }
    private int Right (int pos) {
        return (2 * pos) + 1;
    }
    /**
     * Checks if the node at pos is a leaf
     * @param pos The position of the current Node
     * @return true/false
     */
    private boolean Leaf (int pos) {
        return pos > (size / 2) && pos <= size;
    }
    /**
     * Swaps the node with it's parent
     * @param pos The position of the current node
     */
    private void Swap (int pos) {
        Passenger aux;
        aux = arr[pos];
        arr[pos] = arr[Parent(pos)];
        arr[Parent(pos)] = aux;
    }
    /**
     * Rearranges the elements in order to maintain the heap structure
     * @param pos The position of the current node
     */
    private void Rearrange(int pos) {
        if(Leaf(pos))
            return;
        if(Right(pos) > size) {
            if(arr[pos].prio <= arr[Left(pos)].prio) {
                Swap(Left(pos));
            }
        }
        else if((arr[pos].prio < arr[Left(pos)].prio) 
              || (arr[pos].prio < arr[Right(pos)].prio)) {
                if(arr[Left(pos)].prio >= arr[Right(pos)].prio) {
                    Swap(Left(pos));
                    Rearrange(Left(pos));
                }
                else {
                    Swap(Right(pos));
                    Rearrange(Right(pos));
                }
            }
    }
    /**
     * Inserts a passenger in the priority queue according to his priority
     * @param elem The element to insert
     * @param prio Its priority
     */
    public void Insert(Passenger elem, int prio) {
        arr[++size] = elem;
        int crt = size;
        while (prio > arr[Parent(crt)].prio && crt > 1) {
            Swap(crt);
            crt = Parent(crt);
        }
    }
    /**
     * Eliminates the passenger with the highest priority and rearranges
     * @see Rearrange
     */
    public void Embark () {
        arr[1] = arr[size];
        size--;
        Rearrange(1);
    }
    /**
     * Traverses the heap in pre-order and prints the passengers 
     * @param pos The position of the current node
     * @throws IOException 
     */
    private void PreOrder (int pos) throws IOException{
        if(pos == 1)
            w.write(arr[pos].id);
        else
            w.write(" " + arr[pos].id);
        if(Leaf(pos))
           return;
        PreOrder(Left(pos));
        if(Right(pos) > size)
            return;
        PreOrder(Right(pos));
    }
    /**
     * The requested list function
     * @throws IOException 
     */
    public void List() throws IOException{
        if (size == 0)
            return;
        PreOrder(1);
    }
    /**
     * This function deletes either a non-root passenger
     * or a Single from a Group/Family
     * Checks what case we are on and either deletes the whole entity
     * or just reduces the priority and then rearranges
     * @param p The passenger we want to delete
     */
    public void delete(Passenger p) {
        int i;
        for(i = 1; i <= size; i++) {
            if(arr[i].id.equals(p.id)) {
                if (p instanceof Group) {
                    arr[i] = arr[size];
                    size--;
                    Rearrange(i);
                    break;
                }
                else if(arr[i] instanceof Single) {
                    arr[i] = arr[size];
                    size--;
                    Rearrange(i);
                    break;
                }
                else {
                    int j;
                    for (j = 0; j < ((Group)arr[i]).nrMembers; j++) {
                        if(((Group)arr[i]).members[j].name.equals
                            (((Single)p).name)) {
                            arr[i].prio -= ((Group)arr[i]).members[j].prio;
                        }
                    }
                    Rearrange(i);
                    break;
                }
            }
        }
    }
}
