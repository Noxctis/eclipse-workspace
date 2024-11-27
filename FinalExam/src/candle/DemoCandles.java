
public class DemoCandles {
       public static void main(String[] args) {
              Candle candle = new Candle("Red", 5);
              ScentedCandle scentedCandle = new ScentedCandle("Blue", 6, "Lavender");
              System.out.println("Candle color: " + candle.getColor());
              System.out.println("Candle height: " + candle.getHeight());
              System.out.println("Candle price: " + candle.getPrice());
              System.out.println("Scented candle color: " + scentedCandle.getColor());
              System.out.println("Scented candle height: " + scentedCandle.getHeight());
              System.out.println("Scented candle price: " + scentedCandle.getPrice());
              System.out.println("Scented candle scent: " + scentedCandle.getScent());
              candle.setColor("Green");
              candle.setHeight(7);
              scentedCandle.setColor("Yellow");
              scentedCandle.setHeight(8);
              scentedCandle.setScent("Rose");
              System.out.println("Candle color: " + candle.getColor());
              System.out.println("Candle height: " + candle.getHeight());
              System.out.println("Candle price: " + candle.getPrice());
              System.out.println("Scented candle color: " + scentedCandle.getColor());
              System.out.println("Scented candle height: " + scentedCandle.getHeight());
              System.out.println("Scented candle price: " + scentedCandle.getPrice());
              System.out.println("Scented candle scent: " + scentedCandle.getScent());
       }
}
