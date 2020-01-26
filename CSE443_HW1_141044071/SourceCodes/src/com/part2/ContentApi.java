package com.part2;

import java.util.Observable;

public class ContentApi extends Observable {
    private String text;
    private String photo;
    private String audio;

    public ContentApi() {}

    /**
     * Saves changes for given data and notifies observers for
     * change.
     */
    private void saveChanges() {
        setChanged();
        notifyObservers();
    }

    /**
     * Sets api's contents.
     * @param text
     * @param photo
     * @param audio
     */
    public void setContent(String text, String photo, String audio) {
        this.text = text;
        this.photo = photo;
        this.audio = audio;
        saveChanges();
    }

    public String getText() {
        return text;
    }

    public String getPhoto() {
        return photo;
    }

    public String getAudio() {
        return audio;
    }
}
