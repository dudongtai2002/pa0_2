/*
This is the basic packet class
 */
package pa0_2;
import java.util.*;
import java.security.*;
/**
 * @author dudongtai
 */
public class Packet {
    public int size;
    public int source_id;
    long arrive_time;
    String type;
    //constructor for packet, use specific source.
    public Packet(){
        this.size=exp_rand(512);
    }
    
    
    public Packet(Source source){
        
        
        
        
        
        
        
        
        
    }
    public int exp_rand(int mean){
        
        int a=0;
        while(a==0){
        Random gen=new Random(System.nanoTime());
        double r=gen.nextDouble();
        a=(int)((-1)*(Math.log(r))*mean);
        }
        System.out.println(a);
        return a;
        
    }
    
    
    
}


