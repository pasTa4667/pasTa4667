package com.jp.jplearningapp.json.vocab;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jp.jplearningapp.json.WordList;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class VocabReader {

    private WordList vocabList;

    public VocabReader(){
        try {
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            builder.registerTypeAdapter(WordList.class, new VTypeAdapter());
            Gson gson = builder.create();

            Path path = Paths.get("src\\main\\resources\\com\\jp\\jplearningapp\\vocabs-wanikani.json");
            BufferedReader reader = Files.newBufferedReader(path);

            vocabList = gson.fromJson(reader, WordList.class);

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WordList<Vocab> getVocabList() {return vocabList;}


}
