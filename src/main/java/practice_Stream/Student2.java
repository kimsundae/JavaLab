package practice_Stream;

import lombok.ToString;

@ToString
public class Student2 {
    private String name;
    private boolean isMale;
    private int hak;
    private int ban;
    private int score;

    public Student2(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return isMale;
    }

    public int getHak() {
        return hak;
    }

    public int getBan() {
        return ban;
    }

    public int getScore() {
        return score;
    }



    enum Level{ HIGH, MID, LOW }

}
