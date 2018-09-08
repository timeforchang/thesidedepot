package thesidedepot.app.model;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class scripting {










    public static void main(String[] args) {


        //MongoClientURI uri = new MongoClientURI("mongodb+srv://admin:siderift@cluster0-1jnpy.mongodb.net/test?retryWrites=true");

        MongoClientURI connectionString = new MongoClientURI("mongodb+srv://admin:siderift@cluster0-1jnpy.mongodb.net/test?retryWrites=true");
        MongoClient mongoClient = new MongoClient(connectionString);
        MongoDatabase database = mongoClient.getDatabase("database");
        MongoCollection<Document> collection = database.getCollection("projectsNew");


        Document myDoc = collection.find().first();
        ArrayList<String> solution = (ArrayList<String>) myDoc.get("parsedSteps");

        for (String item: solution) {
            System.out.println(item);
        }







    }




}
