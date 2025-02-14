//Manage Computers program: maintains an ArrayList of Computer objects, 
//can be either Laptop or Desktop, but never just Computer-type objects themselves

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class ManageComputers {

    private static final Set<String> VALID_GPUS = Set.of("Nvidia", "AMD");
    private static final Set<String> VALID_SCREEN_SIZES = Set.of("13", "14");

    // Helper method to get validated input
    private static String getValidatedInput(Scanner s, Set<String> validValues, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = s.nextLine().trim();
            if (validValues.contains(input)) {
                return input;
            }
            System.out.println("Invalid input! Please enter a valid value: " + validValues);
        } while (true);
    }

    public static void main(String args[]) {

        // This ArrayList will hold all the computers in the system. Note that the type
        // of objects expected in this
        // ArrayList are Computer, not Laptop or Desktop, but since those are subclasses
        // of Computer they can be
        // stored in an ArrayList<Computer> anyway.
        ArrayList<Computer> computers = new ArrayList<>();

        Scanner s = new Scanner(System.in);
        String menuOption = "";

        do { // Start of main program loop

            // Show computer data in ArrayList<Computer>
            showComputers(computers);

            // Display menu and return menu option selected by the user
            menuOption = getMenuSelection(s);

            switch (menuOption) {
                // Add new computer
                case "a":

                    addComputer(computers, s);

                    break;

                // Delete a computer
                case "d":

                    deleteComputer(computers, s);

                    break;

                // Edit a computer
                case "e":

                    editComputer(computers, s);

                    break;

            }

        } while (!menuOption.equals("x")); // Stop when "x" is entered

        s.close(); // Close keyboard scanner

    } // End of main

    // -----------------------------
    // Display menu and get user selection, return it
    private static String getMenuSelection(Scanner s) {

        // Display menu options on-screen
        System.out.println("----------");
        System.out.println("A) Add Computer");
        System.out.println("D) Delete Computer");
        System.out.println("E) Edit Computer");
        System.out.println("X) eXit");
        System.out.println("----------");

        return s.nextLine().toLowerCase();
    } // End of getMenuSelection

    // -----------------------------
    // Show data for all laptops and desktops stored in ArrayList<Computer> create
    // in main() method
    private static void showComputers(ArrayList<Computer> computers) {
        int computerListNumber = 0; // This variable is used to hold the "list number" for each computer, starting
                                    // at 1.

        System.out.println("=========");

        System.out.println("LIST OF COMPUTERS:-");

        for (Computer c : computers) {

            computerListNumber++; // Increment list number for each computer

            // Call overridden toString() method for current object to get and display its
            // data
            System.out.println(computerListNumber + ": " + c.toString());
        }

        System.out.println("=========");

    } // End of showComputers

    // -----------------------------
    // Add a new Laptop or Desktop computer to the ArrayList<Computer>
    private static void addComputer(ArrayList<Computer> computers, Scanner s) {
    	String computerType = getValidatedInput(s, Set.of("l", "d"), "Enter type of computer to add ('L' for Laptop, 'D' for Desktop): ");
        
        String CPU = getValidatedInput(s, Set.of("i5", "i7"), "Enter CPU (i5 or i7): ");
        String RAM = getValidatedInput(s, Set.of("16", "32"), "Enter RAM (16 or 32): ");
        String disk = getValidatedInput(s, Set.of("512", "1024"), "Enter Disk (512 or 1024): ");

        System.out.println("ADDING COMPUTER:-");

        switch (computerType) {

            // Add a laptop
            case "l":

                // Get CPU, RAM and Disk info
                String screenSize = getValidatedInput(s, Set.of("13", "14"), "Enter screen size (13 or 14): ");

                // Add new Laptop to ArrayList in main() method
                computers.add(new Laptop(CPU, RAM, disk, screenSize));

                break;

            // Add a desktop
            case "d":

                // Get CPU, RAM and Disk info
  
                String GPUType = getValidatedInput(s, Set.of("Nvidia", "AMD"), "Enter GPU (Nvidia or AMD): ");

                // Add new Desktop to ArrayList in main() method
                computers.add(
                        new Desktop(CPU, RAM, disk, GPUType));

                break;

            // Invalid computer type to add entered
            default:

                System.out.println("Invalid computer type entered!");

        }
    } // End of addComputer

    // -----------------------------
    // Delete a specified computer from the ArrayList
    private static void deleteComputer(ArrayList<Computer> computers, Scanner s) {

        System.out.println("DELETE COMPUTER:-");

        System.out.print("Enter number of computer to delete:");
        int computerListNumberToDelete = Integer.parseInt(s.nextLine()) - 1;

        // Check if computer list number is valid before deleting computer from list
        if (computerListNumberToDelete >= 0 && computerListNumberToDelete < computers.size()) {
            // Subtract 1 to get ArrayList index from on-screen list number to create
            // correct index in ArrayList to delete
            computers.remove(computerListNumberToDelete);
        } else {
            System.out.println("Invalid computer number entered!");
        }

    } // End of deleteComputer

    // -----------------------------
    // Edit a computer. Since Laptop and Desktop are mutable classses/object get new
    // data values and replace old
    // attribute values in object being edited using object setter methods
    private static void editComputer(ArrayList<Computer> computers, Scanner s) {

        System.out.println("EDIT COMPUTER:-");

        System.out.print("Enter number of computer to edit:");
        int computerListNumberToEdit = Integer.parseInt(s.nextLine()) - 1;

        // Check that computerListNumberToEdit is valid first
        if (computerListNumberToEdit >= 0 && computerListNumberToEdit < computers.size()) {
            Computer editedComputer = computers.get(computerListNumberToEdit);


            // Determine exact type of computer being edited
            // Subtract 1 to get ArrayList index from on-screen list number
            if (editedComputer instanceof Laptop) {
                String screenSize = getValidatedInput(s, VALID_SCREEN_SIZES, "Enter screen size (13 or 14): ");
                computers.set(computerListNumberToEdit, new Laptop(editedComputer.getCPU(), editedComputer.getRAM(), editedComputer.getDisk(), screenSize));
            }
            // Subtract 1 to get ArrayList index from on-screen list number
            else if (editedComputer instanceof Desktop) {
                String GPUType = getValidatedInput(s, VALID_GPUS, "Enter GPU (Nvidia or AMD): ");
                computers.set(computerListNumberToEdit, new Desktop(editedComputer.getCPU(), editedComputer.getRAM(), editedComputer.getDisk(), GPUType));
            }

        } else {
            System.out.println("Invalid computer number entered!");
        }

    } // End of editComputer

} // End of ManageComputer class
