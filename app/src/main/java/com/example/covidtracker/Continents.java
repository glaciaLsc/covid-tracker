package com.example.covidtracker;

/*
TODO: Add all missing countries to respective continent arrays
 */
public abstract class Continents {
    public static String[] africaCountries = {
            "Algeria",
            "Angola",
            "Benin",
            "Botswana",
            "Burkina Faso",
            "Burundi",
            "Cameroon",
            "Cape Verde",
            "Central African Republic",
            "Congo (Brazzaville)",
            "Congo (Kinshasa)"
    };
    public static String[] asiaCountries = {
            "Afghanistan",
            "Bangladesh",
            "Cambodia",
            "China",
            "Egypt",
            "India",
            "Indonesia",
            "Iran",
            "Iraq",
            "Israel",
            "Japan",
            "Kazakhstan",
            "Korea (North)",
            "Korea (South)",
            "Russian Federation",
            "Singapore",
            "Syria",
            "Turkey",
            "United Arab Emirates",
            "Viet Nam",
    };
    public static String[] australiaCountries = {
            "Australia",
            "Fiji",
            "New Zealand",
            "Papua New Guinea",
    };
    public static String[] europeCountries = {
            "Albania",
            "Andorra",
            "Austria",
            "Belarus",
            "Belgium",
            "Bosnia and Herzegovina",
            "Bulgaria",
            "Croatia",
            "Czech Republic",
            "France",
            "Germany",
            "Greece",
            "Hungary",
            "Ireland",
            "Italy",
            "Monaco",
            "Netherlands",
            "Norway",
            "Poland",
            "Portugal",
            "Spain",
            "Sweden",
            "Switzerlan",
            "Turkey",
            "Ukraine",
            "United Kingdom",
    };
    public static String[] northAmericaCountries = {
            "United States",
            "Mexico",
            "Canada",
            "Guatemala",
            "Cuba",
            "Haiti",
            "Dominican Republic",
            "Honduras",
            "El Salvador",
            "Nicaragua",
            "Costa Rica",
            "Panama",
            "Puerto Rico",
            "Jamaica",
            "Trinidad and Tobago",
            "Bahamas",
            "Belize",
            "Barbados",
            "Saint Lucia",
            "Saint Vincent and the Grenadines"
    };
    public static String[] southAmericaCountries = {
            "Argentina",
            "Bolivia",
            "Brazil",
            "Chile",
            "Colombia",
            "Ecuador",
            "Guyana",
            "Paraguay",
            "Peru",
            "Suriname",
            "Uruguay",
            "Venezuela",
            "Falkland Islands (Malvinas)",
    };

    public static String[] getAfricaCountries() {
        return africaCountries;
    }
    public static String[] getAsiaCountries() {
        return asiaCountries;
    }
    public static String[] getAustraliaCountries() {
        return australiaCountries;
    }
    public static String[] getEuropeCountries() {
        return europeCountries;
    }
    public static String[] getNorthAmericaCountries() {
        return northAmericaCountries;
    }
    public static String[] getSouthAmericaCountries() {
        return southAmericaCountries;
    }
}