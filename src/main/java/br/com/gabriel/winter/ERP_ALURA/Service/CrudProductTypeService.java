package br.com.gabriel.winter.ERP_ALURA.Service;

import br.com.gabriel.winter.ERP_ALURA.ORM.ProductType;
import br.com.gabriel.winter.ERP_ALURA.Repository.ProductTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudProductTypeService {
    private final ProductTypeRepository productTypeRepository;
    private int action;

    public CrudProductTypeService(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    public void start(Scanner scanner) {
        System.out.println("escolha uma opção");

        System.out.println("digite 1 para cadastrar novo tipo de produto.");
        System.out.println("digite 2 para atualizar o produto.");
        System.out.println("digite 3 para DELETAR o produto.");
        int action = scanner.nextInt();
        switch (action) {
            case 1:
                registerProductType(scanner);
                break;
            case 2:
                attProductType(scanner);
            case 3:
                deleteProductType(scanner);
            default:
                break;
        }

    }

    private void deleteProductType(Scanner scanner) {

        scanner.useDelimiter("\n");
        System.out.println("digite o ID do produto a ser deletado");
        Integer id = scanner.nextInt();
        ProductType productType = this.productTypeRepository.findById(id).get();
        System.out.println(productType.getProductType());
        System.out.println("digite 1 para deletar");
        System.out.println("digite 0 para sair");
        int opcao = scanner.nextInt();
        if (opcao == 1) {
            productTypeRepository.deleteById(id);
            System.out.println("produto deletado com sucesso");
        } else {
            System.out.println("produto nao deletado");
        }

    }

    private void attProductType(Scanner scanner) {
        scanner.useDelimiter("\n");
        System.out.println("digite o ID do produto a ser atualizado");
        Integer id = scanner.nextInt();
        ProductType productType = this.productTypeRepository.findById(id).get();
        System.out.println("digite o tipo do produto atualizado");
        String product = scanner.next();
        productType.setProductType(product);
        productTypeRepository.save(productType);

    }

    private void registerProductType(Scanner scanner) {
        scanner.useDelimiter("\n");
        System.out.println("digite o tipo do produto a ser registrado");
        String product = scanner.next();
        ProductType productType = new ProductType();
        productType.setProductType(product);
        productTypeRepository.save(productType);
        System.out.println("Salvo");
    }
}
