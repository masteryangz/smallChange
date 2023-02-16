package com.SmallChange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class smallChangeSys {
    public static void main(String[] args) {
        String details = "----------------Small Change Detail----------------\n";
        boolean loop = true;
        Scanner sc = new Scanner(System.in);
        String choice = "";
        double money = 0;
        double balance = 0;
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String spendName = "";
        do {
            System.out.println("-----------------Small Change Menu-----------------");
            System.out.println("\t1 Detail    ");
            System.out.println("\t2 Income    ");
            System.out.println("\t3 spenditure");
            System.out.println("\t4 exit      ");
            System.out.print("select(1-4): ");
            choice = sc.next();
            switch (choice) {
                case "1":
                    System.out.println(details);
                    break;
                case "2":
                    System.out.print("Amount of income: ");
                    money = sc.nextDouble();
                    if(money < 0) {
                        System.out.println("invalid amount");
                        break;
                    }
                    balance += money;
                    date = new Date();
                    details += "\nIncome\t+" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "3":
                    System.out.print("name of spenditure: ");
                    spendName = sc.next();
                    System.out.print("amount of spenditure: ");
                    money = sc.nextDouble();
                    if(money < 0 || money > balance) {
                        System.out.println("invalide amount");
                        break;
                    }
                    balance -= money;
                    date = new Date();
                    details += "\n" + spendName + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "4":
                    String yorn = "";
                    while(true) {
                        System.out.println("exit?(y/n)");
                        yorn = sc.next();
                        if("y".equals(yorn) || "n".equals(yorn)) {
                            break;
                        }
                    }
                    if("y".equals(yorn)) {
                        loop = false;
                    } 
                    break;
                default:
                    System.out.println("invalide choice");
            }
        } while(loop);
        System.out.println("-----------------Exit Small Change-----------------");
        sc.close();
    }
}
