package hotel.kealifornia.demo.models;

public class Guest {

    private int guestId;
    private String name;
    private String phoneNo;
    private String email;
    private int awardPoints;

    public Guest() {
    }

    public Guest(int guestId, String name, String phoneNo, String email, int awardPoints) {
        this.guestId = guestId;
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
        this.awardPoints = awardPoints;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAwardPoints() {
        return awardPoints;
    }

    public void setAwardPoints(int awardPoints) {
        this.awardPoints = awardPoints;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "guestId=" + guestId +
                ", name='" + name + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                ", awardPoints=" + awardPoints +
                '}';
    }
}
