package Fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class operation {

	public static void main(String[] args) {

		int c = 1;
		System.out.println("==========================================");
		System.out.println("*					*");
		System.out.println("*     Welcome To LockMe.com		*");
		System.out.println("* A Personal Digital Locker For You*");
		System.out.println("*					*");
		System.out.println("==========================================");
		base();

	}

	public static void base() {
		int c = 1;
		try {

			Scanner sc = new Scanner(System.in);

			int choice = welcome();

			while (c == 1) {
				switch (choice) {
				case 1:
					register();
					System.out.println("Do you Want to Login 1-YES 2-NO");
					int g = sc.nextInt();
					if (g == 1) {
						choice = 2;
					} else {
						c = 2;

					}

					break;
				case 2:
					login();
					break;
				default:
					System.out.println("Enter Valid Option");
					choice = welcome();
					break;

				}
				System.out.println("To Coninue Press 1 ,To Exit Press 1");
				c = sc.nextInt();
			}
		} catch (Exception e) {
			System.out.println("ENTER VALID CHOICE");
			base();

		}

	}

	public static int welcome() {
		System.out.println("1.Registration\n2.Login");
		System.out.println("Enter your Choice");

		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		return choice;

	}

	public static void register() {
		System.out.println("==========================================");
		System.out.println("*					*");
		System.out.println("*   WELCOME TO REGISTRATION PAGE	*");
		System.out.println("*					*");
		System.out.println("==========================================");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your UserId");
		String UserId = sc.next();

		System.out.println("Enter Password");
		String pwd = sc.next();
		System.out.println("Enter email");
		String email = sc.next();
		details d = new details(UserId, pwd, email);

		try {
			FileOutputStream file1 = new FileOutputStream(UserId + ".txt");

			ObjectOutputStream out = new ObjectOutputStream(file1);
			out.writeObject(d);
			out.close();
			file1.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void login() {
		System.out.println("==========================================");
		System.out.println("*					*");
		System.out.println("*   WELCOME TO LOGIN PAGE	 *");
		System.out.println("*					*");
		System.out.println("==========================================");
		Scanner sc = new Scanner(System.in);
		FileInputStream file1;
		try {
			System.out.println("Enter your UserId");
			String UserId1 = sc.next();

			file1 = new FileInputStream(UserId1 + ".txt");
			ObjectInputStream out = new ObjectInputStream(file1);
			details e = (details) out.readObject();
			out.close();
			file1.close();

			System.out.println("Enter Password");
			String pwd1 = sc.next();
			if (pwd1.equals(e.Password)) {

				userOperations.Operations(e.userId);
			} else {
				System.out.println("Wrong Password");
			}

		} catch (java.io.FileNotFoundException e1) {
			System.out.println("Not  a Registered User ");

		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
