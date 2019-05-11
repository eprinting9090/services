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
    @Database(database = DBMS.POSTGRESQL)
    public static Result getAll() {
        try {
            String query = "SELECT * FROM m_user";
            Statement statement = Connection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            List<User> list = new Mapper().toModels(resultSet, User.class);
            JSONArray array = new JSONArray();

            for (User user : list) {
                JSONObject object = new JSONObject();
                object.put("id", user.getId());
                object.put("name", user.getName());
                object.put("email", user.getEmail());
                object.put("address", user.getAddress());

                array.add(object);
            }

            statement.close();
            resultSet.close();
            Connection.disconnect();
            return Results.ok(array.toString());
        } catch (Exception e){
            e.printStackTrace();
            return Results.internalServerError();
        }
    }

    @Database(database = DBMS.POSTGRESQL)
    public static Result get(int id) {
        try {
            String query = "SELECT * FROM m_user WHERE id = ?";
            PreparedStatement statement = Connection.getConnection().prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            User user = new Mapper().toModel(resultSet, User.class);

            JSONObject object = new JSONObject();
            object.put("id", user.getId());
            object.put("name", user.getName());
            object.put("email", user.getEmail());
            object.put("address", user.getAddress());

            statement.close();
            resultSet.close();
            Connection.disconnect();
            return Results.ok(object.toString());
        } catch (Exception e){
            e.printStackTrace();
            return Results.internalServerError();
        }
    }

    @Database(database = DBMS.POSTGRESQL)
    @BodyParser.Of(value = BodyParser.Json.class, maxLength = 1024 * 1024 * 1024)
    public static Result insertAll() {
        try {
            JsonNode jsonNode = request().body().asJson();
            List<User> list = new Mapper().toModels(jsonNode, User.class);

            int count = 0;
            String query = "INSERT INTO m_user (name, email, password, address) VALUES (?,?,?,?)";
            for (User user : list) {
                PreparedStatement preparedStatement = Connection.getConnection().prepareStatement(query);
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getEmail());
                preparedStatement.setString(3, user.getPassword());
                preparedStatement.setString(4, user.getAddress());

                count += preparedStatement.executeUpdate();
            }

            Connection.disconnect();
            return Results.ok("Inserted : " + count);
        } catch (Exception e) {
            e.printStackTrace();
            return Results.internalServerError();
        }
    }

    @Database(database = DBMS.POSTGRESQL)
    @BodyParser.Of(value = BodyParser.Json.class, maxLength = 1024 * 1024 * 1024)
    public static Result insert() {
        try {
            JsonNode jsonNode = request().body().asJson();
            User user = new Mapper().toModel(jsonNode, User.class);

            String query = "INSERT INTO m_user (name, email, password, address) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = Connection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getAddress());

            int count = preparedStatement.executeUpdate();

            preparedStatement.close();
            Connection.disconnect();
            return Results.ok("Inserted : " + count);
        } catch (Exception e) {
            e.printStackTrace();
            return Results.internalServerError();
        }
    }
}
