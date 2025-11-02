package java_ws_client.soap_client;

import client.stub.User;

import java.util.Scanner;

public class InputHandler {
    public static User readUser(Scanner scan){
        System.out.println("Name: ");
        String name = scan.nextLine();
        System.out.println("E-mail: ");
        String email = scan.nextLine();
        System.out.println("Date of birth: ");
        String dt_nascimento = scan.nextLine();
        System.out.println("CPF: ");
        String cpf = scan.nextLine();

        User user = new User();
        user.setNome(name);
        user.setEmail(email);
        user.setDtNascimento(dt_nascimento);
        user.setCpf(cpf);

        return user;
    }
    public static int readId(Scanner scan){
        System.out.println("User ID: ");
        return Integer.parseInt(scan.nextLine());
    }
}
