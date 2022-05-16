package com.jp.jplearningapp.kanji_json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class KanjiReader {

	private KanjiList vocabs;

	public KanjiReader(){
		try {
			GsonBuilder builder = new GsonBuilder();
			builder.registerTypeAdapter(KanjiList.class, new KTypeAdapter());
			builder.setPrettyPrinting();
			Gson gson = builder.create();

			Path path = Paths.get("src\\main\\resources\\com\\jp\\jplearningapp\\kanji-wanikani.json");
			BufferedReader reader = Files.newBufferedReader(path);

			vocabs = gson.fromJson(reader, KanjiList.class);

			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public KanjiList getKanjis(){
		return vocabs;
	}


}