
public class test {

	public static void main(String[] args) {
		Contact one = new Contact();
		Contact tow = new Contact();
		Contact three = new Contact();
		Contact four = new Contact();
		one.setName("Saud"); one.setPhoneNum(11);
		tow.setName("Abood"); tow.setPhoneNum(12);
		three.setName("fah"); three.setPhoneNum(20);
		four.setName("abc"); four.setPhoneNum(21);
		Phonebook my = new Phonebook();
		
		/*System.out.println(my.addCon(one));
		System.out.println(my.addCon(tow));
		System.out.println(my.addCon(three));
		System.out.println(my.addCon(four));
		System.out.println(my.searchContact(20, 2).getName());*/
		
		//System.out.println(my.re());
		String s = "Saudfg";
		System.out.println(s.substring(0, 2));
		
	}

}
