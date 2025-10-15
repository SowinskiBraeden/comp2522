package ca.bcit.comp2522.lab04;

public class Main {
    public static void main(final String[] args) {

        // -------------------------------------------------------------
        // Authors and their birth/death dates
        // -------------------------------------------------------------

        // George Orwell
        final Author author1;
        final Name nameAuthor1;
        final Date birthAuthor1;
        final Date deathAuthor1;

        nameAuthor1 = new Name("George", "Orwell");
        birthAuthor1 = new Date(1903,6,25);
        deathAuthor1 = new Date(1950,1,21);

        author1 = new Author(nameAuthor1,birthAuthor1,deathAuthor1, "Dystopia");

        // Harper Lee
        final Author author2;
        final Name nameAuthor2;
        final Date birthAuthor2;
        final Date deathAuthor2;

        nameAuthor2 = new Name("Harper", "Lee");
        birthAuthor2 = new Date(1926,4,28);
        deathAuthor2 = new Date(2016,2,19);

        author2 = new Author(nameAuthor2,birthAuthor2,deathAuthor2, "Literature/fiction");

        // Jane Austen
        final Author author3;
        final Name nameAuthor3;
        final Date birthAuthor3;
        final Date deathAuthor3;

        nameAuthor3 = new Name("Jane", "Austen");
        birthAuthor3 = new Date(1775,12,16);
        deathAuthor3 = new Date(1817,7,18);

        author3 = new Author(nameAuthor3,birthAuthor3,deathAuthor3, "Literary realism");

        // F. Scott Fitzgerald
        final Author author4;
        final Name nameAuthor4;
        final Date birthAuthor4;
        final Date deathAuthor4;

        nameAuthor4 = new Name("F. Scott", "Fitzgerald");
        birthAuthor4 = new Date(1896,9,24);
        deathAuthor4 = new Date(1940,12,21);

        author4 = new Author(nameAuthor4,birthAuthor4,deathAuthor4, "Modernist fiction");


        // Herman Melville
        final Author author5;
        final Name nameAuthor5;
        final Date birthAuthor5;
        final Date deathAuthor5;

        nameAuthor5 = new Name("Herman", "Melville");
        birthAuthor5 = new Date(1819,8,1);
        deathAuthor5 = new Date(1891,9,28);

        author5 = new Author(nameAuthor5,birthAuthor5,deathAuthor5, "Travelogue");

        // -------------------------------------------------------------
        // Books and associate them with their authors
        // -------------------------------------------------------------

        final Book book1;
        final Book book2;
        final Book book3;
        final Book book4;
        final Book book5;

        book1 = new Book("1984",                  1949, author1);
        book2 = new Book("To Kill a Mockingbird", 1960, author2);
        book3 = new Book("Pride and Prejudice",   1813, author3);
        book4 = new Book("The Great Gatsby",      1925, author4);
        book5 = new Book("Moby-Dick",             1851, author5);

        // -------------------------------------------------------------
        // Biographies (different author and subject)
        // -------------------------------------------------------------
        // Each biography has an author (who writes it) and a subject (the person it’s about)

        // Robert Caro: Robert Moses
        final Author biographyAuthor1;
        final Name nameBiographyAuthor1;
        final Date birthBiographyAuthor1;
        final Date deathBiographyAuthor1;

        nameBiographyAuthor1 = new Name("Robert","Caro");
        birthBiographyAuthor1 = new Date(1935,10,30);
        deathBiographyAuthor1 = new Date(1935,10,30);

        final Person biographySubject1;
        final Name nameBiographySubject1;
        final Date birthBiographySubject1;
        final Date deathBiographySubject1;

        nameBiographySubject1 = new Name("Robert","Moses");
        birthBiographySubject1 = new Date(1888,12,18);
        deathBiographySubject1 = new Date(1981,7, 29);

        biographyAuthor1 = new Author(nameBiographyAuthor1,birthBiographyAuthor1, deathBiographyAuthor1, "Biography");
        biographySubject1 = new Person(birthBiographySubject1, deathBiographySubject1, nameBiographySubject1);

        // Walter Isaacson: Steve Jobs
        final Author biographyAuthor2;
        final Name nameBiographyAuthor2;
        final Date birthBiographyAuthor2;
        final Date deathBiographyAuthor2;

        nameBiographyAuthor2 = new Name("Walter","Isaacson");
        birthBiographyAuthor2 = new Date(1952,5,20);
        deathBiographyAuthor2 = new Date(1952,5,20);

        final Person biographySubject2;
        final Name nameBiographySubject2;
        final Date birthBiographySubject2;
        final Date deathBiographySubject2;

        nameBiographySubject2 = new Name("Steve","Jobs");
        birthBiographySubject2 = new Date(1955,2,24);
        deathBiographySubject2 = new Date(2011,10,5);

        biographyAuthor2 = new Author(nameBiographyAuthor2, birthBiographyAuthor2, deathBiographyAuthor2, "Biography");
        biographySubject2 = new Person(birthBiographySubject2, deathBiographySubject2, nameBiographySubject2);

        // Martin Gilbert: Winston Churchill
        final Author biographyAuthor3;
        final Name nameBiographyAuthor3;
        final Date birthBiographyAuthor3;
        final Date deathBiographyAuthor3;

        nameBiographyAuthor3 = new Name("Martin","Gilbert");
        birthBiographyAuthor3 = new Date(1936,10,25);
        deathBiographyAuthor3 = new Date(2015,2,3);

        final Person biographySubject3;
        final Name nameBiographySubject3;
        final Date birthBiographySubject3;
        final Date deathBiographySubject3;

        nameBiographySubject3 = new Name("Winston","Churchill");
        birthBiographySubject3 = new Date(1874,11,30);
        deathBiographySubject3 = new Date(1965,1,24);

        biographyAuthor3 = new Author(nameBiographyAuthor3, birthBiographyAuthor3, deathBiographyAuthor3, "Biography");
        biographySubject3 = new Person(birthBiographySubject3, deathBiographySubject3, nameBiographySubject3);

        // Ron Chernow: Alexander Hamilton
        final Author biographyAuthor4;
        final Name nameBiographyAuthor4;
        final Date birthBiographyAuthor4;
        final Date deathBiographyAuthor4;

        nameBiographyAuthor4 = new Name("Ron","Chernow");
        birthBiographyAuthor4 = new Date(1949,3,3);
        deathBiographyAuthor4 = new Date(1949,3,3);

        final Person biographySubject4;
        final Name nameBiographySubject4;
        final Date birthBiographySubject4;
        final Date deathBiographySubject4;

        nameBiographySubject4 = new Name("Alexander","Hamilton");
        birthBiographySubject4 = new Date(1755,1,11);
        deathBiographySubject4 = new Date(1804,7,12);

        biographyAuthor4 = new Author(nameBiographyAuthor4, birthBiographyAuthor4, deathBiographyAuthor4, "Biography");
        biographySubject4 = new Person(birthBiographySubject4, deathBiographySubject4, nameBiographySubject4);

        // Walter Isaacson: Albert Einstein
        final Author biographyAuthor5;
        final Name nameBiographyAuthor5;
        final Date birthBiographyAuthor5;
        final Date deathBiographyAuthor5;

        nameBiographyAuthor5 = new Name("Walter","Isaacson");
        birthBiographyAuthor5 = new Date(1952,5,20);
        deathBiographyAuthor5 = new Date(1952,5,20);

        final Person biographySubject5;
        final Name nameBiographySubject5;
        final Date birthBiographySubject5;
        final Date deathBiographySubject5;

        nameBiographySubject5 = new Name("Albert","Einstein");
        birthBiographySubject5 = new Date(1879,3,14);
        deathBiographySubject5 = new Date(1955,4,18);

        biographyAuthor5 = new Author(nameBiographyAuthor5, birthBiographyAuthor5, deathBiographyAuthor5, "Biography");
        biographySubject5 = new Person(birthBiographySubject5, deathBiographySubject5, nameBiographySubject5);

        // -------------------------------------------------------------
        // Biography objects linking authors and subjects
        // -------------------------------------------------------------

        final Biography biography1;
        final Biography biography2;
        final Biography biography3;
        final Biography biography4;
        final Biography biography5;

        biography1 = new Biography("The Power Broker",                1974, biographyAuthor1, biographySubject1);
        biography2 = new Biography("Steve Jobs",                      2011, biographyAuthor2, biographySubject2);
        biography3 = new Biography("A Life",                          1991, biographyAuthor3, biographySubject3);
        biography4 = new Biography("Alexander Hamilton",              2004, biographyAuthor4, biographySubject4);
        biography5 = new Biography("Einstein: His Life and Universe", 2007, biographyAuthor5, biographySubject5);


        // -------------------------------------------------------------
        // Autobiographies (author and subject are same person)
        // -------------------------------------------------------------

        // Anne Frank — "The Diary of a Young Girl"
        final Name nameAutobiographyAuthor1;
        final Date birthAutobiographyAuthor1;
        final Date deathAutobiographyAuthor1;

        nameAutobiographyAuthor1 = new Name("Anne", "Frank");
        birthAutobiographyAuthor1 = new Date(1929, 6, 12);
        deathAutobiographyAuthor1 = new Date(1945, 3, 1); // Approximate date

        final Author autobiographyAuthor1;
        autobiographyAuthor1 = new Author(nameAutobiographyAuthor1, birthAutobiographyAuthor1, deathAutobiographyAuthor1, "Autobiography");


        // Nelson Mandela — "Long Walk to Freedom"
        final Name nameAutobiographyAuthor2;
        final Date birthAutobiographyAuthor2;
        final Date deathAutobiographyAuthor2;

        nameAutobiographyAuthor2 = new Name("Nelson", "Mandela");
        birthAutobiographyAuthor2 = new Date(1918, 7, 18);
        deathAutobiographyAuthor2 = new Date(2013, 12, 5);

        final Author autobiographyAuthor2;
        autobiographyAuthor2 = new Author(nameAutobiographyAuthor2, birthAutobiographyAuthor2, deathAutobiographyAuthor2, "Autobiography");


        // Mahatma Gandhi — "The Story of My Experiments with Truth"
        final Name nameAutobiographyAuthor3;
        final Date birthAutobiographyAuthor3;
        final Date deathAutobiographyAuthor3;

        nameAutobiographyAuthor3 = new Name("Mahatma", "Gandhi");
        birthAutobiographyAuthor3 = new Date(1869, 10, 2);
        deathAutobiographyAuthor3 = new Date(1948, 1, 30);

        final Author autobiographyAuthor3;
        autobiographyAuthor3 = new Author(nameAutobiographyAuthor3, birthAutobiographyAuthor3, deathAutobiographyAuthor3, "Autobiography");


        // Maya Angelou — "I Know Why the Caged Bird Sings"
        final Name nameAutobiographyAuthor4;
        final Date birthAutobiographyAuthor4;
        final Date deathAutobiographyAuthor4;

        nameAutobiographyAuthor4 = new Name("Maya", "Angelou");
        birthAutobiographyAuthor4 = new Date(1928, 4, 4);
        deathAutobiographyAuthor4 = new Date(2014, 5, 28);

        final Author autobiographyAuthor4;
        autobiographyAuthor4 = new Author(nameAutobiographyAuthor4, birthAutobiographyAuthor4, deathAutobiographyAuthor4, "Autobiography");


        // Malcolm X — "The Autobiography of Malcolm X"
        final Name nameAutobiographyAuthor5;
        final Date birthAutobiographyAuthor5;
        final Date deathAutobiographyAuthor5;

        nameAutobiographyAuthor5 = new Name("Malcolm", "X");
        birthAutobiographyAuthor5 = new Date(1925, 5, 19);
        deathAutobiographyAuthor5 = new Date(1965, 2, 21);

        final Author autobiographyAuthor5;
        autobiographyAuthor5 = new Author(nameAutobiographyAuthor5, birthAutobiographyAuthor5, deathAutobiographyAuthor5, "Autobiography");


        // -------------------------------------------------------------
        // Instantiate Autobiography objects
        // -------------------------------------------------------------

        final Autobiography AutoBiography1;
        final Autobiography AutoBiography2;
        final Autobiography AutoBiography3;
        final Autobiography AutoBiography4;
        final Autobiography AutoBiography5;

        AutoBiography1 = new Autobiography("The Diary of a Young Girl",              1947, autobiographyAuthor1);
        AutoBiography2 = new Autobiography("Long Walk to Freedom",                   1994, autobiographyAuthor2);
        AutoBiography3 = new Autobiography("The Story of My Experiments with Truth", 1927, autobiographyAuthor3);
        AutoBiography4 = new Autobiography("I Know Why the Caged Bird Sings",        1969, autobiographyAuthor4);
        AutoBiography5 = new Autobiography("The Autobiography of Malcolm X",         1965, autobiographyAuthor5);

        // -------------------------------------------------------------
        // COMPARISONS
        // -------------------------------------------------------------

        System.out.println("Comparing: ");
        book1.display();
        System.out.println("Reverse info: ");
        book1.backward();
        book1.author.backward();

        System.out.println("to: ");
        book2.display();
        System.out.println("Reverse info: ");
        book2.backward();
        book2.author.backward();

        System.out.println("Comparison: ");
        System.out.println(book1.compareTo(book2));
        System.out.println("Equals: " + book1.equals(book2));

        System.out.println("-------------------------------------------------------------");

        System.out.println("Comparing: ");
        book4.author.display();
        System.out.println("to: ");
        book5.author.display();

        System.out.println("Comparison: ");
        System.out.println(book4.author.compareTo(book5.author));
        System.out.println("Equals: " + book4.author.equals(book5.author));

        System.out.println("-------------------------------------------------------------");

        System.out.println("Comparing: ");
        biography3.display();
        System.out.println("Reverse info: ");
        biography3.backward();
        biography3.author.backward();

        System.out.println("to: ");
        biography5.display();
        System.out.println("Reverse info: ");
        biography5.backward();
        biography5.author.backward();

        System.out.println("Comparison: ");
        System.out.println(biography3.compareTo(biography5));
        System.out.println("Equals: " + biography3.equals(biography5));

        System.out.println("-------------------------------------------------------------");

        System.out.println("Book1 equals Book3: " + book1.equals(book3));
        System.out.println("Book1 equals Book1: " + book1.equals(book1));
        System.out.println("Book3 equals Book3: " + book3.equals(book3));
        System.out.println("Book2 equals Book5: " + book2.equals(book5));
        System.out.println("Biography1 equals Biography2: " + biography1.equals(biography2));
        System.out.println("Biography4 equals Biography5: " + biography4.equals(biography5));
        System.out.println("Autobiography1 equals Autobiography2: " + AutoBiography1.equals(AutoBiography2));
        System.out.println("Autobiography3 equals Autobiography5: " + AutoBiography3.equals(AutoBiography5));


    }
}
