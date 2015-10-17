/*
 This is the java implement of the project assignment 0 of CS655.
 This program simulates the behavior of a server and get the throughput and average latency 
of the generate packages under differenet values of total offered load(from 0.4 to 2.0, 
load+=0.2).
 */
package pa0_2;

/*
 * @author Dongtai Du U59213082 dudongtai2002@gmail.com
 */
public class PA0 {

    public static void main(String[] args) {
       double offer_load=0.4;   
       Server server=new Server(offer_load,0);
       server.init();
       while(server.total_packet<=1000){
           server.flip();// The server would accept next event and move to next state.
           System.out.println("total packet transmitted:"+server.total_packet);
           
       } 
       //Sum result
       System.out.println("offer_load= "+offer_load+", total through put="+(double)server.total_bits/server.current_time+"bps and total average packet delay="+server.total_delay/server.total_packet+"s");
       //Result for each source
       for(int i=0;i<11;i++){
       System.out.println("Source "+i+":  through put="+(double)server.each_source_bits[i]/server.current_time+"bps and average packet delay="+server.each_source_delay[i]/server.each_source_packet[i]+"s");    
       }
    }
}
    

