package blatt02;

import java.util.Objects;

public class Pair<F, S> implements Comparable<Pair<F, S>>{

    private final F first;
    private final S second;

	public Pair(F first, S second){
        this.first = first;
        this.second = second;
    }
    public Pair(){
        this.first = null;
        this.second = null;
    }

    public String toString(){
        return "First: " + first + ", Second: " + second;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public int compareTo(Pair<F,S> o) {
        if(o == null) throw new NullPointerException();

        if(this.first.equals(o.first)) {
            return 0;
        }else if(!(this.first.equals(o.first))){
            return -1;
        }

        return -1;
    }
}
