import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Properties;

import java.sql.DatabaseMetaData;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import LUTools.TConst;

class TMySQL_JDBC {
    public String LUClassName = "TMySQL_JDBC";

    //==============================================
    //
    //==============================================
    private static final String connectionUrl = "jdbc:mysql://%1$s;databaseName=%2$s;user=%3$s;password=%4$s;";
    private static final String FDB_URL_MySQL="jdbc:mysql://localhost;databaseName=mysql_test;user=lyr;password=lyr;portNumber=3306";
    private static String FConnectionString = "";
    private static final String Fdbms = "mysql";
    private static final String FdbName = "mysql_test";
    private static final String FserverName = "localhost";
    private static final String FportNumberString = "3306";
    private static final int FportNumber = 3306;
    private static final String FDB_UserName = "lyr";
    private static final String FDB_Password = "lyr";
    private Properties FConnectionProps = null;
    public Connection FConnection = null;

    //--------------------------------------------------
    // constructor
    //--------------------------------------------------
    public void TMySQL_JDBC() {
        ;
    }
    //--------------------------------------------------
    // destructor
    //--------------------------------------------------
    void Finalize () { ; }

    //--------------------------------------------------
    // @property ConnectionString
    //--------------------------------------------------
    // getter
    //@property
    public String getConnectionString() {
        return FConnectionString;
    }
    // setter
    //@connectionString.setter
    public void setConnectionString(String Value) {
        FConnectionString = Value;
    }

    //--------------------------------------------------
    // @property Connection
    //--------------------------------------------------
    // setter
    //@Connection.setter
    public void setConnection(Connection Value) {
        FConnection = Value;
    }
    // getter
    //@property

