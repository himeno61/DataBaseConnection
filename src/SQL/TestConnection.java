package SQL;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TestConnection {
    public static void main(String[] args) throws SQLException {
        ConnectionToOracle test = new ConnectionToOracle("lbinkiew","lbinkiew");
        try{
            test.getDBConnection();
            System.out.println("ok");
        }
        catch (SQLException s){
            System.out.println("fail");
        }
        List<Address> employerList = test.selectAllAdress();
        for (Address e: employerList) System.out.println(e.toString());
        //test.insertAddress("Krucza 5",51202,"Warszawa");
        //for (Address e: employerList) System.out.println(e.toString());
       //test.updateAddress(82,"Polna 10",45076,"Warszawa");
        test.deleteAddress(81);
        EmployeeInfo employeeInfo = test.getInfoEmployee();
        System.out.println(employeeInfo);
        List<SalaryCount> salaryCounts = new LinkedList<>();
        salaryCounts = test.getSalyCount();
        for (SalaryCount s: salaryCounts) {
            System.out.println(s);
        }
    }
}
