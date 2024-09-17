import java.awt.*;

public class Circle implements Comparable<Circle> {

    private double radius;
    private Color color;
    private int X;
    private int Y;

    public Circle(double radius, Color color, int x, int y) {
        this.radius = radius;
        this.color = color;
        this.X = x;
        this.Y = y;
    }

    public void setX(int x){
        this.X = x;
    }
    public int getRadius() {
        return (int)radius;
    }
    public void setY(int y){
        this.Y = y;
    }

    public Circle(int x, int y) {
        this.X = x;
        this.Y = y;
        color = Color.BLACK;
        radius = Math.random() * 50 + 50;
    }

    public void draw(Graphics g) {
        g.fillOval(X, Y, (int)(radius *2), (int) radius *2);
    }

public int compareTo(Circle o) {
        return ((int)this.radius - (int)o.radius);

}


}
