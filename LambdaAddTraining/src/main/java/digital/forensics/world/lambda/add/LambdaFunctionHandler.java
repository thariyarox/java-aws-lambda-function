package digital.forensics.world.lambda.add;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.PreparedStatement;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import com.google.gson.Gson;

public class LambdaFunctionHandler implements RequestHandler<Object, String> {

    @Override
    public String handleRequest(Object input, Context context) {

        context.getLogger().log("Input: " + input);
        
        String output = "";
        
        Training training = new Gson().fromJson(input.toString(), Training.class);
        
        try {
        	 Class.forName("com.mysql.jdbc.Driver");
             Connection conn = DriverManager.getConnection(DB.CONNECTION_STRING, DB.USERNAME, DB.PASSWORD);

             Statement st = conn.createStatement();
             String sql = "insert into trainings (name, scheduled_date, scheduled_time, resource_person, location) values(?,?,?,?,?)";
             PreparedStatement stmt=  conn.prepareStatement(sql);  
             stmt.setString(1, training.getName());
             stmt.setDate(2, java.sql.Date.valueOf(training.getScheduled_date()));
             stmt.setString(3, training.getScheduled_time());
             stmt.setString(4, training.getResource_person());
             stmt.setString(5, training.getLocation());               
             
             stmt.executeUpdate();

             conn.close();             
             
        } catch(Exception ex) {
        	output = output + ex.getMessage();
        }

        return output;

    	
    }

}
