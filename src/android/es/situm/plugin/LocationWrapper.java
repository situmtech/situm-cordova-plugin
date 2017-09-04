package es.situm.plugin;

import android.graphics.Bitmap;
import android.util.Base64;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
//import java.util.Vector;

import java.io.ByteArrayOutputStream;

import es.situm.sdk.location.LocationStatus;
import es.situm.sdk.model.I18nString;
import es.situm.sdk.model.URL;
import es.situm.sdk.model.cartography.Building;
import es.situm.sdk.model.cartography.Floor;
import es.situm.sdk.model.cartography.Poi;
import es.situm.sdk.model.cartography.PoiCategory;
import es.situm.sdk.model.cartography.Point;
import es.situm.sdk.model.directions.Indication;
import es.situm.sdk.model.directions.Route;
import es.situm.sdk.model.directions.RouteStep;
import es.situm.sdk.model.location.Angle;
import es.situm.sdk.model.location.Bounds;
import es.situm.sdk.model.location.CartesianCoordinate;
import es.situm.sdk.model.location.Coordinate;
import es.situm.sdk.model.location.Dimensions;
import es.situm.sdk.model.location.Location;
import es.situm.sdk.model.navigation.NavigationProgress;
import es.situm.sdk.v1.SitumConversionArea;
import es.situm.sdk.v1.SitumEvent;

public class LocationWrapper {

    //public static final String TAG = "LocationWrapper";

    public static final String ADDRESS = "address";
    public static final String BOUNDS = "bounds";
    public static final String BOUNDS_ROTATED = "boundsRotated";
    public static final String CENTER = "center";
    public static final String DIMENSIONS = "dimensions";
    public static final String INFO_HTML = "infoHtml";
    public static final String BUILDING_NAME = "name";
    public static final String PICTURE_THUMB_URL = "pictureThumbUrl";
    public static final String POI_NAME = "poiName";
    public static final String POI_CATEGORY_NAME = "poiCategoryName";
    public static final String POI_CATEGORY_CODE = "poiCategoryCode";
    public static final String POI_CATEGORY = "category";
    public static final String IS_PUBLIC = "public";
    public static final String PICTURE_URL = "pictureUrl";
    public static final String ROTATION = "rotation";
    public static final String USER_IDENTIFIER = "userIdentifier";

    public static final String ALTITUDE = "altitude";
    public static final String BUILDING_IDENTIFIER = "buildingIdentifier";
    public static final String FLOOR_IDENTIFIER = "floorIdentifier";

    public static final String LEVEL = "level";
    public static final String MAP_URL = "mapUrl";
    public static final String SCALE = "scale";

    public static final String COORDINATE = "coordinate";
    public static final String CARTESIAN_COORDINATE = "cartesianCoordinate";
    public static final String CARTESIAN_BEARING = "cartesianBearing";
    public static final String POSITION = "position";
    public static final String IS_INDOOR = "isIndoor";
    public static final String PROVIDER = "provider";
    public static final String QUALITY = "quality";
    public static final String IS_OUTDOOR = "isOutdoor";

    public static final String RADIUS = "radius";
    public static final String ACCURACY = "accuracy";
    public static final String BEARING = "bearing";
    public static final String TIMESTAMP = "timestamp";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";
    public static final String STATUS_NAME = "statusName";
    public static final String STATUS_ORDINAL = "statusOrdinal";

    public static final String HAS_BEARING = "hasBearing";
    public static final String HAS_CARTESIAN_BEARING = "hasCartesianBearing";
    public static final String BEARING_QUALITY = "bearingQuality";

    public static final String NORTH_EAST = "northEast";
    public static final String NORTH_WEST = "northWest";
    public static final String SOUTH_EAST = "southEast";
    public static final String SOUTH_WEST = "southWest";

    public static final String DEGREES = "degrees";
    public static final String DEGREES_CLOCKWISE = "degreesClockwise";
    public static final String RADIANS_MINUS_PI_PI = "radiansMinusPiPi";
    public static final String RADIANS = "radians";

    public static final String WIDTH = "width";
    public static final String HEIGHT = "height";
    public static final String X = "x";
    public static final String Y = "y";
    public static final String ID = "id";

