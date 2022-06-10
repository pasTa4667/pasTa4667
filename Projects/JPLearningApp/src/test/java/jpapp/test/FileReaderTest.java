package jpapp.test;

import com.jp.jplearningapp.json.vocab.VocabReader;

import com.jp.jplearningapp.json.kanji.KanjiReader;
import com.jp.jplearningapp.json.kanji.KanjiWriter;
import com.jp.jplearningapp.json.vocab.VocabWriter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReaderTest {


    @Test
    void converterTest(){
        VocabReader vocabReader = new VocabReader();
        VocabWriter vocabWriter = new VocabWriter(vocabReader.getVocabList());
    }

    @Test
    void jsonTest(){
        KanjiReader reader = new KanjiReader();
        KanjiWriter writer = new KanjiWriter(reader.getKanjis());
    }

    @Test
    void toListTest(){
        String[] paramList = new String[]{"cat","abc", "-", "abc", "<", "abc"};
        String fin = null;
        String fout = null;
        boolean flag = false;
        List<String> list = new ArrayList<>(Arrays.asList(paramList));
        for(int i = 0; i < paramList.length; i++){
            if(paramList[i].equals("<")){
                fin = paramList[i +1];
                if(!flag) list.remove(paramList[i + 1]);
                list.remove("<");
            }
            if(paramList[i].equals(">")){
                fout = paramList[i +1];
                if(!flag) list.remove(paramList[i + 1]);
                list.remove(">");
            }
            if(paramList[i].equals("-")){
                flag = true;
                list.remove("-");
            }
        }
        String[] paramList01 = new String[list.size()];
        for(int i = 0; i < paramList01.length; i++) paramList01[i] = list.get(i);

        for(String s : paramList01){
            System.out.print(s + ", ");
        }
    }

}
