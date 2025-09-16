public class Bird {
    private String species;
    private String colour;
    private boolean canFly;
    private boolean isAlive;
    private String name;

    public Bird(String name, String species, String colour, boolean canFly) {
        this.name = name;
        this.species = species;
        this.colour = colour;
        this.canFly = canFly;
        this.isAlive = true;
    }

    public String toString() {
        String flyword = !canFly ? "not": "";
        String status = isAlive ? "alive": "dead";
        return name + " is a " + colour + " " + species + ". " + name + " can" + flyword + " fly. " + name + "is " + status + ".";
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if(o == this) {
            return true;
        }

        if(o instanceof Bird) {
            Bird b = (Bird)o;
            return this.name.equals(b.name) && this.species.equals(b.species) && this.colour.equals(b.colour);
        }

        return false;
    }

    public int hashCode() {
        int hCode = 17;
        hCode = 31 * hCode + name.hashCode();
        hCode = 31 * hCode + species.hashCode();
        hCode = 31 * hCode + colour.hashCode();
        
        return hCode;
    }
}
