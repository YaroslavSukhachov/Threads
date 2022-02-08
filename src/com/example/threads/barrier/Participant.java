package com.example.threads.barrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Participant extends Thread {
    private Integer participantId;
    private int currentLotPrice;
    private int cash;
    private CyclicBarrier barrier = Auction.barrier;

    public Participant(Integer participantId, int currentLotPrice, int cash) {
        this.participantId = participantId;
        this.currentLotPrice = currentLotPrice;
        this.cash = cash;
    }

    public Integer getBidId() {
        return participantId;
    }

    public int getCurrentLotPrice() {
        return currentLotPrice;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    @Override
    public void run() {
        try {
            System.out.println("Participant " + participantId
                    + " specifies a price. (cash = " + cash + ")");
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(2500));
            int delta = new Random().nextInt(20);
            currentLotPrice += delta;
            System.out.println("Auction Participant " + participantId + " : " + currentLotPrice);
            this.barrier.await();
            System.out.println("Participant " + participantId
                    + " Continue to work... (cash = " + cash + ")");
        } catch (BrokenBarrierException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
