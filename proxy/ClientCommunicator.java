package proxy;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import JSON.Serializer;
import request.Request;
import result.Result;

public class ClientCommunicator {

    private static ClientCommunicator instance = null;

    private ClientCommunicator() { }

    // static method to create instance of Singleton class
    public static ClientCommunicator getInstance()
    {
        if (instance == null)
            instance = new ClientCommunicator();

        return instance;
    }

    public Result send(Object rObject){

        Request request;
        if(rObject.getClass().equals(Request.class)){
            request = (Request)rObject;

            try{
                Result result = null;

                URL url = new URL("http://" + "127.0.0.1:8080" + "/" + request.getMethodID());
                //get contents for host and port from UI

                HttpURLConnection http = (HttpURLConnection) url.openConnection();

                //specify post
                http.setRequestMethod("POST");
                //set request body
                http.setDoOutput(true);

                //don't add an auth token because you don't need one...

                http.addRequestProperty("Accept", "application/json");

                Serializer serializer = new Serializer();
                String reqData = serializer.encode(request.getData());
                //String reqData = (String)request.getData();

                http.connect();

                OutputStream reqBody = http.getOutputStream();
                serializer.writeString(reqData, reqBody);

                reqBody.close();

                if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {

                    String responseString = serializer.readString(http.getInputStream());
                    result = (Result) serializer.decode(responseString, Result.class);

                } else {
                    System.out.print("Error in Register\n");
                    System.out.print("Error: " + http.getResponseCode() + " - " + http.getErrorStream().read());
                    System.out.print(http.getErrorStream().toString());
                }

                return result;
            }
            catch(MalformedURLException e){
                System.out.print(e.getMessage());
            }
            catch(ProtocolException e)
            {
                System.out.print(e.getMessage());
            }
            catch(IOException e)
            {
                System.out.print(e.getMessage());
            }
        }
        return null;
    }
}
