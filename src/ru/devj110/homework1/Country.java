package ru.devj110.homework1;

public class Country {
    private String name;
    private int square;
    private Integer population;
    private Capital capital;

    public Country(String name, int square, Integer population) {
        setName(name);
        setSquare(square);
        setPopulation(population);
    }

    public Country(String name, int square, Integer population, String capitalName, Integer capitalPopulation) {
        this(name, square, population);
        setCapital(capitalName, capitalPopulation);
    }

    public Country(String name, int square, String capitalName) {
        this(name, square, null, capitalName, null);
    }

    public void setCapital(String name, Integer population) {
        this.capital = new Capital(name, population);
    }

    public void resetCapital() {
        this.capital = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Country: " + getName() + "; square: " + getSquare() + "; population: ");
        sb.append(population == null ? "UNKNOWN" : getPopulation());
        sb.append(capital != null ? " " + capital.toString() : ";");
        return sb.toString();
    }

    public int getDensity() {
        if (population == null) return 0;
        return population / square;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Neither NULL nor empty country name is allowed");
        this.name = name;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        if (square <= 0) throw new IllegalArgumentException("Country square must be greater than 0");
        this.square = square;

    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        if (population != null && population <= 0)
            throw new IllegalArgumentException("Country population must be greater than 0");
        this.population = population;
    }

    public String getCapitalName() {
        if (capital == null) throw new IllegalArgumentException("This country has no capital to get its name");
        return capital.getName();
    }

    public void setCapitalName(String capitalName) {
        if (capital == null) throw new IllegalArgumentException("This country has no capital to set its name");
        capital.setName(capitalName);
    }

    public int getCapitalPopulation() {
        if (capital == null) throw new IllegalArgumentException("This country has no capital to get its Population");
        return capital.getPopulation();
    }

    public void setCapitalPopulation(int capitalPopulation) {
        if (capital == null) throw new IllegalArgumentException("This country has no capital to set its Population");
        capital.setPopulation(capitalPopulation);
    }

    public static void printAll(Country[] countries) {
        for (Country country : countries) {
            System.out.println(country.toString());
        }
    }


    private class Capital {
        private String name;
        private Integer population;

        public Capital(String name, Integer population) {
            setName(name);
            setPopulation(population);
        }

        public Capital(String name) {
            this(name, null);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            if (name == null || name.isEmpty())
                throw new IllegalArgumentException("Neither NULL nor empty capital name is allowed");
            this.name = name;
        }

        public int getPopulation() {
            return population;
        }

        public void setPopulation(Integer population) {
            if (population != null && population <= 0)
                throw new IllegalArgumentException("Capital population must be greater than 0");
            this.population = population;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("Capital: " + getName() + "; capital population: ");
            sb.append(population != null ? getPopulation() : "UNKNOWN");
            sb.append(';');
            return sb.toString();
        }
    }
}
