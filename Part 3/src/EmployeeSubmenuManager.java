
/**
 *
 * @author Alexander
 */
class EmployeeSubmenuManager {
    private DeliveryPersonManager dpm;
    private OrderManager om;
    private EmployeeSettingsSubmenu ess;
    
    public EmployeeSubmenuManager(DeliveryPersonManager dpm, DeliveryPerson deliveryPerson){
        this.dpm = dpm;
        this.om = deliveryPerson.getOrderHistory();
        this.ess = new EmployeeSettingsSubmenu(this.dpm, deliveryPerson.getID());
    }
    
    public void showOrderAssignments(){
        om.showUnfulfilledOrders();
    }
    
    public void showOrderHistory(){
        om.showOrderHistory();
    }
    
    public void menuSettings(){
        
    }
    
    public void profileSettings(){
        ess.showMenu();
    }
}
