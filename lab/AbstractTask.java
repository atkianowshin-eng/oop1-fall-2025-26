abstract class Shape {
    abstract double calculateArea();
    void displayShape() {
        System.out.println(toString());
    }
}

class Rectangle extends Shape {
    double length, width;
    Rectangle (double length, double width){
        this.length = length;
        this.width = width;
    }

@Override
double calculateArea() {
    return length * width;
}

@Override
public String toString() {
    return "Rectangle Area: " + calculateArea();
}

}

class Circle extends Shape {
    double radius;

    Circle (double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle Area: " + calculateArea();
    }
}

public class AbstractTask {
    public static void main(String[] args) {
        Shape s1 = new Rectangle (6, 3.5);
        Shape s2 = new Circle (5.25);

        s1.displayShape();
        s2.displayShape();
    }
}
