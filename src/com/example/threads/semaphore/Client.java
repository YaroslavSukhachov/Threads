package com.example.threads.semaphore;

public class Client extends Thread {
    private ChannelPool<AudioChannel> pool;

    public Client(ChannelPool<AudioChannel> pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        AudioChannel channel = null;
        try {
            channel = pool.getResource(this, 500);
        } catch (ResourceException e) {
            System.err.println("Client #" + this.getId() + " lost ->" + e.getMessage());
        } finally {
            if (channel != null) {
                pool.releaseResource(this, channel);
            }
        }
    }
}
