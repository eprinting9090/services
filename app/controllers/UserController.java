package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import connection.Connection;
import connection.Database;
import connection.enums.DBMS;
import httpactions.ApiAuth;
import mapper.Mapper;
import model.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import play.mvc.BodyParser;
import play.mvc.Result;
import play.mvc.Results;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import static play.mvc.Controller.request;

/**
 * @author AKBAR <akbar.attijani@gmail.com>
 */

@ApiAuth
public class UserController {
    @Database(
            database = DBMS.POSTGRESQL,
            host = "ec2-23-23-173-30.compute-1.amazonaws.com",
            databaseName = "d87s2lf0vv7l32",
            userName = "ppxiknjbrpshfp",
            password = "dadde9e960e7acc54bf9b09a35ef98f4ec01a149e1560b4a8c4f6909271cc76c",
            port = "5432"
    )
    public static Result getAll() {
        try {
            String query = "SELECT * FROM m_user";
            Statement statement = Connection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            List<User> list = new Mapper().toModel(resultSet, User.class);
            JSONArray array = new JSONArray();

            for (User user : list) {
                JSONObject object = new JSONObject();
                object.put("id", user.getId());
                object.put("nip", user.getNip());
                object.put("name", user.getName());

                array.add(object);
            }

            return Results.ok(array.toString());
        } catch (Exception e){
            e.printStackTrace();
            return Results.internalServerError();
        }
    }

    @Database(
            database = DBMS.POSTGRESQL,
            host = "ec2-23-23-173-30.compute-1.amazonaws.com",
            databaseName = "d87s2lf0vv7l32",
            userName = "ppxiknjbrpshfp",
            password = "dadde9e960e7acc54bf9b09a35ef98f4ec01a149e1560b4a8c4f6909271cc76c",
            port = "5432"
    )
    public static Result get(int id) {
        try {
            String query = "SELECT * FROM m_user WHERE id = ?";
            PreparedStatement statement = Connection.getConnection().prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            User user = new Mapper().toSingleModel(resultSet, User.class);

            JSONObject object = new JSONObject();
            object.put("id", user.getId());
            object.put("nip", user.getNip());
            object.put("name", user.getName());

            return Results.ok(object.toString());
        } catch (Exception e){
            e.printStackTrace();
            return Results.internalServerError();
        }
    }

    @Database(
            database = DBMS.POSTGRESQL,
            host = "ec2-23-23-173-30.compute-1.amazonaws.com",
            databaseName = "d87s2lf0vv7l32",
            userName = "ppxiknjbrpshfp",
            password = "dadde9e960e7acc54bf9b09a35ef98f4ec01a149e1560b4a8c4f6909271cc76c",
            port = "5432"
    )
    @BodyParser.Of(value = BodyParser.Json.class, maxLength = 1024 * 1024 * 1024)
    public static Result insertAll() {
        try {
            JsonNode jsonNode = request().body().asJson();
            List<User> list = new Mapper().toModel(jsonNode, User.class);

            JSONArray array = new JSONArray();
            for (User user : list) {
                JSONObject object = new JSONObject();
                object.put("id", user.getId());
                object.put("nip", user.getNip());
                object.put("name", user.getName());

                array.add(object);
            }

            return Results.ok(array.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return Results.internalServerError();
        }
    }

    @Database(
            database = DBMS.POSTGRESQL,
            host = "ec2-23-23-173-30.compute-1.amazonaws.com",
            databaseName = "d87s2lf0vv7l32",
            userName = "ppxiknjbrpshfp",
            password = "dadde9e960e7acc54bf9b09a35ef98f4ec01a149e1560b4a8c4f6909271cc76c",
            port = "5432"
    )
    @BodyParser.Of(value = BodyParser.Json.class, maxLength = 1024 * 1024 * 1024)
    public static Result insert() {
        try {
            
            JsonNode jsonNode = request().body().asJson();
            User user = new Mapper().toSingleModel(jsonNode, User.class);

            JSONObject object = new JSONObject();
            object.put("id", user.getId());
            object.put("nip", user.getNip());
            object.put("name", user.getName());

            return Results.ok(object.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return Results.internalServerError();
        }
    }
}
