package com.jp.jplearningapp.json.kanji;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.jp.jplearningapp.json.Experience;
import com.jp.jplearningapp.json.WordList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KTypeAdapter extends TypeAdapter<WordList<Kanji>> {
    @Override
    public void write(JsonWriter writer, WordList<Kanji> kanjiList) throws IOException {
        writer.beginObject();
        for(Kanji kanji : kanjiList.getAllWords()) {
            writer.name(kanji.sign);

            writer.beginObject();
            writer.name("strokes").value(kanji.strokes);
            writer.name("grade").value(kanji.grade);
            writer.name("freq").value(kanji.freq);
            writer.name("jlpt_old").value(kanji.jlpt_old);
            writer.name("jlpt_new").value(kanji.jlpt_new);
            this.writeStringArray(writer, kanji.meanings, "meanings");
            this.writeStringArray(writer, kanji.readings_on, "readings_on");
            this.writeStringArray(writer, kanji.readings_kun, "readings_kun");
            writer.name("wk_level").value(kanji.wk_level);
            this.writeStringArray(writer, kanji.wk_meanings, "wk_meanings");
            this.writeStringArray(writer, kanji.wk_readings_on, "wk_readings_on");
            this.writeStringArray(writer, kanji.wk_readings_kun, "wk_readings_kun");
            this.writeStringArray(writer, kanji.wk_radicals, "wk_radicals");
            writer.name("experience").value(kanji.experience.getExpAsInt());
            writer.endObject();

        }
        writer.endObject();

    }

    private void writeStringArray(JsonWriter writer, List<String> list, String name) throws IOException {
        writer.name(name);
        writer.beginArray();
        if(list != null) writer.value(list.toString().replace("[", "").replace("]", ""));
        writer.endArray();
    }


    @Override
    public WordList<Kanji> read(JsonReader reader) throws IOException {
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

        return new WordList<>(kanjiList);
    }

    private List<String> readStringArray(JsonReader reader) throws IOException{
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
        kanji.sign = reader.nextName();
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
