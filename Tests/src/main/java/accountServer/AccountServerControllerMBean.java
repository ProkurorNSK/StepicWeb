package accountServer;

public interface AccountServerControllerMBean {
    public int getUsers();

    public int getUsersLimit();

    public void setUsersLimit(int usersLimit);
}
