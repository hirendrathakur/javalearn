package powermockito;

public class CustomerDao {

    public boolean exists(long phoneNumber) {
        return true;
    }

    public boolean save(Customer customer) {
        return false;
    }
}
