package com.SmallChange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSysOOP {
    String details = "----------------Small Change Detail----------------\n";
    boolean loop = true;
    Scanner sc = new Scanner(System.in);
    String choice = "";
    double money = 0;
    double balance = 0;
    Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    String spendName = "";
    public void showMenu() {
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
                    this.details();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.spend();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("invalide choice");
            }
        } while(loop);
    }
    public void details() {
        System.out.println(details);
    }
    public void income() {
        System.out.print("Amount of income: ");
        money = sc.nextDouble();
        if(money < 0) {
            System.out.println("invalid amount");
            return;
        }
        balance += money;
        date = new Date();
        details += "\nIncome\t+" + money + "\t" + sdf.format(date) + "\t" + balance;
    }
    public void spend() {
        System.out.print("name of spenditure: ");
        spendName = sc.next();
        System.out.print("amount of spenditure: ");
        money = sc.nextDouble();
        if(money < 0 || money > balance) {
            System.out.println("invalide amount");
            return;
        }
        balance -= money;
        date = new Date();
        details += "\n" + spendName + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
    }
    public void exit() {
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
    }
}
