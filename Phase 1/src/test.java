
public class test {

	public static void main(String[] args) {
		Contact one = new Contact();
		Contact tow = new Contact();
		Contact three = new Contact();
		Contact four = new Contact();
		one.setName("Saud aljabr"); one.setPhoneNum(11);
		tow.setName("saud kfdf"); tow.setPhoneNum(12);tow.setBirthday("2003");
		three.setName("fah"); three.setPhoneNum(20);
		four.setName("abc"); four.setPhoneNum(21);
		Phonebook my = new Phonebook();
		
		
		my.addCon(one);
		my.addCon(tow);
		my.addCon(three);
		my.addCon(four);
		my.schedule("launch saud", "saud", "2023", "mcdonalds");
		my.schedule("launch abood", "abood", "2021", "mcdonalds");
		my.schedule("launch abz", "abc", "202", "dc");
	//	my.printEventAlphabetically();
		LinkedList<Contact> tmp= my.searchFirstName("Saud");
		tmp.findFirst();
		while (!tmp.last()) {
			System.out.println(tmp.retrieve().toString());
			tmp.findNext();
		}
		System.out.println(tmp.retrieve().toString());
	
		
	}

}