    public void PrintConfig () {
        //beginfunction
        System.out.println("PrintConfig ...");
        System.out.println("================================================");
        System.out.println("dbms: " + Fdbms);
        System.out.println("dbName: " + FdbName);
        System.out.println("userName: " + FDB_UserName);
        System.out.println("serverName: " + FserverName);
        System.out.println("portNumber: " + FportNumber);
        System.out.println("================================================");
    }
    public void PrintConnection () {
    //beginfunction
        DatabaseMetaData LDBMD = null;
        try {
            LDBMD = FConnection.getMetaData();
            System.out.println("PrintConnection ...");
            System.out.println("================================================");
            System.out.println("Driver Name: " + LDBMD.getDriverName());
            System.out.println("Driver Version: " + LDBMD.getDriverVersion());
            System.out.println("------------------------------------------------");
            System.out.println("Connected to database");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //==============================================
    // getConnection_DriverManager() [вариант]
    //==============================================
    public Connection getConnection_DriverManager() throws ClassNotFoundException {
    //beginfunction
        System.out.println ("CreateConnection ...");
        PrintConfig ();
        //*** Установить параметры
        FConnectionProps = new Properties();
        FConnectionProps.put("user", FDB_UserName);
        FConnectionProps.put("password", FDB_Password);
        FConnectionProps.put("portNumber", FportNumberString);
        //*** Сгенерировать FConnectionString
        FConnectionString = "jdbc:"+Fdbms+":"+"//"+FserverName+";databaseName="+FdbName+
                ";user="+FDB_UserName+";password="+FDB_Password+
                ";portNumber="+FportNumber;

        FConnectionString = "jdbc:mysql://localhost:3306/mysql_test";

        System.out.println(FConnectionString);
        //System.out.println(FDB_URL_MySQL);
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            //FConnection = DriverManager.getConnection(FConnectionString);
            //FConnection = DriverManager.getConnection(FConnectionString, FDB_UserName, FDB_Password);
            FConnection = DriverManager.getConnection(FConnectionString, FConnectionProps);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        PrintConnection ();
        return FConnection;
    }

    //-------------------------------------------------------------------------------
    // DROP_Table()
    //-------------------------------------------------------------------------------
    public void DROP_Table() {
        Statement Lstatement = null;
        boolean LresultSet = true;
    //beginfunction
        System.out.println("DROP_Table posts ...");
        // getting Statement object to execute query
        try {
            Lstatement = FConnection.createStatement();
            // executing SELECT query
            String qDROP_Table = "DROP TABLE posts";
            Lstatement.executeUpdate(qDROP_Table);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close Fconnection, Lstatement and LresultSet here
            try { Lstatement.close(); } catch(SQLException se) {  }
        }
    }
    //endfunction

    //-------------------------------------------------------------------------------
    // CREATE_Table()
    //-------------------------------------------------------------------------------
    public void CREATE_Table () {
        Statement Lstatement = null;
        //beginfunction
        System.out.println("CREATE_Table posts ...");
        // getting Statement object to execute query
        try {
            Lstatement = FConnection.createStatement();
            // executing SELECT query
            String qCREATE_Table = """
                CREATE TABLE posts (
                post_id INT PRIMARY KEY NOT NULL,
                message TEXT,
                publish_date DATETIME
                );
            """;
            Lstatement.executeUpdate(qCREATE_Table);
        } catch (SQLException sqlEx) {
             sqlEx.printStackTrace();
        } finally {
            //close Fconnection, Lstatement and LresultSet here
            try { Lstatement.close(); } catch(SQLException se) {  }
        }
    //endfunction
    }
    //-------------------------------------------------------------------------------
    // INSERT_Table()
    //-------------------------------------------------------------------------------
    public void INSERT_Table () {
        Statement Lstatement = null;
        boolean LresultSet = true;
        //beginfunction
        System.out.println("INSERT_Table posts ...");
        // getting Statement object to execute query
        try {
            Lstatement = FConnection.createStatement();
            // executing SELECT query
            String qINSERT_Table = """
            INSERT INTO posts VALUES(10, 'Hey There', '2016/11/23 18:10:45');
            """;
            Lstatement.executeUpdate(qINSERT_Table);
        } catch (SQLException sqlEx) {
             sqlEx.printStackTrace();
        } finally {
            //close Fconnection, Lstatement and LresultSet here
            try { Lstatement.close(); } catch(SQLException se) {  }
        }
    //endfunction
    }
    //-------------------------------------------------------------------------------
    // SelectTable():
    //-------------------------------------------------------------------------------
    public void SELECT_Table() {
        Statement Lstatement = null;
        ResultSet LresultSet = null;
        //beginfunction
        System.out.println("SELECT_Table posts ...");
        // Statement and ResultSet are AutoCloseable and closed automatically.
        try {
            // getting Statement object to execute query
            Lstatement = FConnection.createStatement();
            // executing SELECT query
            String qSELECT_Table = "SELECT * FROM posts ORDER BY publish_date DESC";
            LresultSet = Lstatement.executeQuery(qSELECT_Table);
            while (LresultSet.next()) {
                int count = LresultSet.getRow();
                System.out.println("Message "+count+": "+LresultSet.getString(1) + " "
                        + LresultSet.getString(2) + " " + LresultSet.getTimestamp(3));
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close Fconnection, Lstatement and LresultSet here
            try { Lstatement.close(); } catch(SQLException se) {  }
            try { LresultSet.close(); } catch(SQLException se) {  }
        }
    }
    //endfunction

}

public class TEST_MySQL_JDBC {
    public static void main(String[] args) throws SQLException {
        //beginfunction
        //-------------------------------------------
        // Печать аргументов
        //-------------------------------------------
        System.out.println(args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println (i == 0 ? args[i] : "->" + args[i]);
            System.out.println(String.format("Argument %d: %s", i, args[i]));
        }
        //-------------------------------------------

        //-------------------------------------------
        // Jcommander
        //-------------------------------------------
        try {
            P1Args jArgs = new P1Args();
            JCommander helloCmd = JCommander.newBuilder().addObject(jArgs).build();
            helloCmd.parse(args);
            System.out.println ("P1=" + jArgs.getP1());
            //=====================================================
            String FileName = jArgs.getP1();
        } finally {
            System.out.println ("P1=?????");
        }

        //=====================================================
        //
        //=====================================================
        TConst MyConst = new TConst();
        System.out.println("MyConst.LogDir="+MyConst.LogDir);

        TMySQL_JDBC MySQL_JDBC = new TMySQL_JDBC();
        //-----------------------------------------------
        try {
            MySQL_JDBC.getConnection_DriverManager();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //-----------------------------------------------
        MySQL_JDBC.DROP_Table();
        //-----------------------------------------------
        MySQL_JDBC.CREATE_Table();
        //-----------------------------------------------
        MySQL_JDBC.INSERT_Table ();
        //-----------------------------------------------
        MySQL_JDBC.SELECT_Table();
        //-----------------------------------------------
        MySQL_JDBC.FConnection.close();
        System.out.println("!!!!!!!!!!");
    }
}

class P1Args {
    @Parameter(names = "-P1",description = "User name",required = true)
    private String P1;
    public String getP1() {
        return P1;
    }
}
