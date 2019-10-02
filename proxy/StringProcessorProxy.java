package proxy;

import java.net.URL;

import JSON.Serializer;
import command.CommandData;
import processor.IStringProcessor;
import request.Request;
import request.ToProcess;
import result.Result;

import java.io.*;
import java.net.*;

/**
 * Connection to server. Independent of all other classes. No other classes access the server except
 * the Proxy. Deals with registering a user, logging in a user, getting a family from a user,
 * and getting events from a user. These tasks are synchronous tasks, but are implemented by
 * asynchronous tasks within the UI.
 */
public class StringProcessorProxy implements IStringProcessor {

    private static StringProcessorProxy instance = null;
    private ClientCommunicator clientCommunicator = null;

    private StringProcessorProxy() {
        clientCommunicator = ClientCommunicator.getInstance();
    }

    // static method to create instance of Singleton class
    public static StringProcessorProxy getInstance()
    {
        if (instance == null)
            instance = new StringProcessorProxy();

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
        ToProcess toProcess = new ToProcess();
        toProcess.setStrinToProcess(s);

        request.setMethodID("trim");
        request.setData(toProcess);

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
        ToProcess toProcess = new ToProcess();
        toProcess.setStrinToProcess(s);

        request.setMethodID("tolower");
        request.setData(toProcess);

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
        ToProcess toProcess = new ToProcess();
        toProcess.setStrinToProcess(s);

        request.setMethodID("parsedouble");
        request.setData(toProcess);

        //this has to be a request object...
        Result result = clientCommunicator.send(request);

        if(result.getSuccess().equals(true)){
            return (Double)result.getData();
        } else {
            System.out.print("something went wrong");
        }
        return null;
    }

}