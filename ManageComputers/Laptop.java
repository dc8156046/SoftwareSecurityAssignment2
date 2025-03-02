//Laptop computer: adds screen size to other Computer info

import java.util.Set;
//final modifier means that the class cannot be extended

public final class Laptop {
    // White list of valid screen sizes
    //static means that the set is shared by all instances of the class
    //final means that the set cannot be changed once created
    //set is an unmodifiable collection of unique elements

    private static final Set<String> VALID_SCREEN_SIZES = Set.of("13", "14");

    private final Computer computer; // Composition: Laptop has a Computer
    private final String screenSize;

    // Constructor
    public Laptop(String CPU, String RAM, String disk, String screenSize) {
        // Check if screenSize is valid
        if (!VALID_SCREEN_SIZES.contains(screenSize)) {
            throw new IllegalArgumentException(
                    "Invalid screen size: " + screenSize + ". Allowed values: " + VALID_SCREEN_SIZES);
        }
        //if screenSize is valid, create a new Computer object
        this.computer = new Computer(CPU, RAM, disk);
        this.screenSize = screenSize;
    }

    // Getters
    public String getCPU() {
        return computer.getCPU();
    }

    public String getRAM() {
        return computer.getRAM();
    }

    public String getDisk() {
        return computer.getDisk();
    }

    public String getScreenSize() {
        return screenSize;
    }

    @Override
    //cpu:%-5s means left-justified, 5 characters wide
    //ram:%-3s means left-justified, 3 characters wide
    //disk:%-4s means left-justified, 4 characters wide
    //screen:%s means right-justified, no width specified
    public String toString() {
        return String.format("Type: Laptop   CPU:%-5s RAM:%-3s Disk:%-4s Screen:%s",
                getCPU(), getRAM(), getDisk(), screenSize);
    }
}
