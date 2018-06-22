import business.AdmFacade;
import business.EmployeeFacade;
import business.VisitorFacade;
import business.beans.Author;
import business.beans.Book;
import business.beans.Employee;
import business.beans.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        VisitorFacade visitorFacade = new VisitorFacade();
        AdmFacade admFacade = new AdmFacade();
        EmployeeFacade employeeFacade = new EmployeeFacade();

        Author jada = new Author("Jada Smith", "Horror");
        Author rob = new Author("Robert James", "Fantasy");
        Author tab = new Author("Tabata Northest", "Romance");

        Book one = new Book("Grite", jada, 2017, "Horror", "HO5O - J",
                22.89);
        Book two = new Book("O Castelo da Montanha", rob, 1984, "Fantasy",
                "FO88 - R", 98.55 );
        Book three = new Book("O Último Flamingo do Lago", tab, 2015, "Romance",
                "RO90- T", 19.99);

        admFacade.createBook(one);
        admFacade.createBook(two);
        admFacade.createBook(three);

        Employee john = new Employee("John Silverstone", 40, "JS4000", 950.00);
        Employee jenna = new Employee("Jenna McAdams", 23, "JM23000", 485.00);
        Employee juan = new Employee("Juan Ramirez", 34, "JR34000", 1859.00);

        admFacade.create(john);
        admFacade.create(jenna);
        admFacade.create(juan);

        User adm = new User("adm", "1234");

        System.out.println("Bem-vindo(a) à Livraria Beispiel.\n");

        System.out.println("Digite 1 para iniciar a fachada de visitantes.");
        System.out.println("Digite 2 para iniciar a fachada de funcionários.");
        System.out.println("Digite 3 para inciar a fachada de administrador.");
        int choice = input.nextInt();

        if (choice == 1) {
            int choiceVisitor = -1;
            System.out.println("Digite 1 para buscar por um título de livro.");
            System.out.println("Digite 2 para listar livros disponíveis.");
            if (choiceVisitor == 1) {
                System.out.println("Bem vindo(a). Pesquise por títulos de livros: ");
                String title = input.nextLine();
                System.out.println(visitorFacade.search(title));
            }
            else {
                System.out.println("Livros disponíveis: ");
                visitorFacade.read();
            }
        }
        else if (choice == 2) {
            System.out.println("Bem-vindo funcionário.");
            System.out.println("Digite o nome do livro que será vendido: ");
            String title = input.nextLine();
            Book purchasedBook = employeeFacade.searchBook(title);
            employeeFacade.sale();
        }
        else if (choice == 3) {
            int choiceAdm = -1;
            System.out.println("Bem vindo(a) Administrador.\n");
            System.out.println("Digite 1 para CRUD de livros.");
            System.out.println("Digite 2 para CRUD de funcionários.");
            System.out.println("Digite 3 para CRUD de usuários.");
            choiceAdm = input.nextInt();

            if (choiceAdm == 1) {
                System.out.println("\nCRUD DE LIVROS");
                System.out.println("Digite 1 para criar um livro.");
                System.out.println("Digite 2 para remover um livro.");
                System.out.println("Digite 3 para listar livros disponíveis.");
                int choiceCrudLivros = input.nextInt();

                switch(choiceCrudLivros) {
                    case 1: {
                        Book newBook = new Book();
                        System.out.println("\nCriando novo livro.");
                        System.out.println("Digite o título do livro:");

                        newBook.setTitle(input.nextLine());

                        Author newAuthor = new Author();
                        System.out.println("Criando autor:");
                        System.out.println("Digite o nome do autor: ");
                        newAuthor.setName(input.nextLine());

                        System.out.println("Digite o gênero que esse autor escreve: ");
                        newAuthor.setGender(input.nextLine());
                        newBook.setAuthor(newAuthor);

                        System.out.println("Voltando para o livro: ");
                        System.out.println("Digite o  ano de publicação do livro: ");
                        newBook.setYear(input.nextInt());
                        input.nextLine();

                        System.out.println("Digite o gênero do livro: ");
                        newBook.setGenre(input.nextLine());

                        System.out.println("Digite o código do livro: ");
                        newBook.setCode(input.nextLine());

                        System.out.println("Digite o preço do livro: ");
                        newBook.setUnitPrice(input.nextDouble());
                        input.nextLine();
                        break;
                    }
                    case 2: {
                        System.out.println("Digite o nome do livro que deseja remover: ");
                        String titleRemove = input.nextLine();
                        Book remove = admFacade.searchBook(titleRemove);
                        admFacade.delete(remove);
                        break;
                    }
                    case 3: {
                        System.out.println("Listando livros disponíveis: ");
                        admFacade.readBooks();
                        break;
                    }
                }
            }

            else if(choiceAdm == 2) {
                System.out.println("\nCRUD DE FUNCIONÁRIOS");
                System.out.println("Digite 1 para criar um funcionário.");
                System.out.println("Digite 2 para remover um funcionário.");
                System.out.println("Digite 3 para listar funcionários.");
                int choiceCrudEmployee = input.nextInt();

                switch(choiceCrudEmployee) {
                    case 1: {

                        System.out.println("\nCriando um funcionário: ");
                        System.out.println("Digite o nome do funcionário: ");
                        String name = input.nextLine();

                        System.out.println("Digite a idade do usuário: ");
                        int age = input.nextInt();
                        input.nextLine();

                        System.out.println("Digite o código id do funcionário: ");
                        String idCode = input.nextLine();

                        System.out.println("Digite o salário do funcionário: ");
                        double salary = input.nextDouble();
                        input.nextLine();

                        Employee newEmployee = new Employee(name, age, idCode, salary);
                        admFacade.create(newEmployee);
                        break;
                    }

                    case 2: {
                        System.out.println("Digite o nome do funcionário que deseja excluir: ");
                        String name = input.nextLine();
                        admFacade.delete(admFacade.searchEmployee(name));
                        break;
                    }

                    case 3: {
                        System.out.println("Listando funcionários:");
                        admFacade.readEmployees();
                        break;
                    }
                }
            }

            else {
                System.out.println("CRUD USUÁRIOS");
                System.out.println("Digite 1 para criar um novo usuário.");
                System.out.println("Digite 2 para remover um usuário.");
                int choiceUserCrud = input.nextInt();
                input.nextLine();

                switch(choiceUserCrud) {
                    case 1: {
                        System.out.println("Cadastrando novo usuário: ");
                        System.out.println("Digite o nome do usuário: ");
                        String username = input.nextLine();
                        System.out.println("Digite a senha do usuário: ");
                        String password = input.nextLine();

                        User newUser = new User(username, password);
                        admFacade.saveUser(newUser);
                        break;
                    }
                    case 2: {
                        System.out.println("Digite o usuário que deseja remover: ");
                        String username = input.nextLine();
                        admFacade.delete(admFacade.searchByUser(username));
                        break;
                    }
                }
            }
        }
        else {
            System.out.println("Escolha inválida.");
        }
    }
}