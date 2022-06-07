package blatt04;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BigInput {

    public BigInput(){
        try {
            long starttime = System.currentTimeMillis();
            Scanner sc = new Scanner(new FileInputStream("D:\\Felix\\PastaGit\\Projects\\test\\src\\resources\\bigInput.txt"));
            long sum = 0;


            while(sc.hasNext()){
                sum += sc.nextInt();
            }
            System.out.println(System.currentTimeMillis() - starttime );
            System.out.println("The sum is: " + sum);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
