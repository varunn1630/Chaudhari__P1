// Name: Varun Chaudhari
// UCF ID: 4831096

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover {
   private Set<String> uniqueWords;
   //This method will take the file name as input and remove the duplicate words using the Set

   public void remove(String dataFile) throws FileNotFoundException
   {
       String word;
       uniqueWords = new HashSet<String>();
       Scanner sc=new Scanner(new File(dataFile));
       while(sc.hasNext())
       {
           word=sc.next();
           uniqueWords.add(word);
       }
       sc.close();
   }

   //This method will write the contents of Set to the ouytput file
   public void Write(String outputFile) throws IOException
   {
File f;
FileWriter fw = null;

f = new File(outputFile);
//If file already exists then write data to the existing file
if(f.exists()) {
fw=new FileWriter(f,true);
Iterator itr=uniqueWords.iterator();

while(itr.hasNext())
{
   String str=(String)itr.next();
   fw.write(str+"\n");
}
fw.close();
System.out.println("Data Written to File");
}

else
{
//If no file already exists, create a new File

f.createNewFile();
fw=new FileWriter(f);
Iterator itr=uniqueWords.iterator();

while(itr.hasNext())
{
   String str=(String)itr.next();
   fw.write(str+"\n");
}
fw.close();
System.out.println("Data Written to File");
}

   }

}
// ----------------------------------------------

// Application.java

import java.io.FileNotFoundException;
import java.io.IOException;

public class Application {

   public static void main(String[] args) throws IOException {
       DuplicateRemover d=new DuplicateRemover();
       d.remove("problem1.txt");
       d.Write("unique_words.txt");
   }
}
