package br.com.gabriel.winter.ERP_ALURA;

import br.com.gabriel.winter.ERP_ALURA.Service.CrudProductTypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ErpAluraApplication implements CommandLineRunner {

    private Boolean option = true;
    private final CrudProductTypeService productTypeService;

    public ErpAluraApplication(CrudProductTypeService productTypeService) {
        this.productTypeService = productTypeService;

    }

    public static void main(String[] args) {
        SpringApplication.run(ErpAluraApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        while (option) {
            System.out.println("escolha uma opção");
            System.out.println("digite 0 para sair.");
            System.out.println("digite 1 para produto.");
            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    productTypeService.start(scanner);
                    break;
                case 0:
                    option = false;
                    break;
                default:
                    break;
            }
        }


    }
}
