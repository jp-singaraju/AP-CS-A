public abstract class Animal
{
    private int      age;
    private boolean  alive;
    private Field    field;
    private Location location;
    
    public Animal(Field field, Location location) {
        this.field = field;
        this.location = location;
        this.alive = true;
        this.age = 0;
    }
    
    public void setDead()
    {
        this.alive = false;
        field.remove(location);
    }
    
    public boolean isActive() {
        return this.alive;
    }
    
    public void setLocation(Location location) {
        this.location = location;
    }
    
    public Location getLocation() {
        return this.location;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public void setAge(int num) {
        this.age += num;
    }
    
    public Field getField() {
        return this.field;
    }
    
    public String toString() {
        return "Animal, " + getAge() + " y/o, at " + getLocation();
    }
    
    public abstract void act();
}
