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

public class Itinerary {

    private TripStopNode head;
    private TripStopNode tail;
    private TripStopNode cursor;
    private int totalCount = 0;
    private int sumDistance = 0;
    
    /**
     * Initializes an empty itinerary
     */
    public Itinerary() {
        head = null;
        tail = null;
        cursor = null;
    }
    /**
     * Count the total number of TripStopNodes in the Itinerary
     * @return 
     * the total number of TripStopNodes in the Itinerary
     */
    public int getStopCount() {
        return totalCount;
    }
    /**
     * Count the sum of distances over all TripStopNodes
     * @return 
     * the sum of distances over all TripStopNodes
     */
    public int getTotalDistance() {
        return sumDistance;
    }
    /**
     * Get a reference to the TripStop wrapped by the TripStopNode that cursor points to
     * @return TripStop object
     * a reference to the TripStop wrapped by the TripStopNode that cursor points to
     * If cursor is null, this returns null
     */
    public TripStop getCursorStop() {
        if (cursor == null) {
            return null;
        } else {
            return cursor.getData();
        }
    }
    /**
     * Reset the cursor to the start of the list
     * @Postconditions:
     * If head is not null, the cursor now references the first TripStopNode in this list
     * If head is null, the cursor is set to null as well (there are no TripStop objects in this list)
     */
    public void resetCursorToHead() {
        if (head == null) {
            cursor = null;
        } else {
            cursor = head;
        }
    }
    /**
     * Moves the cursor to select the next TripStopNode in this list
     * @throws EndOfItineraryException 
     * Thrown if cursor is at the tail of the list
     */
    public void cursorForward() throws EndOfItineraryException {
        if (cursor == tail) {
            throw new EndOfItineraryException();
        } else {
            cursor = cursor.getNext();
        }
    }
    /**
     * Moves the cursor to select the previous TripStopNode in this list
     * @throws EndOfItineraryException 
     * Thrown if cursor is at the head of the list
     */
    public void cursorBackward() throws EndOfItineraryException {
        if (cursor == head) {
            throw new EndOfItineraryException();
        } else {
            cursor = cursor.getPrev();
        }
    }
    /**
     * Inserts the indicated TripStop before the cursor
     * @param newStop
     * The TripStop object to be wrapped and inserted into the list before the cursor
     * @Preconditions:
     * newStop is not null
     * @Postconditions:
     * newStop has been wrapped in a new TripStopNode object
     * If cursor was previously not null, the newly created TripStopNode has been inserted into the list before the cursor
     * If cursor was previously null, the newly created TripStopNode has been set as the new head of the list (as well as the tail)
     * The cursor now references the newly created TripStopNode
     * @throws IllegalArgumentException 
     * Thrown if newStop is null
     */
    public void insertBeforeCursor(TripStop newStop) throws IllegalArgumentException {
        if (newStop == null) {
            throw new IllegalArgumentException();
        } else if (cursor == null) {
            TripStopNode tsn = new TripStopNode(newStop);
            head = tsn;
            tail = tsn;
            cursor = tsn;
        } else if (cursor.getPrev() == null) {
            TripStopNode tsn = new TripStopNode(newStop);
            cursor.setPrev(tsn);
            head = head.getPrev();
            // TripStopNode temp = cursor;
            head.setNext(cursor); // how can I do?
            cursor = tsn;
        } else {
            TripStopNode tsn = new TripStopNode(newStop);
            cursor.getPrev().setNext(tsn);
            cursor.getPrev().getNext().setPrev(cursor.getPrev());
            cursor.setPrev(tsn);
            cursor.getPrev().setNext(cursor);
            cursor = cursor.getPrev();
        }
        totalCount++;
        sumDistance += cursor.getData().getDistance();
    }
    /**
     * Inserts the indicated TripStop after the tail of the list
     * @param newStop
     * The TripStop object to be wrapped and inserted into the list after the tail of the list
     * @Preconditions:
     * newStop is not null
     * @Postconditions:
     * newStop has been wrapped in a new TripStopNode object
     * If tail was previously not null, the newly created TripStopNode has been inserted into the list after the tail
     * If tail was previously null, the newly created TripStopNode has been set as the new head of the list (as well as the tail)
     * The tail now references the newly created TripStopNode
     * @throws IllegalArgumentException 
     * Thrown if newStop is null
     */
    public void appendToTail(TripStop newStop) throws IllegalArgumentException {
        if (newStop == null) {
            throw new IllegalArgumentException();
        } else if (tail == null) {
            TripStopNode tsn = new TripStopNode(newStop);
            head = tsn;
            tail = tsn;
            cursor = tsn;
        } else {
            TripStopNode tsn1 = new TripStopNode(newStop);
            tail.setNext(tsn1);
            tail.getNext().setPrev(tail);
            tail = tail.getNext();
        }
        totalCount++;
        sumDistance += tail.getData().getDistance();
    }
    /**
     * Removes the TripStopNode referenced by cursor and returns the TripStop inside
     * @return TripStop object
     * The TripStop that was removed
     * @Preconditions:
     * cursor != null
     * @Postconditons:
     * The TripStopNode referenced by cursor has been removed from the list
     * All other TripStopNodes in the list exist in the same order as before
     * The cursor now references the next TripStopNode
     * Exceptions: If the cursor was originally the tail, the cursor will now reference the current tail
     * @throws EndOfListException 
     * EndOfListException if cursor is null
     */
    public TripStop removeCursor() throws EndOfListException {
        if (cursor == null) {
            throw new EndOfListException();
        }
        TripStop ts = cursor.getData();
        if (cursor == head) {
            sumDistance -= head.getData().getDistance();
            head = head.getNext();
            cursor = head;
        } else if (cursor == tail) {
            sumDistance += tail.getData().getDistance();
            tail = tail.getPrev();
            cursor = tail;
        } else {
            sumDistance -= cursor.getData().getDistance();
            cursor.getPrev().setNext(cursor.getNext());
            cursor.getNext().setPrev(cursor.getPrev());
            cursor = cursor.getPrev();
        }
        totalCount--;
        return ts;
    }

}
