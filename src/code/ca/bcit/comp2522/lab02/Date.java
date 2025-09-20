package ca.bcit.comp2522.lab02;

/**
 * Date contains useful methods about a given date.
 *
 * @author Braeden Sowinski
 * @author Nico Agostini
 * @author Trishaan Shetty
 * @author Calvin Arifianto
 * @version 1.0.0
 */
public final class Date {
    public static final int MAX_YEAR = 2025;

    // Domain of dates
    private static final int MIN_YEAR = 0;
    private static final int MIN_DAY = 1;
    private static final int CURRENT_DAY = 15;
    private static final int CURRENT_MONTH = 9;

    // Constants for calculating leap year, and days in given month
    private static final int YEARS_BTWN_LEAP_YEARS = 4;
    private static final int YEARS_PER_CENTURY = 100;
    private static final int YEARS_BTWN_LEAP_CENTURIES = 400;
    private static final int LEAP_YEAR_MOD_RESULT = 0;
    private static final int LEAP_YEAR_DAYS = 29;
    private static final int NON_LEAP_YEAR_DAYS = 28;
    private static final int MONTH_MOST_DAYS = 31;
    private static final int MONTH_REGULAR_DAYS = 30;
    private static final int EVEN = 2;
    private static final int IS_DIVISIBLE = 1;

    // Constants to get next or last value
    private static final int GET_NEXT = 1;
    private static final int GET_PREVIOUS = 1;

    // Constants to add to sum for calculating day of week
    private static final int CENTURY_CODE_YEAR_EIGHTEEN_HUNDREDS = 2;
    private static final int CENTURY_CODE_YEAR_TWO_THOUSANDS = 6;
    private static final int CENTURY_CODE_AND_MONTH_CODE = 12;

    // Century definitions
    private static final int YEAR_EIGHTEEN_HUNDREDS = 1800;
    private static final int YEAR_NINETEEN_HUNDREDS = 1900;
    private static final int YEAR_TWO_THOUSANDS = 2000;

    // Months
    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;
    private static final int MARCH = 3;
    private static final int APRIL = 4;
    private static final int MAY = 5;
    private static final int JUNE = 6;
    private static final int JULY = 7;
    private static final int AUGUST = 8;
    private static final int SEPTEMBER = 9;
    private static final int OCTOBER = 10;
    private static final int NOVEMBER = 11;
    private static final int DECEMBER = 12;

    // Days of week
    private static final int SATURDAY = 0;
    private static final int SUNDAY = 1;
    private static final int MONDAY = 2;
    private static final int TUESDAY = 3;
    private static final int WEDNESDAY = 4;
    private static final int THURSDAY = 5;
    private static final int FRIDAY = 6;

    // Constants used to calculate day of week
    private static final int DIVISION_BY_TWELVE = 12;
    private static final int DIVISION_BY_FOUR = 4;
    private static final int DAYS_OF_WEEK = 7;
    private static final String MONTH_CODES = "144025036146";

    private final int year;
    private final int month;
    private final int day;

    /*
        isLeapYear calculates if a given year is a leap year or not.

        a) A year is a leap year if it is divisible by LEAP_YEAR_MOD_FOUR,

        b) If the year is also divisible by LEAP_YEAR_MOD_ONE_HUNDRED then
           it is not a leap year.

        c) If the year is divisible by LEAP_YEAR_MOD_ONE_HUNDRED and is
           divisible by LEAP_YEAR_MOD_FOUR_HUNDRED, then it is a leap year.
     */
    private static boolean isLeapYear(final int year) {

        final boolean isLeapYear;
        final boolean leapYearRuleOne;
        final boolean leapYearRuleTwo;

        leapYearRuleOne = (year % YEARS_BTWN_LEAP_CENTURIES) == LEAP_YEAR_MOD_RESULT;
        leapYearRuleTwo = (year % YEARS_BTWN_LEAP_YEARS == LEAP_YEAR_MOD_RESULT && year % YEARS_PER_CENTURY != LEAP_YEAR_MOD_RESULT);

        isLeapYear = leapYearRuleOne || leapYearRuleTwo;

        return isLeapYear;
    }

