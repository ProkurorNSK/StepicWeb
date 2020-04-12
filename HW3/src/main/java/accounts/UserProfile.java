package accounts;


import javax.persistence.*;

/**
 * @author ProkurorNSK
 */
@Entity
@Table(name = "users")
public class UserProfile {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login", unique = true, updatable = false)
    private  String login;

    @Column(name = "password", updatable = false)
    private  String password;

    public UserProfile() {
    }

    public UserProfile(String login, String password) {
        this.id = -1;
        this.login = login;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

}
