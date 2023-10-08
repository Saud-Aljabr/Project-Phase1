
public class Contact implements Comparable<Contact> {
	
	private String name, email, address, birthday, notes;
	private int phoneNum;
	LinkedList <Event> eventCon = new LinkedList<>(); // list for events connected with the contact

	
	public Contact() {
		super();
	}

	public Contact(String name, String email, String address, String birthday, String notes, int phoneNum) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.notes = notes;
		this.phoneNum = phoneNum;
	}

	@Override
	public int compareTo(Contact o) { //  negative means this.name comes before o.name
		return name.compareToIgnoreCase(o.name);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}
	public void addEvent(Event e) {
		eventCon.insert(e);
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", email=" + email + ", address=" + address + ", birthday=" + birthday
				+ ", notes=" + notes + ", phoneNum=" + phoneNum + "]";
	}
	
	

	
	
	

}
