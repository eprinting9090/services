package connection;

import play.libs.F;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;

import java.sql.DriverManager;

/**
 * @author AKBAR <akbar.attijani@gmail.com>
 */
public class DatabaseAction extends Action<Database> {

    @Override
    public F.Promise<Result> call(Http.Context context) {
        try {
            Database check = configuration;
            String host = check.host();
            String port = check.port();
            String databaseName = check.databaseName();
            String schema = check.schema();
            String username = check.userName();
            String password = check.password();

            Class.forName(check.database().toString());
            switch (check.database()) {
                case ACCESS:
                    Connection.setConnection(DriverManager.getConnection(Server.access(host, port, databaseName, username, password)));
                    break;
                case MYSQL:
                    Connection.setConnection(DriverManager.getConnection(Server.mysql(host, port, databaseName, username, password)));
                    break;
                case ORACLE:
                    Connection.setConnection(DriverManager.getConnection(Server.oracle(host, port, databaseName, username, password)));
                    break;
                case POSTGRESQL:
                    Connection.setConnection(DriverManager.getConnection(Server.postgresql(host, port, databaseName, username, password, schema)));
                    break;
                case SQLSERVER:
                    Connection.setConnection(DriverManager.getConnection(Server.sqlserver(host, port, databaseName, username, password)));
                    break;
                case SQLITE:
                    Connection.setConnection(DriverManager.getConnection(Server.sqlite(host, port, databaseName, username, password)));
                    break;

            }

            context.args.put("connection", Connection.getConnection());

            return delegate.call(context);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return F.Promise.promise(() -> status(401, "DATABASE NOT CONNECTED"));
        }
    }
}
