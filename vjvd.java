int maxProfitCooldown(int[] prices) {
    int sell=0, prevSell=0, buy=Integer.MIN_VALUE, prevBuy;
    for (int p : prices) {
        prevBuy = buy;
        buy = Math.max(prevBuy, prevSell - p);
        prevSell = sell;
        sell = Math.max(prevSell, prevBuy + p);
    }
    return sell;
}
