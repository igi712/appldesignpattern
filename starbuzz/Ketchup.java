public class Ketchup extends CondimentDecorator {
    public Ketchup(Beverage beverage) {
        this.beverage = beverage;
    }
    public String getDescription() {
        return beverage.getDescription() + ", Ketchup (Coordinator's special)";
    }
    public double cost() {
		return .15 + beverage.cost();
	}
}