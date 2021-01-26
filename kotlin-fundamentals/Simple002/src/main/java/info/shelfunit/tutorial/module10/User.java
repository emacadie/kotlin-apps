package info.shelfunit.tutorial.module10;

public class User {
    private String name;
    public User( String argName ) {
        this.name = argName;
    }

    public void create( Created created ) {
        created.onCreate( this );
    }

    @Override
    public String toString() {
        return "User{ " + "name = '" + name + "' }";
    }
}
