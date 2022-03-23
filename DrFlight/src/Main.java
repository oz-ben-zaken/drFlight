import Dao.*;
import Facade.*;

import Poco.*;

import java.sql.Timestamp;


public class Main {
    public static void main(String[] args) {

        var foo = new AirlineCompanyDao();
        for (var i : foo.getAll())
            System.out.println(i);

        //foo.remove(new AirlineCompany(4, "air tours", 1, 2));

        for (var i : foo.getAll())
            System.out.println(i);
        AnonymousFacade af = new AnonymousFacade();

        FacadeBase fb = af.Login("oz", "oz123");
        //System.out.println(fb.toString());
        Timestamp date = Timestamp.valueOf("2022-03-27 00:00:00");

    }
}
