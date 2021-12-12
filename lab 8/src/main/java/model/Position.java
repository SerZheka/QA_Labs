package model;

import java.util.Objects;

public class Position {
    private float money;
    private int multiplier;
    private float takeProfit;
    private float stopLoss;
    private boolean dealCancellation;
    private final boolean up;

    public Position(boolean up) {
        this.up = up;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    public float getTakeProfit() {
        return takeProfit;
    }

    public void setTakeProfit(float takeProfit) {
        this.takeProfit = takeProfit;
    }

    public float getStopLoss() {
        return stopLoss;
    }

    public void setStopLoss(float stopLoss) {
        this.stopLoss = stopLoss;
    }

    public boolean isDealCancellation() {
        return dealCancellation;
    }

    public void setDealCancellation(boolean dealCancellation) {
        this.dealCancellation = dealCancellation;
    }

    public boolean isUp() {
        return up;
    }

    @Override
    public String toString() {
        return "Position{" +
                "money=" + money +
                ", multiplier=" + multiplier +
                ", takeProfit=" + takeProfit +
                ", stopLoss=" + stopLoss +
                ", dealCancellation=" + dealCancellation +
                ", up=" + up +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return money == position.money && takeProfit == position.takeProfit && stopLoss == position.stopLoss && dealCancellation == position.dealCancellation && up == position.up && Objects.equals(multiplier, position.multiplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, multiplier, takeProfit, stopLoss, dealCancellation, up);
    }
}
