public class DecoratorApp {
  public static void main(String[] args) {
  Beverage beverage = new Espresso();
  beverage = new Milk(beverage);
  beverage = new Chocolate(beverage);
    System.out.println(beverage.getDescription() + " rub " + beverage.cost());
  }
}

abstract class Beverage {
  String description = "Unknown Beverage";

  public String getDescription() {
    return description;
  }

  public abstract double cost();
}

abstract class Decorator extends Beverage {
  Beverage beverage;
  public abstract String getDescription();
}

class Espresso extends Beverage {
  public Espresso() {
    description = "Espresso";
  }

  @Override
  public double cost() {
    return 250;
  }
}

class Milk extends Decorator {

  public Milk(Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ", Milk";
  }

  @Override
  public double cost() {
    return 40 + beverage.cost();
  }
}

class Chocolate extends Decorator {

  public Chocolate (Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ", Chocolate";
  }

  @Override
  public double cost() {
    return 60 + beverage.cost();
  }
}
