
public class HullEdge{
  public Point origin;
  public Point terminus;
  public boolean flag; //mark true if no points are to the right

  public HullEdge(Point origin, Point terminus){
    flag = false;
    this.origin = origin;
    this.terminus = terminus;
  }

  //returns number monotonic with positive distance to right of edge
  //returns something negative if to left of edge
  //in this case, we compute area of parallelagram made by origin terminus and p
  public double metric(Point p){
    Point v = Point.difference(this.terminus, this.origin);
    Point w = Point.difference(p, this.terminus);
    return Point.crossProduct(w, v);// we want positive when ccwise edge turns clock wise to get to p
  }
}
