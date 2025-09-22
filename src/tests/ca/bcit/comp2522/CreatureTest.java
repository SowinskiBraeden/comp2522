package ca.bcit.comp2522;

import ca.bcit.comp2522.lab02.Creature;
import ca.bcit.comp2522.lab02.Date;
import ca.bcit.comp2522.lab02.Dragon;
import ca.bcit.comp2522.lab02.Elf;
import ca.bcit.comp2522.lab02.Orc;
import ca.bcit.comp2522.lab02.LowFirePowerException;
import ca.bcit.comp2522.lab02.LowManaException;
import ca.bcit.comp2522.lab02.LowRageException;

/**
 * A test driver for the Creature class and its subclasses.
 */
public class CreatureTest {
    /**
     * Main entry point for the test program.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        final Creature creatureDragon;
        final Creature creatureElf;
        final Creature creatureOrc;

        final Date dragonBirthDate;
        final Date elfBirthDate;
        final Date orcBirthDate;

        dragonBirthDate = new Date(2012, 9, 17);
        elfBirthDate =    new Date(1900, 11, 5);
        orcBirthDate =    new Date(500, 5, 3);

        creatureDragon = new Dragon("Sparky", dragonBirthDate, 5, 60);
        creatureElf =    new Elf("Ben", elfBirthDate, 10, 15);
        creatureOrc =    new Orc("Shobob", orcBirthDate, 12, 3);


        if (creatureDragon instanceof Dragon) {
            
            System.out.println("creatureDragon is a Dragon.");
        }

        System.out.println("creatureDragon type: " + creatureDragon.getClass().getSimpleName());

        if (creatureElf instanceof Elf) {

            System.out.println("creatureElf is an Elf.");

        }
        System.out.println("creatureElf type: " + creatureElf.getClass().getSimpleName());

        if (creatureOrc instanceof Orc) {

            System.out.println("creatureOrc is an Orc.");
        }

        System.out.println("creatureOrc type: " + creatureOrc.getClass().getSimpleName());

        creatureDragon.printDetails();
        creatureElf.printDetails();
        creatureOrc.printDetails();

        final Dragon dragon = (Dragon) creatureDragon;
        final Elf elf = (Elf) creatureElf;
        final Orc orc = (Orc) creatureOrc;

        try {

            System.out.println("- Dragon breathed fire on the Elf");

            dragon.breatheFire(elf);
            dragon.printDetails();
            elf.printDetails();
            orc.printDetails();

        } catch (LowFirePowerException e) {

            System.out.println("Attack Not allowed: the dragon's fire power was too low to breathe fire.");

        } catch (Exception e) {

            System.out.println("Unexpected problem during attack: " + e.getMessage());
        }

        try {

            System.out.println("- Elf cast a spell on the Dragon");
            elf.castSpell(dragon);
            dragon.printDetails();
            elf.printDetails();
            orc.printDetails();

        } catch (LowManaException e) {

            System.out.println("Attack Not allowed: the elf didn't have enough mana to cast the spell.");

        } catch (Exception e) {

            System.out.println("Unexpected problem during attack: " + e.getMessage());
        }

        try {

            System.out.println("- Orc went berserk on the Elf");
            orc.berserk(elf);
            dragon.printDetails();
            elf.printDetails();
            orc.printDetails();

        } catch (LowRageException e) {

            System.out.println("Attack Not allowed: the orc didn't have enough rage to go berserk");

        } catch (Exception e) {

            System.out.println("Unexpected problem during attack: " + e.getMessage());
        }

        System.out.println("Final Stats:");
        dragon.printDetails();
        elf.printDetails();
        orc.printDetails();
    }
}
