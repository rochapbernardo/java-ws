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
            throw new RuntimeException("Error initializing SOAP Cliente: " + e.getMessage(), e);
        }
    }

    public void createUser(User user) {
        try {
            User created = userPort.createUser(user);
            System.out.println("User, " + created.getNome() + ", successfully created");
        } catch (Exception e) {
            System.err.println("Fail created user: " + e.getMessage());
        }
    }

    public void listUsers() {
        try {
            List<User> users = userPort.listUsers();
            if (users.isEmpty()) {
                System.err.println("No users found");

            } else {
                System.out.println("All users: ");
                for (User u : users) {
                    System.out.println("\nID: " + u.getId());
                    System.out.println("Name: " + u.getNome());
                    System.out.println("E-mail: " + u.getEmail());
                    System.out.println("Birthdate: " + u.getDtNascimento());
                    System.out.println("CPF: " + u.getCpf());
                }
            }
        } catch (Exception e) {
            System.err.println("Failure to list users. " + e.getMessage());
        }
    }

    public void getUserById(int id) {
        try {
            User user = userPort.getUserById(id);
            if (user != null) {
                System.out.println("User found: " + user.getNome() + "( " + user.getEmail() + ", " + user.getDtNascimento() + ")");
            } else {
                System.out.println("User not found");
            }
        } catch (Exception e) {
            System.err.println("Failure to find users: " + e.getMessage());
        }
    }

    public void updateUser(int id, User user) {
        try{
            User updated = userPort.updateUser(id, user);
            System.out.println("User updated: " + updated.getNome());
        } catch (Exception e) {
            System.err.println("Failure to update users: " + e.getMessage());
        }

    }

    public void deleteUser(int id) {
        try{
            String result = userPort.deleteUser(id);
            System.out.println(result);
        } catch (Exception e) {
            System.err.println("Failure to delete users: " + e.getMessage());
        }

    }

}
