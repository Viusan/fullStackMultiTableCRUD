package oslomet.fullstackmultitablecrud.models;

public class Crew {
    private int id;
    private String name;
    private int birth_year;
    private String country;
    private String skill;
    private int ship_id;

    public Crew(int id, String name, int birth_year, String country, String skill, int ship_id){
        this.id = id;
        this.name = name;
        this.birth_year = birth_year;
        this.country = country;
        this.skill = skill;
        this.ship_id = ship_id;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public int getBirth_year() {return birth_year;}
    public void setBirth_year(int birth_year) {this.birth_year = birth_year;}

    public String getCountry() {return country;}
    public void setCountry(String country) {this.country = country;}

    public String getSkill() {return skill;}
    public void setSkill (String skill) {this.skill = skill;}

    public int getShip_id() {return ship_id;}
    public void setShip_id(int ship_id) {this.ship_id = ship_id;}

}
