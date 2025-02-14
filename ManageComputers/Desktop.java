// Desktop.java

public final class Desktop {
    private final Computer computer; // Composition: Desktop has a Computer
    private final String GPUType;

    // Constructor
    public Desktop(String CPU, String RAM, String disk, String GPUType) {
        this.computer = new Computer(CPU, RAM, disk);
        if (!GPUType.equals("Nvidia") && !GPUType.equals("AMD")) {
            throw new IllegalArgumentException("Invalid GPU type!");
        }
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
        return String.format("Type: Desktop  CPU:%-5s RAM:%-3s Disk:%-4s GPU:%s",
                getCPU(), getRAM(), getDisk(), GPUType);
    }
}
