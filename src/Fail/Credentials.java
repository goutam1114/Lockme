package Fail;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Credentials implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String Domain;
	public String UserName;
	public String Password;

	public Credentials(String domain, String userName, String password) {
		super();
		Domain = domain;
		UserName = userName;
		Password = password;
	}

	@Override
	public String toString() {
		return "Credenials [Domain=" + Domain + ", UserName=" + UserName + ", Password=" + Password + "]";
	}

	public String getDomain() {
		return Domain;
	}

	public void setDomain(String domain) {
		Domain = domain;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Credentials() {
		super();
	}

	public static void getcred(String UserId) {
		System.out.println("Enter Domain Name");
		Scanner s = new Scanner(System.in);
		String domainName = s.next();
		System.out.println("Enter UserName of the " + domainName);
		String UserName = s.next();
		System.out.println("Enter Password of the " + domainName);
		String password = s.next();
		Credentials c = new Credentials(domainName, UserName, password);
		try {
			FileOutputStream file = new FileOutputStream(UserId + "." + domainName + ".txt");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(c);
			out.close();
			file.close();

		} catch (FileNotFoundException e) {
			System.out.println("No Data Found");
		} catch (IOException e) {
		}

	      try {
	          String data = domainName;
	          File f1 = new File(UserId+"creds.txt");
	          if(!f1.exists()) {
	             f1.createNewFile();
	          }

	          FileWriter fileWritter = new FileWriter(f1.getName(),true);
	          BufferedWriter bw = new BufferedWriter(fileWritter);
	          bw.write(data);
	          bw.write(" ");
	          bw.close();
	          System.out.println("Done");
	       } catch(IOException e){
	          e.printStackTrace();
	       }
	    }

	

	public static void fetchcred(String UserId) {
		System.out.println("==========================================");
		System.out.println("*					*");
		System.out.println("*   WELCOME TO DIGITAL LOCKER 	 *");
		System.out.println("*					*");
		System.out.println("==========================================");
		System.out.println("*   YOUR CREDS ARE 	 *");

		creds(UserId);

	}

	public static void creds(String UserId) {
		try (BufferedReader br = new BufferedReader(new FileReader(UserId+"creds.txt"))) {
			   String line= br.readLine() ;
			   String[] cred=line.split("\\s");
			   for (int i = 0; i < cred.length; i++) {
				   System.out.println((i+1)+"."+cred[i]);
				
			}
			   
			   
			
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter the Domain ");
			int dn = sc.nextInt();

			try {
				FileInputStream file = new FileInputStream(UserId + "." +cred[dn-1]  + ".txt");
				ObjectInputStream out = new ObjectInputStream(file);
				Credentials c = (Credentials) out.readObject();
				out.close();
				file.close();
				System.out.println("Domain Name Is :" + c.Domain);
				System.out.println("User Name Of " + c.Domain + " Is: " + c.UserName);
				System.out.println("Password of  " + c.Domain + " Is: " + c.Password);

			} catch (FileNotFoundException e) {
				System.out.println("No data available");
			} catch (IOException e) {
				System.out.println("No data available");
			} catch (ClassNotFoundException e) {
				System.out.println("No data available");
			}}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
			
			
		
	
	}

	public static void deleteCreds(String UserId) {
		try {
		try (BufferedReader br = new BufferedReader(new FileReader(UserId+"creds.txt"))) {
			String line = br.readLine();
			String[] creds = line.split("\\s");
			for (int i = 0; i < creds.length; i++) {

				System.out.println((i + 1) + "." + creds[i]);
			}
			System.out.println("Enter the domain you want to delete");
			Scanner sc = new Scanner(System.in);
			int dn = sc.nextInt();
			File f = new File(UserId + "." + creds[dn-1] + ".txt");
			boolean x = f.delete();
			if (x) {
				System.out.println("deleted " + creds[dn-1]);
			} else {
				System.out.println("Can't delete " + creds[dn-1]);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		catch(Exception e) {
			System.out.println("Enter valid choice");
			deleteCreds(UserId);
			
		}

	}

}
