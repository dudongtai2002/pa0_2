/*
basic class for Source
 */
package pa0_2;

/**
 *
 * @author Dontai Du
 */
public class Source {
    String type;   //telnet, ftp or rogue
    double rate;
    int packet_size;
    int id;
    int number;
    public Source(String type,double rate){
        number=0;
        this.rate=rate;
        this.type=type;
        switch (type){
            case "telnet":
                packet_size=512;break;
            case "ftp":
                packet_size=8192;break;
            case "rogue":
                packet_size=5000;
                break;
        }
    }
}
