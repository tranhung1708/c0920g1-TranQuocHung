 class Employee {
     constructor(name,birthday,cmnd,numberphone,email,lever,position) {
         this.name = name;
         this.birthday = birthday;
         this.cmnd = cmnd ;
         this.numberphone = numberphone;
         this.email = email;
         this.lever = lever;
         this.position = position;
     };
     getName (){
         return this.name;
     }
     getBirthday(){
         return this.birthday;
     }
     getCmnd(){
         return this.cmnd;
     }
     getNumberphone(){
         return this.numberphone;
     }
     getEmail(){
         return this.email
     }
     getLever(){
         return this.lever;
     }
     getPosition(){
         return this.position;
     }
     getSalary(){
         if(this.position === "manager"){
             this.salary = 500;
         }else if (this.position === "sale"){
             this.salary = 300;
         }else if (this.position === "marketing"){
             this.salary = 200;
         }
         return this.salary;
     }
     setName(name){
        return this.name = name;
     }
     setBirthday(birthday){
         return this.birthday = birthday;
     }
     setCmnd(cmnd){
         return this.cmnd = cmnd;
     }
     setNumberphone(numberphone){
         return this.numberphone = numberphone;
     }
     setEmail(email){
         return this.email = email;
     }
     setLever(lever){
         return this.lever = lever;
     }
     setPosition(position){
         return this.position = position;
     }

 }