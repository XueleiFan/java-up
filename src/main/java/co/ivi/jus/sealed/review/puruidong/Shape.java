package co.ivi.jus.sealed.review.puruidong;

public abstract sealed class Shape {
    public final String id;

    public Shape(String id) {
        this.id = id;
    }

    public abstract double area();

    public static final class Circle extends Shape {
        public final double radius;

        public Circle(String id, double radius) {
            super(id);
            this.radius = radius;
        }

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }
    }

    public static final class Square extends Shape {
        public final double side;

        public Square(String id, double side) {
            super(id);
            this.side = side;
        }

        @Override
        public double area() {
            return side * side;
        }
    }

    public static final class Rectangle extends Shape {
        public final double width;
        public final double length;

        public Rectangle(String id, double length, double width) {
            super(id);
            this.length = length;
            this.width = width;
        }

        @Override
        public double area() {
            return length * width;
        }
    }

    public static String getInstanceName(Shape shape) {
        /// reference: https://openjdk.java.net/jeps/406
        return switch (shape) {
            case Circle circle -> circle.getClass().getName();
            case Square square -> square.getClass().getName();
            case Rectangle rectangle -> rectangle.getClass().getName();
            default -> "";
        };
    }

    public static void main(String[] args) {
        Shape circle = new Circle("1", 6.0);
        System.out.println(getInstanceName(circle));
        Circle circle1 = new Circle("2", 7.5);
        System.out.println(circle1.getClass().getName());
        Shape square = new Square("2", 5.0);
        System.out.println(getInstanceName(square));
        Shape rectAngele = new Rectangle("3", 7.0,5.0);
        System.out.println(getInstanceName(rectAngele));
    }

}
