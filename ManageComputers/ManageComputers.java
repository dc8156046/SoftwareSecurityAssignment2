//Manage Computers program: maintains an ArrayList of Computer objects, 
//can be either Laptop or Desktop, but never just Computer-type objects themselves

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class ManageComputers {

    // White-list of valid CPU, RAM, Disk, GPU, Screen Size values
    private static final Set<String> VALID_CPUS = Set.of("i5", "i7");
    private static final Set<String> VALID_RAM = Set.of("16", "32");
    private static final Set<String> VALID_DISK = Set.of("512", "1024");
    private static final Set<String> VALID_GPUS = Set.of("Nvidia", "AMD");
    private static final Set<String> VALID_SCREEN_SIZES = Set.of("13", "14");

    public static void main(String args[]) {

        // This ArrayList will hold all the computers in the system. Note that the type
        // of objects expected in this
        // ArrayList are Computer, not Laptop or Desktop, but since those are subclasses
        // of Computer they can be
        // stored in an ArrayList<Computer> anyway.

        ArrayList<Object> computers = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        String menuOption = "";

        do { // Start of main program loop

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

            // Show computer data in ArrayList<Computer>
            showComputers(computers);

        } while (!menuOption.equals("x")); // Stop when "x" is entered

        s.close(); // Close keyboard scanner

    } // End of main

    // -----------------------------
    // Display menu and get user selection, return it
    private static String getMenuSelection(Scanner s) {
        String menuOption = "";
        Set<String> validOptions = Set.of("a", "d", "e", "x");

        do {
            // Display menu options on-screen
            System.out.println("----------");
            System.out.println("A) Add Computer");
            System.out.println("D) Delete Computer");
            System.out.println("E) Edit Computer");
            System.out.println("X) eXit");
            System.out.println("----------");

            // Get menu selection from keyboard
            System.out.print("Enter menu selection:");
            menuOption = s.nextLine().toLowerCase(); // Make lower case for comparison purposes;

            // Check if menu option is valid
            if (!validOptions.contains(menuOption)) {
                System.out.println("Invalid option! Please enter A, D, E, or X.");
            }
        } while (!validOptions.contains(menuOption));

        return menuOption;
    } // End of getMenuSelection

    // -----------------------------
    // Show data for all laptops and desktops stored in ArrayList<Computer> create
    // in main() method
    private static void showComputers(ArrayList<Object> computers) {
        int computerListNumber = 0; // This variable is used to hold the "list number" for each computer, starting
                                    // at 1.

        System.out.println("=========");

        System.out.println("LIST OF COMPUTERS:-");

        for (Object obj : computers) {
            // Check if object is a Laptop or Desktop
            if (obj instanceof Laptop || obj instanceof Desktop) {
                computerListNumber++; // Increment list number for each computer

                // Call overridden toString() method for current object to get and display its
                // data
                System.out.println(computerListNumber + ": " + obj.toString());
            }
        }

        System.out.println("=========");

    } // End of showComputers

    // -----------------------------
    // Add a new Laptop or Desktop computer to the ArrayList<Computer>
    private static void addComputer(ArrayList<Object> computers, Scanner s) {
        System.out.println("ADDING COMPUTER:-");

        String computerType;
        do {
            System.out.println("Enter type of computer to add ('L' for Laptop, 'D' for Desktop):");
            computerType = s.nextLine().trim().toLowerCase();

            // check if the user entered a valid computer type

            if (!computerType.equals("l") && !computerType.equals("d")) {
                System.out.println("Invalid input! Please enter 'L' or 'D'.");
            }
            // limit the type of computer to either laptop or desktop
        } while (!computerType.equals("l") && !computerType.equals("d"));

        // if the user entered a valid computer type, get the CPU, RAM and Disk info
        String[] computerData = getComputerData(s);
        String CPU = computerData[0];
        String RAM = computerData[1];
        String disk = computerData[2];

        switch (computerType) {

            // Add a laptop
            case "l":

                // Get CPU, RAM and Disk info

                String screenSize = getValidatedInput(s, VALID_SCREEN_SIZES, "Enter screen size (13 or 14): ");

                // Add new Laptop to ArrayList in main() method
                computers.add(new Laptop(CPU, RAM, disk, screenSize));

                break;

            // Add a desktop
            case "d":

                // Get CPU, RAM and Disk info

                String GPUType = getValidatedInput(s, VALID_GPUS, "Enter GPU (Nvidia or AMD): ");

                // Add new Desktop to ArrayList in main() method
                computers.add(new Desktop(CPU, RAM, disk, GPUType));
                break;

            // Invalid computer type to add entered
            // this should never happen, because the user is limited to entering either 'L'
            // or 'D'
            default:

                System.out.println("Invalid computer type entered!");

        }
    } // End of addComputer

    // -----------------------------
    // Delete a specified computer from the ArrayList
    private static void deleteComputer(ArrayList<Object> computers, Scanner s) {
        System.out.println("DELETE COMPUTER:-");

        // Check if there are any computers to delete
        if (computers.isEmpty()) {
            System.out.println("No computers available to delete.");
            return;
        }

        int computerListNumberToDelete = -1;
        boolean validInput = false;

        do {
            System.out.print("Enter number of computer to delete:");
            String input = s.nextLine().trim();

            try {
                computerListNumberToDelete = Integer.parseInt(input) - 1;

                // Check if computer list number is valid before deleting computer from list
                // the initial version provided by the instructor had a bug here, it was
                // computerListNumberToDelete<=computers.size() before, it would cause a
                // particular crashing bug
                if (computerListNumberToDelete >= 0 && computerListNumberToDelete < computers.size()) {
                    // Subtract 1 to get ArrayList index from on-screen list number to create
                    // correct index in ArrayList to delete
                    validInput = true;
                } else {
                    System.out.println("Invalid computer number entered!");
                }
                // catch exception if the user enters a non-integer value
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        } while (!validInput);

        computers.remove(computerListNumberToDelete);
        System.out.println("Computer successfully deleted.");
    } // End of deleteComputer

    // -----------------------------
    // Edit a computer. Since Laptop and Desktop are mutable classses/object get new
    // data values and replace old
    // attribute values in object being edited using object setter methods
    private static void editComputer(ArrayList<Object> computers, Scanner s) {
        System.out.println("EDIT COMPUTER:-");

        System.out.print("Enter number of computer to edit:");
        try {
            int computerListNumberToEdit = Integer.parseInt(s.nextLine()) - 1;

            // Check that computerListNumberToEdit is valid first
            // the initial version had the same bug as the deleteComputer method, it was
            // computerListNumberToEdit<=computers.size() before, it would cause a
            // particular crashing bug
            if (computerListNumberToEdit >= 0 && computerListNumberToEdit < computers.size()) {
                Object selectedComputer = computers.get(computerListNumberToEdit);
                Object newComputer = null;

                String[] computerData = getComputerData(s);
                String CPU = computerData[0];
                String RAM = computerData[1];
                String disk = computerData[2];

                // Determine the type of computer
                if (selectedComputer instanceof Laptop) {
                    String screenSize = getValidatedInput(s, VALID_SCREEN_SIZES, "Enter screen size (13 or 14): ");
                    newComputer = new Laptop(CPU, RAM, disk,
                            screenSize);
                } else if (selectedComputer instanceof Desktop) {
                    String GPUType = getValidatedInput(s, VALID_GPUS, "Enter GPU (Nvidia or AMD): ");
                    newComputer = new Desktop(CPU, RAM, disk, GPUType);
                }

                // Replace old computer object with new one
                // checking if the newComputer object is null seems unnecessary, since it is
                // always assigned a value

                computers.set(computerListNumberToEdit, newComputer);
            } else {

                System.out.println("Invalid computer number entered!");
            }
            // check if the user entered a non-integer value
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid number.");
        }

    } // End of editComputer

    // Helper method to get data common to Laptop and Desktop (CPU, RAM and disk)
    // objects. Returns a Computer-type object
    // holding these values as attribues
    private static String[] getComputerData(Scanner s) {

        String CPU = getValidatedInput(s, VALID_CPUS, "Enter CPU (i5 or i7): ");
        String RAM = getValidatedInput(s, VALID_RAM, "Enter RAM (16 or 32): ");
        String disk = getValidatedInput(s, VALID_DISK, "Enter Disk (512 or 1024): ");

        return new String[] { CPU, RAM, disk };

    } // End of getComputerData

    // Helper method to get validated input
    // compare user input to a set of valid values
    private static String getValidatedInput(Scanner s, Set<String> validValues, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = s.nextLine().trim();
            if (validValues.contains(input)) {
                return input;
            }
            // Display valid values if input is invalid
            System.out.println("Invalid input! Please enter a valid value: " + validValues);

            // infinite loop until valid input is entered
        } while (true);
    }// End of getValidatedInput

} // End of ManageComputer class
