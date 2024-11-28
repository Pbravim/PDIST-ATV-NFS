package br.edu.ifpb.gugawag.so.sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor2 {

    public static void main(String[] args) throws IOException {
        System.out.println("== Servidor ==");

        // Configurando o socket
        ServerSocket serverSocket = new ServerSocket(7001);
        Socket socket = serverSocket.accept();

        // pegando uma referência do canal de saída do socket. Ao escrever nesse canal, está se enviando dados para o
        // servidor
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        // pegando uma referência do canal de entrada do socket. Ao ler deste canal, está se recebendo os dados
        // enviados pelo servidor
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        // laço infinito do servidor
        while (true) {
            System.out.println("Cliente: " + socket.getInetAddress());

            String mensagem = dis.readUTF();
            
            switch (mensagem) {
                case "readdir":
                    
                    break;
                case "rename":
                    break;
                case "create":
                    
                    dos.writeUTF("Digite o arquivo")
                    String arquivo = 

                    Path dir = Paths.get( HOME + "/myDir_" + UUID.randomUUID().toString());
                    Path subdir = dir.resolve("subdir");
                    assertFalse(Files.exists(dir));
                    assertFalse(Files.exists(subdir));

                    Files.createDirectories(subdir);

                    assertTrue(Files.exists(dir));
                    assertTrue(Files.exists(subdir));
                    break;
                case "remove":             
                    Path p = Paths.get(HOME + "/inexistentFile.txt");
                    assertFalse(Files.exists(p));

                    Files.deleteIfExists(p);
                    break;
                default:
                    break;
            }
            
            dos.writeUTF("Li sua mensagem: " + mensagem);
        }
        /*
         * Observe o while acima. Perceba que primeiro se lê a mensagem vinda do cliente (linha 29, depois se escreve
         * (linha 32) no canal de saída do socket. Isso ocorre da forma inversa do que ocorre no while do Cliente2,
         * pois, de outra forma, daria deadlock (se ambos quiserem ler da entrada ao mesmo tempo, por exemplo,
         * ninguém evoluiria, já que todos estariam aguardando.
         */
    }
}
