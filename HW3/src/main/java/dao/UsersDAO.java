package dao;

import accounts.UserProfile;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UsersDAO {
    private Session session;

    public UsersDAO(Session session) {
        this.session = session;
    }

    public UserProfile getUser(String login) throws HibernateException {
        /*CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<UserProfile> criteria = criteriaBuilder.createQuery(UserProfile.class);
        Root<UserProfile> usersDataSetRoot = criteria.from(UserProfile.class);
        return (UserProfile)criteria.where(criteriaBuilder.equal(usersDataSetRoot.get("login"), login));*/

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserProfile> criteriaQuery = builder.createQuery(UserProfile.class);
        Root<UserProfile> root = criteriaQuery.from(UserProfile.class);
        criteriaQuery.select(root);
        criteriaQuery.where(builder.equal(root.get("login"), login));
        return session.createQuery(criteriaQuery).getSingleResult();
    }

    public long insertUserProfile(String login, String password) throws HibernateException {
        return (Long) session.save(new UserProfile(login, password));
    }
}
