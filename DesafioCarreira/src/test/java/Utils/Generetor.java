package Utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Generetor {

    public static String dataHora(){

        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("yyyymmddhhmmss").format(ts);
    }
}