    public static final String EDGES = "edges";
    public static final String FIRST_STEP = "firstStep";
    public static final String LAST_STEP = "lastStep";
    public static final String INDICATIONS = "indications";
    public static final String NODES = "nodes";
    public static final String POINTS = "points";
    public static final String FROM = "from";
    public static final String TO = "TO";
    public static final String STEPS = "steps";

    public static final String DISTANCE_TO_GOAL = "distanceToGoal";
    public static final String DISTANCE = "distance";
    public static final String DISTANCE_TO_NEXT_LEVEL = "distanceToNextLevel";
    public static final String DISTANCE_TO_CLOSEST_POINT_IN_ROUTE = "distanceToClosestPointInRoute";
    public static final String DISTANCE_TO_END_STEP = "distanceToEndStep";
    public static final String INDICATION_TYPE = "indicationType";
    public static final String CURRENT_INDICATION = "currentIndication";
    public static final String NEXT_INDICATION = "nextIndication";
    public static final String IS_FIRST = "isFirst";
    public static final String IS_LAST = "isLast";
    public static final String CLOSEST_POINT_IN_ROUTE = "closestPointInRoute";
    public static final String STEP_IDX_DESTINATION = "stepIdxDestination";
    public static final String STEP_IDX_ORIGIN = "stepIdxOrigin";
    public static final String NEEDED_LEVEL_CHANGE = "neededLevelChange";
    public static final String ORIENTATION_TYPE = "orientationType";
    public static final String ORIENTATION = "orientation";
    public static final String ROUTE_STEP = "routeStep";
    public static final String TIME_TO_END_STEP = "timeToEndStep";
    public static final String TIME_TO_GOAL = "timeToGoal";

    public static final String CONVERSION_AREA = "conversionArea";
    public static final String IDENTIFIER = "identifier";
    public static final String CUSTOM_FIELDS = "customFields";
    public static final String TOP_LEFT = "topLeft";
    public static final String BOTTOM_LEFT = "bottomLeft";
    public static final String TOP_RIGHT = "topRight";
    public static final String BOTTOM_RIGHT = "bottomRight";
    public static final String POI_CATEGORY_ICON_SELECTED = "icon_selected";
    public static final String POI_CATEGORY_ICON_UNSELECTED = "icon_unselected";

    public static JSONObject buildingToJsonObject(Building building) throws JSONException {
        JSONObject jo = new JSONObject();
        jo.put(ADDRESS, building.getAddress());
        jo.put(BOUNDS, boundsToJsonObject(building.getBounds()));
        jo.put(BOUNDS_ROTATED, boundsToJsonObject(building.getBoundsRotated()));
        jo.put(CENTER, coordinateToJsonObject(building.getCenter()));
        jo.put(DIMENSIONS, dimensionsToJsonObject(building.getDimensions()));
        jo.put(INFO_HTML, building.getInfoHtml());
        jo.put(BUILDING_NAME, building.getName());
        jo.put(PICTURE_THUMB_URL, building.getPictureThumbUrl().getValue());
        jo.put(PICTURE_URL, building.getPictureUrl().getValue());
        jo.put(ROTATION, building.getRotation().radians());
        jo.put(USER_IDENTIFIER, building.getUserIdentifier());
        jo.put(BUILDING_IDENTIFIER, building.getIdentifier());
        return jo;
    }

