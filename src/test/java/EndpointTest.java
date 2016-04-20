import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class EndpointTest {
    @Test public void testParser() {
      String pointString = "1,1;5,5;1,3";
      ArrayList<Point> points = Endpoint.parseSerial(pointString);
      assertTrue(points.size() == 3);
    }

    @Test public void testSerializer(){

    }

    @Test public void testGetConvexHull(){
      
    }
}
