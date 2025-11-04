public class CostCalculation {

    private double taxCost;
    private double totalCost;

    public CostCalculation(){
        this.taxCost = 0.0;
        this.totalCost = 0.0;
    }

    public double getTaxCost(){
        return taxCost;
    }

    public double getTotalCost(){
        return totalCost;
    }

    public void setTaxCost(double taxCost){
        this.taxCost = taxCost;
    }

    public void calculateTotalCost(double itemCost){
        this.totalCost = itemCost + this.taxCost;
    }
}
