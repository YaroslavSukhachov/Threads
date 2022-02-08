package com.example.threads.semaphore;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AudioChannel extends Channel {
    private int channelId;

    public AudioChannel(int channelId) {
        this.channelId = channelId;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    @Override
    public void using() {
        try {
            // using channel
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("AudioChannel{");
        sb.append("id = ").append(channelId);
        sb.append(", busy = ").append(isBusy()).append("}");
        return sb.toString();
    }
}
