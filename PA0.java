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
       double offer_load=2;
       Server server=new Server(offer_load,1);
       server.init();
       int i=0;
       while(server.total_packet<=100){
           server.flip();
           i++;
           System.out.print("loop number:"+i+"  ");
           System.out.println("total packet transmitted:"+server.total_packet);
                   
       }
       
       System.out.println(server.total_bits+" bits and "+server.total_delay+"ms");
    }
}
    

