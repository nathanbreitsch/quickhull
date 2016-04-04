import org.junit.Test;
import static org.junit.Assert.*;


public class HullEdgeTest {
    @Test public void testMetric() {
        Point p1 = new Point(10, 0);
        Point p2 = new Point(0,0);
        Point q = new Point(0, 4);//y = 4, x=0
        HullEdge counterClockWise = new HullEdge(p1, p2); // line seg at y=0 slope=0
        HullEdge clockWise = new HullEdge(p2, p1);
        double delta = 0.001;
        assertTrue(counterClockWise.metric(q) > 0);
        assertTrue(clockWise.metric(q) < 0);
    }
}
