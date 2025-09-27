import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Clase GenerateInfoFiles - Genera archivos pseudoaleatorios para la entrega semana 3.
 * Class GenerateInfoFiles - Generates pseudo-random files for week 3 assignment.
 */
public class GenerateInfoFiles {

    // Listas base para generar datos pseudoaleatorios
    // Base lists to generate pseudo-random data
    private static final String[] nombres = {"edwin", "Ana", "Jhon", "Luisa", "Pedro", "María", "Andrés", "Camila", "Laura", "Felipe" };
    private static final String[] apellidos = { "Gómez", "Martínez", "Rodríguez", "Hernández", "López", "Fernández", "Palacios", "Torres", "Ramírez", "Castaño" };
    private static final String[] tiposDocumento = { "CC", "TI", "CE" };
    private static final String[] productosBase = { "Arroz", "Frijoles", "Leche", "Pan", "Huevos", "Azúcar", "Aceite", "Café", "Sal", "Chocolate", "Pollo", "Carne", "Queso", "Pasta", "Yogur", "Mantequilla", "Cereal", "Atún", "Galletas", "Jugo" };
    private static Random random = new Random();

    // Carpeta predeterminada para guardar los archivos
    // Default folder to save generated files
    public static final String OUTPUT_FOLDER = "output";

    /**
     * Verifica si la carpeta de salida existe y la crea si no está.
     * Ensures the output folder exists, creates it if it does not.
     */
    private static void ensureOutputFolder() {
        File folder = new File(OUTPUT_FOLDER);
        if (!folder.exists()) {
            folder.mkdirs(); // Crea la carpeta si no existe
        }
    }

    /**
     * Crea un archivo de ventas con productos y cantidades vendidos por un vendedor.
     * Creates a sales file with products and quantities sold by a salesman.
     * @param randomSalesCount número de ventas a generar
     * @param name nombre del vendedor (solo usado en consola)
     * @param id identificador único del vendedor
     */
    public static void createSalesMenFile(int randomSalesCount, String name, long id) {
        ensureOutputFolder();
        String fileName = OUTPUT_FOLDER + "/ventas_" + id + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            String tipoDoc = tiposDocumento[random.nextInt(tiposDocumento.length)];
            writer.write(tipoDoc + ";" + id);
            writer.newLine();

            for (int i = 1; i <= randomSalesCount; i++) {
                int cantidad = random.nextInt(15) + 1; // cantidades de 1 a 15
                int idProducto = random.nextInt(20) + 1; // IDs de producto entre 1 y 20
                writer.write("P" + idProducto + ";" + cantidad + ";");
                writer.newLine();
            }
            System.out.println(" Archivo de ventas generado: " + fileName);
        } catch (IOException e) {
            System.err.println(" Error al generar archivo de ventas: " + e.getMessage());
        }
    }

    /**
     * Crea un archivo de productos con ID, nombre y precio.
     * Creates a products file with ID, name, and price.
     * @param productsCount número de productos a generar
     *  productsCount number of products to generate
     */
    public static void createProductsFile(int productsCount) {
        ensureOutputFolder();
        String fileName = OUTPUT_FOLDER + "/productos.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 1; i <= productsCount; i++) {
                String nombreProducto = productosBase[random.nextInt(productosBase.length)] + "_" + i;
                double precio = 1000 + (random.nextInt(90000)); // precios entre 1000 y 99999
                writer.write("P" + i + ";" + nombreProducto + ";" + precio);
                writer.newLine();
            }
            System.out.println(" Archivo de productos generado: " + fileName);
        } catch (IOException e) {
            System.err.println(" Error al generar archivo de productos: " + e.getMessage());
        }
    }

    /**
     * Crea un archivo de vendedores con documento, id, nombre y apellido.
     * @param salesmanCount número de vendedores a generar
     * Crea un archivo de vendedores con documento, id, nombre y apellido.
     * salesmanCount número de vendedores a generar
     */
    public static void createSalesManInfoFile(int salesmanCount) {
        ensureOutputFolder();
        String fileName = OUTPUT_FOLDER + "/vendedores.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 1; i <= salesmanCount; i++) {
                String tipoDoc = tiposDocumento[random.nextInt(tiposDocumento.length)];
                long id = 1000 + random.nextInt(9000);
                String nombre = nombres[random.nextInt(nombres.length)];
                String apellido = apellidos[random.nextInt(apellidos.length)];
                writer.write(tipoDoc + ";" + id + ";" + nombre + ";" + apellido);
                writer.newLine();
            }
            System.out.println("Archivo de vendedores generado: " + fileName);
        } catch (IOException e) {
            System.err.println("Error al generar archivo de vendedores: " + e.getMessage());
        }
    }
}
