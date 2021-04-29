package com.company;

import java.util.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static MobilePhone mphone = new MobilePhone("343 456 6544");


    public static void main(String[] args) {

        boolean quit = false;

        startPhone();
        printActions();


        int option = 0;

        while(!quit){
            System.out.print("Please select an option");
            option = scanner.nextInt();
            scanner.nextLine();

            switch(option){
                case 0:
                    System.out.println("\n Shutting down");
                    quit = true;
                    break;
                case 1:
                    mphone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }

        }
    }

    private static void startPhone(){

        System.out.println("Starting phone......");
    }

    private static void addNewContact(){
        System.out.println("Enter new contacts name: ");
        String name = scanner.nextLine();
        System.out.println("Enter new phone number: ");
        String phone = scanner.nextLine();
        Contacts newContact = Contacts.createContact(name, phone);
        if(mphone.addNewContact(newContact)){
            System.out.println("New Contact added "+ name +" ,phone = " + phone);
        }else{
            System.out.println("Cannot add, " + name + " already on file");
        }
    }

    private static void updateContact(){
        System.out.println("Enter existing contact name ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mphone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("Contact not found. ");
            return;
        }
        System.out.print("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new number: ");
        String newPhoneNumber = scanner.nextLine();
        Contacts newContact = Contacts.createContact(newName, newPhoneNumber);
        if(mphone.updateContact(existingContactRecord, newContact)){
            System.out.println("Successfully updated record");
        }else{
            System.out.println("Error updating record");
        }
    }

    private static void removeContact() {
        System.out.println("Enter existing contact name ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mphone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found. ");
            return;
        }
        if(mphone.removeContact(existingContactRecord)){
            System.out.println("Successfully removed");
        }else{
            System.out.println("Error deleting contact");
        }
    }

    private static void queryContact(){
        System.out.println("Enter existing contact name ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mphone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found. ");
            return;
        }
        System.out.println("Name: " + existingContactRecord.getName() + " phone number is " + existingContactRecord.getPhoneNumber());


    }

    private static void printActions(){
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - to shutdown\n" +
                "1 - to print Contacts\n" +
                "2 - add a new contact\n" +
                "3 - update an existing contact\n" +
                "4 - remove an existing contact\n" +
                "5 - query an existing contact\n" +
                "6 - List all actions\n");

        System.out.println("Choose your action: ");
    }









}
