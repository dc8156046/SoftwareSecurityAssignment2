import java.util.Set;
//Desktop computer: adds GPU type

public final class Desktop {
    // White list of GPU types
    private static final Set<String> VALID_GPUS = Set.of("NVIDIA", "AMD");

    private final Computer computer; // Composition: Desktop has a Computer
    private final String GPUType;

    // Constructors

    public Desktop(String CPU, int RAM, int disk, String GPUType) {
        // Check if the GPU type is valid
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

    public int getRAM() {
        return computer.getRAM();
    }

    public int getDisk() {
        return computer.getDisk();
    }

    public String getGPUType() {
        return this.GPUType;
    }

    @Override
    public String toString() {
        return String.format("Type: Desktop  CPU:%-5s RAM:%-2dGB Disk:%-4dGB GPU:%s",
                getCPU(), getRAM(), getDisk(), GPUType);
    }

}