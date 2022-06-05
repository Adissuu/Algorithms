import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

// ---------------------------------------
// COMP 352
// Assignment 2
// Written By: Ali Fetanat (40158208), Gabriel Dubois (40209252)
// Due June 5, 2022
// ---------------------------------------
@SuppressWarnings("all")
//Driver class to test all 4 implementation of priority queue
public class PQTester {
  //String builder used for creating the result table
  static StringBuilder Print= new StringBuilder();


  //Method to measure the time and performance of each one of the implementaions
  static void measureTime(int nValue, MyPQSortedArray<Integer, String> Sortedarr, MyPQUnsortedArray<Integer, String> Unsortedarr, 
  MyPQSortedLinkedList<Integer, String> Sortedlist, MyPQUnsortedLinkedList<Integer, String> Unsortedlist){

    //Declaring variables for run time
    long sortedarrinsert, sortedarrremove
    ,unsortedarrinsert, unsortedarrremove, sortedlistinsert,
    sortedlistremove, unsortedlistinsert, unsortedlistremove;

    //Defining booleans for inserting to specific file
    boolean file1used = false;
    boolean file2used = false;
    boolean file3used = false;

    //Declaring string for the value
    String content = null;

    //Declaring scanner for reading from the files
    Scanner sortedArr_file1 = null;
    Scanner sortedArr_file2 = null;
    Scanner sortedArr_file3 = null;
    Scanner unsortedArr_file1 = null;
    Scanner unsortedArr_file2 = null;
    Scanner unsortedArr_file3 = null;
    Scanner sortedlist_file1 = null;
    Scanner sortedlist_file2 = null;
    Scanner sortedlist_file3 = null;
    Scanner unsortedlist_file1 = null;
    Scanner unsortedlist_file2 = null;
    Scanner unsortedlist_file3 = null;

    //Based on the value, it's being decide which file to use
    if(nValue<= 10000){
      try{
        sortedArr_file1 = new Scanner(new File("elements_test_file1.txt"));
        unsortedArr_file1 = new Scanner(new File("elements_test_file1.txt"));
        sortedlist_file1 = new Scanner(new File("elements_test_file1.txt"));
        unsortedlist_file1 = new Scanner(new File("elements_test_file1.txt"));
        file1used= true;
        System.out.print("elements_test_file1.txt" + "is being used\n");
      } catch(FileNotFoundException e){
        System.out.print("Sorry, file 1 couldn't be found");
      }

    }
    else if(nValue > 10000 && nValue <= 100000){
      try{
        sortedArr_file2 = new Scanner(new File("elements_test_file2.txt"));
        unsortedArr_file2 = new Scanner(new File("elements_test_file2.txt"));
        sortedlist_file2 = new Scanner(new File("elements_test_file2.txt"));
        unsortedlist_file2 = new Scanner(new File("elements_test_file2.txt"));
        file2used= true;
        System.out.print("elements_test_file2.txt" + "is being used\n");
      } catch(FileNotFoundException e){
        System.out.print("Sorry, file 2 couldn't be found");
      }
    }
    else if(nValue > 100000 && nValue <= 1000000){
      try{
        sortedArr_file3 = new Scanner(new File("elements_test_file3.txt"));
        unsortedArr_file3 = new Scanner(new File("elements_test_file3.txt"));
        sortedlist_file3 = new Scanner(new File("elements_test_file3.txt"));
        unsortedlist_file3 = new Scanner(new File("elements_test_file3.txt"));
        file3used= true;
        System.out.print("elements_test_file3.txt" + "is being used\n");
      } catch(FileNotFoundException e){
        System.out.print("Sorry, file 3 couldn't be found");
      }
    }


    //Inserting n elements into sorted array
    long startTime = System.currentTimeMillis();
    for(int i =0; i<nValue; i++){
      if(file1used){
        content=sortedArr_file1.nextLine();
      }
      else if(file2used){
        content=sortedArr_file2.nextLine();
      }
      else if(file3used){
        content=sortedArr_file3.nextLine();

      }
      int randomNumber = ThreadLocalRandom.current().nextInt(0,100 + 1);
      Sortedarr.insert(randomNumber, content);
    }
    long endTime = System.currentTimeMillis();
    sortedarrinsert= endTime- startTime;
    System.out.println("Time taken to insert " + nValue + " items into sorted array was " + sortedarrinsert + "ms");

    startTime=0;
    endTime=0;


    //Removing n elements from sorted array
    startTime = System.currentTimeMillis();
    for(int i =0; i< nValue; i++){
      Sortedarr.removeMin();
    }
    endTime = System.currentTimeMillis();
    sortedarrremove = endTime - startTime;
    System.out.println("Time taken to remove " + nValue + " items from sorted array was " + sortedarrremove + "ms");

    startTime=0;
    endTime=0;

    //Inserting n elements into unsorted array
    startTime = System.currentTimeMillis();
    for(int i =0; i<nValue; i++){
      if(file1used){
        content=unsortedArr_file1.nextLine();
      }
      else if(file2used){
        content=unsortedArr_file2.nextLine();
      }
      else if(file3used){
        content=unsortedArr_file3.nextLine();

      }
      int randomNumber = ThreadLocalRandom.current().nextInt(0,100 + 1);
      Unsortedarr.insert(randomNumber, content);
    }
    endTime = System.currentTimeMillis();
    unsortedarrinsert= endTime- startTime;
    System.out.println("Time taken to insert " + nValue + " items into unsorted array was " + sortedarrinsert + "ms");

    startTime=0;
    endTime=0;


    //Removing n elements from unsorted array
    startTime = System.currentTimeMillis();
    for(int i =0; i< nValue; i++){
      Unsortedarr.removeMin();
    }
    endTime = System.currentTimeMillis();
    unsortedarrremove = endTime - startTime;
    System.out.println("Time taken to remove " + nValue + " items from unsorted array was " + sortedarrremove + "ms");

    startTime=0;
    endTime=0;

    //Inserting n elements into sorted Linked list
    startTime = System.currentTimeMillis();
    for(int i =0; i<nValue; i++){
      if(file1used){
        content=sortedlist_file1.nextLine();
      }
      else if(file2used){
        content=sortedlist_file2.nextLine();
      }
      else if(file3used){
        content=sortedlist_file3.nextLine();

      }
      int randomNumber = ThreadLocalRandom.current().nextInt(0,100 + 1);
      Sortedlist.insert(randomNumber, content);
    }
    endTime = System.currentTimeMillis();
    sortedlistinsert = endTime- startTime;
    System.out.println("Time taken to insert " + nValue + " items into sorted Linked list was " + sortedarrinsert + "ms");

    startTime=0;
    endTime=0;


    //Removing n elements from sorted Linked list
    startTime = System.currentTimeMillis();
    for(int i =0; i< nValue; i++){
      Sortedlist.removeMin();
    }
    endTime = System.currentTimeMillis();
    sortedlistremove = endTime - startTime;
    System.out.println("Time taken to remove " + nValue + " items from sorted Linked list was " + sortedarrremove + "ms");

    startTime=0;
    endTime=0;

    //Inserting n elements into unsorted Linked list
    startTime = System.currentTimeMillis();
    for(int i =0; i<nValue; i++){
      if(file1used){
        content=unsortedlist_file1.nextLine();
      }
      else if(file2used){
        content=unsortedlist_file2.nextLine();
      }
      else if(file3used){
        content=unsortedlist_file3.nextLine();

      }
      int randomNumber = ThreadLocalRandom.current().nextInt(0,100 + 1);
      Unsortedlist.insert(randomNumber, content);
    }
    endTime = System.currentTimeMillis();
    unsortedlistinsert = endTime- startTime;
    System.out.println("Time taken to insert " + nValue + " items into unsorted Linked list was " + sortedarrinsert + "ms");

    startTime=0;
    endTime=0;


    //Removing n elements from unsorted Linked list
    startTime = System.currentTimeMillis();
    for(int i =0; i< nValue; i++){
      Unsortedlist.removeMin();
    }
    endTime = System.currentTimeMillis();
    unsortedlistremove = endTime - startTime;
    System.out.println("Time taken to remove " + nValue + " items from unsorted Linked list was " + sortedarrremove + "ms");

    System.out.print("\n\n********************************************************\n\n");
    
    //Formating the table
    Print.append("\n\n\n");
    Print.append("-----------------------------------------------\n");
    Print.append(String.format("|%20s|%20s|%20s|\n", "N = " + nValue, "Insert(k,v) ms", "RemoveMin() ms"));
    Print.append("-----------------------------------------------\n");
    Print.append(String.format("|%20s|%20s|%20s|\n", "MyPQUnsortedArray", unsortedarrinsert + "ms", unsortedarrremove +"ms"));
    Print.append("-----------------------------------------------\n");
    Print.append(String.format("|%20s|%20s|%20s|\n", "MyPQUnsortedList", unsortedlistinsert + "ms", unsortedlistremove +"ms"));
    Print.append("-----------------------------------------------\n");
    Print.append(String.format("|%20s|%20s|%20s|\n", "MyPQSortedArray", sortedarrinsert + "ms", sortedarrremove +"ms"));
    Print.append("-----------------------------------------------\n");
    Print.append(String.format("|%20s|%20s|%20s|\n", "MyPQSortedList", sortedlistinsert + "ms", sortedlistremove +"ms"));
    Print.append("-----------------------------------------------\n");
    Print.append("\n\n\n");
  }





  public static void main(String[] args){
    int[] values = {10, 100, 1000, 10000, 100000, 1000000};
    for (int i=0; i<values.length;i++){
      measureTime(values[i], new MyPQSortedArray<Integer, String> (), new MyPQUnsortedArray<Integer, String> (), 
      new MyPQSortedLinkedList<Integer, String> (), new MyPQUnsortedLinkedList<Integer, String> ());
    }

    PrintWriter PQwritetester = null;
    try{
      PQwritetester = new PrintWriter(new File("pqtestrun.txt"));
    } catch (FileNotFoundException e){
      System.out.println("Error, something went wrong");
    }

    PQwritetester.println(Print);
    PQwritetester.close();
  }
  
}
