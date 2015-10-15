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
    int current_algo; // 0 for FIFO, 1 for RR, 2 for DRR.
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
            Event init_event=new Event(init_packet,"arrival",this);
            timeline.add(init_event);
            
        }
        System.out.println("The server is ready!");
    }
    //each "move" for the server, just get the head event and implement it.
    public void flip(){
        if(timeline.isEmpty()){
            System.out.println("Timeline is Empty!");
            return;
        }
        current_time=timeline.get(0).time;
        Event current_event=timeline.get(0);
        timeline.remove(0);
        switch(current_event.type){
            case "arrival":   //If a new packet arrives, put it in the relating waiting queue.
                 int id=current_event.packet.source_id;
                 queue.get(id).add(current_event.packet);
                 //create the next packet with the same source
                 Packet next=new Packet(this.sourcelist.get(id),this.current_time);
                 Event next_e=new Event(next,"arrival",this);
                 this.position_event(next_e);
                 break;
            case "departure": // If the event is departure, record the numbers
                 this.current_packet.transmission_time=this.current_time;
                 this.total_packet+=1;
                 this.total_bits+=current_packet.size;
                 this.total_delay+=current_packet.start_time-current_packet.arrive_time;
                 //send the packet to the universe :)
                 this.busy=false;current_packet=null;break;
            default:
                System.out.println("find unidentified event!");return;
        }
        read(); 
    }
    //function to get a packet from the queue and working on it.
    public void read(){
        //You have to ensure the server it's not working on something.
        if(this.busy){
            return;
        }
        //use the algorithnm to get a packet.
        switch(current_algo){
            case 0: this.current_packet=FIFO();break;
            case 1: this.current_packet=RR();break;  
            case 2: this.current_packet=DRR();break;
            default: System.out.println("algorithnm does not exist");
        }
        
        if(current_packet==null){
            System.out.println("cannot get a packet from queue");
        }else{
        current_packet.start_time=this.current_time;
        //generate the departure event.
        Event departure=new Event(current_packet,"departure",this);
        position_event(departure);
        }
        
    }
    //First in First out, search the head of the 11 queue, find the packet with smallest arrival time
    public Packet FIFO(){
        int queue_id=-1;
        long check_time=Long.MAX_VALUE;
        for(int i=0;i<this.queue.size();i++){
           if(this.queue.get(i).isEmpty()==false&&queue.get(i).element().arrive_time<check_time){
               queue_id=i;
           }
        }
        if(queue_id==-1){                
          return null; 
        }
        Packet temp=queue.get(queue_id).removeFirst();
        return temp;
    }
    public Packet RR(){
       return null; 
    }        
    public Packet DRR(){
       return null; 
    }
    //This function put the event at the right position in the timeline
    //not a good algorithnm, can be optimized.
    public void position_event(Event e){
        int pos;
        long time1=e.time;
        if(this.timeline.isEmpty()==false){
        for(pos=0;pos<this.timeline.size();pos++){
            if (time1<=this.timeline.get(pos).time){
                this.timeline.add(pos, e);
                return;
            }
            
        }
        }
        this.timeline.add(e);
        
        
    }
    
    
    
    
}
