package of2.lf;

public class Book {

    private int numPages;
    private String title;

    public Book(int numPages, String title) {
    	this.numPages = numPages;
    	this.title = title;
    }

    public void setNumPages(int numPages) {
    	this.numPages = numPages;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setTitle(String title) {
    	this.title = title;
    }

    public String getTitle() {
        return title;
    }
    
    @Override
    public String toString() {
    	return "Boken " + title + " er på " + numPages + " sider";
    }

    public static void main(String[] args) {
        Book book = new Book(100, "Big Java");

        System.out.println("The book \"" + book.getTitle() + "\" has " + book.getNumPages() + " pages.");

        book.setNumPages(718);
        book.setTitle("Introduction to Algorithms");
        System.out.println("The book \"" + book.getTitle() + "\" has " + book.getNumPages() + " pages.");

        System.out.println(book);
    }

}
