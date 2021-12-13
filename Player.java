public class Player {
    private String name;
    private int location = 0;

    Player(String name) {
        this.name = name;

    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getLocation(){
        return location;
    }

    public String getName() {
        return name;
    }
}
