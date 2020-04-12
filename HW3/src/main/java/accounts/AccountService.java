package accounts;


import dbService.DBException;
import dbService.DBService;

/**
 * @author ProkurorNSK
 */
public class AccountService {

    DBService dbService = new DBService();

    public void addNewUser(String login, String password) {
        try {
            dbService.addUser(login, password);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    public UserProfile getUserByLogin(String login) {
        UserProfile userProfile = null;
        try {
            userProfile = dbService.getUserByLogin(login);
        } catch (DBException e) {
            e.printStackTrace();
        }
        return userProfile;
    }
}
