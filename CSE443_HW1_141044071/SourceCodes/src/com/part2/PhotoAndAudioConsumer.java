package com.part2;

import java.util.Observable;
import java.util.Observer;

public class PhotoAndAudioConsumer implements Observer, ShowContent {
    private String photo = "Waiting for photo data";
    private String audio = "Waiting for audio data";

    public PhotoAndAudioConsumer(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof ContentApi) {
            ContentApi contentApi = (ContentApi) o;
            this.photo += "\nPhoto: " + contentApi.getPhoto();
            this.audio += "\nAudio: " + contentApi.getAudio();
            show();
        }
    }

    @Override
    public void show() {
        System.out.println(this.photo);
        System.out.println(this.audio);
    }
}
