import praxis.cl.Archivo;


public  class Main{
    public  static void main(String[] args) {
    Archivo archivo = new Archivo();


    archivo.crearArchivo("datos", "texto.txt");
    archivo.buscarTexto("src/datos/texto.txt", "Gato");
}
}
