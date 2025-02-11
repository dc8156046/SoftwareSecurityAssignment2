//Computer class: manages computer CPU, RAM and Disk information

import java.util.Set;

public class Computer {
    // White list of CPU, RAM and Disk
    private static final Set<String> VALID_CPUS = Set.of("i5", "i7");
    private static final Set<Integer> VALID_RAM = Set.of(16, 32);
    private static final Set<Integer> VALID_DISK = Set.of(512, 1024);

    private final String CPU; // CPU, RAM and Disk are final as they should not be changed once set
    private final int RAM;
    private final int disk;

    // Constructors

    public Computer(String CPU, int RAM, int disk) {
        // Check if the CPU, RAM and Disk are valid
        if (!VALID_CPUS.contains(CPU)) {
            throw new IllegalArgumentException("Invalid CPU type: " + CPU + ". Allowed values: " + VALID_CPUS);
        }
        if (!VALID_RAM.contains(RAM)) {
            throw new IllegalArgumentException("Invalid RAM size: " + RAM + ". Allowed values: " + VALID_RAM);
        }
        if (!VALID_DISK.contains(disk)) {
            throw new IllegalArgumentException("Invalid Disk size: " + disk + ". Allowed values: " + VALID_DISK);
        }

        this.CPU = CPU;
        this.RAM = RAM;
        this.disk = disk;
    }

    // Getters
    public String getCPU() {
        return this.CPU;
    }

    public int getRAM() {
        return this.RAM;
    }

    public int getDisk() {
        return this.disk;
    }

}