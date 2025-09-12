package SingleInheritance;

class Book {
    String title;
    int publicationYear;

    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    void displayInfo() {
        System.out.println("Book -> Title: " + title + ", Year: " + publicationYear);
    }
}

class Author extends Book {
    String name;
    String bio;

    Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    @Override
    void displayInfo() {
        System.out.println("Book -> Title: " + title + ", Year: " + publicationYear);
        System.out.println("Author -> Name: " + name + ", Bio: " + bio);
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Author a1 = new Author("The Great Adventure", 2021, "John Smith", "Fiction writer with 10+ years of experience.");
        a1.displayInfo();
    }
}
