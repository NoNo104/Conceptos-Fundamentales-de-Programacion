package generadordeproductos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Clase encargada de generar un archivo plano con productos escolares u oficina
 * con precios coherentes (máximo $10.000 COP).
 */
public class GenerateInfoFiles {

    public static void main(String[] args) {
        try {
            createProductsFile(10); // Genera 10 productos
            System.out.println("Archivo de productos generado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al generar el archivo: " + e.getMessage());
        }
    }

    /**
     * Genera un archivo llamado 'productos.txt' con productos escolares/oficina
     * y precios entre $1.000 y $10.000 COP.
     *
     * @param productsCount Número de productos a generar
     * @throws IOException Si ocurre un error al escribir el archivo
     */
    public static void createProductsFile(int productsCount) throws IOException {
        String[] nombresBase = {
            "Lapicero", "Cuaderno", "Borrador", "Regla", "Marcador",
            "Tijeras", "Pegante", "Cartuchera", "Colores", "Sacapuntas",
            "Agenda", "Carpeta", "Corrector", "Notas adhesivas", "Plumones"
        };

        Random random = new Random();
        BufferedWriter writer = new BufferedWriter(new FileWriter("productos.txt"));

        for (int i = 1; i <= productsCount; i++) {
            String idProducto = "P" + String.format("%03d", i);
            String nombreProducto = nombresBase[random.nextInt(nombresBase.length)] + " " + i;
            double precio = 1000 + random.nextInt(9000); // Precio entre $1.000 y $10.000
            String precioFormateado = String.format("%.2f", precio);

            writer.write(idProducto + ";" + nombreProducto + ";" + precioFormateado);
            writer.newLine();
        }

        writer.close();
    }
}