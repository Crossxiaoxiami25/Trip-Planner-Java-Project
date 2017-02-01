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

import java.util.Scanner;

public class TripPlanner {

    public static void main(String[] args) {
        Itinerary iFirst = new Itinerary();
        Itinerary iSecond = new Itinerary();
        Scanner input = new Scanner(System.in);
        String inputChoise = "";
        String location, activity;
        int distance;
        boolean excptionIsPassed1, excptionIsPassed2;
        System.out.println("Welcome to TripPlanner!" + "\n" + "\n" + "Menu:");
        System.out.println("F-Cursor forward");
        System.out.println("B-Cursor backward");
        System.out.println("I-Insert before cursor");
        System.out.println("A-Append to tail");
        System.out.println("D-Delete and move cursor forward");
        System.out.println("H-Cursor to Head");
        System.out.println("T-Cursor to Tail");
        System.out.println("E-Edit cursor");
        System.out.println("S-Switch itinerary");
        System.out.println("O-Insert cursor from other itinerary after cursor from this itinerary");
        System.out.println("R-Replace this itinerary with a copy of the other itinerary");
        System.out.println("P-Print current itinerary, including summary");
        System.out.println("C-Clear current itinerary");
        System.out.println("Q-Quit");
        System.out.print("Choose an action:");
        inputChoise = input.nextLine();

        while (!inputChoise.equalsIgnoreCase("Q")) {
            excptionIsPassed1 = false;
            excptionIsPassed2 = false;
            if (inputChoise.equalsIgnoreCase("F")) {
                try {
                    iFirst.cursorForward();
                    System.out.println("Cursor moved forward.");
                } catch (EndOfItineraryException e) {
                    System.out.println("Cursor already at end of list.");
                }
            } else if (inputChoise.equalsIgnoreCase("B")) {
                try {
                    iFirst.cursorBackward();
                    System.out.println("Cursor moved back.");
                } catch (EndOfItineraryException e) {
                    System.out.println("Cursor already at head of list.");
                }
            } else if (inputChoise.equalsIgnoreCase("I")) {
                while (!excptionIsPassed2) {
                    System.out.print("Enter Location:");
                    location = input.nextLine();
                    System.out.print("Enter Activity:");
                    activity = input.nextLine();
                    TripStop ts = new TripStop(location, activity);
                    while (!excptionIsPassed1) {
                        try {
                            System.out.print("Enter Distance:");
                            distance = input.nextInt();
                            input.nextLine();
                            ts.setDistance(distance);
                            excptionIsPassed1 = true;
                        } catch (IllegalArgumentException e) {
                            System.out.println("This distance is invalid -- distance must be >=0.Try again.");
                        }
                    }
                    try {
                        iFirst.insertBeforeCursor(ts);
                        System.out.println("\n\nAdded.");
                        excptionIsPassed2 = true;
                    } catch (IllegalArgumentException e) {
                        System.out.println("New stop must exist.");
                    }
                }
            } else if (inputChoise.equalsIgnoreCase("A")) {
                while (!excptionIsPassed2) {
                    System.out.print("Enter Location:");
                    location = input.nextLine();
                    System.out.print("Enter Activity:");
                    activity = input.nextLine();
                    TripStop ts = new TripStop(location, activity);
                    while (!excptionIsPassed1) {
                        try {
                            System.out.print("Enter Distance:");
                            distance = input.nextInt();
                            input.nextLine();
                            ts.setDistance(distance);
                            excptionIsPassed1 = true;
                        } catch (IllegalArgumentException e) {
                            System.out.println("This distance is invalid -- distance must be >=0.Try again.");
                        }
                    }
                    try {
                        iFirst.appendToTail(ts);
                        System.out.println("\n\nAdded.");
                        excptionIsPassed2 = true;
                    } catch (IllegalArgumentException e) {
                        System.out.println("New stop must exist.");
                    }
                }
            } else if (inputChoise.equalsIgnoreCase("D")) {
                try {
                    iFirst.removeCursor();
                    System.out.println("Deleted cursor.");
                } catch (EndOfListException e) {
                    System.out.println("The list is already empty.");
                }
                try {
                    iFirst.cursorForward();
                    System.out.println("Cursor moved forward.");
                } catch (EndOfItineraryException e) {
                    System.out.println("Cursor already at end of list.");
                }
            } else if (inputChoise.equalsIgnoreCase("H")) {
                iFirst.resetCursorToHead();
                System.out.println("Cursor is seted to head.");
            } else if (inputChoise.equalsIgnoreCase("T")) {
                try {
                    iFirst.cursorForward();
                } catch (EndOfItineraryException e) {
                    System.out.println("Cursor is seted to tail.");
                }
            } else if (inputChoise.equalsIgnoreCase("E")) {
                System.out.print("Edit Location, or press enter without typing anything to keep:");
                location = input.nextLine();
                if (location.length() != 0) {
                    iFirst.getCursorStop().setLocation(location);
                }
                System.out.print("Edit Activity, or press enter without typing anything to keep:");
                activity = input.nextLine();
                if (activity.length() != 0) {
                    iFirst.getCursorStop().setActivity(activity);
                }
                while (!excptionIsPassed1) {
                    try {
                        System.out.print("Edit Distance, or press enter without typing anything to keep:");
                        String distance1 = input.nextLine();
                        if (distance1.length() != 0) {
                            int dis = Integer.parseInt(distance1);
                            iFirst.getCursorStop().setDistance(dis);
                            excptionIsPassed1 = true;
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("This distance is invalid -- distance must be >=0.Try again.");
                    }
                }
            } else if (inputChoise.equalsIgnoreCase("S")) {
                Itinerary iTemp = iFirst;
                Itinerary iTemp1 = iSecond;
                iFirst = iTemp1;
                iSecond = iTemp;
                System.out.println("Itinerary switched.");
            } else if (inputChoise.equalsIgnoreCase("O")) {
                TripStop tsTemp = new TripStop();
                tsTemp.setLocation(iSecond.getCursorStop().getLocation());
                tsTemp.setActivity(iSecond.getCursorStop().getActivity());
                tsTemp.setDistance(iSecond.getCursorStop().getDistance());
                TripStopNode temp = new TripStopNode(tsTemp);
                try {
                    iFirst.insertBeforeCursor(temp.getData());
                    System.out.println("Inserted.");
                } catch (IllegalArgumentException e) {
                    System.out.println("The list copy from is empty.");
                }
            } else if (inputChoise.equalsIgnoreCase("R")) {
                Itinerary iTemp = iSecond;
                iFirst = iTemp;
                System.out.println("Itinerary switched.");
            } else if (inputChoise.equalsIgnoreCase("P")) {
                if (iFirst.getCursorStop() == null) {
                    System.out.println("The list is empty.");
                } else {
                    int count = 0, afterCursorCount = 0;
                    TripStop temp = iFirst.getCursorStop();
                    iFirst.resetCursorToHead();
                    for (int i = 0; i < iFirst.getStopCount(); i++) {
                        if (temp == iFirst.getCursorStop()) {
                            afterCursorCount = count;
                            count = 0;
                            System.out.print(">");
                        }
                        count++;
                        System.out.println(iFirst.getCursorStop().toString());
                        try {
                            iFirst.cursorForward();
                        } catch (EndOfItineraryException e) {
                        }
                    }
                    iFirst.resetCursorToHead();
                    for (int i = 0; i < iFirst.getStopCount(); i++) {
                        if (temp == iFirst.getCursorStop()) {
                            break;
                        }
                        try {
                            iFirst.cursorForward();
                        } catch (EndOfItineraryException e) {
                        }
                    }
                    System.out.println("\n\nSummary: This trip has " + iFirst.getStopCount() + " stop,totaling "
                            + iFirst.getTotalDistance() + " miles. "
                            + "There are " + afterCursorCount + " stops before the cursor and " + --count + " stops after the cursor.");
                }
            } else if (inputChoise.equalsIgnoreCase("C")) {
                while (!excptionIsPassed2) {
                    try {
                        iFirst.removeCursor();
                    } catch (EndOfListException e) {
                        excptionIsPassed2 = true;
                        System.out.println("Itinerary Cleared.");
                    }
                }
            }
            System.out.print("Choose an action:");
            inputChoise = input.nextLine();
        }
    }
}
