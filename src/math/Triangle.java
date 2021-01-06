package math;

import java.awt.*;

public class Triangle {

    public Vertex vertex1;
    public Vertex vertex2;
    public Vertex vertex3;
    public Color color;

    public Triangle(Vertex v1, Vertex v2, Vertex v3, Color color) {
        this.vertex1 = v1;
        this.vertex2 = v2;
        this.vertex3 = v3;
        this.color = color;
    }

}