    public static JSONObject mapStringToJsonObject(Map<String, String> mp) throws JSONException {
        JSONObject jo = new JSONObject();
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> pairs = (Map.Entry<String, String>) it.next();
            jo.put(pairs.getKey(), pairs.getValue());
        }
        return jo;
    }

    public static Building buildingJsonObjectToBuilding(JSONObject jo) throws JSONException {
        Building building = null;
        Coordinate center = new Coordinate(jo.getJSONObject(CENTER).getDouble(LATITUDE),
                jo.getJSONObject(CENTER).getDouble(LONGITUDE));
        Dimensions dimesnsions = new Dimensions(jo.getJSONObject(DIMENSIONS).getDouble(WIDTH),
                jo.getJSONObject(DIMENSIONS).getDouble(HEIGHT));
        building = new Building.Builder().identifier(jo.getString(BUILDING_IDENTIFIER)).address(jo.getString(ADDRESS))
                .name(jo.getString(BUILDING_NAME)).userIdentifier(jo.getString(USER_IDENTIFIER)).center(center)
                .dimensions(dimesnsions).infoHtml(jo.getString(INFO_HTML)).build();
        return building;
    }

    //Floor

    public static JSONObject floorToJsonObject(Floor floor) throws JSONException {
        JSONObject jo = new JSONObject();
        jo.put(ALTITUDE, floor.getAltitude());
        jo.put(BUILDING_IDENTIFIER, floor.getBuildingIdentifier());
        jo.put(LEVEL, floor.getLevel());
        jo.put(MAP_URL, floor.getMapUrl().getValue());
        jo.put(SCALE, floor.getScale());
        jo.put(FLOOR_IDENTIFIER, floor.getIdentifier());
        return jo;
    }

    public static Floor floorJsonObjectToFloor(JSONObject jo) throws JSONException {
        Floor floor = null;
        floor = new Floor.Builder().buildingIdentifier(jo.getString(BUILDING_IDENTIFIER))
                .altitude(jo.getDouble(ALTITUDE)).level(jo.getInt(LEVEL)).mapUrl(new URL(jo.getString(MAP_URL)))
                .scale(jo.getDouble(SCALE)).build();
        return floor;
    }

    //Situm Events

    public static JSONObject situmEventToJsonObject(SitumEvent situmEvent) throws JSONException {
        JSONObject jo = new JSONObject();
        jo.put(BUILDING_IDENTIFIER, situmEvent.getBuildingId());
        jo.put(IDENTIFIER, situmEvent.getId());
        jo.put(FLOOR_IDENTIFIER, situmEvent.getFloor_id());
        jo.put(INFO_HTML, situmEvent.getHtml());
        jo.put(CONVERSION_AREA, conversionAreaToJsonObject(situmEvent.getConversionArea()));
        jo.put(CUSTOM_FIELDS, mapStringToJsonObject(situmEvent.getCustomFields()));
        jo.put(RADIUS, situmEvent.getRadius());
        return jo;
    }

    public static JSONObject conversionAreaToJsonObject(SitumConversionArea situmCA) throws JSONException {
        JSONObject jo = new JSONObject();
        jo.put(FLOOR_IDENTIFIER, situmCA.getFloor_id());
        jo.put(TOP_LEFT, situmCA.getTopLeft());
        jo.put(TOP_RIGHT, situmCA.getTopRight());
        jo.put(BOTTOM_LEFT, situmCA.getBottomLeft());
        jo.put(BOTTOM_RIGHT, situmCA.getBottomRight());
        return jo;
    }

    // POI

    public static JSONObject poiToJsonObject(Poi poi) throws JSONException {
        JSONObject jo = new JSONObject();
        jo.put(BUILDING_IDENTIFIER, poi.getBuildingIdentifier());
        jo.put(CARTESIAN_COORDINATE, cartesianCoordinateToJsonObject(poi.getCartesianCoordinate()));
        jo.put(COORDINATE, coordinateToJsonObject(poi.getCoordinate()));
        jo.put(FLOOR_IDENTIFIER, poi.getFloorIdentifier());
        jo.put(POI_NAME, poi.getName());
        jo.put(POSITION, pointToJsonObject(poi.getPosition()));
        jo.put(IS_INDOOR, poi.isIndoor());
        jo.put(IS_OUTDOOR, poi.isOutdoor());
        jo.put(POI_CATEGORY, poi.getCategory().getCode());
        return jo;
    }

    public static JSONObject poiCategoryToJsonObject(PoiCategory poiCategory) throws JSONException {
        JSONObject jo = new JSONObject();
        jo.put(POI_CATEGORY_CODE, poiCategory.getCode());
        jo.put(POI_CATEGORY_NAME, poiCategory.getName());
        jo.put(POI_CATEGORY_ICON_SELECTED, poiCategory.getSelectedIconUrl().getValue());
        jo.put(POI_CATEGORY_ICON_UNSELECTED, poiCategory.getUnselectedIconUrl().getValue());
        jo.put(IS_PUBLIC, poiCategory.isPublic());
        return jo;
    }

    public static PoiCategory poiCategoryFromJsonObject(JSONObject jo) throws JSONException {
        PoiCategory category = null;
        Map<String, String> mapName = new HashMap<String, String>();
        mapName.put("name", jo.getString(POI_CATEGORY_NAME));
        category = new PoiCategory.Builder().code(jo.getString(POI_CATEGORY_CODE)).name(new I18nString(mapName))
                .isPublic(jo.getBoolean(IS_PUBLIC)).build();
        return category;
    }

    // Location

    public static JSONObject locationToJsonObject(Location location) throws JSONException {
        JSONObject jo = new JSONObject();
        jo.put(ACCURACY, location.getAccuracy());
        jo.put(BEARING, angleToJsonObject(location.getBearing()));
        jo.put(BEARING_QUALITY, location.getBearingQuality().toString());
        jo.put(BUILDING_IDENTIFIER, location.getBuildingIdentifier());
        jo.put(CARTESIAN_BEARING, angleToJsonObject(location.getCartesianBearing()));
        jo.put(CARTESIAN_COORDINATE, cartesianCoordinateToJsonObject(location.getCartesianCoordinate()));
        jo.put(COORDINATE, coordinateToJsonObject(location.getCoordinate()));
        jo.put(FLOOR_IDENTIFIER, location.getFloorIdentifier());
        jo.put(POSITION, pointToJsonObject(location.getPosition()));
        jo.put(PROVIDER, location.getProvider());
        jo.put(QUALITY, location.getQuality().toString());
        jo.put(HAS_BEARING, location.hasBearing());
        jo.put(TIMESTAMP, location.getTime());
        jo.put(HAS_CARTESIAN_BEARING, location.hasCartesianBearing());
        jo.put(IS_INDOOR, location.isIndoor());
        jo.put(IS_OUTDOOR, location.isOutdoor());
        return jo;
    }

    public static JSONObject locationStatusToJsonObject(LocationStatus locationStatus) throws JSONException {
        JSONObject jo = new JSONObject();
        jo.put(STATUS_NAME, locationStatus.name());
        jo.put(STATUS_ORDINAL, locationStatus.ordinal());
        return jo;
    }

    public static Location locationJsonObjectToLocation(JSONObject jo) throws JSONException {
        Location location = null;
        location = new Location.Builder(jo.getLong(TIMESTAMP), jo.getString(PROVIDER),
                pointJsonObjectToPoint(jo.getJSONObject(POSITION)), Float.valueOf(jo.getString(ACCURACY))).build();
        return location;
    }

    // Coordinate

    public static JSONObject coordinateToJsonObject(Coordinate coordinate) throws JSONException {
        JSONObject jo = new JSONObject();
        jo.put(LATITUDE, coordinate.getLatitude());
        jo.put(LONGITUDE, coordinate.getLongitude());
        return jo;
    }

    public static Coordinate coordinateJsonObjectToCoordinate(JSONObject jo) throws JSONException {
        Coordinate coordinate = null;
        coordinate = new Coordinate(jo.getDouble(LATITUDE), jo.getDouble(LONGITUDE));
        return coordinate;
    }

    // Point

    public static JSONObject pointToJsonObject(Point point) throws JSONException {
        JSONObject jo = new JSONObject();
        jo.put(BUILDING_IDENTIFIER, point.getBuildingIdentifier());
        jo.put(CARTESIAN_COORDINATE, cartesianCoordinateToJsonObject(point.getCartesianCoordinate()));
        jo.put(COORDINATE, coordinateToJsonObject(point.getCoordinate()));
        jo.put(FLOOR_IDENTIFIER, point.getFloorIdentifier());
        jo.put(IS_INDOOR, point.isIndoor());
        jo.put(IS_OUTDOOR, point.isOutdoor());
        return jo;
    }

    public static Point pointJsonObjectToPoint(JSONObject jo) throws JSONException {
        Point point = null;

        if (!jo.has(COORDINATE)) {
            jo.put(COORDINATE, new JSONObject().put(LATITUDE, jo.getJSONObject(CARTESIAN_COORDINATE).getDouble(X))
                    .put(LONGITUDE, jo.getJSONObject(CARTESIAN_COORDINATE).getDouble(Y)));
        }

        point = new Point(jo.getString(BUILDING_IDENTIFIER), jo.getString(FLOOR_IDENTIFIER),
                coordinateJsonObjectToCoordinate(jo.getJSONObject(COORDINATE)),
                cartesianCoordinateJsonObjectToCartesianCoordinate(jo.getJSONObject(CARTESIAN_COORDINATE)));
        return point;
    }

    // CartesianCoordinate

    public static JSONObject cartesianCoordinateToJsonObject(CartesianCoordinate cartesianCoordinate)
            throws JSONException {
        JSONObject jo = new JSONObject();
        jo.put(X, cartesianCoordinate.getX());
        jo.put(Y, cartesianCoordinate.getY());
        return jo;
    }

    public static CartesianCoordinate cartesianCoordinateJsonObjectToCartesianCoordinate(JSONObject jo)
            throws JSONException {
        CartesianCoordinate cartesianCoordinate = null;
        cartesianCoordinate = new CartesianCoordinate(jo.getDouble(X), jo.getDouble(Y));
        return cartesianCoordinate;
    }

    // Dimensions

    public static JSONObject dimensionsToJsonObject(Dimensions dimensions) throws JSONException {
        JSONObject jo = new JSONObject();
        jo.put(WIDTH, dimensions.getWidth());
        jo.put(HEIGHT, dimensions.getHeight());
        return jo;
    }

    // Bounds

    public static JSONObject boundsToJsonObject(Bounds bounds) throws JSONException {
        JSONObject jo = new JSONObject();
        jo.put(NORTH_EAST, coordinateToJsonObject(bounds.getNorthEast()));
        jo.put(NORTH_WEST, coordinateToJsonObject(bounds.getNorthWest()));
        jo.put(SOUTH_EAST, coordinateToJsonObject(bounds.getSouthEast()));
        jo.put(SOUTH_WEST, coordinateToJsonObject(bounds.getSouthWest()));
        return jo;
    }

    // Angle

    public static JSONObject angleToJsonObject(Angle angle) throws JSONException {
        JSONObject jo = new JSONObject();
        jo.put(DEGREES, angle.degrees());
        jo.put(DEGREES_CLOCKWISE, angle.degreesClockwise());
        jo.put(RADIANS, angle.radians());
        jo.put(RADIANS_MINUS_PI_PI, angle.radiansMinusPiPi());
        return jo;
    }

    // Route

    public static JSONObject routeToJsonObject(Route route) throws JSONException {
        JSONObject jo = new JSONObject();
        JSONArray edgesJsonArray = new JSONArray();
        for (RouteStep routeStep : route.getEdges()) {
            edgesJsonArray.put(routeStepToJsonObject(routeStep));
        }
        JSONArray stepsJsonArray = new JSONArray();
        for (RouteStep routeStep : route.getSteps()) {
            stepsJsonArray.put(routeStepToJsonObject(routeStep));
        }
        JSONArray indicationsJsonArray = new JSONArray();
        for (Indication indication : route.getIndications()) {
            indicationsJsonArray.put(indicationToJsonObject(indication));
        }
        JSONArray nodesJsonArray = new JSONArray();
        for (Point point : route.getNodes()) {
            nodesJsonArray.put(pointToJsonObject(point));
        }
        JSONArray pointsJsonArray = new JSONArray();
        for (Point point : route.getPoints()) {
            pointsJsonArray.put(pointToJsonObject(point));
        }

        jo.put(EDGES, edgesJsonArray);
        jo.put(FIRST_STEP, routeStepToJsonObject(route.getFirstStep()));
        jo.put(FROM, pointToJsonObject(route.getFrom()));
        jo.put(INDICATIONS, indicationsJsonArray);
        jo.put(LAST_STEP, routeStepToJsonObject(route.getLastStep()));
        jo.put(NODES, nodesJsonArray);
        jo.put(POINTS, pointsJsonArray);
        jo.put(INDICATIONS, indicationsJsonArray);
        jo.put(TO, pointToJsonObject(route.getTo()));
        jo.put(STEPS, stepsJsonArray);
        return jo;
    }

    //RouteStep

    public static JSONObject routeStepToJsonObject(RouteStep routeStep) throws JSONException {
        JSONObject jo = new JSONObject();
        jo.put(DISTANCE, routeStep.getDistance());
        jo.put(DISTANCE_TO_GOAL, routeStep.getDistanceToGoal());
        jo.put(FROM, pointToJsonObject(routeStep.getFrom()));
        jo.put(ID, routeStep.getId());
        jo.put(TO, pointToJsonObject(routeStep.getTo()));
        jo.put(IS_FIRST, routeStep.isFirst());
        jo.put(IS_LAST, routeStep.isLast());
        return jo;
    }

    public static RouteStep routeStepJsonObjectToRouteStep(JSONObject jo) throws JSONException {
        RouteStep routeStep = null;
        routeStep = new RouteStep.Builder().distance(jo.getDouble(DISTANCE))
                .distanceToEnd(jo.getDouble(DISTANCE_TO_GOAL)).from(pointJsonObjectToPoint(jo.getJSONObject(FROM)))
                .to(pointJsonObjectToPoint(jo.getJSONObject(TO))).id(jo.getInt(ID)).isLast(jo.getBoolean(IS_LAST))
                .build();
        return routeStep;
    }

    // Indication

    public static JSONObject indicationToJsonObject(Indication indication) throws JSONException {
        JSONObject jo = new JSONObject();
        jo.put(DISTANCE, indication.getDistance());
        jo.put(DISTANCE_TO_NEXT_LEVEL, indication.getDistanceToNextLevel());
        jo.put(INDICATION_TYPE, indication.getIndicationType().toString());
        jo.put(ORIENTATION, indication.getOrientation());
        jo.put(ORIENTATION_TYPE, indication.getOrientationType());
        jo.put(STEP_IDX_DESTINATION, indication.getStepIdxDestination());
        jo.put(STEP_IDX_ORIGIN, indication.getStepIdxOrigin());
        jo.put(NEEDED_LEVEL_CHANGE, indication.isNeededLevelChange());
        return jo;
    }

    public static Indication indicationJsonObjectToIndication(JSONObject jo) throws JSONException {
        Indication indication = null;
        indication = new Indication.Builder().setDistance(jo.getDouble(DISTANCE))
                .setDistanceToNextLevel(jo.getInt(DISTANCE_TO_NEXT_LEVEL))
                .setInstructionType(Indication.Action.valueOf(jo.getString(INDICATION_TYPE)))
                .setOrientation(jo.getDouble(ORIENTATION))
                .setOrientationType(Indication.Orientation.valueOf(jo.getString(ORIENTATION_TYPE)))
                .setStepIdxDestination(jo.getInt(STEP_IDX_DESTINATION)).setStepIdxOrigin(jo.getInt(STEP_IDX_ORIGIN))
                .build();
        return indication;
    }

    // NavigationProgress

    public static JSONObject navigationProgressToJsonObject(NavigationProgress navigationProgress)
            throws JSONException {
        JSONObject jo = new JSONObject();
        jo.put(CLOSEST_POINT_IN_ROUTE, pointToJsonObject(navigationProgress.getClosestPointInRoute()));
        jo.put(CURRENT_INDICATION, indicationToJsonObject(navigationProgress.getCurrentIndication()));
        jo.put(NEXT_INDICATION, indicationToJsonObject(navigationProgress.getNextIndication()));
        jo.put(DISTANCE_TO_CLOSEST_POINT_IN_ROUTE, navigationProgress.getDistanceToClosestPointInRoute());
        jo.put(DISTANCE_TO_END_STEP, navigationProgress.getDistanceToEndStep());
        jo.put(DISTANCE_TO_GOAL, navigationProgress.getDistanceToGoal());
        jo.put(ROUTE_STEP, routeStepToJsonObject(navigationProgress.getRouteStep()));
        jo.put(TIME_TO_END_STEP, navigationProgress.getTimeToEndStep());
        jo.put(TIME_TO_GOAL, navigationProgress.getTimeToGoal());
        return jo;
    }

    // Utils

    public static JSONObject bitmapToString(Bitmap bitmap) throws JSONException {
        JSONObject jo = new JSONObject();
        String encodedImage;
        ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOS);
        encodedImage = Base64.encodeToString(byteArrayOS.toByteArray(), Base64.DEFAULT);
        jo.put("data", encodedImage);
        return jo;
    }
}
