
public class Phonebook<T> {
	Contact s = new Contact();
	LinkedList<Contact> conlist = new LinkedList<>(); // list for contacts
	LinkedList<Event> eventlist = new LinkedList<>(); // list for events

	public String re() {
		conlist.findLast();
		return conlist.retrieve().getName();
	}

	public boolean addCon(Contact c) {
		if (conlist.empty()) {
			conlist.insert(c);
			return true;
		}
		if (checkSearch(c) == false)
			return false;
		conlist.findFirst();
		if (c.compareTo(conlist.retrieve()) < 0) {
			conlist.insertFirst(c);
			return true;
		}
		conlist.findNext();
		while (!conlist.last()) { // sort by name
			if (c.compareTo(conlist.retrieve()) < 0) {
				conlist.findPrev();
				conlist.insert(c);
				return true;
			}
			conlist.findNext();
		}
		if (c.compareTo(conlist.retrieve()) < 0) {// to compare the last contact
			conlist.findPrev();
			conlist.insert(c);
			return true;
		}
		conlist.insert(c);
		return true;

	}

	private boolean checkSearch(Contact c) {// checking if there is no contact with same name and phoneNum
		if (conlist.empty() == false) {
			conlist.findFirst();
			while (!conlist.last()) {
				if (c.getPhoneNum() == conlist.retrieve().getPhoneNum())
					return false;
				if (c.getName().equalsIgnoreCase(conlist.retrieve().getName()))
					return false;
				conlist.findNext();
			}
			if (c.getPhoneNum() == conlist.retrieve().getPhoneNum())
				return false;
			if (c.getName().equalsIgnoreCase(conlist.retrieve().getName()))
				return false;
		}
		return true;
	}

	public Contact searchContact(T s, int x) { // the x represent the criteria search
		conlist.findFirst();
		if (x == 1) { // if x=1 search by name
			while (!conlist.last()) {
				if (((String) s).equalsIgnoreCase(conlist.retrieve().getName()))
					return conlist.retrieve();
				conlist.findNext();
			}
			if (((String) s).equalsIgnoreCase(conlist.retrieve().getName()))
				return conlist.retrieve();
		} else if (x == 2) { // if x=2 search by phonNum
			while (!conlist.last()) {
				if ((Integer) s == conlist.retrieve().getPhoneNum())
					return conlist.retrieve();
				conlist.findNext();
			}
			if ((Integer) s == conlist.retrieve().getPhoneNum())
				return conlist.retrieve();
		} else if (x == 3) { // if x=3 search by email
			while (!conlist.last()) {
				if (((String) s).equalsIgnoreCase(conlist.retrieve().getEmail()))
					return conlist.retrieve();
				conlist.findNext();
			}
			if (((String) s).equalsIgnoreCase(conlist.retrieve().getEmail()))
				return conlist.retrieve();
		} else if (x == 4) { // if x=4 search by Address
			while (!conlist.last()) {
				if (((String) s).equalsIgnoreCase(conlist.retrieve().getAddress()))
					return conlist.retrieve();
				conlist.findNext();
			}
			if (((String) s).equalsIgnoreCase(conlist.retrieve().getAddress()))
				return conlist.retrieve();
		} else if (x == 5) { // if x=5 search by birthday
			while (!conlist.last()) {
				if (((String) s).equalsIgnoreCase(conlist.retrieve().getBirthday()))
					return conlist.retrieve();
				conlist.findNext();
			}
			if (((String) s).equalsIgnoreCase(conlist.retrieve().getBirthday()))
				return conlist.retrieve();
		}
		return null;

	}

