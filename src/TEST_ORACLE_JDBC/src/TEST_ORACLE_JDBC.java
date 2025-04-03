import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Properties;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

import java.sql.DatabaseMetaData;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import LUTools.TConst;

class TORACLE_JDBC {
    public String LUClassName = "TORACLE_JDBC";
    //==============================================
    // 00 вариант
    //==============================================
    //static String FDB_URL_ORACLE= "jdbc:oracle:thin:@localhost:1521/ORCL";
    private String FConnectionString = "";
    private String Fdbms = "oracle";
    public String FdbName = "ORCL";
    private String FserverName = "@localhost";
    private int FportNumber = 1521;
    private static final String FDB_UserName = "lyr";
    private static final String FDB_Password = "lyr";
    public OracleConnection FConnectionOracle = null;
    private Properties FConnectionProps = null;

    //--------------------------------------------------
    // constructor
    //--------------------------------------------------
    public TORACLE_JDBC() {
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
        return this.FConnectionString;
    }
    // setter
    //@connectionString.setter
    public void setConnectionString(String Value) {
        this.FConnectionString = Value;
    }

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
        //*** Get the JDBC driver name and version
        DatabaseMetaData LDBMD = null;
        try {
            LDBMD = FConnectionOracle.getMetaData();
            System.out.println("PrintConnection ...");
            System.out.println("================================================");
            System.out.println("Driver Name: " + LDBMD.getDriverName());
            System.out.println("Driver Version: " + LDBMD.getDriverVersion());
            System.out.println("------------------------------------------------");
            // Print some connection properties
            System.out.println("AutoClose="+FConnectionOracle.getAutoClose());
            System.out.println("Default Row Prefetch Value is: " + FConnectionOracle.getDefaultRowPrefetch());
            System.out.println("Database Username is: " + FConnectionOracle.getUserName());
            System.out.println("================================================");
            System.out.println("Connected to database");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //--------------------------------------------------
    // @property Connection
    //--------------------------------------------------
    // setter
    //@Connection.setter
    public void setConnection(OracleConnection Value) {
        FConnectionOracle = Value;
    }
    // getter
    //@property
    //==============================================
    // getConnection_DriverManager() [вариант]
    //==============================================
    public OracleConnection getConnection_DriverManager() {
    //beginfunction
        System.out.println ("CreateConnection_DriverManager ...");
        PrintConfig ();
        //*** Установить параметры
        FConnectionProps = new Properties();
        FConnectionProps.put("user", FDB_UserName);
        FConnectionProps.put("password", FDB_Password);
        //*** Сгенерировать FConnectionString
        FConnectionString = "jdbc:" + Fdbms + ":" + "thin"+ ":" + FserverName + ":" + FportNumber + "/"+FdbName;
        System.out.println(FConnectionString);
        //*** Создать FConnectionOracle
        try {
            //FConnectionOracle = (OracleConnection) DriverManager.getConnection(FConnectionString, FDB_UserName, FDB_Password);
            FConnectionOracle = (OracleConnection) DriverManager.getConnection(FConnectionString, FConnectionProps);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        PrintConnection ();
        return FConnectionOracle;
    }
    //==============================================================
    // getConnection_OracleConnection() [вариант]
    //==============================================================
    public OracleConnection getConnection_OracleConnection() {
    //beginfunction
        System.out.println ("CreateConnection_OracleConnection ...");
        PrintConfig ();
        //*** Установить параметры
        FConnectionProps = new Properties();
        FConnectionProps.put(OracleConnection.CONNECTION_PROPERTY_USER_NAME, FDB_UserName);
        FConnectionProps.put(OracleConnection.CONNECTION_PROPERTY_PASSWORD, FDB_Password);
        //FConnectionProps.put(OracleConnection.CONNECTION_PROPERTY_DEFAULT_ROW_PREFETCH, "20");
        //*** Сгенерировать FConnectionString
        FConnectionString = "jdbc:" + Fdbms + ":" + "thin"+ ":" + FserverName + ":" + FportNumber + "/"+FdbName;
        System.out.println(FConnectionString);
        //*** Создать FConnectionOracle
        try {
            OracleDataSource LODS = new OracleDataSource();
            LODS.setURL (FConnectionString);
            LODS.setConnectionProperties(FConnectionProps);
            // With AutoCloseable, the connection is closed automatically.
            FConnectionOracle = (OracleConnection) LODS.getConnection();
            PrintConnection ();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ;
        }
        return FConnectionOracle;
    }
    //endfunction

    //-------------------------------------------------------------------------------
    // DROP_Table()
    //-------------------------------------------------------------------------------
    public void DROP_Table() {
        Statement Lstatement = null;
        ResultSet LresultSet = null;
    //beginfunction
        System.out.println("DROP_Table posts ...");
        // getting Statement object to execute query
        try {
            Lstatement = FConnectionOracle.createStatement();
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
            Lstatement = FConnectionOracle.createStatement();
            // executing SELECT query
            String qCREATE_Table = """
            CREATE TABLE posts (
                    post_id INT PRIMARY KEY NOT NULL,
                    message varchar2(1000),
                    publish_date DATE
            )
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
        ResultSet LresultSet = null;
        //beginfunction
        System.out.println("INSERT_Table posts ...");
        // getting Statement object to execute query
        try {
            Lstatement = FConnectionOracle.createStatement();
            // executing SELECT query
            String qINSERT_Table = """
            INSERT INTO posts VALUES(10, 'Hey There', '23.11.2016')
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
            Lstatement = FConnectionOracle.createStatement();
            // executing SELECT query
            String qSELECT_Table = "SELECT * FROM posts ORDER BY publish_date DESC";
            LresultSet = Lstatement.executeQuery(qSELECT_Table);
            while (LresultSet.next()) {
                int count = LresultSet.getRow();
                System.out.println("getRow: " + count);
                System.out.println("Message: "+LresultSet.getString(1) + " "
                        + LresultSet.getString(2) + " " + LresultSet.getDate(3));
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

public class TEST_ORACLE_JDBC {
    public static void main(String[] args) throws SQLException {
        //beginfunction
        //-------------------------------------------
        // Печать аргументов
        //-------------------------------------------
        System.out.println(args.length);
        for (int i = 0; i < args.length; i++) {
            //System.out.println (i == 0 ? args[i] : "->" + args[i]);
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
        System.out.println(MyConst.LogDir);

        TORACLE_JDBC ORACLE_JDBC = new TORACLE_JDBC();
        //-----------------------------------------------
        ORACLE_JDBC.getConnection_DriverManager();
        //-----------------------------------------------
        ORACLE_JDBC.DROP_Table();
        //-----------------------------------------------
        ORACLE_JDBC.CREATE_Table();
        //-----------------------------------------------
        ORACLE_JDBC.INSERT_Table ();
        //-----------------------------------------------
        ORACLE_JDBC.SELECT_Table();
        //-----------------------------------------------
        ORACLE_JDBC.FConnectionOracle.close();
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
