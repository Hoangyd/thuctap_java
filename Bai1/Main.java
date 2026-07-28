class Shape {
    protected double width;
    protected double height;

    public Shape(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public String getInfo() {
        return "Width: " + width + ", Height: " + height;
    }
}

class Rectangle extends Shape {
    public Rectangle(double width, double height) {
        super(width, height);
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String getInfo() {
        return "Rectangle -> " + super.getInfo() + ", Area: " + getArea() + ", Perimeter: " + getPerimeter();
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super(radius * 2, radius * 2);
        this.radius = radius;
    }

    public double getArea() {
        return 3.14 * radius * radius;
    }

    public double getCircumference() {
        return width * 3.14;
    }

    @Override
    public String getInfo() {
        return "Circle -> Radius: " + radius + ", Diameter: " + width + ", Area: " + getArea()
                + ", Circumference: " + getCircumference();
    }
}

public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape(10, 20);
        Rectangle rectangle = new Rectangle(10, 20);
        Circle circle = new Circle(7);

        System.out.println("Shape information:");
        System.out.println(shape.getInfo());
        System.out.println();

        System.out.println("Rectangle information:");
        System.out.println(rectangle.getInfo());
        System.out.println();

        System.out.println("Circle information:");
        System.out.println(circle.getInfo());
    }
}