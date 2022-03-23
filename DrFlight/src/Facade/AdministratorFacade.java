package Facade;

import Dao.AdministratorDao;
import Misc.LoginToken;
import Poco.Administrator;
import Poco.AirlineCompany;
import Poco.Customer;

import java.util.List;

public class AdministratorFacade extends AnonymousFacade {

    protected AdministratorDao administratorDao = new AdministratorDao();
    private final LoginToken loginToken;

    public AdministratorFacade(LoginToken loginToken) {
        this.loginToken = loginToken;
    }

    /**
     * Gets token to authenticate admin.
     * @param loginToken
     * @return List of all customers.
     */
    public List<Customer> get_all_customers(LoginToken loginToken) {
        if (!this.loginToken.toString().equals(loginToken.toString())) {
            printAuthenticationError();
            return null;
        }
        return this.customerDao.getAll();
    }

    /**
     * Gets token to authenticate admin.
     * Try to add specified airline to database by calling airlineCompanyDao.add.
     * @param airline
     * @param loginToken
     * @return True if succeeds or false if not.
     */
    public boolean add_airline(AirlineCompany airline, LoginToken loginToken) {
        if (!this.loginToken.toString().equals(loginToken.toString())) {
            printAuthenticationError();
            return false;
        }
        if (airline.countryId <= 0) {
            System.out.println("country id must be a positive number");
            return false;
        }
        return this.airlineCompanyDao.add(airline);
    }

    /**
     * Gets token to authenticate admin.
     * Try to add specified customer to database by calling customerDao.add.
     * @param customer
     * @param loginToken
     * @return True if succeeds or false if not.
     */
    public boolean add_customer(Customer customer, LoginToken loginToken) {
        if (!this.loginToken.toString().equals(loginToken.toString())) {
            printAuthenticationError();
            return false;
        }
        if (isNotNumeric(customer.phoneNumber) || isNotNumeric(customer.creditCardNumber)) {
            System.out.println("The fields 'phoneNumber' and/or 'creditCardNumber' must be numerical");
            return false;
        }
        return this.customerDao.add(customer);
    }

    /**
     * Gets token to authenticate admin.
     * Try to add specified administrator to database by calling administratorDao.add.
     * @param administrator
     * @param loginToken
     * @return True if succeeds or false if not.
     */
    public boolean add_administrator(Administrator administrator, LoginToken loginToken) {
        if (!this.loginToken.toString().equals(loginToken.toString())) {
            printAuthenticationError();
            return false;
        }
        return this.administratorDao.add(administrator);
    }

    /**
     * Gets token to authenticate admin.
     * Try to remove specified airline from database by calling airlineCompanyDao.remove.
     * @param airline
     * @param loginToken
     * @return True if succeeds or false if not.
     */
    public boolean remove_airline(AirlineCompany airline, LoginToken loginToken) {
        if (!this.loginToken.toString().equals(loginToken.toString())) {
            printAuthenticationError();
            return false;
        }
        if (airline.countryId <= 0) {
            System.out.println("country id must be a positive number");
            return false;
        }
        return this.airlineCompanyDao.remove(airline);
    }

    /**
     * Gets token to authenticate admin.
     * Try to remove specified customer from database by calling customerDao.remove.
     * @param customer
     * @param loginToken
     * @return True if succeeds or false if not.
     */
    public boolean remove_customer(Customer customer, LoginToken loginToken) {
        if (!this.loginToken.toString().equals(loginToken.toString())) {
            printAuthenticationError();
            return false;
        }
        if (isNotNumeric(customer.phoneNumber) || isNotNumeric(customer.creditCardNumber)) {
            System.out.println("The fields 'phoneNumber' and/or 'creditCardNumber' must be numerical");
            return false;
        }
        return this.customerDao.remove(customer);
    }

    /**
     * Gets token to authenticate admin.
     * Try to remove specified administrator from database by calling administratorDao.remove.
     * @param administrator
     * @param loginToken
     * @return True if succeeds or false if not.
     */
    public boolean remove_administrator(Administrator administrator, LoginToken loginToken) {
        if (!this.loginToken.toString().equals(loginToken.toString())) {
            printAuthenticationError();
            return false;
        }
        return this.administratorDao.remove(administrator);
    }

}
