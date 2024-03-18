class Parent {
   
    public void display() {
        System.out.println("Parent's display method");
    }

    public void display(String message) {
        System.out.println("Parent's display method with message: " + message);
    }

    
    public void greet() {
        System.out.println("Hello from Parent class");
    }
}

class Child extends Parent {
    
    @Override
    public void greet() {
        System.out.println("Hello from Child class");
    }

    
    public void introduce() {
        System.out.println("I'm a Child class");
    }
}

public class Main {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();

        
        parent.display();
        parent.display("Overloaded method");

        
        parent.greet(); 
        child.greet(); 
        
        child.introduce();
    }
}
