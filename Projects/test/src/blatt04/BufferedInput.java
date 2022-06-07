package blatt04;

import javax.management.modelmbean.XMLParseException;
import java.io.BufferedReader;
import java.io.FileReader;
public class BufferedInput {

    public BufferedInput(){
        try {
            long starttime = System.currentTimeMillis();
            BufferedReader sc = new BufferedReader(new FileReader("src\\resources\\bigInput.txt"));
            long sum = 0;
            String st;
            while((st = sc.readLine())!= null){
                sum += Integer.parseInt(st);
            }
            System.out.println(System.currentTimeMillis() - starttime );
            System.out.println("The sum is: " + sum);

        }catch (Exception e){
            System.out.println("file not found");
        }
    }
}
