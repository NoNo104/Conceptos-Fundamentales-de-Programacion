public class Main {
    /**
     * Metodo principal que llama a los generadores de archivos de prueba.
     * Main method that calls the test file generators.
     */
 public static void main(String[] args) {
    System.out.println(" Generando archivos de prueba...");

    GenerateInfoFiles.createSalesManInfoFile(10);   // genera 10 vendedores
    GenerateInfoFiles.createProductsFile(20);      // genera 20 productos
    GenerateInfoFiles.createSalesMenFile(15, "Carlos", 1234);  // ventas para un vendedor
    GenerateInfoFiles.createSalesMenFile(12, "Ana", 5678);     // ventas para otro
    GenerateInfoFiles.createSalesMenFile(18, "Jhon", 9101);
    GenerateInfoFiles.createSalesMenFile(20, "Luisa", 1121);

    System.out.println("Generación de archivos completada exitosamente. Revisa la carpeta '" + GenerateInfoFiles.OUTPUT_FOLDER + "'");
 }
}
