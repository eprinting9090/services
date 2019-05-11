package mapper;

import com.fasterxml.jackson.databind.JsonNode;
import mapper.annotation.Column;
import mapper.annotation.JsonField;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author AKBAR <akbar.attijani@gmail.com>
 */
public class Mapper {
    public <T> List<T> toModel(ResultSet resultSet, Class<?> c) {
        List<T> result = new ArrayList<>();

        try {
            while (resultSet.next()) {
                // Get Fields
                Object clas = c.newInstance();
                java.lang.reflect.Field[] fields = c.getDeclaredFields();

                for (java.lang.reflect.Field f : fields) {
                    if (f.isAnnotationPresent(Column.class)) {
                        Annotation field = f.getAnnotation(Column.class);
                        String fieldName = getAnnotationValue("name", field).toString();
                        f.setAccessible(true);

                        // set data object
                        Class<?> dataType = f.getType();
                        if (dataType == String.class) {
                            f.set(clas, resultSet.getString(fieldName));
                        } else if (dataType == Integer.class || dataType == int.class) {
                            f.setInt(clas, resultSet.getInt(fieldName));
                        } else if (dataType == Double.class || dataType == double.class) {
                            f.setDouble(clas, resultSet.getDouble(fieldName));
                        } else if (dataType == Long.class || dataType == long.class) {
                            f.setLong(clas, resultSet.getLong(fieldName));
                        } else {
                            throw new Exception("Data Type not valid. Apply only String, Integer, Double, or Long");
                        }
                    }
                }

                result.add(((T) clas));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public <T> T toSingleModel(ResultSet resultSet, Class<?> c) throws IllegalAccessException, InstantiationException {
        try {
            Object clas = c.newInstance();

            if (resultSet.next()) {
                // Get Fields
                java.lang.reflect.Field[] fields = c.getDeclaredFields();

                for (java.lang.reflect.Field f : fields) {
                    if (f.isAnnotationPresent(Column.class)) {
                        Annotation field = f.getAnnotation(Column.class);
                        String fieldName = getAnnotationValue("name", field).toString();
                        f.setAccessible(true);

                        // set data object
                        Class<?> dataType = f.getType();
                        if (dataType == String.class) {
                            f.set(clas, resultSet.getString(fieldName));
                        } else if (dataType == Integer.class || dataType == int.class) {
                            f.setInt(clas, resultSet.getInt(fieldName));
                        } else if (dataType == Double.class || dataType == double.class) {
                            f.setDouble(clas, resultSet.getDouble(fieldName));
                        } else if (dataType == Long.class || dataType == long.class) {
                            f.setLong(clas, resultSet.getLong(fieldName));
                        } else {
                            throw new Exception("Data Type not valid. Apply only String, Integer, Double, or Long");
                        }
                    }
                }
            }

            return ((T) clas);
        } catch (Exception e) {
            e.printStackTrace();
            return ((T) c.newInstance());
        }
    }

    public <T> List<T> toModel(JsonNode jsonNode, Class<?> c) {
        List<T> result = new ArrayList<>();

        try {
            for (int i = 0; i < jsonNode.size(); i++) {
                JsonNode jsonObject = jsonNode.get(i);

                // Get Fields
                Object clas = c.newInstance();
                java.lang.reflect.Field[] fields = c.getDeclaredFields();

                for (java.lang.reflect.Field f : fields) {
                    if (f.isAnnotationPresent(JsonField.class)) {
                        Annotation field = f.getAnnotation(JsonField.class);
                        String fieldName = getAnnotationValue("key", field).toString();
                        f.setAccessible(true);

                        // set data object
                        Class<?> dataType = f.getType();
                        if (dataType == String.class) {
                            f.set(clas, jsonObject.path(fieldName).asText());
                        } else if (dataType == Integer.class || dataType == int.class) {
                            f.setInt(clas, jsonObject.path(fieldName).asInt());
                        } else if (dataType == Double.class || dataType == double.class) {
                            f.setDouble(clas, jsonObject.path(fieldName).asDouble());
                        } else if (dataType == Long.class || dataType == long.class) {
                            f.setLong(clas, jsonObject.path(fieldName).asLong());
                        } else {
                            throw new Exception("Data Type not valid. Apply only String, Integer, Double, or Long");
                        }
                    }
                }

                result.add(((T) clas));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public <T> T toSingleModel(JsonNode jsonNode, Class<?> c) throws IllegalAccessException, InstantiationException {
        try {
            // Get Fields
            Object clas = c.newInstance();
            java.lang.reflect.Field[] fields = c.getDeclaredFields();

            for (java.lang.reflect.Field f : fields) {
                if (f.isAnnotationPresent(JsonField.class)) {
                    Annotation field = f.getAnnotation(JsonField.class);
                    String fieldName = getAnnotationValue("key", field).toString();
                    f.setAccessible(true);

                    // set data object
                    Class<?> dataType = f.getType();
                    if (dataType == String.class) {
                        f.set(clas, jsonNode.path(fieldName).asText());
                    } else if (dataType == Integer.class || dataType == int.class) {
                        f.setInt(clas, jsonNode.path(fieldName).asInt());
                    } else if (dataType == Double.class || dataType == double.class) {
                        f.setDouble(clas, jsonNode.path(fieldName).asDouble());
                    } else if (dataType == Long.class || dataType == long.class) {
                        f.setLong(clas, jsonNode.path(fieldName).asLong());
                    } else {
                        throw new Exception("Data Type not valid. Apply only String, Integer, Double, or Long");
                    }
                }
            }

            return ((T) clas);
        } catch (Exception e) {
            e.printStackTrace();
            return ((T) c.newInstance());
        }
    }

    private Object getAnnotationValue(String key, Annotation annotation) throws Exception {
        Class<? extends Annotation> type = annotation.annotationType();
        for (Method mm : type.getDeclaredMethods()) {
            if (mm.getName().equals(key)) {
                return mm.invoke(annotation, (Object[])null);
            }
        }

        return null;
    }
}
