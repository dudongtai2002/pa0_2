/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa0_2;
import java.util.*;
/**
 *
 * @author dudongtai
 */
public class Server {
    double Rate=1;
    long time;
    ArrayList<LinkedList<Packet>> queue=new ArrayList <>();
    ArrayList<Event> timeline=new ArrayList<> ();
    int total_packet;
    long total_bits;
    long total_delay;
    public Server(){
        time=0;
        for(int i=0;i<11;i++){
            LinkedList<Packet> a=new LinkedList<>();
            queue.add(a);
            }
        total_packet=0;
        total_bits=0;
        total_delay=0;
     
    }
    //put the first 11 packet in the timeline
    public void init(){
        
    }
    
    
    
    
    
    
    
    
}
