package thesidedepot.app.model;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public  class scripting {








    public void databasePull() {
        ArrayList<Project> holder = new ArrayList<>();
        //MongoClientURI uri = new MongoClientURI("mongodb+srv://admin:siderift@cluster0-1jnpy.mongodb.net/test?retryWrites=true");

        MongoClientURI connectionString = new MongoClientURI("mongodb+srv://admin:siderift@cluster0-1jnpy.mongodb.net/test?retryWrites=true");
        MongoClient mongoClient = new MongoClient(connectionString);
        MongoDatabase database = mongoClient.getDatabase("database");
        MongoCollection<Document> collection = database.getCollection("projectsFinalA");




        for (Document cursor : collection.find()) {
            Project proj = new Project((String) cursor.get("title"),(String) cursor.get("description"), (String)cursor.get("difficulty"),
                    (String)cursor.get("category"),(ArrayList<String>) cursor.get("toolsAndMaterials"), (String)cursor.get("time"),(String) cursor.get("image"),
                    (Double) cursor.get("priceEstimate"),(ArrayList<String>) cursor.get("parsedSteps"),(ArrayList<String>) cursor.get("parsedHeaders"), (ArrayList<String>) cursor.get("weblinks"));
            holder.add(proj);
        }

        for (Project item : holder) {
            System.out.println(item.toString());
        }

        System.out.println(holder.size());
    }

    public void createUser(String username, String password) {
        
    }

    public static void main(String[] args) {



    }




}
