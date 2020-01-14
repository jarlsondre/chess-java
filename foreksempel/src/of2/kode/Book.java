package of2.kode;

public class Book {

    private int numPages;
    private String title;

    public Book(int numPages, String title) {

    }

    public void setNumPages(int numPages) {

    }

    public int getNumPages() {
        return 0;
    }

    public void setTitle(String title) {

    }

    public String getTitle() {
        return "";
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
