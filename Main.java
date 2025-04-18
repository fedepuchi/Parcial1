import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




    
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> productos = new ArrayList<>();
        List<Integer> almacen = new ArrayList<>();
        List<Integer> listcompra = new ArrayList<>();
        int salir = 0;
        int prod = 0;
        int opcion;
        while (salir == 0) {
            
            while (prod == 0) {
                System.out.println("Agregar producto");
                String producto  = scanner.nextLine();
                productos.add(producto);
                scanner.nextLine(); 
                System.out.println("Dejar de agregar productos? (No:0/Si:1)");
                prod = scanner.nextInt();

                
            }
            
            for (int i = 0 ; i < productos.size(); i++) {
                
                System.out.println("Agregar cantidad del producto");
                int cantidad = scanner.nextInt();
                if ((cantidad < 0) || (cantidad == 0)) {
                    System.out.println("La cantidad no puede ser negativa o 0. Intente de nuevo.");
                    i--;
                    
                }else{
                    almacen.add(cantidad);
                    listcompra.add(cantidad);
                    scanner.nextLine(); 
                    
                }
              
            }
            System.out.println("Dejar de agregar productos? (No:0/Si:1)");
            salir = scanner.nextInt();
            
        }
        

        do {

            System.out.println("\nn--MENU--");
            System.out.println("1. Inventario");
            System.out.println("2. Almacenar");
            System.out.println("3. Venta");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    for (int i = 0; i < productos.size(); i++) {
         
                        System.out.print(i +". " + productos.get(i)+ ", cantidad: "+ almacen.get(i) + "\n"   );

                    }
        
                    break;
                case 2:
                    System.out.print("Que producto desea almacenar: ");
                    for (int i = 0; i < productos.size(); i++) {
                        System.out.print("\n"+ i + ". " + productos.get(i) + ".\n");
                    }
                    int productoElegido = scanner.nextInt();

                    System.out.print("\nCuantos productos desea almacenar: ");   
                    int cantidadAlmacenar = scanner.nextInt();
                    almacen.set(productoElegido, almacen.get(productoElegido) + cantidadAlmacenar);
                    
                    break;
                case 3:
                    System.out.print("Que producto desea comprar: ");
                    for (int i = 0; i < productos.size(); i++) {
                        System.out.print(i + ". " + productos.get(i)+"\n");
                    }
                    int productoElegido2 = scanner.nextInt();
                    System.out.print("Cuantos productos desea comprar: ");
                    int cantidadComprar = scanner.nextInt();
                    if (almacen.get(productoElegido2) >= cantidadComprar) {
                        almacen.set(productoElegido2, almacen.get(productoElegido2) - cantidadComprar);
                        System.out.println("Compra exitosa!");
                    } else {
                        System.out.println("No hay suficiente stock para la compra.");
                    }
                    if (almacen.get(productoElegido2) == 0) {
                        int cantidadInicial = listcompra.get(productoElegido2);
                        almacen.set(productoElegido2, cantidadInicial * 2);
                        System.out.println("La nueva cantidad del producto " + productos.get(productoElegido2) + " es: " + almacen.get(productoElegido2)+"\n");
                    }
                    break;
                case 0:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opcion != 0);
        scanner.close();  
    }
}

