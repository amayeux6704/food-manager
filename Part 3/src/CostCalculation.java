public class CostCalculation {

    private double taxCost;
    private double totalCost;
    private double subTotal;
    private double taxRate;

    public CostCalculation(){
        this.taxCost = 0.0;
        this.taxRate = 0.0;
        this.totalCost = 0.0;
        this.subTotal = 0.0;
    }

    public double getTaxCost(){
        return taxCost;
    }

    public double getTotalCost(){
        return totalCost;
    }

    public void setTaxRate(double taxRate){
        this.taxRate = taxRate;
        System.out.println("Tax rate set to " + taxRate);
    }

    public void calculateTaxCost(double taxRate){
        double unrounded = (taxRate/100) * subTotal;
        this.taxCost = Math.round(unrounded * 100.0) / 100.0;
    }

    public void calculateDishSubTotal(Dish dish){
        if (dish != null){
            this.subTotal += dish.getPrice();
        }
    }

    public void calculateTotalCost(){
        this.totalCost = subTotal + taxCost;
    }

    public void displayTotalCost(double totalCost){
        System.out.println("The total cost of the order is: $" + totalCost);
    }

    public void displayTaxRate(){
        System.out.println("Tax rate: " + this.taxRate + "%");
    }
}
