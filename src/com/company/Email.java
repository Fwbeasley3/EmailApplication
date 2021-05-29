package com.company;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private int defaultPasswordLength = 10;
    private String companySuffix = "aeycompany.com";

    // Constructor to receive the first and last name
    public Email (String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        // Call a method asking for the department - return the department
        this.department = setDepartment();

        // Call a method to generate a random password
        this.password = randPassword(defaultPasswordLength);
        System.out.println("Your password is " + this.password);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toUpperCase() + "@" + department + "." + companySuffix;

    }

    //Ask for the department
    private String setDepartment() {
        System.out.println("New employee: " + firstName + ". DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n4 for none\n Enter Department Code");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();

        switch (depChoice) {
            case 1:
                return "Sales";
            case 2:
                return "Development";
            case 3:
                return "Accounting";
            default:
                return "";
        }

    }

    private String randPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@345";
        char[] password = new char[length];

        for (int i =0; i < length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    //Set the alternate email
    public void setAlternateEmail (String altEmail) {
        this.alternateEmail = altEmail;
    }

    //Change the password
    public void changePassword (String password){
        this.password = password;
    }

    public int getMailboxCapacity () {
        return mailboxCapacity;
    }

    public String getAlternateEmail () {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo (){
        return "DISPLAY NAME: " + firstName + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }


}
