package LI.content;

import arc.Core;
import arc.audio.*;

public class LIaudio {
    public static Sound
        wind = new Sound(),
        laser = new Sound();

    public static Music NTlaunch = new Music();

    public static void load() {
        loadSound();
        loadMusic();
    }

    private static void loadSound() {
        Core.assets.load("sounds/wind.mp3", Sound.class).loaded = s -> wind = s;
        Core.assets.load("sounds/laser.ogg", Sound.class).loaded = s -> laser = s;
    }
    private static void loadMusic() {
        Core.assets.load("music/NTlaunch.ogg", Music.class).loaded = m -> NTlaunch = m;
    }
}