    /*
        daysInMonth calculates the max number of days in a given month.

        If the month is February, we must know if it is a leap year or
        not, as the numbers of days changes.

        Otherwise, for any other month, we determine if the month comes
        before August, as every odd month from January to July, has
        MONTH_MOST_DAYS, and every even month has MONTH_REGULAR_DAYS.

        If the month is after August, then from August to December every
        odd month hsa MONTH_MOST_DAYS, and every even month has
        MONTH_REGULAR_DAYS.
     */
    private static int daysInMonth(
            final int month,
            final boolean isLeapYear
    ) {

        if (month == FEBRUARY) {
            if (isLeapYear) {
                return LEAP_YEAR_DAYS;
            } else {
                return NON_LEAP_YEAR_DAYS;
            }
        }

        final boolean longMonth;

        if (month <= JULY) {
            longMonth = (month % EVEN) == IS_DIVISIBLE;
        } else {
            longMonth = ((month + GET_NEXT) % EVEN) == IS_DIVISIBLE;
        }

        if (longMonth) {
            return MONTH_MOST_DAYS;
        } else {
            return MONTH_REGULAR_DAYS;
        }
    }

    /*
        validateYear checks input year is in valid range
     */
    private static void validateYear(final int year)
            throws IllegalArgumentException
    {

        if (year < MIN_YEAR || year > MAX_YEAR) {
            throw new IllegalArgumentException("invalid year");
        }
    }

    /*
        validateMonth checks input month is in valid range
     */
    private static void validateMonth(final int month)
            throws IllegalArgumentException
    {

        if (month < JANUARY || month > DECEMBER) {
            throw new IllegalArgumentException("invalid month");
        }
    }

    /*
        validateDay ensures the day given is less than the max day
        calculated by daysInMonth and greater than the MIN_DAY
     */
    private static void validateDay(
            final int day,
            final int month,
            final int year
    )
            throws IllegalArgumentException
    {

        final boolean leapYear;
        final int maxDays;

        leapYear = isLeapYear(year);
        maxDays = daysInMonth(month, leapYear);

        if (day < MIN_DAY || day > maxDays) {
            throw new IllegalArgumentException("invalid day");
        }
    }

