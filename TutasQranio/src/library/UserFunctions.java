package library;
 
import java.util.ArrayList;
import java.util.List;
 
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
 
import android.content.Context;
import android.util.Log;
 
public class UserFunctions {
     
    private JSONParser jsonParser;
     
    // Testing in localhost using wamp or xampp 
    // use http://10.0.2.2/ to connect to your localhost ie http://localhost/
    
    private static String loginURL = "http://192.168.0.101/QranioTuta/";
    private static String registerURL = "http://192.168.0.101/QranioTuta/";
    private static String displayURL = "http://192.168.0.101/QranioTuta/";
    private static String disciplinaURL = "http://192.168.0.101/QranioTuta/";
    private static String notaURL = "http://192.168.0.101/QranioTuta/";
     
    /*
    private static String loginURL = "http://169.254.59.234/android_login_api/";
    private static String registerURL = "http://169.254.59.234/android_login_api/";
    private static String displayURL = "http://169.254.59.234/android_login_api/";
    private static String disciplinaURL = "http://169.254.59.234/android_login_api/";
    */
    /*
    private static String loginURL = "http://127.0.0.1/android_login_api/";
    private static String registerURL = "http://127.0.0.1/android_login_api/";
    private static String displayURL = "http://127.0.0.1/android_login_api/";
    private static String disciplinaURL = "http://127.0.0.1/android_login_api/";
    */
    
    private static String login_tag = "login";
    private static String register_tag = "register";
    private static String display_tag = "display";
    private static String disciplina_tag = "disciplina";
    private static String nota_tag = "notaDisciplina";
    
    // constructor
    public UserFunctions(){
        jsonParser = new JSONParser();
    }
     
    /**
     * function make Login Request
     * @param email
     * @param password
     * */
    public JSONObject loginUser(String email, String password){
        // Building Parameters
    	
    	List<NameValuePair> params = new ArrayList<NameValuePair>();
        
    	params.add(new BasicNameValuePair("tag", login_tag));
        params.add(new BasicNameValuePair("email", email));
        params.add(new BasicNameValuePair("password", password));
        
        JSONObject json = jsonParser.getJSONFromUrl(loginURL, params);
        
        Log.e("JSON", "LoginUser");
        
        // return json
        //Log.e("JSON", json.toString());
        return json;
    }
     
    /**
     * function make Login Request
     * @param name
     * @param email
     * @param password
     * */
    public JSONObject registerUser(String name, String email, String password){
        // Building Parameters
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("tag", register_tag));
        params.add(new BasicNameValuePair("name", name));
        params.add(new BasicNameValuePair("email", email));
        params.add(new BasicNameValuePair("password", password));
         
        // getting JSON Object
        JSONObject json = jsonParser.getJSONFromUrl(registerURL, params);
        // return json
        return json;
    }
     
    public JSONObject displayUser(String email){
        // Building Parameters
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("tag", display_tag));
        //params.add(new BasicNameValuePair("name", name));
        params.add(new BasicNameValuePair("email", email));
         
        // getting JSON Object
        JSONObject json = jsonParser.getJSONFromUrl(displayURL, params);
        // return json
        return json;
    }
    
    public JSONObject disciplinasUser(String id){  
    // Building Parameters
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("tag", disciplina_tag));
        params.add(new BasicNameValuePair("id", id));
         
        // getting JSON Object
        JSONObject json = jsonParser.getJSONFromUrl(disciplinaURL, params);
        
        // return json
        return json;        
    }

    public JSONObject notasUser(String id, String disciplina){  
        // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("tag", nota_tag));
            params.add(new BasicNameValuePair("id", id));
            params.add(new BasicNameValuePair("disciplina", disciplina));
             
            // getting JSON Object
            JSONObject json = jsonParser.getJSONFromUrl(notaURL, params);
            
            // return json
            return json;        
    }
    
    /**
     * Function get Login status
     * */
    public boolean isUserLoggedIn(Context context){
        DatabaseHandler db = new DatabaseHandler(context);
        int count = db.getRowCount();
        if(count > 0){
            // user logged in
            return true;
        }
        return false;
    }
     
    /**
     * Function to logout user
     * Reset Database
     * */
    public boolean logoutUser(Context context){
        DatabaseHandler db = new DatabaseHandler(context);
        db.resetTables();
        return true;
    }
     
}