package session_4;

import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.util.Scanner;

public class VeHinhChuNhat {
    public static class Rectangle{
        double height ,weight ;
        public Rectangle(){
        }
        public Rectangle(double weight , double height){
            this.weight = weight;
            this.height = height;
        }
        public double getArea(){
            return  this.weight * this.height;
        }
        public double getPerimeter(){
            return (this.weight + this.height)*2;
        }
        public String display(){
            return "rectangle{" + "weight" + weight +",height = " + height + "}";
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the weight");
        double weight = scanner.nextDouble();
        System.out.println("enter the height");
        double height =scanner.nextDouble();
        Rectangle rectangle = new Rectangle(weight,height);
        System.out.println("Hình chữ nhật của bạn"+rectangle.display());
        System.out.println("Chu vi của hình chữ nhật"+rectangle.getPerimeter());
        System.out.println("Diện tích hình chữ nhật"+rectangle.getArea());
    }

}
