//Desktop computer: adds GPU type

public class Desktop {
    Computer computer; //Composition: Desktop has a Computer
    String GPUType=null;

    //Constructors
    public Desktop() {
        this.computer = new Computer();
    } //No-arg constructor

    public Desktop(String CPU, String RAM, String disk, String GPUType) {
        //Call Computer constructor
        this.computer = new Computer(CPU, RAM, disk);

        //Only in Desktop subclass
        this.GPUType=GPUType;
    }

    public void setCPU(String CPU) {
        computer.setCPU(CPU);
    }
    
    public void setRAM(String RAM) {
        computer.setRAM(RAM);
    }
    
    public void setDisk(String disk) {
        computer.setDisk(disk);
    }
    
    public String getCPU() {
        return computer.getCPU();
    }
    
    public String getRAM() {
        return computer.getRAM();
    }
    
    public String getDisk() {
        return computer.getDisk();
    }

    //Setter
    public void setGPUType(String GPUType) {
        this.GPUType=GPUType;
    }

    //Getter
    public String getGPUType() {
        return this.GPUType;
    }

    //Return formatted version of data
    public String toString() {
        return "Type:Desktop\tCPU:" + getCPU() + 
               "\tRAM:" + getRAM() + 
               "\tDisk:" + getDisk() + 
               "\tGPU:" + GPUType;
    }

}