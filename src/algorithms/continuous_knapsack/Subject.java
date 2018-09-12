package algorithms.continuous_knapsack;

public class Subject {
    private Integer cost;
    private Integer weight;
    private Double unitValue;

    public Subject(int cost, int weight) {
        this.cost = cost;
        this.weight = weight;
        unitValue = (double)cost / weight;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
        unitValue = (double)cost / weight;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
        unitValue = (double)cost / weight;
    }

    public Double getUnitValue() {
        return unitValue;
    }
}
