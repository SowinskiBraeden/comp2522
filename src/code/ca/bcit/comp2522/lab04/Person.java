package ca.bcit.comp2522.lab04;

public class Person {
    private final Date dateOfBirth;
    private final Date dateOfDeath;
    private final Name name;

    private final boolean CAN_BE_NULL = true;
    private final boolean CANT_BE_NULL = false;

    public Person(final Date dateOfBirth,
                  final Date dateOfDeath,
                  final Name name)
    {
        dateValidator(dateOfBirth, CAN_BE_NULL);
        dateValidator(dateOfDeath, CANT_BE_NULL);

        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.name = name;

    }


    public void dateValidator(final Date dateToBeChecked,
                              final boolean canBeNull)
    {
        if (!canBeNull)
        {
         if ( dateToBeChecked == null)
         {
             throw new IllegalArgumentException("Date cannot be null");
         }
        }
    }

}
