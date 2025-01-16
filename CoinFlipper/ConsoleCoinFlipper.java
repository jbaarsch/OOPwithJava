package CoinFlipper;

public class ConsoleCoinFlipper {

    private Coin coin;

    public ConsoleCoinFlipper() {
        coin = new Coin();
    }

    public Coin getCoin() {
        return coin;
    }

    public static void main(String[] args) {
        ConsoleCoinFlipper flipper = new ConsoleCoinFlipper();

        System.out.println(flipper.getCoin().isHeads());

        int headCount = 0;
        int tailCount = 0;

        for (int i = 0; i < 10000; i++) {
            flipper.coin.flip();
            if (flipper.getCoin().isHeads()) {
                headCount++;
            } else {
                tailCount++;
            }
            System.out.println(flipper.getCoin().isHeads());
        }

        System.out.println("Heads: " + headCount);
        System.out.println("Tails: " + tailCount);

    }


}
