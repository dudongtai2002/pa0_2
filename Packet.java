/*
This is the basic packet class
 */
package pa0_2;
import java.util.*;

/**
 * @author Dongtai Du
 */
public class Packet {
    public int size;
    public int source_id;
    long arrive_time;   // the time arrived at the server.
    long start_time;   //the time when the server starts to process it
    long transmission_time;  //time when the packet leaves server.
    //constructor for packet, for bootstrap use.
    public Packet(Source source){
        this.source_id=source.id;
        this.size=(int)exp_rand(source.packet_size);
        this.arrive_time=0;  
        
        }
    
    
    
    //constructor for packet, use specific source and time, being called in the event "arrival"
   
    public Packet(Source source,long time){
        this.source_id=source.id;
        this.size=(int)exp_rand(source.packet_size);
        this.arrive_time=time+exp_rand(source.packet_size/source.rate); 
        source.number++;
        }
 
    //function for generate exponential distributio n random number
    public static long exp_rand(double mean){
        
        long a=0;
        while(a==0){
        Random gen=new Random(System.nanoTime());
        double r=gen.nextDouble();
        a=(long)((-1)*(Math.log(r))*mean);
        }
        
        return a;
        
    }
    
    
    
}


