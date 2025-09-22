package ca.bcit.comp2522.project;

import java.util.Arrays;

/**
 * Country class
 *
 * @author Braeden Sowinski
 * @version 1.0.0
 */
public class Country {
    final String name;
    final String capitalCityName;
    final String[] facts;

    Country(
        final String name,
        final String capitalCityName,
        final String[] facts
    ) {
        this.name = name;
        this.capitalCityName = capitalCityName;
        this.facts = facts;
    }
}
