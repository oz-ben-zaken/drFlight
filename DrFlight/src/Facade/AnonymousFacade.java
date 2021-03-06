package Facade;

import Dao.CustomerDao;
import Misc.LoginToken;
import Poco.Customer;
import Poco.User;

public class AnonymousFacade extends FacadeBase {

    protected CustomerDao customerDao = new CustomerDao();

    /**
     * Gets a User by username from userDao.getUserByUsername(username).
     * Checks if the User.password we got back matches the password.
     * If we got a match then we create the appropriate facade.
     * @param username
     * @param password
     * @return return the facade we created or the original faced if user don't exist..
     */
    public FacadeBase Login(String username, String password) {

        User user = this.userDao.getUserByUsername(username);
        if (user == null) {
            System.out.println("Username does not exist.");
            return this;
        }
        if (!user.password.equals(password)) {
            System.out.println("Password does not matched.");
            return this;
        }
        LoginToken loginToken = new LoginToken(user.id,user.username, user.userRole);
        this.customerDao.close();
        this.userDao.close();
        this.airlineCompanyDao.close();
        this.flightDao.close();
        this.countryDao.close();
        return switch (user.userRole) {
            case 1 -> new CustomerFacade(loginToken);
            case 2 -> new AirlineFacade(loginToken);
            case 3 -> new AdministratorFacade(loginToken);
            default -> this;
        };
    }

    /**
     * Create new User in the database with BaseFacade.create_new_user(user)
     * Proceeds to create Customer with matching Customer.userId = user.id in the database.
     * @param customer
     * @param user
     * @return True if customer added to the database successfully, or false otherwise.
     */
    public boolean add_customer(Customer customer, User user) {
        if (isNotNumeric(customer.phoneNumber) || isNotNumeric(customer.creditCardNumber)) {
            System.out.println("The fields 'phoneNumber' and/or 'creditCardNumber' must be numerical");
            return false;
        }
        user.userRole = 1;
        this.create_new_user(user);
        user = this.userDao.getUserByUsername(user.username);
        customer.userId = user.id;
        return this.customerDao.add(customer);
    }
}
