//Desktop computer: adds GPU type

public class Desktop {
    Computer computer=null; //Composition: Desktop has a Computer
    String GPUType=null;

    //Constructors
    public Desktop() {
        
    } //No-arg constructor

    public Desktop(String CPU, String RAM, String disk, String GPUType) {
        //Call Computer constructor
        this.computer = new Computer(CPU, RAM, disk);

        //Only in Desktop subclass
        this.GPUType=GPUType;
    }
    
    //Getter
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

    //Return formatted version of data
    public String toString() {
        return "Type:Desktop\tCPU:" + getCPU() + 
               "\tRAM:" + getRAM() + 
               "\tDisk:" + getDisk() + 
               "\tGPU:" + GPUType;
    }

}