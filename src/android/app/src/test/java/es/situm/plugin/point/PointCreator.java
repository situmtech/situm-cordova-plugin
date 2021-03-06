package es.situm.plugin.point;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;

import es.situm.sdk.model.URL;
import es.situm.sdk.model.cartography.Building;
import es.situm.sdk.model.cartography.Point;
import es.situm.sdk.model.location.Angle;
import es.situm.sdk.model.location.CartesianCoordinate;
import es.situm.sdk.model.location.Coordinate;
import es.situm.sdk.model.location.Dimensions;

public class PointCreator {

    private final ClassLoader classLoader = getClass().getClassLoader();
    private final JSONParser parser = new JSONParser();

    public Point createPointWithCoordinate() {
        return  new Point(new Coordinate(3,6));
    }

    public Point createPointWithCoordinateAndBuildingId() {
        return  new Point("101" , new Coordinate(54,64));
    }

    public Point createPointWithBuildingIdAndFloor() {
        Coordinate coordinate = Coordinate.EMPTY;
        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(5,7);
        return new Point("101", "12", coordinate, cartesianCoordinate);
    }

    public Point createPointWithBuildingWithAngleFromDegrees() {
        Coordinate coordinate = new Coordinate(12.3,14.0);
        Dimensions dimensions = new Dimensions( 40.5,60.2);
        Building building = new Building.Builder()
                .address("TEST_BUILDING")
                .center(coordinate)
                .dimensions(dimensions)
                .infoHtml("TEST_INFO")
                .name("TEST_NAME")
                .pictureThumbUrl(new URL("TEST_URL"))
                .pictureUrl(new URL("TEST_URL"))
                .rotation(Angle.fromDegrees(45))
                .userIdentifier("TEST_USER")
                .build();
        return new Point(building, "12",new CartesianCoordinate(4,7));
    }

    public Point createPointWithBuildingWithAngleFromRadians() {
        Coordinate coordinate = new Coordinate(12.3,14.0);
        Dimensions dimensions = new Dimensions( 40.5,60.2);
        Building building = new Building.Builder()
                .address("TEST_BUILDING")
                .center(coordinate)
                .dimensions(dimensions)
                .infoHtml("TEST_INFO")
                .name("TEST_NAME")
                .pictureThumbUrl(new URL("TEST_URL"))
                .pictureUrl(new URL("TEST_URL"))
                .rotation(Angle.fromRadians(0.3))
                .userIdentifier("TEST_USER")
                .build();
        return new Point(building, "12",new CartesianCoordinate(4,7));
    }

    public Point createPointWithBuildingWithAddress() {
        Coordinate coordinate = new Coordinate(12.3,14.0);
        Dimensions dimensions = new Dimensions( 40.5,60.2);
        Building building = new Building.Builder()
                .center(coordinate)
                .dimensions(dimensions)
                .name("TEST_NAME")
                .address("TEST_ADDRESS")
                .rotation(Angle.fromRadians(0.3))
                .userIdentifier("TEST_USER")
                .build();
        return new Point(building, "12",new CartesianCoordinate(4,7));
    }

    public Point createPointWithBuildingWithInfo() {
        Coordinate coordinate = new Coordinate(12.3,14.0);
        Dimensions dimensions = new Dimensions( 40.5,60.2);
        Building building = new Building.Builder()
                .center(coordinate)
                .dimensions(dimensions)
                .name("TEST_NAME")
                .rotation(Angle.fromRadians(0.3))
                .userIdentifier("TEST_USER")
                .infoHtml("TEST_INFO")
                .build();
        return new Point(building, "12",new CartesianCoordinate(4,7));
    }

    public Point createPointWithBuildingWithPicture() {
        Coordinate coordinate = new Coordinate(12.3,14.0);
        Dimensions dimensions = new Dimensions( 40.5,60.2);
        Building building = new Building.Builder()
                .center(coordinate)
                .dimensions(dimensions)
                .name("TEST_NAME")
                .rotation(Angle.fromRadians(0.3))
                .userIdentifier("TEST_USER")
                .pictureUrl(new URL("TEST_URL"))
                .pictureThumbUrl(new URL("TEST_URL"))
                .build();
        return new Point(building, "12",new CartesianCoordinate(4,7));
    }

    public JSONObject getPoint1(){
        try{
            java.net.URL resource = classLoader.getResource("point/point1.json");
            File file = new File(resource.getFile());
            return new JSONObject(parser.parse(new FileReader(file)).toString());
        }catch(Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public JSONObject getPoint2(){
        try{
            java.net.URL resource = classLoader.getResource("point/point2.json");
            File file = new File(resource.getFile());
            return new JSONObject(parser.parse(new FileReader(file)).toString());
        }catch(Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public JSONObject getPoint3(){
        try{
            java.net.URL resource = classLoader.getResource("point/point3.json");
            File file = new File(resource.getFile());
            return new JSONObject(parser.parse(new FileReader(file)).toString());
        }catch(Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public JSONObject getPoint4(){
        try{
            java.net.URL resource = classLoader.getResource("point/point4.json");
            File file = new File(resource.getFile());
            return new JSONObject(parser.parse(new FileReader(file)).toString());
        }catch(Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public JSONObject getPoint5(){
        try{
            java.net.URL resource = classLoader.getResource("point/point5.json");
            File file = new File(resource.getFile());
            return new JSONObject(parser.parse(new FileReader(file)).toString());
        }catch(Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public JSONObject getPoint6(){
        try{
            java.net.URL resource = classLoader.getResource("point/point6.json");
            File file = new File(resource.getFile());
            return new JSONObject(parser.parse(new FileReader(file)).toString());
        }catch(Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public JSONObject getPoint7(){
        try{
            java.net.URL resource = classLoader.getResource("point/point7.json");
            File file = new File(resource.getFile());
            return new JSONObject(parser.parse(new FileReader(file)).toString());
        }catch(Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public JSONObject getPoint8(){
        try{
            java.net.URL resource = classLoader.getResource("point/point8.json");
            File file = new File(resource.getFile());
            return new JSONObject(parser.parse(new FileReader(file)).toString());
        }catch(Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }
}
