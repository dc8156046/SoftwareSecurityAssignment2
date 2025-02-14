//Computer class: manages computer CPU, RAM and Disk information

import java.util.Set;

public final class Computer {

    private final String CPU; // CPU, RAM and Disk are final as they should not be changed once set
    private final String RAM;
    private final String disk;

    // Constructors

    public Computer(String CPU, String RAM, String disk) {
        if (!isValidCPU(CPU) || !isValidRAM(RAM) || !isValidDisk(disk)) {
            throw new IllegalArgumentException("Invalid parameters!");
        }
        this.CPU = CPU;
        this.RAM = RAM;
        this.disk = disk;
    }

    // Getters
    public String getCPU() {
        return CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public String getDisk() {
        return disk;
    }
    
    // Whitelist validation methods for each attribute
    private boolean isValidCPU(String CPU) {
        return CPU.equals("i5") || CPU.equals("i7");
    }

    private boolean isValidRAM(String RAM) {
        return RAM.equals("16") || RAM.equals("32");
    }

    private boolean isValidDisk(String disk) {
        return disk.equals("512") || disk.equals("1024");
    }

    @Override
    public String toString() {
        return "CPU: " + CPU + ", RAM: " + RAM + ", Disk: " + disk;
    }
}
