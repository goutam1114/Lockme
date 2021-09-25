package Lockme;

import java.util.Scanner;

public class userOperations {
	public static void Operations(String UserId) {
		System.out.println("Hello " + UserId + "!");
		
		int c = 1;
		try {
		while (c == 1) {
			System.out.println("Please Select Operation You Want to Perform");

			System.out.println("1.Store credentilas\n2.Retrieve Credentilas\n3.Delete Credenilas");
			Scanner S = new Scanner(System.in);
			
				int ch = S.nextInt();
			
			
			

			switch (ch) {
			case 1:
				Credentials.getcred(UserId);
				break;
			case 2:
				Credentials.fetchcred(UserId);
				break;
			case 3:
				Credentials.deleteCreds(UserId);
				break;

			}
			System.out.println("Do you want to continue 1-YES 2-NO");
			c=S.nextInt();
			if(c==2) {
				System.exit(0);
			}
			
		}
		}
		catch(Exception e) {
			System.out.println("ENTER VALID CHOICE " );
			//Operations(UserId);
			//e.printStackTrace();
			
			
		}
	}

}
