import net.xqj.exist.ExistXQDataSource;

import javax.xml.xquery.*;

/**
 * Created by 46066294p on 18/02/16.
 */
public class Principal {
    public static void main(String[] args) throws XQException {

        XQDataSource xqs = new ExistXQDataSource();
        xqs.setProperty("serverName", "172.31.101.228");
        xqs.setProperty("port", "8080");

        XQConnection conn = xqs.getConnection();

        //String desdeData = "1992-01-01";

        /*
        String cad = "for $i in fn:doc(\"mondial.xml\")//country[contains(goverment, 'democracy')" +
                "and indep_date >='" + "1982-03-11" + "'] " +
                "return concat($i/name,' - ',$i/goverment,' - ',$i/indep_date)";
                */

        String cad = "for $i in fn:doc(\"mondial.xml\")//country[contains(government,'democracy')" +
                "and indep_date >='"+"1982-03-11"+"'] " +
                "return concat($i/name,' - ',$i/govenment,' - ',$i/indep_date)";

        XQPreparedExpression xqpe = conn.prepareExpression(cad);

        XQResultSequence rs = xqpe.executeQuery();

        while(rs.next()){
            System.out.println(rs.getItemAsString(null));

        }

        conn.close();


    }//main

}//Principal
