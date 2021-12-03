package model;
import dao.EsculturaDAO;
import dao.PinturaDAO;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PinturaDAO pDAO = new PinturaDAO();
        EsculturaDAO eDAO = new EsculturaDAO();
        Pintura p1 = new Pintura();
        Escultura e1 = new Escultura();
        boolean flag = true;

        while(flag) {
            System.out.println("1 - Inserir pintura");
            System.out.println("2 - Inserir escultura");
            System.out.println("3 - Atualizar pintura");
            System.out.println("4 - Atualizar escultura");
            System.out.println("5 - Deletar pintura");
            System.out.println("6 - Deletar escultura");
            System.out.println("7 - Buscar pintura sem filtro");
            System.out.println("8 - Buscar escultura sem filtro");
            System.out.println("9 - Sair");
            System.out.println("Sua opção: ");
            int op = sc.nextInt();

            switch (op){
                case 1:
                    sc.nextLine();
                    System.out.println("Digite o nome da pintura: ");
                    p1.setNome(sc.nextLine());
                    System.out.println("Digite o nome do autor: ");
                    p1.setAutor(sc.nextLine());
                    System.out.println("Digite o ano: ");
                    p1.setAno(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Digite a técnica: ");
                    p1.setTecnica(sc.nextLine());

                    if(pDAO.inserirPintura(p1)){
                        System.out.println("Pintura inserida!");
                    }
                    else{
                        System.out.println("Erro na inserção!");
                    }
                    break;

                case 2:
                    sc.nextLine();
                    System.out.println("Digite o nome da escultura: ");
                    e1.setNome(sc.nextLine());
                    System.out.println("Digite o nome do autor: ");
                    e1.setAutor(sc.nextLine());
                    System.out.println("Digite o ano: ");
                    e1.setAno(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Digite o material: ");
                    e1.setMaterial(sc.nextLine());

                    if(eDAO.inserirEscultura(e1)){
                        System.out.println("Escultura inserida!");
                    }
                    else{
                        System.out.println("Erro na inserção!");
                    }
                    break;

                case 3:
                    int id;
                    sc.nextLine();
                    System.out.println("Digite o id da pintura a ser atualizada: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite o nome da pintura a ser atualizado: ");
                    p1.setNome(sc.nextLine());
                    System.out.println("Digite o nome do autor a ser atualizado: ");
                    p1.setAutor(sc.nextLine());
                    System.out.println("Digite o ano a ser atualizado: ");
                    p1.setAno(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Digite a técnica a ser atualizado: ");
                    p1.setTecnica(sc.nextLine());

                    if(pDAO.atualizarPintura(id, p1)){
                        System.out.println("Pintura alterada!");
                    }
                    else{
                        System.out.println("Erro na alteração!");
                    }
                    break;

                case 4:
                    int id2;
                    sc.nextLine();
                    System.out.println("Digite o id da escultura a ser atualizada: ");
                    id2 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite o nome da escultura a ser atualizado: ");
                    e1.setNome(sc.nextLine());
                    System.out.println("Digite o nome do autor a ser atualizado: ");
                    e1.setAutor(sc.nextLine());
                    System.out.println("Digite o ano a ser atualizado: ");
                    e1.setAno(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Digite o material a ser atualizado: ");
                    e1.setMaterial(sc.nextLine());

                    if(eDAO.atualizarEscultura(id2, e1)){
                        System.out.println("Escultura alterada!");
                    }
                    else{
                        System.out.println("Erro na alteração!");
                    }
                    break;

                case 5:
                    int id3;
                    sc.nextLine();
                    System.out.println("Digite o id da pintura a ser excluída: ");
                    id3 = sc.nextInt();
                    if(pDAO.deletarPintura(id3)){
                        System.out.println("Pintura deletada!");
                    }
                    else{
                        System.out.println("Erro ao deletar!");
                    }
                    break;

                case 6:
                    int id4;
                    sc.nextLine();
                    System.out.println("Digite o id da escultura a ser excluída: ");
                    id4 = sc.nextInt();
                    System.out.println(id4);
                    if(eDAO.deletarEscultura(id4)){
                        System.out.println("Escultura deletada!");
                    }
                    else{
                        System.out.println("Erro ao deletar!");
                    }
                    break;

                case 7:
                    ArrayList<Pintura> pin = pDAO.buscarPinturaSemFiltro();
                    break;

                case 8:
                    ArrayList<Escultura> esc = eDAO.buscarEsculturaSemFiltro();
                    break;

                case 9:
                    System.out.println("Você saiu");
                    flag = false;
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }
}
