
public class Point{
  public double x;
  public double y;

  public Point(double x, double y){
    this.x = x;
    this.y = y;
  }

  public static Point difference(Point p1, Point p2){
    return new Point(p1.x - p2.x, p1.y - p2.y);
  }

  public static double crossProduct(Point p1, Point p2){
    return p1.x * p2.y - p1.y * p2.x;
  }

}
