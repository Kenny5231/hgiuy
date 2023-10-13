
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kenny
 */
public class Almacen_datos {
    private static boolean colocado1=false;
    private static boolean colocado2=false;
    private static boolean turno1=true;
    private static boolean turno2=false;
    private static String dificultad ="Easy" ;
    private static String modo="Tutorial";
    private static String estado;
    private static boolean winner;
    private static String Player1;
    private static String Player2;
    private static boolean gano1=false;
    private static boolean gano2=false;
    private static boolean retirada1=false;
    private static boolean retirada2=false;
    private static String arreglo[];
    private int vidaporta;
    private int vidaacorazado;
    private int vidasubmarino;
    private int vida_destrutor;

    public static boolean isRetirada2() {
        return retirada2;
    }

    public static void setRetirada2(boolean retirada2) {
        Almacen_datos.retirada2 = retirada2;
    }

    public static boolean isRetirada1() {
        return retirada1;
    }

    public static void setRetirada1(boolean retirada1) {
        Almacen_datos.retirada1 = retirada1;
    }

    public static boolean isGano1() {
        return gano1;
    }

    public static void setGano1(boolean gano1) {
        Almacen_datos.gano1 = gano1;
    }

    public static boolean isGano2() {
        return gano2;
    }

    public static void setGano2(boolean gano2) {
        Almacen_datos.gano2 = gano2;
    }
    
    
 public static String Descrip(){
 String player1=Almacen_datos.getPlayer1();
 String player2=Almacen_datos.getPlayer2();
 String mode= Almacen_datos.getDificultad();
 boolean win1= isGano1();
 boolean win2= isGano2();
 String Texto;
 if(retirada1==true){
  Texto=player1+" se ha retirado contra"+player2+"en el modo de juego de "+mode;
 return Texto;
 }
 if(retirada2==true){
  Texto=player2+" se ha retirado contra"+player1+"en el modo de juego de "+mode;
 return Texto;
 }
 if(win1==true){
 Texto=player1+" a destruido todos los barcos del jugador "+player2+"en el modo"+mode;
 return Texto;
 }
 if(win2==true){
  Texto=player2+" a destruido todos los barcos del jugador "+player1+"en el modo"+mode;
 return Texto;
 }
 Texto=" ";
 return Texto;
 }
 public static void arreglo(JTextArea texto){
 }
 
 
 
// public static void Arreglo(){
//     int i=0;
// arreglo[i]=Almacen
// 
// }
 
 
 
    public static String getPlayer1() {
        return Player1;
    }

    public static void setPlayer1(String Player1) {
        System.out.println("jugador 1: "+Player1);
        Almacen_datos.Player1 = Player1;
    }

    public static String getPlayer2() {
        return Player2;
    }

    public static void setPlayer2(String Player2) {
        System.out.println("jugador2: "+Player2 );
        Almacen_datos.Player2 = Player2;
    }

    public static boolean isWinner() {
        return winner;
    }

    public static void setWinner(boolean winner) {
        System.out.println("setwinner: "+winner);
        Almacen_datos.winner = winner;
    }

    
    
    public static boolean isColocado1() {
        return colocado1;
    }

    public static void setColocado1(boolean colocado1) {
        System.out.println("colocado1: "+colocado1);
        Almacen_datos.colocado1 = colocado1;
    }

    public static boolean isColocado2() {
        return colocado2;
    }

    public static void setColocado2(boolean colocado2) {
        System.out.println("colocado2: "+colocado2);
        Almacen_datos.colocado2 = colocado2;
    }
    
    
    
    
    
    
    public static boolean isTurno1() {
        return turno1;
    }

    public static void setTurno1(boolean turno1) {
        System.out.println("turno1: "+turno1);
        Almacen_datos.turno1 = turno1;
    }

    public static boolean isTurno2() {
        return turno2;
    }

    public static void setTurno2(boolean turno2) {
                System.out.println("turno2: "+turno2);
        Almacen_datos.turno2 = turno2;
    }
    
    
    
    
    //configuracion de barcos y modos 
     public int  portaavione(){
     vidaporta=5;
    return vidaporta;
    }
    public int acorazado(){
    vidaacorazado=4;
    return vidaacorazado;
    }
    public int submarino(){
    vidasubmarino=3;
    return vidasubmarino;
    }
    public int destructor(){
    vida_destrutor=2;
    return vida_destrutor;
    }
    
    //descuento vida por vez acertada 
    public void  atacporta(){
    vidaporta--;    
    }
    public void atacacorazado(){
    vidaacorazado--;
    }
    public void atacsubmarino(){
    vidasubmarino--;
    }
    public void atacdestrutor(){
    vida_destrutor--;
    }
    
    //llamado y envio del modo de juego
    public static String getModo() {
        return modo;
    }

    public static void setModo(String mod) {
        modo = mod;
        System.out.println(modo);
    }
    //llamado y enviado de dificultad
    public static String getDificultad() {
        return dificultad;
    }

    public static void setDificultad(String dificult) {
        dificultad = dificult;
        System.out.println(dificultad);
    }

    
    
    
    
    
    
    
 
    
    
    
}
