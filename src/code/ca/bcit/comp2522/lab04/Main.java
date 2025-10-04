package ca.bcit.comp2522.lab04;

public class Main {
    public static void main(final String[] args) {

        Author author1;
        Name nameAuthor1;
        Date birthAuthor1;
        Date deathAuthor1;

        nameAuthor1 = new Name("George", "Orwell");
        birthAuthor1 = new Date(1903,6,25);
        deathAuthor1 = new Date(1950,1,21);

        author1 = new Author(nameAuthor1,birthAuthor1,deathAuthor1, "Dystopia");


        Author author2;
        Name nameAuthor2;
        Date birthAuthor2;
        Date deathAuthor2;

        nameAuthor2 = new Name("Harper", "Lee");
        birthAuthor2 = new Date(1926,4,28);
        deathAuthor2 = new Date(2016,2,19);

        author2 = new Author(nameAuthor2,birthAuthor2,deathAuthor2, "Literature/fiction");

        Author author3;
        Name nameAuthor3;
        Date birthAuthor3;
        Date deathAuthor3;

        nameAuthor3 = new Name("Jane", "Austen");
        birthAuthor3 = new Date(1775,12,16);
        deathAuthor3 = new Date(1817,7,18);

        author3 = new Author(nameAuthor3,birthAuthor3,deathAuthor3, "Literary realism");


        Author author4;
        Name nameAuthor4;
        Date birthAuthor4;
        Date deathAuthor4;

        nameAuthor4 = new Name("F. Scott", "Fitzgerald");
        birthAuthor4 = new Date(1896,9,24);
        deathAuthor4 = new Date(1940,12,21);

        author4 = new Author(nameAuthor4,birthAuthor4,deathAuthor4, "Modernist fiction");

        Author author5;
        Name nameAuthor5;
        Date birthAuthor5;
        Date deathAuthor5;

        nameAuthor5 = new Name("Herman", "Melville");
        birthAuthor5 = new Date(1819,8,1);
        deathAuthor5 = new Date(1891,9,28);

        author5 = new Author(nameAuthor5,birthAuthor5,deathAuthor5, "Travelogue");

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

        Biography biography1;
        Biography biography2;
        Biography biography3;
        Biography biography4;
        Biography biography5;

        biography1 = new Biography("The Power Broker", 1974, biographyAuthor1, biographySubject1);

        Autobiography AutoBio1;
        Autobiography AutoBio2;
        Autobiography AutoBio3;
        Autobiography AutoBio4;
        Autobiography AutoBio5;



    }
}
