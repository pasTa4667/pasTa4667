package blatt04;

import blatt02.Pair;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser {

    private Map<Integer, Pair<String, String>> map = new HashMap<>();

    public LogParser(){
            try{
                BufferedReader br = new BufferedReader(new FileReader("D:\\Felix\\PastaGit\\Projects\\test\\src\\resources\\build.log"));
                String str = "";
                Pattern pattern01 = Pattern.compile("Warning");
                Matcher matcher = null;

                var counter = 0;

                while((str = br.readLine()) != null) {
                    matcher = pattern01.matcher(str);
                    boolean boo = matcher.find();
                    if (boo) {
                        counter++;
                    }
                }
                System.out.println(counter);

            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public CharSequence fromFile(String filename) throws IOException {
        FileInputStream fis = new FileInputStream(filename);
        FileChannel fc = fis.getChannel();

        // Create a read-only CharBuffer on the file
        ByteBuffer bbuf = fc.map(FileChannel.MapMode.READ_ONLY, 0, (int) fc.size());
        CharBuffer cbuf = Charset.forName("8859_1").newDecoder().decode(bbuf);
        return cbuf;
    }
}
