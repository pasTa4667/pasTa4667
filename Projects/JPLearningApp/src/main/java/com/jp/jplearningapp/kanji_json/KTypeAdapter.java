package com.jp.jplearningapp.kanji_json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.jp.jplearningapp.Experience;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KTypeAdapter extends TypeAdapter<KanjiList> {
    @Override
    public void write(JsonWriter jsonWriter, KanjiList kanjiList) throws IOException {

    }

    @Override
    public KanjiList read(JsonReader reader) throws IOException {
        KanjiList kanjis;
        List<Kanji> kanjiList = new ArrayList<>();
        reader.beginObject();

        while (reader.hasNext()) {
            Kanji kanji = null;
            JsonToken token = reader.peek();
            if(token.equals(JsonToken.NAME)){
                kanji = this.readKanji(reader);
            }else reader.skipValue();

            kanjiList.add(kanji);
        }
        reader.endObject();
        kanjis = new KanjiList(kanjiList);
        return kanjis;
    }

    public List<String> readStringArray(JsonReader reader) throws IOException{
        List<String> list = new ArrayList<>();

        reader.beginArray();
        while(reader.hasNext()){
            list.add(reader.nextString());
        }
        reader.endArray();

        return list;
    }

    public Kanji readKanji(JsonReader reader) throws IOException{
        Kanji kanji = new Kanji();
        kanji.sign = reader.nextName() ;
        reader.beginObject();

        while (reader.hasNext()) {
            String name = reader.nextName();
            switch (name) {
                case "strokes" -> kanji.strokes = reader.nextInt();
                case "grade" -> kanji.grade = reader.nextInt();
                case "freq" -> kanji.freq = reader.nextInt();
                case "jlpt_old" -> kanji.jlpt_old = reader.nextInt();
                case "jlpt_new" -> kanji.jlpt_new = reader.nextInt();
                case "meanings" -> kanji.meanings = this.readStringArray(reader);
                case "readings_on" -> kanji.readings_on = this.readStringArray(reader);
                case "readings_kun" -> kanji.readings_kun = this.readStringArray(reader);
                case "wk_level" -> kanji.wk_level = reader.nextInt();
                case "wk_meanings" -> kanji.wk_meanings = this.readStringArray(reader);
                case "wk_readings_on" -> kanji.wk_readings_on = this.readStringArray(reader);
                case "wk_readings_kun" -> kanji.wk_readings_kun = this.readStringArray(reader);
                case "experience" -> kanji.experience = Experience.intToExp(reader.nextInt());
                default -> reader.skipValue();
            }
        }
        reader.endObject();

        return kanji;
    }

}
