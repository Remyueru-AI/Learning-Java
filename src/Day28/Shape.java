package Day28;

public abstract class Shape {

    //this is an abstract method
    abstract double area();

    //this is a concreate method
    void display() {
        System.out.println("This is a shape");
    }
}
/*
Shape - all shape have area method
    > Circle
    > Triangle
    > Rectangle
*/