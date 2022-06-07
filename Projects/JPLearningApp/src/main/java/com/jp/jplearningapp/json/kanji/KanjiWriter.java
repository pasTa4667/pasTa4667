package com.jp.jplearningapp.json.kanji;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jp.jplearningapp.json.WordList;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;

public class KanjiWriter {

    public KanjiWriter(WordList kanjiList){
        try {
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(WordList.class, new KTypeAdapter());
            builder.setPrettyPrinting();
            Gson gson = builder.create();

            Path path = Paths.get("src\\main\\resources\\com\\jp\\jplearningapp\\kanji-wanikani.json");
            BufferedWriter writer = Files.newBufferedWriter(path);

            gson.toJson(kanjiList, writer);

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
