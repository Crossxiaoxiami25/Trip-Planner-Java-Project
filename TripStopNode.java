/**
 * Xia Lin
 * 110732381
 * xia.lin@stonybrook.edu
 * Assignment 1
 * CSE214-01
 * Charles Chen
 * Shilpi Bhattacharyya
 */
package homework2;

public class TripStopNode {

    private TripStop data;
    private TripStopNode next;
    private TripStopNode prev;
    
    /**
     * Default constructor
     * @param initData
     * The data to be wrapped by this TripStopNode. This parameter should not be null, since we should never have a TripStopNode with null data (remember, this class serves only as a wrapper for the TripStop class)
     * @Preconditions:
     * initData is not null
     * @Postconditions:
     * This TripStopNode has been initialized to wrap the indicated TripStop, and prev and next have been set to null
     * @throws IllegalArgumentException 
     * Thrown if initData is null
     */
    public TripStopNode(TripStop initData) throws IllegalArgumentException {
        if (initData == null) {
            throw new IllegalArgumentException();
        } else {
            data = initData;
            next = null;
            prev = null;
        }
    }
    /**
     * Get the reference to the data member variable of the list node
     * @return 
     * the reference to the data member variable of the list node
     */
    public TripStop getData() {
        return data;
    }
    /**
     * Sets the data private field to the one passed as a parameter
     * @param newData
     * newData  - Reference to a new TripStop object to update the data member variable. This parameter must not be null, since we should never have a TripStopNode with null data (remember, this class serves only as a wrapper for the TripStop class)
     * @Preconditions:
     * newData is not null
     * @throws IllegalArgumentException 
     * Thrown if newData is null
     */
    public void setData(TripStop newData) throws IllegalArgumentException {
        if (newData == null) {
            throw new IllegalArgumentException();
        } else {
            data = newData;
        }

    }
    /**
     * Get the reference to the next member variable of the list node. Can be null, means there's no next TripStopNode
     * @return 
     * the reference to the next member variable of the list node. Can be null, means there's no next TripStopNode
     */
    public TripStopNode getNext() {
        return next;
    }
    /**
     * Updates the next member variable with a new TripStopNode reference
     * @param newNext 
     * newNext - Reference to a new TripStopNode object to update the next member variable. This parameter may be null, since it is okay to have no next TripStopNode (this means webve reached the tail of the list!)
     */
    public void setNext(TripStopNode newNext) {
        next = newNext;
    }
    /**
     * Gets the reference to the prev member variable of the list node
     * @return 
     * The reference of the prev member variable. Note that this return value can be null, meaning that there is no previous TripStopNode in the list. (this means webve reached the head of the list!)
     */
    public TripStopNode getPrev() {
        return prev;
    }
    /**
     * Updates the prev member variable with a new TripStopNode reference
     * @param newPrev 
     * newPrev - Reference to a new TripStopNode object to update the prev member variable. This parameter may be null, since it is okay to have no previousTripStopNode (this means webve reached the head of the list!)
     */
    public void setPrev(TripStopNode newPrev) {
        prev = newPrev;

    }

}
