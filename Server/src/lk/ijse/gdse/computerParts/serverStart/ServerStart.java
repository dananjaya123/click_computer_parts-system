package lk.ijse.gdse.computerParts.serverStart;


import lk.ijse.gdse.computerParts.service.ServiseFactoryImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerStart {
    public static void main(String[] args) {

        try {
            Registry  registry = LocateRegistry.createRegistry(5060);
            registry.rebind("ijse", ServiseFactoryImpl.getInstance());
            System.out.println("Server Started");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
