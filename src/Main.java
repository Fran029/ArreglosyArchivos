//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Archivo objeto= new Archivo();
        System.out.println(objeto.getLista());


        objeto.crearArchivo("datos","texto.txt");
        objeto.buscarTexto("src/datos/texto.txt","Gato");
    }



}