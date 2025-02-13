//Laptop computer: adds screen size to other Computer info

import java.util.Set;

public final class Laptop {
    // White list of valid screen sizes
    private static final Set<String> VALID_SCREEN_SIZES = Set.of("13", "14");

    private final Computer computer; // Composition: Laptop has a Computer
    private final String screenSize;

    // Constructor
    public Laptop(String CPU, String RAM, String disk, String screenSize) {
        if (!VALID_SCREEN_SIZES.contains(screenSize)) {
            throw new IllegalArgumentException(
                    "Invalid screen size: " + screenSize + ". Allowed values: " + VALID_SCREEN_SIZES);
        }

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
        return this.screenSize;
    }

    @Override
    public String toString() {
        return String.format("Type: Laptop   CPU:%-5s RAM:%-3s Disk:%-4s Screen:%s",
                getCPU(), getRAM(), getDisk(), screenSize);
    }
}