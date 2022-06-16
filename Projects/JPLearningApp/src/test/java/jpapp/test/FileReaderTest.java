package jpapp.test;

import com.jp.jplearningapp.json.vocab.VocabReader;

import com.jp.jplearningapp.json.kanji.KanjiReader;
import com.jp.jplearningapp.json.kanji.KanjiWriter;
import com.jp.jplearningapp.json.vocab.VocabWriter;
import kotlin.text.Regex;
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
        String str = "This website is for losers LOL!";
        System.out.println(str.replaceAll("(a|e|i|o|u)", ""));
    }

}
