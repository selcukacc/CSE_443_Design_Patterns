package com.part2;

import java.util.Observable;
import java.util.Observer;

public class TextConsumer implements Observer, ShowContent {
    private String text = "Waiting for text data.";

    public TextConsumer(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {

        if(o instanceof ContentApi) {
            ContentApi contentApi = (ContentApi)o;
            this.text += "\nText: " + contentApi.getText();
        }

        show();
    }

    public void show() {
        System.out.println(text);
    }
}
