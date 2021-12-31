package com.greatlearning.driver;

import com.greatlearning.service.Stockers;
import java.util.*;

public class Main {
	static void sortAscending(ArrayList<Stockers> stocks){
        Collections.sort(stocks, new Comparator<Stockers>() {
            @Override
            public int compare(Stockers s1, Stockers s2) {
                if (s1.getPrice() > s2.getPrice())
                    return 1;
                if (s1.getPrice() < s2.getPrice())
                    return -1;
                return 0;
            }
        });
        for (Stockers stockers : stocks) {
            System.out.print(stockers.getPrice()+" ");
        }
        System.out.println();
    }
    static void sortDescending(ArrayList<Stockers> stocks){
        Collections.sort(stocks, new Comparator<Stockers>() {
            @Override
            public int compare(Stockers s1, Stockers s2) {
                if (s1.getPrice() < s2.getPrice())
                    return 1;
                if (s1.getPrice() > s2.getPrice())
                    return -1;
                return 0;
            }
        });
        for (Stockers stockers : stocks) {
            System.out.print(stockers.getPrice()+" ");
        }
        System.out.println();
    }
    static void displayRise(ArrayList<Stockers> stocks){
        int c=0;
        for (Stockers stockers : stocks) {
            if(stockers.getRise()==true)
                c++;
        }   
        System.out.println(c);
    }
    static void displayDecline(ArrayList<Stockers> stocks){
        int c=0;
        for (Stockers stockers : stocks) {
            if(stockers.getRise()==false)
                c++;
        }   
        System.out.println(c);
    }
    static void search(ArrayList<Stockers> stocks,double price){
        boolean found = false;
        for (Stockers stockers : stocks) {
            if(stockers.getPrice()==price)
            {
                found=true;
                break;   
            }
        }  
        if(found){
            System.out.println("Stock of value "+price+" is present");
        }else{
            System.out.println("Value not found");   
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the no of companies");
        int n=sc.nextInt();
        ArrayList<Stockers> stocks=new ArrayList<>(n);
        for(int i=0;i<n;i++){
            System.out.println("Enter current stock price of the company "+(i+1));
            double price=sc.nextDouble();
            System.out.println("Whether company's stock price rose today compare to yesterday?");
            boolean rise=sc.nextBoolean();
            stocks.add(new Stockers(price, rise));
        }
        System.out.println("\n-----------------------------------------------");
        while(true){
            Boolean exit=false;
            System.out.println("Enter the operation that you want to perform\n1. Display the companies stock prices in ascending order\n2. Display the companies stock prices in descending order\n3. Display the total no of companies for which stock prices rose today\n4. Display the total no of companies for which stock prices declined today\n5. Search a specific stock price\n6. press 0 to exit\n-----------------------------------------------");
            int c=sc.nextInt();
            switch(c){
                case 1:{
                    System.out.println("Stock prices in ascending order are :");
                    sortAscending(stocks);
                    System.out.println("\n-----------------------------------------------");
                    break;
                }
                case 2:{
                    System.out.println("Stock prices in descending order are :");
                    sortDescending(stocks);
                    System.out.println("\n-----------------------------------------------");
                    break;
                }
                case 3:{
                    System.out.println("Total no of companies whose stock price rose today : ");
                    displayRise(stocks);
                    System.out.println("\n-----------------------------------------------");
                    break;
                }
                case 4:{
                    System.out.println("Total no of companies whose stock price declined today : ");
                    displayDecline(stocks);
                    System.out.println("\n-----------------------------------------------");
                    break;
                }
                case 5:{
                    System.out.println("enter the key value");
                    search(stocks,sc.nextDouble());
                    System.out.println("\n-----------------------------------------------");
                    break;
                }
                case 0:{
                    exit=true;
                    System.out.println("Exited successfully");
                    break;
                }
                default:{
                    System.out.println("Error!!\nWrong Choice");
                    System.out.println("\n-----------------------------------------------");
                    break;
                }
            }
            if(exit) break;
        }  
        sc.close();
    }
}
