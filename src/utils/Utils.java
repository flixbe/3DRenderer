package utils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import math.Triangle;
import math.Vertex;

public class Utils {

    public static Color getShade(Color color, double shade) {
        double redLinear   = Math.pow(color.getRed(), 2.4)   * shade;
        double greenLinear = Math.pow(color.getGreen(), 2.4) * shade;
        double blueLinear  = Math.pow(color.getBlue(), 2.4)  * shade;

        int red   = (int) Math.pow(redLinear,   1 / 2.4);
        int green = (int) Math.pow(greenLinear, 1 / 2.4);
        int blue  = (int) Math.pow(blueLinear,  1 / 2.4);

        return new Color(red, green, blue);
    }

    public static List<Triangle> inflate(List<Triangle> triangle) {
        List<Triangle> result = new ArrayList<>();

        for (Triangle t : triangle) {
            Vertex v1 = new Vertex((t.vertex1.x + t.vertex2.x) / 2, (t.vertex1.y + t.vertex2.y) / 2, (t.vertex1.z + t.vertex2.z) / 2);
            Vertex v2 = new Vertex((t.vertex2.x + t.vertex3.x) / 2, (t.vertex2.y + t.vertex3.y) / 2, (t.vertex2.z + t.vertex3.z) / 2);
            Vertex v3 = new Vertex((t.vertex1.x + t.vertex3.x) / 2, (t.vertex1.y + t.vertex3.y) / 2, (t.vertex1.z + t.vertex3.z) / 2);
            result.add(new Triangle(t.vertex1, v1, v3, t.color));
            result.add(new Triangle(t.vertex2, v1, v2, t.color));
            result.add(new Triangle(t.vertex3, v2, v3, t.color));
            result.add(new Triangle(v1, v2, v3, t.color));
        }

        for (Triangle t : result) {
            for (Vertex v : new Vertex[] { t.vertex1, t.vertex2, t.vertex3 }) {
                double l = Math.sqrt(v.x * v.x + v.y * v.y + v.z * v.z) / Math.sqrt(30000);
                v.x /= l;
                v.y /= l;
                v.z /= l;
            }
        }
        return result;
    }

}
