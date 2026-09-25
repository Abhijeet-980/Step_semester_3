// Problem 3. The Nickname Tag
// immutable: the name is split once in the constructor into final fields,
// and getNickname() only reads what was stored.

public class Problem3_NicknameTag {
    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println(tag.getNickname());

        NameTag sameName = new NameTag("Maria Gomez");
        System.out.println(sameName.getNickname());
        System.out.println("Same object: " + (tag == sameName));
    }
}

class NameTag {
    private final String firstName;
    private final String lastName;

    NameTag(String fullName) {
        String[] parts = fullName.split(" ");
        this.firstName = parts[0];
        this.lastName = parts[1];
    }

    String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }
}
