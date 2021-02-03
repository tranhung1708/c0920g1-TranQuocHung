let name = document.getElementById("name");
let email = document.getElementById('email');
let phone = document.getElementById('phone');
let Gender = document.getElementById('Gender');
let lever = document.getElementById('lever');
let Id = document.getElementById('Id');
let Date = document.getElementById('Date');
let Location = document.getElementById('Location');
let Salary = document.getElementById('Salary');
let Datebook = document.getElementById('Datebook');
let rental = document.getElementById('rental');
let number = document.getElementById('number');
let discount = document.getElementById('discount');

function submitForm() {
    console.log(phone)
    document.getElementById("displayName").innerText = name.value ;
    document.getElementById("displayEmail").innerText = email.value;
    document.getElementById("displayPhone").innerText = phone.value;
    document.getElementById("displayGender").innerText = Gender.value;
    document.getElementById("displayLever").innerText = lever.value;
    document.getElementById("displayId").innerText = Id.value;
    document.getElementById("displayDate").innerText = Date.value;
    document.getElementById("displayLocation").innerText = Location.value;
    document.getElementById("displaySalary").innerText = Salary.value;
    document.getElementById("displayDatebook").innerText =Datebook.value;
    document.getElementById("displayRental").innerText = 'Price to be paid: '+ rental.value;
    document.getElementById('displayNumber').innerText = 'Total rental days:' + number.value;
    document.getElementById('displaydiscount').innerText = 'Reduction:' + discount.value;

  let  result = rental.value * number.value * (1 - discount.value / 100);
    document.getElementById('displayResult').innerHTML = 'Số tiền phải trả: ' + result  ;
}