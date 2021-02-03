package session_5;

public class Default1 {
    //default chỉ có thể truy cập trong package
//    package pack;

    static class A{

        void msg(){System.out.println("Hello");}

    }



//save by B.java

//package mypack;
//
//import pack.*;

    static class B{

        public static void main(String args[]){

            A obj = new A();//Compile Time Error

            obj.msg();//Compile Time Error

        }

    }
}
