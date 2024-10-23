package com.example.javafxworkshop;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Position {
    private LocalDate entryDate;
    private DoubleProperty averagePrice, lastPrice;
    private IntegerProperty shares;
    private final StringProperty symbol;
    private double yesterdayClose;
    private DoubleProperty totalCost,profitAndLoss,marketValue,percentProfitLoss;

    public Position(String symbol,LocalDate entryDate, double averagePrice, int shares) {
        this.entryDate = entryDate;
        this.averagePrice = new SimpleDoubleProperty(averagePrice);
        this.lastPrice = new SimpleDoubleProperty(averagePrice);
        this.shares = new SimpleIntegerProperty(shares);
        this.symbol = new SimpleStringProperty(symbol);
        this.yesterdayClose = 0;
        this.totalCost = new SimpleDoubleProperty(shares*averagePrice);
        this.marketValue = new SimpleDoubleProperty(shares*lastPrice.get());
        this.profitAndLoss = new SimpleDoubleProperty(marketValue.get()-totalCost.get());
        this.percentProfitLoss = new SimpleDoubleProperty(profitAndLoss.get()/totalCost.get());
    }



    public void setSymbol(String symbol) {
        this.symbol.set(symbol);
    }

    public double getTotalCost() {
        return totalCost.get();
    }

    public DoubleProperty totalCostProperty() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost.set(totalCost);
    }

    public double getProfitAndLoss() {
        return profitAndLoss.get();
    }

    public DoubleProperty profitAndLossProperty() {
        return profitAndLoss;
    }

    public void setProfitAndLoss(double profitAndLoss) {
        this.profitAndLoss.set(profitAndLoss);
    }

    public double getMarketValue() {
        return marketValue.get();
    }

    public DoubleProperty marketValueProperty() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue.set(marketValue);
    }

    public double getPercentProfitLoss() {
        return percentProfitLoss.get();
    }

    public DoubleProperty percentProfitLossProperty() {
        return percentProfitLoss;
    }

    public void setPercentProfitLoss(double percentProfitLoss) {
        this.percentProfitLoss.set(percentProfitLoss);
    }

    public double getYesterdayClose() {
        return yesterdayClose;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice.set(averagePrice);
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public void setLastPrice(double lastPrice) {
        this.lastPrice.set(lastPrice);
    }

    public void setShares(int shares) {
        this.shares.set(shares);
    }

    public void setYesterdayClose(double yesterdayClose) {
        this.yesterdayClose = yesterdayClose;
    }

    public double getAveragePrice() {
        return averagePrice.get();
    }

    public double getLastPrice() {
        return lastPrice.get();
    }

    public int getShares() {
        return shares.get();
    }

    public String getSymbol() {
        return symbol.get();
    }
    public DoubleProperty lastPriceProperty(){
        return lastPrice;
    }
    public DoubleProperty averagePriceProperty(){
        return averagePrice;
    }
    public IntegerProperty sharesProperty(){
        return shares;
    }
    public StringProperty symbolProperty(){
        return symbol;
    }

}
