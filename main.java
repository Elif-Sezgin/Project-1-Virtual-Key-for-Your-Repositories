package ManagementSystem;
import java.util.Scanner;
public class main {
public static void main(String[] args) {
// TODO Auto-generated method stub
System.out.println("---------------------------------------------------------");
System.out.println("Welcome to Prototype of the Application of LockedMe.com");
System.out.println("Application Name : Virtual Key for Your Repositories");
System.out.println("Application Developer : Elif Sezgin");
System.out.println("---------------------------------------------------------");



ManagementSystem m = new ManagementSystem();


m.initialize();
System.out.println("Please enter the number of the main menu option you would like to go with from the main menu options:   ");
Scanner sc = new Scanner(System.in);
int ch, ch1, ch2;
ch = sc.nextInt();
switch(ch) {
case 1: 
	m.firstoption();
	do
	{
		System.out.println("\nContinue options: ");
		System.out.println("1. Enter directory and continue with the main menu");
		System.out.println("2. Exit from the application");
		ch2 = sc.nextInt();
		switch (ch2) {
		
		case 1:
			m.initialize();
		break;
		case 2:
			m.exit();
		break;
		}
		
	}while( ch2 < 2);
	break;
	
	
case 2: 
	do
	{
	System.out.println("Edit Options:");
	System.out.println("1. Add file to the directory");
	System.out.println("2. Remove file from the directory");
	System.out.println("3. Search a file in the directory");
	System.out.println("4. Select new directory and continue with the main menu");
	System.out.println("5. Exit from the application");
	System.out.println("Please enter the number of the edit option you would like to go with:   ");
	ch1 = sc.nextInt();
	switch (ch1) {
	case 1:
		m.addfileoption();
	break;
	case 2:
		m.removefileoption();
	break;
	case 3:
		m.searchoption();
	break;
	case 4:
		m.initialize();
	break;
	case 5:
		m.exit();
	break;
	}
	
}while( ch1 < 5);
break;
case 3: 
	m.exit();
	break;
} 
}
}









