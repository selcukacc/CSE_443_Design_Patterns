package com.part2;

public class ContentManagement {

    public static void main(String[] args) {
        System.out.println("-------- Part 2 --------");

        ContentApi contentApi = new ContentApi();
        TextConsumer textConsumer = new TextConsumer(contentApi);
        PhotoAndAudioConsumer photoAndAudioConsumer = new PhotoAndAudioConsumer(contentApi);


        contentApi.setContent("Text1", "Photo1", "Audio1");
        contentApi.deleteObserver(textConsumer);
        contentApi.setContent(null, "photo2", "audio2");

    }
}
