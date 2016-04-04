
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class QuickHull {
    private ArrayList<Point> points;

    public QuickHull(ArrayList<Point> points){
      this.points = points;
    }

    public Point leftMost(){
      Point left = new Point(Double.POSITIVE_INFINITY, 0);
      for(Point p : points){
        if(p.x < left.x){
          left = p;
        }
      }
      return left;
    }

    public Point rightMost(){
      Point right = new Point(Double.NEGATIVE_INFINITY, 0);
      for(Point p : points){
        if(p.x > right.x){
          right = p;
        }
      }
      return right;
    }

    public HullEdge initialLeft(){
      return new HullEdge(rightMost(), leftMost());
    }

    public HullEdge initialRight(){
      return new HullEdge(leftMost(), rightMost());
    }

    public Point farthest(HullEdge edge){

      Point farthest = null;
      double maxMetric = Double.NEGATIVE_INFINITY;
      for(Point p : points){
        double metric = edge.metric(p);
        if(metric > maxMetric){
          maxMetric = metric;
          farthest = p;
        }
      }
      if(maxMetric > 0){
        return farthest;
      }
      else{
        return null;
      }

    }

    public List<HullEdge> convexHull(){
      List<HullEdge> ch = new LinkedList<HullEdge>();
      ch.add(initialLeft());
      ch.add(initialRight());
      return null;
    }

}
