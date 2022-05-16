package blatt03;

import blatt02.Pair;

import java.util.HashMap;

public class HashMapArray {

    private final HashMap<Integer, Object> hashMap = new HashMap<>();

    public HashMapArray(){}

    public boolean addAt(int pos, Object obj){
        if(hashMap.get(pos) != null){
            hashMap.remove(pos);
        }
        hashMap.put(pos, obj);
        return true;
    }

    public Object getAt(int pos){
        if(hashMap.size() < pos){
            throw new IndexOutOfBoundsException();
        }
        return hashMap.get(pos);
    }

    public int length(){
        return hashMap.size();
    }


}
