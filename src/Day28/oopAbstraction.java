package Day28;

public class oopAbstraction {
    public static void main(String[] args) {
        Circle circle = new Circle(10);
        Rectangle rectangle = new Rectangle(10, 10);
        Triangle triangle = new Triangle(10, 15);

        //all under shape inherited display
        circle.display();
        rectangle.display();
        triangle.display();

        //you can use shape class as commonality
        Shape[] shapes = {circle, rectangle, triangle};
        for (Shape shape : shapes) {
            System.out.println(shape.area());
        }

    }
}
/*
Abstraction - hide the actual implementation of a function
    abstract class - can have properties
                   - cannot be instantiated, but they can have subclasses
                   - can contain 'abstract' methods (which must be implemented and no code block)
                   - can contain 'concreate' methods (which are inherited)

    interface - just like an abstract class
              - declaration in an interface must be initialized
              - every function is considered abstract
*/