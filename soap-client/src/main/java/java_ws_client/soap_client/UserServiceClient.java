package java_ws_client.soap_client;

import client.stub.User;
import client.stub.UserEndpoint;
import jakarta.xml.ws.Service;

import javax.xml.namespace.QName;
import java.net.URL;
import java.util.List;

public class UserServiceClient {
    private final UserEndpoint userPort;

    public UserServiceClient() {
        try {
            URL wsdlURL = new URL("http://localhost:8081/ws/users?wsdl");
            QName SERVICE_NAME = new QName("http://endpoint.soap_crud_server.java_ws_server/", "UserService");
            Service service = Service.create(wsdlURL, SERVICE_NAME);
            this.userPort = service.getPort(UserEndpoint.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void createUser(User user){
        User created = userPort.createUser(user);
        System.out.println("User, created: " + created);
    }
    public void listUsers(){
        List<User> users = userPort.listUsers();
        System.out.println("All users: ");
        for(User u : users){
            System.out.println(u);
        }
    }
    public void getUserById(int id){
        User user = userPort.getUserById(id);
        System.out.println("User found: " + user);
    }
    public void updateUser(int id, User user){
        User update = userPort.updateUser(id, user);
        System.out.println("User update: " + update);
    }
    public void deleteUser(int id){
        String result = userPort.deleteUser(id);
        System.out.println(result);
    }

}
