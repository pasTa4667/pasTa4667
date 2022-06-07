package com.jp.jplearningapp.json.vocab;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jp.jplearningapp.json.WordList;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class VocabWriter {

    public VocabWriter(WordList<Vocab> list){
        try {
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(WordList.class, new VTypeAdapter());
            builder.setPrettyPrinting();
            Gson gson = builder.create();

            Path path = Paths.get("src\\main\\resources\\com\\jp\\jplearningapp\\vocabs-wanikani.json");
            BufferedWriter writer = Files.newBufferedWriter(path);

            gson.toJson(list, writer);

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
