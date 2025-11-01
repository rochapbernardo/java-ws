package java_ws_server.soap_crud_server.endpoint;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java_ws_server.soap_crud_server.entity.User;
import java_ws_server.soap_crud_server.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@WebService(serviceName = "UserService")
@Component
public class UserEndpoint {
    private final UserService service;

    public UserEndpoint(UserService service) {
        this.service = service;
    }

    @WebMethod
    public User createUser(@WebParam(name = "user") User user){
        return service.createUser(user);
    }

    @WebMethod
    public User getUserById(@WebParam(name = "id") int id){
        return service.getUserById(id).orElse(null);
    }

    @WebMethod
    public List<User> listUsers(){
        return service.getAllUsers();
    }

    @WebMethod
    public User updateUser(@WebParam(name = "id") int id, User userUpdate){
        return service.updateUser(id, userUpdate);
    }

    @WebMethod
    public String deleteUser(@WebParam(name = "id") int id){
        service.deleteUser(id);
        return "User successfully deleted";
    }
}
