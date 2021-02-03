class Customer {
    constructor(name, cmnd, birthday, email, address, typeService, typeRoom, typeCustomer, discount, quantityIncluded, rentDays) {
        this.name = name;
        this.cmnd = cmnd;
        this.birthday = birthday;
        this.email = email;
        this.address = address;
        this.typeService = typeService;
        this.typeRoom = typeRoom;
        this.typeCustomer = typeCustomer;
        this.discount = discount;
        this.quantityIncluded = quantityIncluded;
        this.rentDays = rentDays;
    };
    getName() {
        return this.name;
    }
    getCmnd() {
        return this.cmnd;
    }
    getBirthday() {
        return this.birthday;
    }
    getEmail() {
        return this.email;
    }
    getAddress() {
        return this.address;
    }
    getTypeService() {
        return this.typeService;
    }
    getTypeRoom() {
        return this.typeRoom;
    }
    getTypeCustomer() {
        return this.typeCustomer;
    }
    getDiscount() {
        return this.discount;
    }
    getQuantityIncluded() {
        return this.quantityIncluded;
    }
    getRentdays() {
        return this.rentDays;
    }
    getTotalPays() {
        let money = 0;
        if (this.typeService === "Villa") {
            money = 500;
        } else if (this.typeService === "House") {
            money = 300;
        } else if (this.typeService === "Room") {
            money = 200;
        }
        return this.rentdays * money*(1- this.discount / 100)  ;
    }
    setName(name) {
        return this.name = name;
    }
    setCmnd(cmnd) {
        return this.cmnd = cmnd;
    }
    setEmail(email){
        return this.email = email;
    }
    setAddress(address) {
        return this.address = address;
    }
    setTypeService(typeService) {
        return this.typeService = typeService;
    }
    setTypeRoom(typeRoom) {
        return this.typeRoom = typeRoom;
    }
    setTypeCustomer(typeCustomer) {
        return this.typeCustomer = typeCustomer;
    }
    setDiscount(discount) {
        return this.discount = discount;
    }
    setQuantityIncluded(quantityIncluded) {
        return this.quantityIncluded = quantityIncluded;
    }
    setRentdays(rentdays) {
        return this.rentdays = rentdays;
    }
    setBirthday(birthday){
        return this.birthday = birthday;
    }
}