    /**
     * Date constructor
     * @param year int
     * @param month int
     * @param day int
     */
    public Date(
            final int year,
            final int month,
            final int day
    ) {

        validateYear(year);
        validateMonth(month);
        validateDay(day, month, year);

        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * getYear of Date
     * @return year
     */
    public final int getYear() {

        return this.year;
    }

    /**
     * getMonth of Date
     * @return month
     */
    public final String getMonth() {

        final String month;

        if (this.month == JANUARY) {
            month = "January";
        } else if (this.month == FEBRUARY) {
            month = "February";
        } else if (this.month == MARCH) {
            month = "March";
        } else if (this.month == APRIL) {
            month = "April";
        } else if (this.month == MAY) {
            month = "May";
        } else if (this.month == JUNE) {
            month = "June";
        } else if (this.month == JULY) {
            month = "July";
        } else if (this.month == AUGUST) {
            month = "August";
        } else if (this.month == SEPTEMBER) {
            month = "September";
        } else if (this.month == OCTOBER) {
            month = "October";
        } else if (this.month == NOVEMBER) {
            month = "November";
        } else if (this.month == DECEMBER) {
            month = "December";
        } else {
            throw new IllegalArgumentException("invalid month");
        }

        return month;
    }

    /**
     * getDay of Date
     * @return day
     */
    public final int getDay() {

        return this.day;
    }

    /**
     * getYyyyMmDd formatted as string
     * @return date in YyyyMmDd format
     */
    public final String getYyyyMmDd() {

        final String date;

        date = this.year + "-" +  this.month + "-" + this.day;

        return date;
    }

    /**
     * getDayOfWeek
     *
     * To get the day of the week, do the following seven steps for dates in the 1900s:
     *
     * e.g. October 31 1977:
     * step 1: calculate the number of twelves in 77:
     * 6
     * step 2: calculate the remainder from step 1: 77 - 12*6 = 77 - 72 =
     * 5
     * step 3: calculate the number of fours in step 2: 5/4 = 1.25, so
     * 1
     * step 4: add the day of the month to each step above: 31 + 6 + 5 + 1 =
     * 43
     * step 5: add the month code (for jfmamjjasond: 144025036146): for october it is 1: 43 + 1 =
     * 44
     * step 6: add the previous five numbers: (44) and mod by 7: 44%7 = 2 (44/7 = 6 remainder 2)
     * step 7: sat sun mon tue wed thu fri is 0 1 2 3 4 5 6; our 2 means Oct 31 1977 was monday
     * Extra notes:
     * a) for January/February dates in leap years, add 6 at the start
     * b) for all dates in the 2000s, add 6 at the start
     * c) for all dates in the 1800s, add 2 at the star
     *
     * @return day of week
     */
    public final String getDayOfWeek() {

        final int year;
        final int century;
        final String monthCode;

        final int step0;
        final int step1;
        final int step2;
        final int step3;
        final int step4;
        final int step5;

        final int dayIndex;
        final String day;

        monthCode = MONTH_CODES.charAt(this.month - GET_PREVIOUS) + "";

        if (this.year < YEAR_NINETEEN_HUNDREDS) {
            century = YEAR_EIGHTEEN_HUNDREDS;
        } else if (this.year < YEAR_TWO_THOUSANDS) {
            century = YEAR_NINETEEN_HUNDREDS;
        } else {
            century = YEAR_TWO_THOUSANDS;
        }

        year = this.year - century;

        if (
                isLeapYear(this.year) &&
                        (this.month == JANUARY || this.month == FEBRUARY) &&
                        this.year >= YEAR_TWO_THOUSANDS
        ) {

            step0 = CENTURY_CODE_AND_MONTH_CODE;

        } else if (
                isLeapYear(this.year) &&
                        (this.month == JANUARY || this.month == FEBRUARY)
        ) {
            step0 = CENTURY_CODE_YEAR_TWO_THOUSANDS;
        } else if (this.year >= YEAR_TWO_THOUSANDS) {
            step0 = CENTURY_CODE_YEAR_TWO_THOUSANDS;
        } else if (this.year < YEAR_NINETEEN_HUNDREDS) {
            step0 = CENTURY_CODE_YEAR_EIGHTEEN_HUNDREDS;
        } else {
            step0 = 0;
        }

        step1 = year / DIVISION_BY_TWELVE;
        step2 = year - (DIVISION_BY_TWELVE * step1);
        step3 = step2 / DIVISION_BY_FOUR;
        step4 = this.day + step0 + step1  + step2 + step3;
        step5 = step4 + Integer.parseInt(monthCode);

        dayIndex = step5 % DAYS_OF_WEEK;

        if (dayIndex == SATURDAY) {
            day = "Saturday";
        } else if (dayIndex == SUNDAY) {
            day = "Sunday";
        } else if (dayIndex == MONDAY) {
            day = "Monday";
        } else if (dayIndex == TUESDAY) {
            day = "Tuesday";
        } else if (dayIndex == WEDNESDAY) {
            day = "Wednesday";
        } else if (dayIndex == THURSDAY) {
            day = "Thursday";
        } else if (dayIndex == FRIDAY) {
            day = "Friday";
        } else {
            throw new IllegalArgumentException("invalid day");
        }

        return day;
    }

    public boolean isInFuture() {

        if (this.year > MAX_YEAR) {
            return true;
        } else if (this.year == MAX_YEAR &&
                   this.month > CURRENT_MONTH) {
            return true;
        } else if (this.year == MAX_YEAR &&
                   this.month == CURRENT_MONTH &&
                   this.day > CURRENT_DAY) {
            return true;
        }

        return false;
    }
}
