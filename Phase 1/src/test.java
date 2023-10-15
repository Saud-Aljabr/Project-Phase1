import java.util.Scanner;

public class test {

 public static void main(String[] args) {
  Scanner s = new Scanner(System.in);
  Phonebook phonebook = new Phonebook();
  int x = 0;
  int num =0;
  do {
   System.out.println("Welcome to the Linked Tree Phonebook!");
   System.out.println("please choose an option:\n");
   System.out.println("1.Add a contact \n");
   System.out.println("2.Delete a contact\n");
   System.out.println("3.Search for a contact\n");
   System.out.println("4.Schedule an event\n");
   System.out.println("5.Print event details\n");
   System.out.println("6.Print contacts by first name\n");
   System.out.println("7.Print all events alphabitacally\n");
   System.out.println("8.Exit");
   x = s.nextInt();
   switch (x) {
   case 1:
    s.nextLine();
    System.out.println("Enter the contact's name:");
    String name = s.nextLine();
    System.out.println("Enter the contact's phone number:");
    num = s.nextInt();
    s.nextLine();
    System.out.println("Enter the contact's email address:");
    String email = s.nextLine(); 
    System.out.println("Enter the contact's address:");
    String address = s.nextLine();   
    System.out.println("Enter the contact's birthday:");
    String birthday = s.nextLine();   
    System.out.println("Enter any notes for the contact: ");
    String notes = s.nextLine();
    
    if (phonebook.addCon(new Contact(name,num,email,address,birthday,notes)))
     System.out.println("Contact added successfully\n");
    else 
     System.out.println("You already added this contact\n");
    break;
   case 2:
	    System.out.println("Enter search criteria:\n1.Contact name\n2.Conatct phone number");
	    num = s.nextInt();
	    while (num<1 || num>2) {
	     System.out.println("Enter a valid number:");
	     num = s.nextInt();
	    }
	    if (num == 1) {
	     s.nextLine();
	     System.out.println("Enter the contact's name:");
	     if(phonebook.deleteCon2(s.nextLine(),num))
	      System.out.println("Deleted successfully");
	     else
	      System.out.println("Contact does not exist");
	     }
	    else if (num == 2) {
	     System.out.println("Enter the contact's phone number:");
	     if(phonebook.deleteCon2(s.nextInt(),num))
	      System.out.println("Deleted successfully");
	     else
	      System.out.println("Contact does not exist");
	     }
	    
	    break;
   case 3:
	    LinkedList<Contact> tmp = null;
	    System.out.println("Enter search criteria:\n1.Name\n2.Phone number\n3.Email\n4.Adress\n5.Birthday");
	    num = s.nextInt();
	    s.nextLine();
	    while (num<1 || num>5) {
	     System.out.println("Enter a valid number");
	     num = s.nextInt();
	    }
	    if (num == 1) {
	     System.out.println("Enter the contact's name:");
	     tmp = phonebook.searchContact(s.nextLine(), num);
	    }
	    else if (num == 2) {
	     System.out.println("Enter the contact's phone number:");
	     tmp = phonebook.searchContact(s.nextInt(), num);
	    }
	    else if (num == 3) {
	     System.out.println("Enter the contact's Email:");
	     tmp = phonebook.searchContact(s.nextLine(), num);
	    }
	    else if (num == 4) {
	     System.out.println("Enter the contact's Address:");
	     tmp = phonebook.searchContact(s.nextLine(), num);
	    }
	    else if (num == 5) {
	     System.out.println("Enter the contact's Birthday:");
	     tmp = phonebook.searchContact(s.nextLine(), num);
	    }
	    if (tmp == null) {
	     System.out.println("Contact does not exist!");
	     break;
	     }
	    tmp.findFirst();
	    while(!tmp.last()) {
	     System.out.println(tmp.retrieve().toString());
	     tmp.findNext();
	    }
	    System.out.println(tmp.retrieve().toString());
	    tmp = null;
	    break;
   case 4:
	    System.out.println("Enter Event title:\nEnter contact name:\nEnter event date and time:\nEnter event location:");
	    s.nextLine();
	    if (phonebook.schedule(s.nextLine(), s.nextLine(), s.nextLine(), s.nextLine()))
	     System.out.println("Event scheduled successfully! ");
	    else 
	     System.out.println("Failed to schedule the event, ethier there is a conflict or the contact does not exist");
	    break;
   case 5:
	    System.out.println("Enter search criteria:\n1.Conatct name\n2.Event title");
	    num = s.nextInt();
	    while(num>2 || num<1) {
	        System.out.println("Enter a valid number");
	    }
	    s.nextLine();
	    if (num == 1) {
	     System.out.println("Enter contact name");
	     tmp = phonebook.searchContact(s.nextLine(), num);
	     if (tmp == null) {
	      System.out.println("contact does not exist");
	      break;
	     }
	     LinkedList<Event> conEventList = tmp.retrieve().eventCon;
	     conEventList.findFirst();
	     while (!conEventList.last()) {
	      System.out.println(conEventList.retrieve().toString());
	      conEventList.findNext();
	     }
	     System.out.println(conEventList.retrieve().toString());
	    }
	    else if (num == 2) {
	        System.out.println("Enter event title");
	        Event tmpEvent = phonebook.eventSearchTitle(s.nextLine());
	        if(tmpEvent != null)
	         System.out.println(tmpEvent.toString());
	        else 
	         System.out.println("There is no event with this title");
	         
	       }
	       break;
   case 6:
	    s.nextLine();
	    System.out.println("Enter the first name: ");
	    LinkedList <Contact> listFirst = phonebook.searchFirstName(s.next());
	    if (listFirst.empty())
	     System.out.println("There is no contact with this first name");
	    else {
	     listFirst.findFirst();
	     while(!listFirst.last()) {
	      System.out.println(listFirst.retrieve().toString());
	      listFirst.findNext();
	     }
	     System.out.println(listFirst.retrieve().toString());
	    }
	    break;
   case 7:
	    phonebook.printEventAlphabetically();
	    break;
	 }
   s.next();
  } while (x != 8);
  System.out.println("Bey!");

 }
}
 
