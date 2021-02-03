package Test4;

public class Man extends Human {
    private String driver;
    private String howToMakeMoney;
    private String playWithChildren;

    @Override
    public void show() {
        System.out.println(this.toString());
    }

    public Man() {
    }

    public Man(String name, String yearOld, String address, String phoneNumber, String identityCard, String job) {
        super(name, yearOld, address, phoneNumber, identityCard, job);
    }

    public Man(String driver, String goMakeMoney, String playWithChildren) {
        this.driver = driver;
        this.howToMakeMoney = goMakeMoney;
        this.playWithChildren = playWithChildren;
    }

    public Man(String name, String yearOld, String address, String phoneNumber, String identityCard, String job, String driver, String goMakeMoney, String playWithChildren) {
        super(name, yearOld, address, phoneNumber, identityCard, job);
        this.driver = driver;
        this.howToMakeMoney = goMakeMoney;
        this.playWithChildren = playWithChildren;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getHowToMakeMoney() {
        return howToMakeMoney;
    }

    public void setHowToMakeMoney(String howToMakeMoney) {
        this.howToMakeMoney = howToMakeMoney;
    }

    public String getPlayWithChildren() {
        return playWithChildren;
    }

    public void setPlayWithChildren(String playWithChildren) {
        this.playWithChildren = playWithChildren;
    }

    @Override
    public String toString() {
        return "Man{" + super.toString() +
                "driver='" + driver + '\'' +
                ", goMakeMoney='" + howToMakeMoney + '\'' +
                ", playWithChildren='" + playWithChildren + '\'' +
                '}';
    }
}
