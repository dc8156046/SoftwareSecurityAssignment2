//Desktop computer: adds GPU type

import java.util.Set;

public final class Desktop {
    // White list of valid GPU values
    private static final Set<String> VALID_GPUS = Set.of("Nvidia", "AMD");

    Computer computer; // Composition: Desktop has a Computer
    String GPUType = null;

    // Constructors

    public Desktop(String CPU, String RAM, String disk, String GPUType) {
        if (!VALID_GPUS.contains(GPUType)) {
            throw new IllegalArgumentException("Invalid GPU type: " + GPUType + ". Allowed values: " + VALID_GPUS);
        }

        this.computer = new Computer(CPU, RAM, disk);
        this.GPUType = GPUType;
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

    public String getGPUType() {
        return this.GPUType;
    }

    @Override
    public String toString() {
        return String.format("Type: Desktop  CPU:%-5s RAM:%-3s Disk:%-4s GPU:%s",
                getCPU(), getRAM(), getDisk(), GPUType);
    }

}