
package com.mycompany.dsdtrabalho1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Servidor {
 private static HashMap<String, Pessoa> pessoas = new HashMap<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(751)) {
            System.out.println("Servidor Iniciado. Aguardando conexão na porta 751...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado: " + socket.getInetAddress());

                Thread t = new Thread(new ClientHandler(socket));
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

                String operation;
                while ((operation = reader.readLine()) != null) {
                    switch (operation) {
                        case "INSERT":
                            insert(reader, writer);
                            break;
                        case "UPDATE":
                            update(reader, writer);
                            break;
                        case "GET":
                            get(reader, writer);
                            break;
                        case "DELETE":
                            delete(reader, writer);
                            break;
                        case "LIST":
                            list(writer);
                            break;
                        default:
                            writer.println("Operação inválida!");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void insert(BufferedReader reader, PrintWriter writer) throws IOException {
            String cpf = reader.readLine();
            String nome = reader.readLine();
            String endereco = reader.readLine();
            String contato = reader.readLine();
            int idUnico = Integer.parseInt(reader.readLine());
            Pessoa pessoa = new Pessoa(cpf, nome, endereco, contato, idUnico);
            pessoas.put(cpf, pessoa);
        }

        private void update(BufferedReader reader, PrintWriter writer) throws IOException {
            String cpf = reader.readLine();
            Pessoa pessoa = pessoas.get(cpf);
            if (pessoa != null) {
                String nome = reader.readLine();
                String endereco = reader.readLine();
                String contato = reader.readLine();
                pessoa.setNome(nome);
                pessoa.setEndereco(endereco);
                pessoa.setContato(contato);
                writer.println("Pessoa atualizada com sucesso");
            } else {
                writer.println("Pessoa não encontrada");
            }
        }

        private void get(BufferedReader reader, PrintWriter writer) throws IOException {
            String cpf = reader.readLine();
            Pessoa pessoa = pessoas.get(cpf);
            if (pessoa != null) {
                writer.println(pessoa.getCpf() + ";" + pessoa.getNome() + ";" + pessoa.getEndereco() + ";" + pessoa.getContato() + ";" + pessoa.getIdUnico());
            } else {
                writer.println("Pessoa não encontrada");
            }
        }

        private void delete(BufferedReader reader, PrintWriter writer) throws IOException {
            String cpf = reader.readLine();
            Pessoa removed = pessoas.remove(cpf);
            if (removed != null) {
                writer.println("Pessoa removida com sucesso");
            } else {
                writer.println("Pessoa não encontrada");
            }
        }

        private void list(PrintWriter writer) {
            if (pessoas.isEmpty()) {
                writer.println("0");
            } else {
                writer.println(String.format("%02d", pessoas.size()));
                for (Pessoa pessoa : pessoas.values()) {
                    writer.println(pessoa.getCpf() + ";" + pessoa.getNome() + ";" + pessoa.getEndereco() + ";" + pessoa.getContato() + ";" + pessoa.getIdUnico());
                }
            }
        }
    }
}

    
    

