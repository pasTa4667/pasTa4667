package Labor;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class ShellCorr {

    public static void main(String[] args) {
        System.out.println("hello");
        String env = System.getenv("PATH");
        String[] path = env.split(":");

        while(true) {
            String[][][] input = splitInput();
        }
    }
    public static String[][] parse_redirect(String[] arr){
        int i;
        int index_out=0;
        int index_in=0;
        for(i=0; i<arr.length; i++){
            if(arr[i].equals(">"))
                index_out = i;
            else if(arr[i].equals("<"))
                index_in = i;
        }
        String[][] ret = new String[3][i];
        ret[1][0] = null;
        ret[2][0] = null;

        if(index_out!=0){
            ret[2][0] = arr[index_out+1];
        }
        if(index_in!=0){
            ret[1][0] = arr[index_in+1];
        }

        if(index_out > index_in){
            if(index_in != 0)
                ret[0] = Arrays.copyOfRange(arr,0,index_in);
            else
                ret[0] = Arrays.copyOfRange(arr,0,index_out);
        }else if(index_out < index_in){
            if(index_out != 0)
                ret[0] = Arrays.copyOfRange(arr,0,index_out);
            else
                ret[0] = Arrays.copyOfRange(arr,0,index_in);
        }else
            ret[0] = arr;

        return ret;
    }

    public static void return_valid_path(String[] arr,String[] env){
        for(String s : env){
            File tmp = new File(s +"/"+ arr[0]);
            if(tmp.exists()){
                arr[0] = s +"/"+ arr[0];
                break;
            }
        }
    }

    public static String[][][] splitInput() {
        Scanner in = new Scanner(System.in);
        System.out.print("Custom Shell: $ ");
        String input = in.nextLine();

        String[] pip_sep = input.split(" \\| ");

        String[][] sep_input = new String[pip_sep.length][];
        for(int i = 0; i<pip_sep.length; i++){
            sep_input[i] = pip_sep[i].split(" && ");
        }
        String[][][] split_input = new String[sep_input.length][][];
        for(int i=0; i< sep_input.length; i++){
            split_input[i] = new String[sep_input[i].length][];
            for(int j=0; j<sep_input[i].length; j++) {
                split_input[i][j] = sep_input[i][j].split(" ");
            }
        }

        for(String[][] d2 : split_input){
            for(String[] d1 : d2){
                System.err.println(Arrays.toString(d1));
            }
        }

        return split_input;
    }



}
