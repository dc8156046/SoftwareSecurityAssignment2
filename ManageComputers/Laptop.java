import java.util.Set;
//Laptop computer: adds screen size to other Computer info

public final class Laptop {
    // White list of screen sizes
    private static final Set<Integer> VALID_SCREEN_SIZES = Set.of(13, 14);

    private final Computer computer; // Composition: Laptop has a Computer
    private final int screenSize;

    // Constructor
    public Laptop(String CPU, int RAM, int disk, int screenSize) {
        // Check if the screen size is valid
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

    public int getRAM() {
        return computer.getRAM();
    }

    public int getDisk() {
        return computer.getDisk();
    }

    public int getScreenSize() {
        return this.screenSize;
    }

    @Override
    public String toString() {
        return String.format("Type: Laptop   CPU:%-5s RAM:%-2dGB Disk:%-4dGB Screen:%d\"",
                getCPU(), getRAM(), getDisk(), screenSize);
    }
}