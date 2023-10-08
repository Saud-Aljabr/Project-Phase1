public class Event {
	private String title,dateTime,location;
	private Contact contact;
	
	public Event(String title, String dateTime, String location, Contact contact) {
		super();
		this.title = title;
		this.dateTime = dateTime;
		this.location = location;
		this.contact = contact;
	}
	public int compareTo(Event e) { //  this method for comparing alphabetically, negative means this.title comes before e.title
		return title.compareToIgnoreCase(e.title);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Event [title=" + title + ", dateTime=" + dateTime + ", location=" + location + ", contact=" + contact
				+ "]";
	}
	
}
