//Computer class: manages computer CPU, RAM and Disk information

public class Computer {

    private final String CPU; // CPU, RAM and Disk are final as they should not be changed once set
    private final String RAM;
    private final String disk;

    // Constructors

    public Computer(String CPU, String RAM, String disk) {
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