package ca.bcit.comp2522.lab06;

@FunctionalInterface
public interface EligibilityRule {
    boolean isEligible(HockeyPlayer player);
}