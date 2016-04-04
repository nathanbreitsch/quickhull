import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/*
 * This Java source file was auto generated by running 'gradle init --type java-library'
 * by 'nathanbreitsch' at '4/2/16 8:29 PM' with Gradle 2.10
 *
 * @author nathanbreitsch, @date 4/2/16 8:29 PM
 */
public class QuickHullTest {

    //construct a regular n-gon with radius 1
    public static QuickHull makeRegularNgon(int n, int m){

      ArrayList<Point> points = new ArrayList<Point>(n);

      for(int i = 0; i < n; i++){
        double theta = 2 * i * Math.PI / n;
        points.add(new Point(
            Math.cos(theta),
            Math.sin(theta)
        ));
      }

      for(int i = 0; i < m; i++){
        double theta = 2 * Math.random() * Math.PI;
        double radius = Math.random();
      }

      QuickHull qh = new QuickHull(points);
      return qh;

    }

    @Test public void testLeftMost() {

      QuickHull qh = QuickHullTest.makeRegularNgon(4, 0);
      Point left = qh.leftMost();
      assertEquals(-1, left.x, 0.0001);

    }

    @Test public void testRightMost() {

      QuickHull qh = QuickHullTest.makeRegularNgon(4, 0);
      Point right = qh.rightMost();
      assertEquals(1, right.x, 0.0001);

    }

    @Test public void testInitialLeft() {

        QuickHull qh = QuickHullTest.makeRegularNgon(4, 0);
        HullEdge edge = qh.initialLeft();
        double delta = 0.0001;
        assertEquals(1, edge.origin.x, delta);
        assertEquals(0, edge.origin.y, delta);
        assertEquals(-1, edge.terminus.x, delta);
        assertEquals(0, edge.terminus.y, delta);

    }

    @Test public void testInitialRight() {

        QuickHull qh = QuickHullTest.makeRegularNgon(4, 0);
        HullEdge edge = qh.initialRight();
        double delta = 0.0001;
        assertEquals(-1, edge.origin.x, delta);
        assertEquals(0, edge.origin.y, delta);
        assertEquals(1, edge.terminus.x, delta);
        assertEquals(0, edge.terminus.y, delta);

    }

    @Test public void testFarthest() {

        QuickHull qh = QuickHullTest.makeRegularNgon(4, 0);
        HullEdge edge = qh.initialLeft();
        Point farthest = qh.farthest(edge);
        assertEquals(1, farthest.y, 0.001);
        assertEquals(0, farthest.x, 0.001);

    }
}
