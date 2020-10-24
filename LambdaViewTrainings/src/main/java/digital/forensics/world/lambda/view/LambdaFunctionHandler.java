package digital.forensics.world.lambda.view;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class LambdaFunctionHandler implements RequestHandler<Object, String> {

    @Override
    public String handleRequest(Object input, Context context) {
        context.getLogger().log("Input: " + input);
        
        String output = "";
        ArrayList<Training> trainings = new ArrayList<Training>();
        
        try {
        	 Class.forName("com.mysql.jdbc.Driver");
             Connection conn = DriverManager.getConnection(DB.CONNECTION_STRING, DB.USERNAME, DB.PASSWORD);

             Statement st = conn.createStatement();
             String sql = "select id, name, scheduled_date, scheduled_time, resource_person, location from trainings";
             ResultSet rs = st.executeQuery(sql);
            

             while (rs.next()) {
            	 int id = rs.getInt("id");
            	 String name = rs.getString("name");
            	 String scheduled_date = rs.getString("scheduled_date");
            	 String scheduled_time = rs.getString("scheduled_time");
            	 String resource_person = rs.getString("resource_person");
            	 String location = rs.getString("location");
            	 
            	 Training training = new Training(id, name, scheduled_date, scheduled_time, resource_person, location);
            	 trainings.add(training);      	 
             }
             conn.close();
             
             output = new Gson().toJson(trainings);
        } catch(Exception ex) {
        	output = output + ex.getMessage();
        }

        return output;
    }

}
