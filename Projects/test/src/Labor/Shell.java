package Labor;

import java.util.*;

import static java.lang.System.exit;

public class Shell {

    String env = System.getenv("PATH");
    String[] path = env.split(":");

    public Shell(){
        //Scanner sc = new Scanner(System.in);
        //System.out.print("Next Command: ");

        String next;
        List<String> cmd;

        String[][][] input = splitInput();

        /*
        while((next = sc.nextLine()) != null){
            if(next.equals("exit")) return;
            if(this.checkCmd(cmd = convert(next))){
                cmd.clear();
            }else return;

            System.out.print("Next Command: ");
        }

         */

        exit(0);

    }

    //converts input into split up command
    //0 for program, 1 for optionals, 2 for parameters
    public List<String> StringToList(String string){
        String[] sArray = string.split(" ");

        return new ArrayList<>(Arrays.asList(sArray));
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


    static void checkCmd(){}


}
