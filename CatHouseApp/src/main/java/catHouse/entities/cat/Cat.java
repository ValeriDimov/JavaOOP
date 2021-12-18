package catHouse.entities.cat;

public interface Cat {
    String getName();

    void setName(String name);

    int getKilograms();

    double getPrice();

    public abstract void eating();
}
