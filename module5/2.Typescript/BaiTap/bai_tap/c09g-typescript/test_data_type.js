function sum(a, b) {
    return a + b;
}
console.log(sum(2, 10));
var studentTuple = [1, 'Nguyen Van A', '04/02/2021'];
var studentInterface = {
    id: 1,
    name: "Nguyen Van A",
    date_of_birth: "04/02/2021"
};
var Student = /** @class */ (function () {
    function Student(id, name, date_of_birth) {
        this.id = id;
        this.name = name;
        this.date_of_birth = date_of_birth;
    }
    return Student;
}());
var studentClass = new Student(1, "Nguyen Van A", "04/02/2021");
console.log("Tuple");
console.log(studentTuple);
console.log("Interface");
console.log(studentInterface);
console.log("Class");
console.log(studentClass);
