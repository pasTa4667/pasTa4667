package api;

/** Abstract class for animals. */
public abstract class AbstractAnimal implements Ingestable, Moveable {

    protected static final int HUNGER_LIMIT = 10;

    protected final int legs;
    private int food;

    protected AbstractAnimal(int food, int legs) {

        if(legs < 0 || legs > 1000){
            System.out.println("worked");
            throw new IllegalArgumentException();
        }else this.legs = legs;

        this.food = food;

    }

    @Override
    public void eat() {
        this.food = this.food + 1;
    }

    @Override
    public void eat(int food) {
        for (int i = food; i > 0; i--) {
            eat();
        }
    }

    @Override
    public boolean isHungry() {
        return food <= HUNGER_LIMIT;
    }

    @Override
    public boolean isDead() {
        return food <= 0;
    }

    protected void burnFood() throws AnimalIsDeadException {
        if(this.isDead()){
            throw new AnimalIsDeadException();
        }else{
            this.food = this.food - 1;
        }

    }

    protected void burnFood(int food) throws AnimalIsDeadException {
        for (int i = food; i > 0; i--) {
            burnFood();
        }
    }

}