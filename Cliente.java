
package com.mycompany.dsdtrabalho1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Cliente {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 751);
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.println("Conectado ao servidor.");

            while (true) {
                System.out.println("Escolha a operação:");
                System.out.println("1. Inserir Pessoa");
                System.out.println("2. Atualizar Pessoa");
                System.out.println("3. Obter Pessoa");
                System.out.println("4. Remover Pessoa");
                System.out.println("5. Listar Pessoas");
                System.out.println("6. Inserir Projeto");
                System.out.println("7. Sair");

                int choice = Integer.parseInt(reader.readLine());

                switch (choice) {
                    case 1:
                        insertPessoa(reader, writer);
                        break;
                    case 2:
                        updatePessoa(reader, writer);
                        break;
                    case 3:
                        getPessoa(reader, writer);
                        break;
                    case 4:
                        deletePessoa(reader, writer);
                        break;
                    case 5:
                        listPessoa(reader, writer);
                        break;
                    case 6:
                        // Implementar a lógica para inserir projeto
                        break;
                    case 7:
                        return;
                    default:
                        System.out.println("Opção inválida");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void insertPessoa(BufferedReader reader, PrintWriter writer) throws IOException {
        writer.println("INSERT_PESSOA");
        System.out.println("Informe o CPF da pessoa:");
        String cpf = reader.readLine();
        writer.println(cpf);
        System.out.println("Informe o nome da pessoa:");
        String nome = reader.readLine();
        writer.println(nome);
        System.out.println("Informe o endereço da pessoa:");
        String endereco = reader.readLine();
        writer.println(endereco);
        System.out.println("Informe o contato da pessoa:");
        String contato = reader.readLine();
        writer.println(contato);
        System.out.println("Informe o id único da pessoa:");
        String idUnico = reader.readLine();
        writer.println(idUnico);
        System.out.println("Informe o histórico de solicitações da pessoa:");
        String historicoDeSolicitacoes = reader.readLine();
        writer.println(historicoDeSolicitacoes);

        String response = reader.readLine();
        System.out.println("Resposta do servidor: " + response + "Pessoa inserida com sucesso!");
    }

    private static void updatePessoa(BufferedReader reader, PrintWriter writer) throws IOException {
        writer.println("UPDATE_PESSOA");
        System.out.println("Informe o CPF da pessoa:");
        String cpf = reader.readLine();
        writer.println(cpf);
        System.out.println("Informe o novo nome da pessoa:");
        String nome = reader.readLine();
        writer.println(nome);
        System.out.println("Informe o novo endereço da pessoa:");
        String endereco = reader.readLine();
        writer.println(endereco);
        System.out.println("Informe o novo contato da pessoa:");
        String contato = reader.readLine();
        writer.println(contato);
        //System.out.println("Informe o novo id único da pessoa:");
        //String idUnico = reader.readLine();
        //writer.println(idUnico);
       // System.out.println("Informe o novo histórico de solicitações da pessoa:");
        //String historicoDeSolicitacoes = reader.readLine();
        //writer.println(historicoDeSolicitacoes);

        //Aqui não está saindo no console a reesposta com os novos dados cadastrados em pessoa
        String response = reader.readLine();
        System.out.println("Resposta do servidor: " + response + "Pessoa atualizada com sucesso!");
    }

    private static void getPessoa(BufferedReader reader, PrintWriter writer) throws IOException {
        writer.println("GET_PESSOA");
        System.out.println("Informe o CPF da pessoa:");
        String cpf = reader.readLine();
        writer.println(cpf);

        String response = reader.readLine();
        System.out.println("Resposta do servidor: " + response);
    }

    private static void deletePessoa(BufferedReader reader, PrintWriter writer) throws IOException {
        writer.println("DELETE_PESSOA");
        System.out.println("Informe o CPF da pessoa:");
        String cpf = reader.readLine();
        writer.println(cpf);

        
        String response = reader.readLine();
        System.out.println("Resposta do servidor: " + response + " " + "Pessoa do CPF: " +  cpf + " " + "deletada com sucesso!");
    }

    private static void listPessoa(BufferedReader reader, PrintWriter writer) throws IOException {
        writer.println("LIST_PESSOA");

        int count = Integer.parseInt(reader.readLine());
        if (count == 0) {
            System.out.println("Sem pessoas cadastradas");
        } else {
            System.out.println("Lista de Pessoas:");
            for (int i = 0; i < count; i++) {
                String data = reader.readLine();
                System.out.println(data);
            }
        }
    }

}
