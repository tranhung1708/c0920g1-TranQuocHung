package Test4;

public abstract class Human {
    protected String name;
    protected String yearOld;
    protected String address;
    protected String phoneNumber;
    protected String identityCard;
    protected String job;

    public abstract void show();

    public Human() {
    }

    public Human(String name, String yearOld, String address,
                 String phoneNumber, String identityCard, String job) {
        this.name = name;
        this.yearOld = yearOld;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.identityCard = identityCard;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearOld() {
        return yearOld;
    }

    public void setYearOld(String yearOld) {
        this.yearOld = yearOld;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", yearOld='" + yearOld + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", identityCard='" + identityCard + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
