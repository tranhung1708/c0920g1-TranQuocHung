package Test4;

public class Women extends Human {
    private String housewife;
    private String washingClothes;
    protected String pickUpYourBaby;
    @Override
    public void show() {
        System.out.println(this.toString());
    }


    public Women() {
    }

    public Women(String name, String yearOld, String address, String phoneNumber, String identityCard, String job) {
        super(name, yearOld, address, phoneNumber, identityCard, job);
    }

    public Women(String housewife, String washingClothes, String pickUpYourBaby) {
        this.housewife = housewife;
        this.washingClothes = washingClothes;
        this.pickUpYourBaby = pickUpYourBaby;
    }

    public Women(String name, String yearOld, String address, String phoneNumber, String identityCard, String job, String housewife, String washingClothes, String pickUpYourBaby) {
        super(name, yearOld, address, phoneNumber, identityCard, job);
        this.housewife = housewife;
        this.washingClothes = washingClothes;
        this.pickUpYourBaby = pickUpYourBaby;
    }

    public String getHousewife() {
        return housewife;
    }

    public void setHousewife(String housewife) {
        this.housewife = housewife;
    }

    public String getWashingClothes() {
        return washingClothes;
    }

    public void setWashingClothes(String washingClothes) {
        this.washingClothes = washingClothes;
    }

    public String getPickUpYourBaby() {
        return pickUpYourBaby;
    }

    public void setPickUpYourBaby(String pickUpYourBaby) {
        this.pickUpYourBaby = pickUpYourBaby;
    }

    @Override
    public String toString() {
        return "Women{" + super.toString()+
                "housewife='" + housewife + '\'' +
                ", washingClothes='" + washingClothes + '\'' +
                ", pickUpYourBaby='" + pickUpYourBaby + '\'' +
                '}';
    }
}
