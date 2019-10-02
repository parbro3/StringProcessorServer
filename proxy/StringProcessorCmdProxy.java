package proxy;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;

import JSON.Serializer;
import command.CommandData;
import processor.IStringProcessor;
import request.Request;
import result.Result;

import java.io.*;
import java.net.*;

/**
 * Connection to server. Independent of all other classes. No other classes access the server except
 * the Proxy. Deals with registering a user, logging in a user, getting a family from a user,
 * and getting events from a user. These tasks are synchronous tasks, but are implemented by
 * asynchronous tasks within the UI.
 */
public class StringProcessorCmdProxy implements IStringProcessor {

    private static StringProcessorCmdProxy instance = null;
    private ClientCommunicator clientCommunicator = null;

    private StringProcessorCmdProxy() {
        clientCommunicator = ClientCommunicator.getInstance();
    }

    // static method to create instance of Singleton class
    public static StringProcessorCmdProxy getInstance()
    {
        if (instance == null)
            instance = new StringProcessorCmdProxy();

        return instance;
    }

    public ClientCommunicator getClientCommunicator() {
        return clientCommunicator;
    }

    public void setClientCommunicator(ClientCommunicator clientCommunicator) {
        this.clientCommunicator = clientCommunicator;
    }

    //each of these methods should call the client communicator? or maybe just in the proxy
    //constructor?
    @Override
    public String trim(String s){

        Request request = new Request();
        request.setMethodID("execcmd");

        //build the command data object with the string
        CommandData commandData = new CommandData("processor.StringProcessor", "trimcmd", new String[] {"String"},
                new Object[] { s });

        //maybe i should just make it "String" as the class... and then return String.class in
        //a switch statement... that would be the work-around.

        request.setData(commandData);

        //this has to be a request object...
        Result result = clientCommunicator.send(request);

        if(result.getSuccess().equals(true)){
            return (String)result.getData();
        } else {
            System.out.print("something went wrong");
        }
        return null;
    }

    public String toLower(String s){
        Request request = new Request();
        request.setMethodID("execcmd");

        //build the command data object with the string
        CommandData commandData = new CommandData("processor.StringProcessor", "toLowercmd", new String[] {"String"},
                new Object[] { s });

        //maybe i should just make it "String" as the class... and then return String.class in
        //a switch statement... that would be the work-around.

        request.setData(commandData);

        //this has to be a request object...
        Result result = clientCommunicator.send(request);

        if(result.getSuccess().equals(true)){
            return (String)result.getData();
        } else {
            System.out.print("something went wrong");
        }
        return null;
    }

    public Double parseDouble(String s){
        Request request = new Request();
        request.setMethodID("execcmd");

        //build the command data object with the string
        CommandData commandData = new CommandData("processor.StringProcessor", "parseDoublecmd", new String[] {"String"},
                new Object[] { s });

        //maybe i should just make it "String" as the class... and then return String.class in
        //a switch statement... that would be the work-around.

        request.setData(commandData);

        //this has to be a request object...
        Result result = clientCommunicator.send(request);

        if(result.getSuccess().equals(true)){
            return (Double)result.getData();
        } else {
            throw new NumberFormatException();
        }
    }

}