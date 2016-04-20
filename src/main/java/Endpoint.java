
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;




public class Endpoint {
  public String getConvexHull(String serial, Context context) {
    ArrayList<Point> points = parseSerial(serial);
    QuickHull qh = new QuickHull(points);
    List<HullEdge> ch = qh.convexHull();
    return serialize(ch);
  }

  public static ArrayList<Point> parseSerial(String serial){
    ArrayList<Point> points = new ArrayList<Point>();
    String[] pointStrings = serial.split(";");
    for(String pointString : pointStrings){
      String[] xyString = pointString.split(",");
      if(xyString.length == 2){
        double x = Double.parseDouble(xyString[0]);
        double y = Double.parseDouble(xyString[1]);
        points.add(new Point(x, y));
      }
    }
    return points;
  }

  public static String serialize(List<HullEdge> hull){
    return hull.stream()
                .map(edge -> Double.toString(edge.origin.x) + ","
                      + Double.toString(edge.origin.y)+ ","
                      + Double.toString(edge.terminus.x) + ","
                      + Double.toString(edge.terminus.y)
                    )
                .collect(Collectors.joining(";"));
  }

}
