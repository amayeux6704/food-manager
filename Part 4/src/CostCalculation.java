/** Calculates the cost of an order
 * @author Brendan Casey
*/
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

/**
 * Gets the tax rate
 * @return A double representing the tax rate
 */
    public double getTaxRate(){
        return taxRate;
    }

/**
 * Gets the tax cost
 * @return A double representing the tax cost
 */
    public double getTaxCost(){
        return taxCost;
    }

/**
 * Gets the total cost
 * @return A double representing the total cost
 */
    public double getTotalCost(){
        return totalCost;
    }

/**
 * Sets the tax rate
 * @param taxRate The tax rate
 */
    public void setTaxRate(double taxRate){
        this.taxRate = taxRate;
        System.out.println("Tax rate set to " + taxRate);
    }

/** Calculates the tax cost
 */
    public void calculateTaxCost(){
        double unrounded = (taxRate/100) * subTotal;
        this.taxCost = Math.round(unrounded * 100.0) / 100.0;
    }

/**
 * Calculates the subtotal cost
 * @param dish The dish to be added to the subtotal
 */
    public void calculateDishSubTotal(Dish dish){
        if (dish != null){
            this.subTotal += dish.getPrice();
        }
    }

/** Calculates the total cost
 */
    public void calculateTotalCost(){
        this.totalCost = subTotal + taxCost;
    }

/**
 * Displays the total cost
 * @param totalCost The total cost of the order
 */
    public void displayTotalCost(double totalCost){
        System.out.println("The total cost of the order is: $" + totalCost);
    }

/** Displays the tax rate
 */
    public void displayTaxRate(){
        System.out.println("Tax rate: " + this.taxRate + "%");
    }
}
