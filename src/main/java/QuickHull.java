
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;

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

      Point farthestPoint = null;
      double maxMetric = Double.NEGATIVE_INFINITY;
      for(Point p : points){
        double metric = edge.metric(p);
        if(metric > maxMetric){
          maxMetric = metric;
          farthestPoint = p;
        }
      }
      if(maxMetric > 0){
        return farthestPoint;
      }
      else{
        return null;
      }

    }

    public List<HullEdge> convexHull(){
      List<HullEdge> ch = new LinkedList<HullEdge>();
      ch.add(initialLeft());
      ch.add(initialRight());
      boolean done = false;
      while(!done){
        done = true;

        for(ListIterator<HullEdge> currentEdgeIterator = ch.listIterator(); currentEdgeIterator.hasNext();){
          HullEdge currentEdge = currentEdgeIterator.next();
          Point farthestPoint = farthest(currentEdge);
          if(farthestPoint != null){
            done = false;
            HullEdge edge1 = new HullEdge(currentEdge.origin, farthestPoint);
            HullEdge edge2 = new HullEdge(farthestPoint, currentEdge.terminus);
            currentEdgeIterator.set(edge2);
            currentEdgeIterator.add(edge1);
          }
        }

      }
      return ch;
    }

    public List< List<HullEdge> > convexHullAnimation(){
      List< List<HullEdge> > chAnimation = new LinkedList<HullEdge>();
      List<HullEdge> ch = new LinkedList<HullEdge>();
      ch.add(initialLeft());
      ch.add(initialRight());
      boolean done = false;
      while(!done){
        done = true;
        chAnimation.add(ch.clone());
        for(ListIterator<HullEdge> currentEdgeIterator = ch.listIterator(); currentEdgeIterator.hasNext();){
          HullEdge currentEdge = currentEdgeIterator.next();
          Point farthestPoint = farthest(currentEdge);
          if(farthestPoint != null){
            done = false;
            HullEdge edge1 = new HullEdge(currentEdge.origin, farthestPoint);
            HullEdge edge2 = new HullEdge(farthestPoint, currentEdge.terminus);
            currentEdgeIterator.set(edge2);
            currentEdgeIterator.add(edge1);
          }
        }

      }
      return chAnimation;
    }

}
