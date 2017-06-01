package example.haim.recyclerviewanimalsounds;

/**
 * Created by DELL e7440 on 29/05/2017.
 */

public class Animal {
    private final int imageResID;
    private final int soundResID;

    public Animal(int imageResID, int soundResID) {
        this.imageResID = imageResID;
        this.soundResID = soundResID;
    }

    public int getImageResID() {
        return imageResID;
    }

    public int getSoundResID() {
        return soundResID;
    }
}
