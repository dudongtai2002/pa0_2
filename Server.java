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
    double offer_load;
    long current_time;
    ArrayList<LinkedList<Packet>> queue=new ArrayList <>();
    ArrayList<Event> timeline=new ArrayList<> ();
    int total_packet;
    long total_bits;
    long total_delay;
    ArrayList<Source> sourcelist=new ArrayList<>();
    boolean busy;
    Packet current_packet;
    public Server(double M){
        current_time=0;
        for(int i=0;i<11;i++){
            LinkedList<Packet> a=new LinkedList<>();
            queue.add(a);
            }
        total_packet=0;
        total_bits=0;
        total_delay=0;
        offer_load=M;
        //Source 0 to 3 is telnet
        for(int i=0;i<=3;i++){
            Source a=new Source("telnet",offer_load/10*Rate);
            a.id=i;
            sourcelist.add(a);
        }
        //Source 4 to 9 is ftp
        for(int i=4;i<=9;i++){
            Source a=new Source("ftp",offer_load/10*Rate);
            a.id=i;
            sourcelist.add(a);
        }
        //Source 10 is the rogue
            Source rg=new Source("rogue",Rate/2);
            sourcelist.add(rg);
        
     
    }
    //put the first 11 packet in the timeline
    public void init(){
        for(int i=0;i<11;i++){
            Packet init_packet=new Packet(sourcelist.get(i));
            
            
            
            
        }
    }
    
    
    
    
    
    
    
    
}