	public boolean deleteCon(String n) { // deletes a contact with all connected events
		Contact tmp = null;
		conlist.findFirst();
		while(!conlist.last()) {
			if (n.equalsIgnoreCase(conlist.retrieve().getName())) {
				tmp = conlist.retrieve();
				conlist.remove();
				}
			conlist.findNext();
		}
		if (n.equalsIgnoreCase(conlist.retrieve().getName())) {
			tmp = conlist.retrieve();
			conlist.remove();
			}
		if (tmp == null) // if tmp still null it means contact does not exist
			return false;
		eventlist.findFirst(); // from here it deletes all connected events with contact
		while (!eventlist.last()) {
			if (tmp == eventlist.retrieve().getContact())
				eventlist.remove();
			eventlist.findNext();
		}
		if (tmp == eventlist.retrieve().getContact())
			eventlist.remove();
		return true;
	}

	public boolean schedule(String t, String n, String DT, String l) { // to add an event
		Contact tmp = searchContact((T) n, 1);
		if (tmp == null || !checkConflict(DT)) // checking if contact exist or there is a conflict
			return false;
		else {
			Event ev = new Event(t, DT, l, tmp);
			tmp.addEvent(ev); // this adding is for the events connected to the contact

			if (eventlist.empty()) {
				eventlist.insert(ev);
				return true;
			}
			eventlist.findFirst();
			if (ev.compareTo(eventlist.retrieve()) < 0) { // seperate in case if ev comes before the first one
				eventlist.insertFirst(ev); 
				return true;
			}
			eventlist.findNext();
			while (!eventlist.last()) {
				if (ev.compareTo(eventlist.retrieve()) < 0) {
					eventlist.findPrev();
					eventlist.insert(ev);
					return true;
				}
				eventlist.findNext();
			}
			if (ev.compareTo(eventlist.retrieve()) < 0) { // repeated pressure for last contact
				eventlist.findPrev();
				eventlist.insert(ev);
				return true;
			}
			eventlist.insert(ev);
			return true;
		}
	}

	private boolean checkConflict(String DT) { // to check if there is conflict in Date or Time in events
		if (eventlist.empty())
			return true;
		while (!eventlist.last()) {
			if (DT.equalsIgnoreCase(eventlist.retrieve().getDateTime()))
				return false;
		}
		if (DT.equalsIgnoreCase(eventlist.retrieve().getDateTime())) // repeated pressure for last contact
			return false;
		return true;
	}
	
	public LinkedList<Event> eventSearchName(String s) { // to search for event by name, it returns a linkedlist
																// of type event because one contact could have many events							
		Contact tmp = searchContact((T) s, 1);
		if (tmp == null)
			return null;
		return tmp.eventCon;

	}
	
	public Event eventSearchTitle(String title) { // to search for event by title
			eventlist.findFirst();
			while (!eventlist.last()) {
				if (eventlist.retrieve().getTitle().equalsIgnoreCase(title))
					return eventlist.retrieve();
				conlist.findNext();
			}
			if (eventlist.retrieve().getTitle().equalsIgnoreCase(title)) // repeated pressure for last contact
				return eventlist.retrieve();
		
		return null; // null if there is no event with this title
	}
	
	public LinkedList<Contact> searchFirstName(String name){ // search by first name
		LinkedList<Contact> firstName= new LinkedList<>();
		conlist.findFirst();
		while(!conlist.last()) {
			String tmp = conlist.retrieve().getName();
			int x =0;
			for(int i=0 ; i <tmp.length(); i++) // this loop is to detect the space 
				if (tmp.charAt(i) == ' ') {
					x = i;
					break;
				}
			if (name.equalsIgnoreCase(tmp.substring(0, x)))
				firstName.insert(conlist.retrieve());
			conlist.findNext();
		}
		String tmp = conlist.retrieve().getName(); // repeated pressure for last contact
		int x =0;
		for(int i=0 ; i <tmp.length(); i++) 
			if (tmp.charAt(i) == ' ') {
				x = i;
				break;
			}
		if (name.equalsIgnoreCase(tmp.substring(0, x)))
			firstName.insert(conlist.retrieve());
		
		return firstName;
		
		
	}

}
