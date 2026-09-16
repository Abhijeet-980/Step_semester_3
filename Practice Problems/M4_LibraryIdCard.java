// M4. Library ID Card Management
// duplicate is a second reference to the SAME object, so a change through it
// is visible through ravi, and == is true. separate is a new object with
// identical fields, but == is false because identity is not equality.

public class M4_LibraryIdCard {
    public static void main(String[] args) {
        IdCard ravi = new IdCard("Ravi", 0);

        // second variable pointing at the same object (no new object created)
        IdCard duplicate = ravi;
        duplicate.booksIssued = 3;

        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));

        // third object with identical field values, but a different object
        IdCard separate = new IdCard("Ravi", 3);
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}

class IdCard {
    String name;
    int booksIssued;

    IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }
}
