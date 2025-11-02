package java_ws_client.soap_client;

import java.util.Scanner;

public class UserClient {
    private final Scanner scan = new Scanner(System.in);
    private final UserServiceClient serviceClient = new UserServiceClient();

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("\n=== MENU SOAP CLIENT ===");
            System.out.println("1 - Criar usuário");
            System.out.println("2 - Listar usuários");
            System.out.println("3 - Buscar usuário por ID");
            System.out.println("4 - Atualizar usuário");
            System.out.println("5 - Deletar usuário");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int option = Integer.parseInt(scan.nextLine());
            switch (option){
                case 1 -> serviceClient.createUser(InputHandler.readUser(scan));
                case 2 -> serviceClient.listUsers();
                case 3 -> serviceClient.getUserById(InputHandler.readId(scan));
                case 4 -> serviceClient.updateUser(InputHandler.readId(scan), InputHandler.readUser(scan));
                case 5 -> serviceClient.deleteUser(InputHandler.readId(scan));
                case 0 -> running = false;
            }
        }
    }
}
