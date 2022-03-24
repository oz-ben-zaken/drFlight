package Poco;

public class Country implements Poco{
    public int id;
    public String name;
    public String flagUrl = "\\resources\\FlagImg\\def_flag";;

    public Country(int id, String name, String url) {
        this.id = id;
        this.name = name;
        if(!(url == null))
            this.flagUrl = url;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
