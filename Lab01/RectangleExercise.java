// ============================================================
// Lab 1 - Exercise solutions
// File: RectangleExercise.java  (Intermediate: largest area in array)
// Student: Ronald Murape (H250475V)
// ============================================================
public class RectangleExercise {

    double width;
    double height;

    double area()       { return width * height; }
    double perimeter()  { return 2 * (width + height); }

    public static void main(String[] args) {
        RectangleExercise[] rects = new RectangleExercise[5];
        rects[0] = new RectangleExercise(); rects[0].width = 2;  rects[0].height = 3;
        rects[1] = new RectangleExercise(); rects[1].width = 5;  rects[1].height = 5;
        rects[2] = new RectangleExercise(); rects[2].width = 1;  rects[2].height = 8;
        rects[3] = new RectangleExercise(); rects[3].width = 4;  rects[3].height = 4;
        rects[4] = new RectangleExercise(); rects[4].width = 3;  rects[4].height = 6;

        // EXPLAIN: aliasing demo - r2 points at the SAME object as r1
        RectangleExercise r1 = rects[0];
        RectangleExercise r2 = r1;
        r2.width = 99;
        System.out.println("After r2.width=99, r1.width = " + r1.width);   // 99

        // largest area
        RectangleExercise largest = rects[0];
        for (int i = 1; i < rects.length; i++) {
            if (rects[i].area() > largest.area()) largest = rects[i];
        }
        System.out.println("Largest area = " + largest.area());
    }
}
