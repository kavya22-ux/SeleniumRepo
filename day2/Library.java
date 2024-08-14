package week1.day2;

public class Library {
	public String addBook(String bookTitle) {
		System.out.println("Book added Successfully");
		return bookTitle;
	}
	
	public void issueBook(){
		System.out.println("Book issued Successfully");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Library lib = new Library();
		lib.addBook(null);
		lib.issueBook();
		

	}

}
