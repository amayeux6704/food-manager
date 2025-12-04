
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 * This class provides a GUI for the user to enter the system either as a customer
 * or employee. It allows the user to enter their credentials to log in to the 
 * system if they already have an account, sign up or create an account if they
 * are not already in the system, or enter as a guest if they do not wish to 
 * create a new account. 
 * 
 * @author Alexander
 */
public class UserEntryMenuGUI extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(UserEntryMenuGUI.class.getName());
    
    /**
     * A flag variable to be used to determine if the user is trying to log in 
     * to the system or create a new account.
     */
    private boolean logIn;
    /**
     * The customer manager to be used throughout the entire system.
     */
    private CustomerManager cm;
    /**
     * The delivery person manager to be used throughout the entire system.
     */
    private DeliveryPersonManager dpm;
    /**
     * The account manager object that will handle logging in and creating new
     * profiles for users.
     */
    private AccountManager am;
    /**
     * The general order manager that stores and manages all of the
     * orders within the system.
     */
    private OrderManager gom;
    /**
     * The food menu to be used throughout the entire system.
     */
    private Menu menu;
    /**
     * The restaurant that sells the food in the system.
     */
    private Restaurant restaurant;
    /**
     * The inventory of ingredients for each dish to be sold.
     */
    private Inventory inventory;
    /**
     * The cost calculation object to calculate the cost of the orders.
     */
    private CostCalculation cc;

    /**
     * Creates new form AccountScreenGUI. It also initializes the nameLabel and
     * name Text Field to not be visible, since the menu will default to log in
     * when opened. Then, it will also set the logIn flag to true. Finally, it
     * will initialize a new AccountManager object to handle logging in or
     * signing up users.
     */
    public UserEntryMenuGUI() {
        initComponents();
        nameLabel.setVisible(false);
        nameTF.setVisible(false);
        logIn = true;
        am = new AccountManager();
    }
    
    /**
     * Creates a new form AccountScreenGUI by calling the no argument constructor.
     * This specifically initializes the general order manager, menu, restaurant,
     * inventory, and cost calculation objects to passed as arguments to the 
     * customerMenuGUI/employeeMenuGUI.
     * 
     * @param gom   The general order manager that stores and manages all of the
     *              orders within the system.
     * @param menu  The food menu to be used throughout the entire program.
     * @param restaurant    The restaurant that sells the food in the system.
     * @param inventory     The inventory of ingredients for each dish
     * @param cc    The cost calculation object to calculate the cost of orders.
     */
    public UserEntryMenuGUI(OrderManager gom, Menu menu, Restaurant restaurant, 
            Inventory inventory, CostCalculation cc){
        this();
        this.gom = gom;
        this.menu = menu;
        this.restaurant = restaurant;
        this.inventory = inventory;
        this.cc = cc;
    }
    
    /**
     * Creates a new form AccountScreenGUI and initializes the order manager, 
     * menu, restaurant, inventory, and cost calculation objects. It also 
     * initializes the customer manager variable to be used to search for and 
     * add customers to the system when either logging in or signing up.
     * 
     * @param cm    The customer manager that is to be used throughout the whole
     *              system.
     * @param gom   The general order manager that stores and manages all of the
     *              orders within the system.
     * @param menu  The food menu to be used throughout the entire program.
     * @param restaurant    The restaurant that sells the food in the system.
     * @param inventory     The inventory of ingredients for each dish
     * @param cc    The cost calculation object to calculate the cost of orders.
     */
    public UserEntryMenuGUI(CustomerManager cm, OrderManager gom, 
            Menu menu, Restaurant restaurant, Inventory inventory, CostCalculation cc){
        this(gom, menu, restaurant, inventory, cc);
        this.cm = cm;
        this.setTitle("Customer Entry");
    }
    
    /**
     * Creates a new form AccountScreenGUI and initializes the order manager, 
     * menu, restaurant, inventory, and cost calculation objects to passed as 
     * arguments to the customerMenuGUI/employeeMenuGUI by calling the associated
     * constructor. It also initializes the delivery person manager variable to 
     * be used to search for and add customers to the system when either logging 
     * in or creating a new profile. 
     * 
     * @param dpm   The delivery person manager that is to be used throughout 
     *              the whole system.
     * @param gom   The general order manager that stores and manages all of the
     *              orders within the system.
     * @param menu  The food menu to be used throughout the entire program.
     * @param restaurant    The restaurant that sells the food in the system.
     * @param inventory     The inventory of ingredients for each dish
     * @param cc    The cost calculation object to calculate the cost of orders.
     */
    public UserEntryMenuGUI(DeliveryPersonManager dpm, OrderManager gom, 
            Menu menu, Restaurant restaurant, Inventory inventory, CostCalculation cc){
        this(gom, menu, restaurant, inventory, cc);
        this.dpm = dpm;
        this.setTitle("Employee Entry");
        guestLabel.setVisible(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        loginSignupDescrLabel = new javax.swing.JLabel();
        loginCreateButton = new javax.swing.JButton();
        signUpLabel = new javax.swing.JLabel();
        guestLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        emailTF = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        passwordLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        loginSignupDescrLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        loginSignupDescrLabel.setText("Log In");

        loginCreateButton.setText("Log In");
        loginCreateButton.setNextFocusableComponent(signUpLabel);
        loginCreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginCreateButtonActionPerformed(evt);
            }
        });

        signUpLabel.setText("Don't have an account? Click here to Sign Up");
        signUpLabel.setNextFocusableComponent(guestLabel);
        signUpLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signUpLabelMouseClicked(evt);
            }
        });
        signUpLabel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                signUpLabelKeyPressed(evt);
            }
        });

        guestLabel.setText("Not ready to sign up? Click here to continue as a guest");
        guestLabel.setNextFocusableComponent(nameTF);
        guestLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guestLabelMouseClicked(evt);
            }
        });
        guestLabel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                guestLabelKeyPressed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nameLabel.setText("Name:");

        nameTF.setNextFocusableComponent(emailTF);

        emailTF.setNextFocusableComponent(jPasswordField1);

        jPasswordField1.setNextFocusableComponent(loginCreateButton);

        passwordLabel.setText("Password:");

        emailLabel.setText("Email:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel)
                    .addComponent(nameLabel)
                    .addComponent(emailLabel)
                    .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(emailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordLabel)
                .addGap(3, 3, 3)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(loginSignupDescrLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(guestLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(signUpLabel)
                                .addGap(28, 28, 28))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(loginCreateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(79, 79, 79)))
                .addGap(68, 68, 68))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginSignupDescrLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginCreateButton)
                .addGap(12, 12, 12)
                .addComponent(signUpLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(guestLabel)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(439, 308));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * This method is called when the login/create account button is clicked.
     * It will assign the input values of the name and email text fields as well
     * as the password field to respective string variables. If the cm is not 
     * null, a customer is logging in, so the customerLogin() method will be
     * called, passing the name, email, and password variables as arguments. 
     * If the dpm is not null, then an employee is logging in, so the 
     * employeeLogin() method will be called, passing the name, email, and 
     * password variables as arguments.
     * 
     * @param evt The event that occurs when the button is pressed.
     */
    private void loginCreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginCreateButtonActionPerformed

        String name, email, password;
        
        name = nameTF.getText();
        email = emailTF.getText();
        password = new String(jPasswordField1.getPassword());
        if(cm != null){customerLogin(name, email, password);}
        if(dpm != null){employeeLogin(name, email, password);}
        
    }//GEN-LAST:event_loginCreateButtonActionPerformed

    /**
     * This method calls the changeView() method whenever the sign up label is 
     * clicked on the form. This will change the view of the form to either be 
     * the log in or sign up form based on what the form currently shows.
     * 
     * @param evt   The event that occurs when the label is clicked.
     */
    private void signUpLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpLabelMouseClicked
        changeView();
    }//GEN-LAST:event_signUpLabelMouseClicked
   
    /**
     * This method calls the enterAsGuest() method to allow the user to enter
     * as a guest whenever the guest label is clicked on the form.
     * 
     * @param evt   The event that occurs when the label is clicked.
     */
    private void guestLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guestLabelMouseClicked
        enterAsGuest();
    }//GEN-LAST:event_guestLabelMouseClicked
    
    /**
     * This method calls the changeView() method whenever a key is pressed while
     * the sign up label is selected on the form via the tab key. This will 
     * change the view of the form to either be the log in or sign up form based
     * on what the form currently shows.
     * 
     * @param evt   The event that occurs when a key is pressed while the label
     *              is selected via the tab key.
     */
    private void signUpLabelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_signUpLabelKeyPressed
        changeView();
    }//GEN-LAST:event_signUpLabelKeyPressed

    /**
     * This method calls the enterAsGuest() method to allow the user to enter
     * as a guest whenever a key is pressed while the guest label is selected on
     * the for via the tab key.
     * 
     * @param evt   The event that occurs when a key is pressed while the label
     *              is selected via the tab key.
     */
    private void guestLabelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_guestLabelKeyPressed
         enterAsGuest();
    }//GEN-LAST:event_guestLabelKeyPressed
    
    /**
     * This method lets the customer user log in to or sign up for the system.
     * It will create a new Customer object and initialize it to a null value.
     * It will then check if the parameter name, email, and password string
     * values are valid. If they are, then if the customer is trying to log in,
     * the logIn() method from the am object will be called and the returned
     * value will be assigned to the customer object. Otherwise, the signUp()
     * method from the am object will be called and the returned value will be
     * assigned to the customer object. Finally, the customer object will be 
     * passed as the argument to the openCustomerMenuGUI() method to open the
     * customer menu.
     * 
     * @param name      The customer's name.
     * @param email     The customer's email.
     * @param password  The customer's password.
     */
    private void customerLogin(String name, String email, String password){
        Customer customer = null;
        if(textFieldsValid(name, email, password)){
            if(logIn){
                customer = am.logIn(this, cm, email, password);
            }
            else{
                customer = am.signUp(this, cm, name, email, password);
            }
            openCustomerMenuGUI(customer);
        }
    }
    /**
     * This method lets the employee user log in to or create a new account for 
     * the system. It will create a new DeliveryPerson object and initialize it 
     * to a null value. It will then check if the parameter name, email, and 
     * password string values are valid. If they are, then if the employee is 
     * trying to log in, the logIn() method from the am object will be called 
     * and the returned value will be assigned to the deliveryPerson object. 
     * Otherwise, the signUp() method from the am object will be called and the 
     * returned value will be assigned to the deliveryPerson object. Finally, 
     * the deliveryPerson object will be passed as the argument to the 
     * openEmployeeMenuGUI() method to open the employee menu.
     * 
     * @param name      The delivery person's name.
     * @param email     The delivery person's email.
     * @param password  The delivery person's password.
     */
    private void employeeLogin(String name, String email, String password){
        DeliveryPerson deliveryPerson = null;
        if(textFieldsValid(name, email, password)){
            if(logIn){
                deliveryPerson = am.logIn(this, dpm, email, password);
            }
            else{
                deliveryPerson = am.signUp(this, dpm, name, email, password);
            }
            openEmployeeMenuGUI(deliveryPerson);
        }
    }
    
    /**
     * This method opens the Customer Menu for a user that is entering as a
     * guest. It creates a Customer object named guest, and calls the guest()
     * method from the am object to set the guest variable as a Customer object
     * within the system. The method then passes this guest object as an
     * argument to the openCustomerMenuGUI() method to open the customer menu.
     */
    private void enterAsGuest(){
        Customer guest = am.guest(cm);
        openCustomerMenuGUI(guest);
    }
    
    /**
     * This method determines whether all of the text fields have valid input.
     * If the user is trying to create a new account and they have not entered
     * their name, the method will display a message box to the user prompting
     * them to enter their name, and the method will return false. If the user 
     * has not entered an email address, a message box will be displayed 
     * prompting the user to enter an email address and will return false. If 
     * the user has not entered a password, a message box will be displayed
     * prompting the user to enter a password and will return false. If none of
     * these conditions are met, then all text fields have been filled out, so
     * the method will return true.
     * 
     * @param name      The value of the name entered in the name text field.
     * @param email     The value of the email address entered in the email text 
     *                  field.
     * @param password  The value of the password entered in the password text 
     *                  field.
     * @return  false if either the user is trying to create an account and the
     *          name field is empty, if the email address field is empty, or if
     *          the password field is empty. Otherwise, true.
     */
    private boolean textFieldsValid(String name, String email, String password){
        if(!logIn && name.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter your name.");
            return false;
        }
        if(email.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter an email address.");
            return false;
        }
        if(password.equals("")){
            JOptionPane.showMessageDialog(this, "Please enter a password.");
            return false;
        }
        
        return true;
    }
    
    /**
     * This method opens the employee menu if the input Customer object is not 
     * null. It first clears the fields of the form so the user's information is
     * not present after they finish their session. Then, a new CustomerMenuGUI
     * object is created, passing the cm, customer's ID, the gom, menu, 
     * restaurant, inventory, and cc as arguments so they can be used in that 
     * form. Finally, the new CustomerMenuGUI is displayed to the user.
     * 
     * @param customer      The customer that is entering the system.
     */
    private void openCustomerMenuGUI(Customer customer){
        if(customer != null){
            clearFields();
            CustomerMenuGUI custMenuGUI = new CustomerMenuGUI(cm, customer.getID(), gom, menu, restaurant, inventory, cc);
            custMenuGUI.setVisible(true);
        }
    }
    
    /**
     * This method opens the employee menu if the input DeliveryPerson object is
     * not null. It first clears the fields of the form so the user's
     * information is not present after they finish their session. Then, a new
     * EmployeeMenuGUI object is created, passing the dpm, delivery person's ID,
     * the gom, menu, restaurant, inventory, and cc as arguments so they can be
     * used in that form. Finally, the new EmployeeMenuGUI is displayed to the
     * user.
     * 
     * @param deliveryPerson    The delivery person/employee that is entering
     *                          the system.
     */
    private void openEmployeeMenuGUI(DeliveryPerson deliveryPerson){
        if(deliveryPerson != null){
            clearFields();
            EmployeeMenuGUI empMenuGUI = new EmployeeMenuGUI(dpm, deliveryPerson.getID(), gom, menu, restaurant, inventory, cc);
            empMenuGUI.setVisible(true);
        }
    }
    
    /**
     * This method changes the view of the form to either show the log in or
     * sign up form. This is done by using the logIn flag to determine the
     * current view of the form. 
     * 
     * If it is currently the log in form, the text of the labels and buttons 
     * are changed to represent signing up. The name label and text field and 
     * made visible so the user can enter their name information, and the text 
     * field is given focus. If a customer is using the login menu, the guest 
     * label is hidden. Finally, the logIn flag is set to false.
     * 
     * If it is not currently the log in form, the text of the labels and
     * buttons are changed to represent logging in. The name label and text
     * field are hidden since they are not needed for logging, and the email
     * text field is given focus. If a customer is using the login menu, the
     * guest label is made visible. Finally, the logIn flag is set to true.
     */
    private void changeView(){
        if(logIn){
            loginSignupDescrLabel.setText("Sign Up");
            loginCreateButton.setText("Create Account");
            nameLabel.setVisible(true);
            nameTF.setVisible(true);
            nameTF.requestFocus();
            if(cm != null){guestLabel.setVisible(false);}
            signUpLabel.setText("Already have an account? Click here to log in");
            logIn = false;
        }
        else
        {
            loginSignupDescrLabel.setText("Log In");
            loginCreateButton.setText("Log In");
            nameLabel.setVisible(false);
            nameTF.setVisible(false);
            emailTF.requestFocus();
            if(cm != null){guestLabel.setVisible(true);}
            signUpLabel.setText("Don't have an account? Click here to Sign Up");
            logIn = true;
        }
    }
    
    /**
     * This method clears all of the text fields on the form, resetting them
     * to an empty value.
     */
    private void clearFields(){
        nameTF.setText("");
        emailTF.setText("");
        jPasswordField1.setText("");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new UserEntryMenuGUI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTF;
    private javax.swing.JLabel guestLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JButton loginCreateButton;
    private javax.swing.JLabel loginSignupDescrLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTF;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel signUpLabel;
    // End of variables declaration//GEN-END:variables
}
