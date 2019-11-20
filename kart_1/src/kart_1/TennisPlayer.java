package kart_1;

/**
 * @author mackr
 * @version 1.0
 * Class which represents tennis player
 */
public class TennisPlayer implements Comparable<TennisPlayer>{
    private int position;
    private String country;
    private String name;
    private String surname;
    private int age;
    private int points;
    private int championships;
    /**
     * Constructor
     * @param position
     * @param country
     * @param name
     * @param surname
     * @param age
     * @param points
     * @param championships
     */
    public TennisPlayer(int position, String country, String name, String surname,
                        int age, int points, int championships) {
        this.position = position;
        this.country = country;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.points = points;
        this.championships = championships;
    }
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public int getChampionships() {
        return championships;
    }
    public void setChampionships(int championships) {
        this.championships = championships;
    }
    /**
     * Compare to method which compare two tennis players by age
     * @param o tennis player to compare
     * @return zero/negative/positive integer if object is equal/less/greater than
    specified object
     */
    @Override
    public int compareTo(TennisPlayer o) {
        return Double.compare(age,o.age);
    }
    /**
     * Print all parameters of tennis player
     * @return String
     */
    @Override
    public String toString() {
        return "TennisPlayer{" +
                "position=" + position +
                ", country='" + country + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", points=" + points +
                ", championships=" + championships +
                '}';
    }
}
