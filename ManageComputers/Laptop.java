//Laptop computer: adds screen size to other Computer info

public final class Laptop {
    private final Computer computer; // Composition: Laptop has a Computer
    private final String screenSize;

    // Constructor
    public Laptop(String CPU, String RAM, String disk, String screenSize) {
        this.computer = new Computer(CPU, RAM, disk);
        if (!screenSize.equals("13") && !screenSize.equals("14")) {
            throw new IllegalArgumentException("Invalid screen size!");
        }
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
    public String toString() {
        return String.format("Type: Laptop   CPU:%-5s RAM:%-3s Disk:%-4s Screen:%s",
                getCPU(), getRAM(), getDisk(), screenSize);
    }
}
