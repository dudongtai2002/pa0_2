/*
This is the basic packet class
 */
package pa0_2;
import java.util.*;

/**
 * @author dudongtai
 */
public class Packet {
    public int size;
    public int source_id;
    long arrive_time;
    
    //constructor for packet, for bootstrap use.
    public Packet(Source source){
        this.source_id=source.id;
        this.size=exp_rand(source.packet_size);
        this.arrive_time=0;      
        }
    
    
    
    //constructor for packet, use specific source and time;
   
    public Packet(Source source,long time){
        this.source_id=source.id;
        this.size=exp_rand(source.packet_size);
        this.arrive_time=time+(long)(size/source.rate);        
        }
 
  
    public int exp_rand(int mean){
        
        int a=0;
        while(a==0){
        Random gen=new Random(System.nanoTime());
        double r=gen.nextDouble();
        a=(int)((-1)*(Math.log(r))*mean);
        }
        
        return a;
        
    }
    
    
    
}


