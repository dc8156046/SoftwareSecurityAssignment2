//Laptop computer: adds screen size to other Computer info

public class Laptop { //Laptop 
    Computer computer = null; //Composition: Laptop has a Computer
    String screenSize = null;

    //Constructors
    public Laptop() {
        
    } //No-arg constructor

    public Laptop(String CPU, String RAM, String disk, String screenSize) {
        //Call Computer constructor
        this.computer = new Computer(CPU, RAM, disk);
        
        this.screenSize=screenSize;
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

    public String getScreenSize() {
        return this.screenSize;
    }

    //Return formatted version of data
    public String toString() {
        return "Type:Laptop\tCPU:" + getCPU() + 
               "\tRAM:" + getRAM() + 
               "\tDisk:" + getDisk() + 
               "\tScreen:" + screenSize;
    }
    
}