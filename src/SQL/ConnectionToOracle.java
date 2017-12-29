package SQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import oracle.jdbc.pool.OracleDataSource; 

public class ConnectionToOracle {
    public ConnectionToOracle() {
    }
    public ConnectionToOracle(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
    private String jdbcUrl = "jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf";
    private String userId ;
    private String password;
    private Connection dbConnection;

    public Connection getDBConnection() throws SQLException{
        OracleDataSource ds;
        ds = new OracleDataSource();
        ds.setURL(jdbcUrl);
        dbConnection=ds.getConnection(userId,password);
        return dbConnection;
    }

    public List<Address> selectAllAdress()throws SQLException{
        Statement statement = null;
        String selectTableSQL = "SELECT * from ADDRESS";
        statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
        List<Address> addressList = new LinkedList<>();
        while (rs.next()){
            addressList.add( new Address(rs.getInt("ADDRESS_ID"),rs.getString("STREET"),
                    rs.getInt("ZIP_CODE"),rs.getString("city"))
            );
        }
        return  addressList;
    }

    public List<Employer> selectAllEmployers()throws SQLException{
        Statement statement = null;
        String selectTableSQL = "SELECT * from EMPLOYER";
        statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
        List<Employer> employerList = new LinkedList<>();
        while (rs.next()){
            employerList.add( new Employer(rs.getInt("ADDRESS_ID"),rs.getLong("NIP"),
                    rs.getString("COMPANY_NAME"),
                    rs.getLong("PHONE"),
                    rs.getString("WEBSITE"))
            );
        }
        return  employerList;
    }
    public void insertAddress(String street, Integer zip_code, String city)throws SQLException {
        Statement statement = null;
        String insertTableSQL = "INSERT into ADDRESS (street,zip_code,city)values "
                + "("
                + "'"+street + "'"+ ","
                + "'"+zip_code.toString() + "'"+ ","
                + "'"+city + "'"
                + ")";
        statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(insertTableSQL);
    }

    public void updateAddress (Integer id, String street, Integer zip_code, String city) throws SQLException {
        Statement statement = null;
        String insertTableSQL = "UPDATE ADDRESS SET "
                + "ADDRESS.STREET = " + "'"+street + "'"+","
                + "ADDRESS.ZIP_CODE = " + "'"+zip_code.toString() + "'"+","
                + "ADDRESS.CITY = " + "'"+city + "' "
                + "WHERE ADDRESS.ADDRESS_ID = "+id;
        statement = dbConnection.createStatement();
        statement.executeQuery(insertTableSQL);
    }
    public void deleteAddress (Integer id) throws SQLException {
        Statement statement = null;
        String deleteTableSQL ="DELETE FROM ADDRESS WHERE "
                + "ADDRESS.ADDRESS_ID = "+id;
        statement = dbConnection.createStatement();
        statement.executeQuery(deleteTableSQL);
    }

    public EmployeeInfo getInfoEmployee () throws  SQLException{
        Statement statement = null;
        String selectTableSQL = "SELECT "
                + "min(employee.age) MIN,  "
                + "max(employee.age) MAX,"
                + "avg(employee.age) AVG "
                + "FROM EMPLOYEE";
        statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
        if(rs.next())
            return  new EmployeeInfo(rs.getInt("MIN"),
                    rs.getInt("MAX"),
                    rs.getInt("AVG"));
        return null;
    }

    public List<SalaryCount> getSalyCount () throws SQLException{
        Statement statement = null;
        String selectTableSQL = "SELECT SALLARY, COUNT(SALLARY) AS COUNT FROM JOB_OFFER GROUP BY SALLARY ";
        statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
        List<SalaryCount> salaryCountList= new LinkedList<>();
        while(rs.next()){
            salaryCountList.add(new SalaryCount(rs.getInt("SALLARY"),rs.getInt("COUNT")));
        }
        return salaryCountList;
    }
}