package com.jp.jplearningapp.json.vocab;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.jp.jplearningapp.json.Experience;
import com.jp.jplearningapp.json.WordList;
import com.jp.jplearningapp.json.Words;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VTypeAdapter extends TypeAdapter<WordList<Vocab>> {
    @Override
    public void write(JsonWriter writer, WordList<Vocab> list) throws IOException {
        writer.beginObject();

        for(Vocab word : list.getAllWords()){
            writer.name(word.sign);

            writer.beginObject();
            writer.name("meanings");
            this.writeStringArray(writer, word.meanings);

            writer.name("readings");
            this.writeStringArray(writer, word.readings);

            writer.name("wk_level").value(word.wk_level);

            if(word.experience == null){
                writer.name("experience").value(0);
            }else
                writer.name("experience").value(word.experience.getExpAsInt());
            writer.endObject();

        }

        writer.endObject();
    }

    public void writeStringArray(JsonWriter writer, List<String> list) throws IOException {
        writer.beginArray();
        if(list != null) writer.value(list.toString().replace("[", "").replace("]", ""));
        writer.endArray();
    }

    @Override
    public WordList<Vocab> read(JsonReader reader) throws IOException {
        List<Vocab> list = new ArrayList<>();

        reader.beginObject();

        while(reader.hasNext()){
            Vocab vocab = null;
            JsonToken token = reader.peek();
            if(token.equals(JsonToken.NAME)){
                vocab = this.readVocab(reader);
            }else reader.skipValue();

            list.add(vocab);
        }

        reader.endObject();

        return new WordList<>(list);
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

    private Vocab readVocab(JsonReader reader) throws IOException{
        Vocab vocab = new Vocab();
        vocab.sign = reader.nextName();
        reader.beginObject();

        while(reader.hasNext()){
            String name = reader.nextName();
            switch(name){
                case "sign" -> vocab.sign = reader.nextString();
                case "readings" -> vocab.readings = this.readStringArray(reader);
                case "meanings" -> vocab.meanings = this.readStringArray(reader);
                case "wk_level" -> vocab.wk_level = reader.nextInt();
                case "experience" -> vocab.experience = Experience.intToExp(reader.nextInt());
                default -> reader.skipValue();
            }
        }

        reader.endObject();

        return vocab;
    }


}
