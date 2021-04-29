class Car{
    private String name;
    private Boolean engine;
    private int cylinders;
    private int wheels;

    public Car(String name, int cylinders) {
        this.name = name;
        this.engine = true;
        this.cylinders = cylinders;
        this.wheels = 4;
    }

    public String getName() {
        return name;
    }

    public int getCylinders() {
        return cylinders;
    }

    public Boolean getEngine() {
        return engine;
    }

    public int getWheels() {
        return wheels;
    }

    public String accelerate(/*int finalVelocity, int initialVelocity, int time*/){
        //return (finalVelocity - initialVelocity) / time;
        return "Car -> accelerate()";
    }

    public String startEngine(){
        return "Car -> startEngine()";
    }

    public String brake(){
        return "Car -> brake()";
    }

}

class Prius extends Car{

    public Prius(String name, int cylinders) {
        super(name, cylinders);
    }

    @Override
    public String accelerate() {
        return "Prius -> accelerate()";
    }

    @Override
    public String startEngine() {
        return "Prius -> StartEngine()";
    }

    @Override
    public String brake() {
        return "Prius -> brake()";
    }
}

class Ford extends Car{

    public Ford(String name, int cylinders) {
        super(name, cylinders);
    }

    @Override
    public String accelerate() {
        return "Ford -> accelerate()";
    }

    @Override
    public String startEngine() {
        return "Ford -> StartEngine()";
    }

    @Override
    public String brake() {
        return "Ford -> brake()";
    }
}

class Buick extends Car{

    public Buick(String name, int cylinders) {
        super(name, cylinders);
    }

    @Override
    public String accelerate() {
        return "Buick -> accelerate()";
    }

    @Override
    public String startEngine() {
        return "Buick -> StartEngine()";
    }

    @Override
    public String brake() {
        return "Buick -> brake()";
    }
}

public class Main {

    public static void main(String[] args) {
       Car car = new Car("Base Car",8);
        System.out.println(car.accelerate());
        System.out.println(car.brake());
        System.out.println(car.startEngine());

        Prius prius = new Prius("PriusX", 7);
        System.out.println(prius.accelerate());
        System.out.println(prius.brake());
        System.out.println(prius.startEngine());

        Ford ford = new Ford("Ford1X", 17);
        System.out.println(ford.accelerate());
        System.out.println(ford.brake());
        System.out.println(ford.startEngine());

        Buick buick = new Buick("BuickX13", 13);
        System.out.println(buick.accelerate());
        System.out.println(buick.brake());
        System.out.println(buick.startEngine());


    }
}
