package connection.enums;

/**
 * @author AKBAR <akbar.attijani@gmail.com>
 */
public enum DBMS {
    MYSQL("com.mysql.jdbc.Driver"),
    ORACLE("org.postgresql.Driver"),
    POSTGRESQL("org.postgresql.Driver"),
    SQLSERVER("com.microsoft.sqlserver.jdbc.SQLServerDriver"),
    SQLITE("org.sqlite.JDBC"),
    ACCESS("sun.jdbc.odbc.JdbcOdbcDriver");

    private final String responseCode;

    DBMS(final String response) {
        responseCode = response;
    }

    @Override
    public String toString() {
        return responseCode;
    }
}
