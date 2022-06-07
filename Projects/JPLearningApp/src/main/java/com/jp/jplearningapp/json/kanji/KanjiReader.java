package com.jp.jplearningapp.json.kanji;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jp.jplearningapp.json.WordList;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class KanjiReader {

	private WordList kanjiList;

	public KanjiReader(){
		try {
			GsonBuilder builder = new GsonBuilder();
			builder.registerTypeAdapter(WordList.class, new KTypeAdapter());
			builder.setPrettyPrinting();
			Gson gson = builder.create();

			Path path = Paths.get("src\\main\\resources\\com\\jp\\jplearningapp\\kanji-wanikani.json");
			BufferedReader reader = Files.newBufferedReader(path);

			kanjiList = gson.fromJson(reader, WordList.class);

			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public WordList getKanjis(){
		return kanjiList;
	}


}