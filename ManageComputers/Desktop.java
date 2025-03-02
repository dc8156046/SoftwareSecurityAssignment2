// Desktop.java

import java.util.Set;

//final modifier means that the class cannot be extended
public final class Desktop {
    // White list of valid GPU values
    //set is an unmodifiable collection of unique elements

    private static final Set<String> VALID_GPUS = Set.of("Nvidia", "AMD");

    private final Computer computer; // Composition: Desktop has a Computer
    private final String GPUType;

    // Constructors
    public Desktop(String CPU, String RAM, String disk, String GPUType) {
        // Check if GPUType is valid
        if (!VALID_GPUS.contains(GPUType)) {
            throw new IllegalArgumentException("Invalid GPU type: " + GPUType + ". Allowed values: " + VALID_GPUS);
        }
        //if GPUType is valid, create a new Computer object
        this.computer = new Computer(CPU, RAM, disk);
        this.GPUType = GPUType;
    }

    // Getters
    public String getGPUType() {
        return GPUType;
    }

    public String getRAM() {
        return computer.getRAM();
    }

    public String getDisk() {
        return computer.getDisk();
    }

    public String getCPU() {
        return computer.getCPU();
    }

    @Override
    public String toString() {
        //cpu:%-5s means left-justified, 5 characters wide
        //ram:%-3s means left-justified, 3 characters wide
        //disk:%-4s means left-justified, 4 characters wide
        //gpu:%s means right-justified, no width specified
        return String.format("Type: Desktop  CPU:%-5s RAM:%-3s Disk:%-4s GPU:%s",
                getCPU(), getRAM(), getDisk(), GPUType);
    }
}
