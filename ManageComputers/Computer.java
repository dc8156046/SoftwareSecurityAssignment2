//Computer class: manages computer CPU, RAM and Disk information

import java.util.Set;

public class Computer {
    // White list of valid CPU, RAM and Disk values
    private static final Set<String> VALID_CPUS = Set.of("i5", "i7");
    private static final Set<String> VALID_RAM = Set.of("16", "32");
    private static final Set<String> VALID_DISK = Set.of("512", "1024");

    private final String CPU; // CPU, RAM and Disk are final as they should not be changed once set
    private final String RAM;
    private final String disk;

    // Constructors

    public Computer(String CPU, String RAM, String disk) {
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

    public String getRAM() {
        return this.RAM;
    }

    public String getDisk() {
        return this.disk;
    }

}