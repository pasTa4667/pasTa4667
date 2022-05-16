package api;

/** Bird that can do stuff. */
public final class Eagle extends AbstractBird implements BirdOfPrey {

    protected static final int HUNTED_FOOD_VALUE = 10;
    protected static final int TAKEOFF_FOOD_COST = 3;
    protected final String name;

    public Eagle(int food, String name) {
        super(food, 2);
        this.name = name;
    }

    public Eagle(String name, int legs){
        super(legs);
        this.name = name;
    }

    @Override
    public void hunt() {
        takeOff();
        move();
        land();
        eat(HUNTED_FOOD_VALUE);
    }

    @Override
    public void land() {
        try {
            burnFood();
            super.land();
        } catch (AnimalIsDeadException ex) {
            // Not beautiful, should be rethrown. But for now this is ok.
            System.err.println("Not possilbe, animal dead!");
        }
    }

    @Override
    public void takeOff() {
        try {
            burnFood(TAKEOFF_FOOD_COST);
            super.takeOff();
        } catch (AnimalIsDeadException ex) {
            // Not beautiful, should be rethrown. But for now this is ok.
            System.err.println("Not possilbe, animal dead!");
        }
    }

    @Override
    public void move() {
        try {
            burnFood();
        } catch (AnimalIsDeadException ex) {
            // Not beautiful, should be rethrown. But for now this is ok.
            System.err.println("Not possilbe, animal dead!");
        }
    }

    @Override
    public String toString(){
        return "Bird Name: " + name;
    }

    public <T extends Eagle> boolean equals(T eagle){
        return this.name == eagle.name;
    }


}
