import java.awt.Color;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Hilbert3D {
    public static void main(String[] args) {

        // Sets the starting recursive depth
        int depth = 2;
        if (args.length != 0) depth = Integer.parseInt(args[0]);

        // Sets the physical width of the cube
        double width = 0.5;
        StdDraw3D.setScale(-width * 1.7, width * 1.7);

        // Draws the specified Hilbert curve
        draw(width, depth);

        // Show loop, changes the recursive depth with key presses
        while (true) {
            if (StdDraw3D.hasNextKeyTyped()) {
                char c = StdDraw3D.nextKeyTyped();
                if ((c == '=') || (c == '+'))
                    if (depth < 5) draw(width, ++depth);
                if ((c == '_') || (c == '-'))
                    if (depth > 1) draw(width, --depth);
            }
            StdDraw3D.show(20);
        }
    }

    /** Calculates and draws a Hilbert curve with the given width and recursive depth. */
    private static void draw(double width, int depth) {

        StdDraw3D.clear();
        List<StdDraw3D.Vector3D> vecs = hilbert3D(width, depth);

        double[] x = new double[vecs.size()];
        double[] y = new double[vecs.size()];
        double[] z = new double[vecs.size()];
        Color[] colors = new Color[vecs.size()];

        for (int i = 0; i < vecs.size(); i++) {
            StdDraw3D.Vector3D r = vecs.get(i);
            x[i] = r.x;
            y[i] = r.y;
            z[i] = r.z;
            colors[i] = Color.getHSBColor((float)i/((float)vecs.size()), 1, 1);
        }

        StdDraw3D.setPenRadius(2);
        double radius = 0.02 * width;
        
        // Draws Hilbert curve as unshaded lines
        //StdDraw3D.lines(x, y, z, colors);

        // Draws the Hilbert curve as shaded cylindrical tubes
        StdDraw3D.tubes(x, y, z, radius, colors);

        // Draws the help text
        StdDraw3D.setPenColor(StdDraw3D.WHITE);
        String help = "Press '+' or '-' to change fractal depth. Current depth = [" + depth + "]";
        StdDraw3D.overlayText(0, -1.5 * width, help);

        // Draws the bordering cube of the Hilbert curve
        StdDraw3D.setPenRadius(0.1);
        StdDraw3D.setPenColor(StdDraw3D.WHITE, 20);
        StdDraw3D.cube(0, 0, 0, width);
    }

    /** Wrapper method that begins the Hilbert3D recursive process. */
    private static List<StdDraw3D.Vector3D> hilbert3D(double width, int depth) {
        return hilbert3D(new StdDraw3D.Vector3D(), width, depth, 0, 1, 2, 3, 4, 5, 6, 7);
    }

    /** Recursive algorithm for constructing a set of vertices for the Hilbert curve. */
    private static List<StdDraw3D.Vector3D> hilbert3D
    (StdDraw3D.Vector3D center, double width, int depth, int v0, int v1, int v2, int v3, int v4 ,int v5, int v6, int v7) {

        // Creates the eight possible vertices of a gray code.
        StdDraw3D.Vector3D[] vecs = new StdDraw3D.Vector3D[] {
                new StdDraw3D.Vector3D(center.x - width/2, center.y + width/2, center.z - width/2),
                new StdDraw3D.Vector3D(center.x - width/2, center.y + width/2, center.z + width/2),
                new StdDraw3D.Vector3D(center.x - width/2, center.y - width/2, center.z + width/2),
                new StdDraw3D.Vector3D(center.x - width/2, center.y - width/2, center.z - width/2),
                new StdDraw3D.Vector3D(center.x + width/2, center.y - width/2, center.z - width/2),
                new StdDraw3D.Vector3D(center.x + width/2, center.y - width/2, center.z + width/2),
                new StdDraw3D.Vector3D(center.x + width/2, center.y + width/2, center.z + width/2),
                new StdDraw3D.Vector3D(center.x + width/2, center.y + width/2, center.z - width/2)
            };

        // Arranges the gray code by the specified arguments.
        StdDraw3D.Vector3D[] gray = new StdDraw3D.Vector3D[] 
            { vecs[v0], vecs[v1], vecs[v2], vecs[v3], vecs[v4], vecs[v5], vecs[v6], vecs[v7] };

        if (depth <= 1) return Arrays.asList(gray);

        // Constructs the curve by concatenating vertices from recursive calls.
        List<StdDraw3D.Vector3D> verts = new LinkedList<StdDraw3D.Vector3D>();
        verts.addAll(hilbert3D(gray[0], width/2, depth - 1, v0, v3, v4, v7, v6, v5, v2, v1));
        verts.addAll(hilbert3D(gray[1], width/2, depth - 1, v0, v7, v6, v1, v2, v5, v4, v3));
        verts.addAll(hilbert3D(gray[2], width/2, depth - 1, v0, v7, v6, v1, v2, v5, v4, v3));
        verts.addAll(hilbert3D(gray[3], width/2, depth - 1, v2, v3, v0, v1, v6, v7, v4, v5));
        verts.addAll(hilbert3D(gray[4], width/2, depth - 1, v2, v3, v0, v1, v6, v7, v4, v5));
        verts.addAll(hilbert3D(gray[5], width/2, depth - 1, v4, v3, v2, v5, v6, v1, v0, v7));
        verts.addAll(hilbert3D(gray[6], width/2, depth - 1, v4, v3, v2, v5, v6, v1, v0, v7));
        verts.addAll(hilbert3D(gray[7], width/2, depth - 1, v6, v5, v2, v1, v0, v3, v4, v7));

        return verts;
    }
}

