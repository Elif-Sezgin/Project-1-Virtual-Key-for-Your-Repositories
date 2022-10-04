package ManagementSystem;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;
class ManagementSystem{
private static final String[] FileNames = null;
public String Path;
public String IPath;
public String getPath() {
return Path;
}
public String getIPath() {
return IPath;
}
public void setPath(String path) {
Path = path;
}
public void setIPath(String Ipath) {
IPath = Ipath;
}
void SetWorkingDirectoryPath() {
System.out.print("\nPlease enter the directory path: ");
Scanner sc = new Scanner(System.in);
String p = sc.nextLine();
if(Pattern.matches("((\\/)+|(\\\\)+)", p)) {
System.out.println("\nPlease provide the absolute path.");
SetWorkingDirectoryPath();
}
else {
if(new File(p).exists() && new File(p).isDirectory()) {
setPath(p);
setIPath(p);
}else {
System.out.println("\nInvalid directory path is provided.");
SetWorkingDirectoryPath();
}
}
}

public void DisplayFilesInAscendingOrder(String FilePath) {
try {
	File f=new File(FilePath);
	File files[]=f.listFiles();
	for(File fileEntry:files)
	{
		System.out.println(fileEntry.getName());
	}
}
catch (Exception e) {
	e.printStackTrace();
}
}
boolean AddFile(String FileName, String FilePath) {
System.out.println("***Creating File: "+ FileName + " ***");
try {
File nFile = new File(FilePath+"//"+FileName);
if(!nFile.exists()) {
if(nFile.createNewFile()) {
System.out.println( FileName + " succesfully created");
return true;
}else {
System.out.println("Unable to create a "+ FileName +" .Please try again.");
return GetAddFileNameDetails(FilePath);
}
}else {
System.out.println("File with the name " + FileName + " already existin the directory. Try again with different name.");
return GetAddFileNameDetails(FilePath);
}
}
catch (IOException e){
	
return false;
}
}
boolean GetAddFileNameDetails(String FilePath) {
System.out.print("Name of the new file:");
Scanner sc = new Scanner(System.in);
String FileName = sc.next();
return AddFile(FileName, FilePath);
}

	void DeletionList() {
	System.out.println("======= [ Select the number of file to delete] ======");
	File folder = new File(getIPath());
	int numFiles = folder.list().length;
	if(numFiles < 1) {
	System.out.println("File is empty");
	}
	String[] FileNames = new String[numFiles+1];
	int i=0;
	for (File fileEntry : folder.listFiles()) {
	if (!fileEntry.isDirectory()) {
	i++;
	FileNames[i] = fileEntry.getName();
	System.out.println("["+ i +"] " + fileEntry.getName());
	}
	}
	}

	
	public void DeleteFilegece(String FileName, String FilePath) {
		
		String Filename;
	      Scanner scan = new Scanner(System.in);
	      
	      System.out.print("Enter the Name of File to Delete: ");
	      Filename = scan.nextLine();
	      
	      
	      File myfile = new File(FilePath + "\\" + Filename);
	      
	      if(myfile.delete())
	         System.out.println("\nThe file is deleted successfully!");
	      else
	         System.out.println("\nFile Not Found");
	}
				
	public void searchFile(String FileName, String FilePath) {
		String Filename;
	      Scanner scan = new Scanner(System.in);
	      System.out.print("Enter the Name of File to Delete: ");
	      Filename = scan.nextLine();
		boolean isExisted=false;
		try {
			File f = new File(FilePath);
			File files[] = f.listFiles();
			for (File fileEntry : files) {
				if (fileEntry.isFile()) {
					if(fileEntry.getName().equals(Filename))
						isExisted=true;
				}
			}
			if(isExisted)
				System.out.println("File is existed");
			else
				System.out.println("File is not existed in the directory");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void exitpage() {
		System.out.print("EXIT");
	}
	
public void initialize() {
	System.out.println("⭐⭐⭐  Main Menu Options ⭐⭐⭐");
	System.out.println("1. Display the files in the directory in ascending order");
	System.out.println("2. Edit the directory ");
	System.out.println("3. Exit from the application");

/* Set Directory */
SetWorkingDirectoryPath();
}
public void firstoption() {
/* Main Menu */
DisplayFilesInAscendingOrder(IPath);
}
public void addfileoption() {
	GetAddFileNameDetails(IPath);
	AddFile(IPath, IPath);
}
public void removefileoption() {
	DeletionList();
	DeleteFilegece(IPath, IPath);

}
public void searchoption() {
	searchFile(IPath, IPath);
	
}
public void exit() {
	exitpage();
}

}

	
