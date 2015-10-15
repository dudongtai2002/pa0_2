/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa0_2;

/**
 *
 * @author dudongtai
 */
public class Event {
    String type;  //arrival or departure.
    Packet packet;
    long time;
    Server server;
    public Event(Packet pk,String type,Server sv){
        this.packet=pk;
        this.type=type;
        this.server=sv;
        if(type.equals("arrival")){       //when make a new arrival event
            time=pk.arrive_time;
        }else if(type.equals("departure")){
            time=(long)(pk.size/server.Rate)+server.current_time;    //when make a new departure event.
        }else{
            System.out.println("Unknown event type!");
            
        }
    
    
}
}