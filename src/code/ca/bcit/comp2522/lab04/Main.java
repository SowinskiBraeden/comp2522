package ca.bcit.comp2522.lab04;

public class Main {
    public static void main(final String[] args) {

        // -------------------------------------------------------------
        // Authors and their birth/death dates
        // -------------------------------------------------------------

        // George Orwell
        Author author1;
        Name nameAuthor1;
        Date birthAuthor1;
        Date deathAuthor1;

        nameAuthor1 = new Name("George", "Orwell");
        birthAuthor1 = new Date(1903,6,25);
        deathAuthor1 = new Date(1950,1,21);

        author1 = new Author(nameAuthor1,birthAuthor1,deathAuthor1, "Dystopia");


        // Harper Lee
        Author author2;
        Name nameAuthor2;
        Date birthAuthor2;
        Date deathAuthor2;

        nameAuthor2 = new Name("Harper", "Lee");
        birthAuthor2 = new Date(1926,4,28);
        deathAuthor2 = new Date(2016,2,19);

        author2 = new Author(nameAuthor2,birthAuthor2,deathAuthor2, "Literature/fiction");


        // Jane Austen
        Author author3;
        Name nameAuthor3;
        Date birthAuthor3;
        Date deathAuthor3;

        nameAuthor3 = new Name("Jane", "Austen");
        birthAuthor3 = new Date(1775,12,16);
        deathAuthor3 = new Date(1817,7,18);

        author3 = new Author(nameAuthor3,birthAuthor3,deathAuthor3, "Literary realism");


        // F. Scott Fitzgerald
        Author author4;
        Name nameAuthor4;
        Date birthAuthor4;
        Date deathAuthor4;

        nameAuthor4 = new Name("F. Scott", "Fitzgerald");
        birthAuthor4 = new Date(1896,9,24);
        deathAuthor4 = new Date(1940,12,21);

        author4 = new Author(nameAuthor4,birthAuthor4,deathAuthor4, "Modernist fiction");


        // Herman Melville
        Author author5;
        Name nameAuthor5;
        Date birthAuthor5;
        Date deathAuthor5;

        nameAuthor5 = new Name("Herman", "Melville");
        birthAuthor5 = new Date(1819,8,1);
        deathAuthor5 = new Date(1891,9,28);

        author5 = new Author(nameAuthor5,birthAuthor5,deathAuthor5, "Travelogue");


        // -------------------------------------------------------------
        // Books and associate them with their authors
        // -------------------------------------------------------------

        Book book1;
        Book book2;
        Book book3;
        Book book4;
        Book book5;

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
        Author biographyAuthor1;
        Name nameBiographyAuthor1;
        Date birthBiographyAuthor1;
        Date deathBiographyAuthor1;

        nameBiographyAuthor1 = new Name("Robert","Caro");
        birthBiographyAuthor1 = new Date(1935,10,30);
        deathBiographyAuthor1 = new Date(1935,10,30);

        Person biographySubject1;
        Name nameBiographySubject1;
        Date birthBiographySubject1;
        Date deathBiographySubject1;

        nameBiographySubject1 = new Name("Robert","Moses");
        birthBiographySubject1 = new Date(1888,12,18);
        deathBiographySubject1 = new Date(1981,7, 29);

        biographyAuthor1 = new Author(nameBiographyAuthor1,birthBiographyAuthor1, deathBiographyAuthor1, "Biography");
        biographySubject1 = new Person(birthBiographySubject1, deathBiographySubject1, nameBiographySubject1);


        // Walter Isaacson: Steve Jobs
        Author biographyAuthor2;
        Name nameBiographyAuthor2;
        Date birthBiographyAuthor2;
        Date deathBiographyAuthor2;

        nameBiographyAuthor2 = new Name("Walter","Isaacson");
        birthBiographyAuthor2 = new Date(1952,5,20);
        deathBiographyAuthor2 = new Date(1952,5,20);

        Person biographySubject2;
        Name nameBiographySubject2;
        Date birthBiographySubject2;
        Date deathBiographySubject2;

        nameBiographySubject2 = new Name("Steve","Jobs");
        birthBiographySubject2 = new Date(1955,2,24);
        deathBiographySubject2 = new Date(2011,10,5);

        biographyAuthor2 = new Author(nameBiographyAuthor2, birthBiographyAuthor2, deathBiographyAuthor2, "Biography");
        biographySubject2 = new Person(birthBiographySubject2, deathBiographySubject2, nameBiographySubject2);


        // Martin Gilbert: Winston Churchill
        Author biographyAuthor3;
        Name nameBiographyAuthor3;
        Date birthBiographyAuthor3;
        Date deathBiographyAuthor3;

        nameBiographyAuthor3 = new Name("Martin","Gilbert");
        birthBiographyAuthor3 = new Date(1936,10,25);
        deathBiographyAuthor3 = new Date(2015,2,3);

        Person biographySubject3;
        Name nameBiographySubject3;
        Date birthBiographySubject3;
        Date deathBiographySubject3;

        nameBiographySubject3 = new Name("Winston","Churchill");
        birthBiographySubject3 = new Date(1874,11,30);
        deathBiographySubject3 = new Date(1965,1,24);

        biographyAuthor3 = new Author(nameBiographyAuthor3, birthBiographyAuthor3, deathBiographyAuthor3, "Biography");
        biographySubject3 = new Person(birthBiographySubject3, deathBiographySubject3, nameBiographySubject3);


        // Ron Chernow: Alexander Hamilton
        Author biographyAuthor4;
        Name nameBiographyAuthor4;
        Date birthBiographyAuthor4;
        Date deathBiographyAuthor4;

        nameBiographyAuthor4 = new Name("Ron","Chernow");
        birthBiographyAuthor4 = new Date(1949,3,3);
        deathBiographyAuthor4 = new Date(1949,3,3);

        Person biographySubject4;
        Name nameBiographySubject4;
        Date birthBiographySubject4;
        Date deathBiographySubject4;

        nameBiographySubject4 = new Name("Alexander","Hamilton");
        birthBiographySubject4 = new Date(1755,1,11);
        deathBiographySubject4 = new Date(1804,7,12);

        biographyAuthor4 = new Author(nameBiographyAuthor4, birthBiographyAuthor4, deathBiographyAuthor4, "Biography");
        biographySubject4 = new Person(birthBiographySubject4, deathBiographySubject4, nameBiographySubject4);


        // Walter Isaacson: Albert Einstein
        Author biographyAuthor5;
        Name nameBiographyAuthor5;
        Date birthBiographyAuthor5;
        Date deathBiographyAuthor5;

        nameBiographyAuthor5 = new Name("Walter","Isaacson");
        birthBiographyAuthor5 = new Date(1952,5,20);
        deathBiographyAuthor5 = new Date(1952,5,20);

        Person biographySubject5;
        Name nameBiographySubject5;
        Date birthBiographySubject5;
        Date deathBiographySubject5;

        nameBiographySubject5 = new Name("Albert","Einstein");
        birthBiographySubject5 = new Date(1879,3,14);
        deathBiographySubject5 = new Date(1955,4,18);

        biographyAuthor5 = new Author(nameBiographyAuthor5, birthBiographyAuthor5, deathBiographyAuthor5, "Biography");
        biographySubject5 = new Person(birthBiographySubject5, deathBiographySubject5, nameBiographySubject5);


        // -------------------------------------------------------------
        // Biography objects linking authors and subjects
        // -------------------------------------------------------------

        Biography biography1;
        Biography biography2;
        Biography biography3;
        Biography biography4;
        Biography biography5;

        biography1 = new Biography("The Power Broker",                1974, biographyAuthor1, biographySubject1);
        biography2 = new Biography("Steve Jobs",                      2011, biographyAuthor2, biographySubject2);
        biography3 = new Biography("A Life",                          1991, biographyAuthor3, biographySubject3);
        biography4 = new Biography("Alexander Hamilton",              2004, biographyAuthor4, biographySubject4);
        biography5 = new Biography("Einstein: His Life and Universe", 2007, biographyAuthor5, biographySubject5);


        // -------------------------------------------------------------
        // Autobiographies (author and subject are same person)
        // -------------------------------------------------------------

        // Anne Frank — "The Diary of a Young Girl"
        Name nameAutobiographyAuthor1;
        Date birthAutobiographyAuthor1;
        Date deathAutobiographyAuthor1;

        nameAutobiographyAuthor1 = new Name("Anne", "Frank");
        birthAutobiographyAuthor1 = new Date(1929, 6, 12);
        deathAutobiographyAuthor1 = new Date(1945, 3, 1); // Approximate date

        Author autobiographyAuthor1;
        autobiographyAuthor1 = new Author(nameAutobiographyAuthor1, birthAutobiographyAuthor1, deathAutobiographyAuthor1, "Autobiography");


        // Nelson Mandela — "Long Walk to Freedom"
        Name nameAutobiographyAuthor2;
        Date birthAutobiographyAuthor2;
        Date deathAutobiographyAuthor2;

        nameAutobiographyAuthor2 = new Name("Nelson", "Mandela");
        birthAutobiographyAuthor2 = new Date(1918, 7, 18);
        deathAutobiographyAuthor2 = new Date(2013, 12, 5);

        Author autobiographyAuthor2;
        autobiographyAuthor2 = new Author(nameAutobiographyAuthor2, birthAutobiographyAuthor2, deathAutobiographyAuthor2, "Autobiography");


        // Mahatma Gandhi — "The Story of My Experiments with Truth"
        Name nameAutobiographyAuthor3;
        Date birthAutobiographyAuthor3;
        Date deathAutobiographyAuthor3;

        nameAutobiographyAuthor3 = new Name("Mahatma", "Gandhi");
        birthAutobiographyAuthor3 = new Date(1869, 10, 2);
        deathAutobiographyAuthor3 = new Date(1948, 1, 30);

        Author autobiographyAuthor3;
        autobiographyAuthor3 = new Author(nameAutobiographyAuthor3, birthAutobiographyAuthor3, deathAutobiographyAuthor3, "Autobiography");


        // Maya Angelou — "I Know Why the Caged Bird Sings"
        Name nameAutobiographyAuthor4;
        Date birthAutobiographyAuthor4;
        Date deathAutobiographyAuthor4;

        nameAutobiographyAuthor4 = new Name("Maya", "Angelou");
        birthAutobiographyAuthor4 = new Date(1928, 4, 4);
        deathAutobiographyAuthor4 = new Date(2014, 5, 28);

        Author autobiographyAuthor4;
        autobiographyAuthor4 = new Author(nameAutobiographyAuthor4, birthAutobiographyAuthor4, deathAutobiographyAuthor4, "Autobiography");


        // Malcolm X — "The Autobiography of Malcolm X"
        Name nameAutobiographyAuthor5;
        Date birthAutobiographyAuthor5;
        Date deathAutobiographyAuthor5;

        nameAutobiographyAuthor5 = new Name("Malcolm", "X");
        birthAutobiographyAuthor5 = new Date(1925, 5, 19);
        deathAutobiographyAuthor5 = new Date(1965, 2, 21);

        Author autobiographyAuthor5;
        autobiographyAuthor5 = new Author(nameAutobiographyAuthor5, birthAutobiographyAuthor5, deathAutobiographyAuthor5, "Autobiography");


        // -------------------------------------------------------------
        // Instantiate Autobiography objects
        // -------------------------------------------------------------

        Autobiography AutoBiography1;
        Autobiography AutoBiography2;
        Autobiography AutoBiography3;
        Autobiography AutoBiography4;
        Autobiography AutoBiography5;

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
