package connection;

import connection.enums.DBMS;
import play.mvc.With;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author AKBAR <akbar.attijani@gmail.com>
 */

@With(DatabaseAction.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Database {
    DBMS database() default DBMS.POSTGRESQL;
    String host() default "ec2-54-235-114-242.compute-1.amazonaws.com";
    String port() default "5432";
    String databaseName() default "dus39scnr8avm";
    String schema() default "public";
    String userName() default "qwuqzhxeflufxd";
    String password() default "a71ed299038ab3aa2e31b678896f6129b81cbaff7aebe38890ea7025edda725d";
}
