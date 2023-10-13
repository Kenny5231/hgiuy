
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Izquierdo_Tablero extends JPanel {    
String Usuario;
String Contra;
static ArrayList<Usuarios>ListadeUsuarios;
private Inicio_sesion loginWindow;
menu_principal back;
     private Random random = new Random();
    private JButton[][] buttons;
    private char[][] board;
    private boolean atacado = false;
    //recuerda manipular la cantidad devendiendo el modo de juego 
    private boolean portaaviones = false;
    private boolean destructor = false;
    private boolean acorazado = false;
    private boolean submarino = false;
    //tambien lo de tamño
    private int tamaño = 0;
    private int alma[] = new int[128];
    private int cont=0;
    //lado al cual se coloriara 
    private boolean vertical = true;
    private static int colocados = 0;
    //la cantidad de barcos colocados 
    private int cantdetru = 0;
    private int cantporta = 0;
    private int cantacorazado = 0;
    private int cantsubmarino = 0;
    //el de destru 
    private int maxmodo=1;
    //para activar modos
    boolean tutorial = false;
    boolean Arcade = false;
    //inicio el juego
    private boolean inicio = false;
    private boolean antes=true;
    private boolean easy=false;
    private boolean normal=false;       
    private boolean expert =false;
    private boolean genius= false;
    private boolean mirar=true;
    //imagenes 
    private ImageIcon[] fire;
    private ImageIcon[] portaima;
    private ImageIcon[] portaimaver;
    private ImageIcon[] destruimaver;
    private ImageIcon[] destruima;
    private ImageIcon[] submaima;
    private ImageIcon[] submaimaver;
    private ImageIcon[] acorazadoimaver;
    private ImageIcon[] acorazadoima;
    private ImageIcon[] agua;
    private int ima = 0;
    //vida barcos
    private int vidaporta=5;
    private int vidaacorazado=4;
    private int vidasubmarino=3;
    private int vidadestrutor=2;
    //permitidos
    private int maxcolocados;
    //turnos
    public boolean turno1;
    public boolean turno2;
    private boolean colocados1;
    private boolean colocados2;
    private boolean despues=true;
    public Izquierdo_Tablero(ArrayList<Usuarios>ListadeUsuarios) {
        this.ListadeUsuarios=ListadeUsuarios;
        back = new menu_principal(ListadeUsuarios, Almacen_datos.getPlayer1(), Contra, loginWindow);
        //estado del juego 
        restarall();
        String dificultad = Almacen_datos.getDificultad();
        String modo = Almacen_datos.getModo();
        //reconocer el modo
        if (modo.equals("Tutorial")) {
            tutorial = true;
            maxmodo=1;
        }
        if (modo.equals("Arcade")) {
            Arcade = true;
            tutorial=false;
        }
        if(dificultad.equals("Easy")&& Arcade){
         easy=true;
         normal=false;       
         expert =false;
         genius= false;
         maxmodo=2;
        }else if(dificultad.equals("Normal")&& Arcade){
         easy=false;
         normal=true;       
         expert =false;
         genius= false;
         maxmodo=1;
        }else if(dificultad.equals("Expert")&& Arcade){
         easy=false;
         normal=false;       
         expert =true;
         genius= false;
         maxmodo=1;
        }else if(dificultad.equals("Genius")&& Arcade){
        easy=false;
         normal=false;       
         expert =false;
         genius= true;
         maxmodo=1;
        }
        setLayout(new GridLayout(8, 8));
        buttons = new JButton[8][8];
        board = new char[8][8];
        //imagenes
        //agua
        agua = new ImageIcon[1];
        agua[0] = new ImageIcon("/Users/Kenny/Downloads/battleship/graphics/water.gif");
        //fire
        fire = new ImageIcon[1];
        fire[0] = new ImageIcon("/Users/Kenny/Downloads/battleship/graphics/fire.gif");
        //porta
        portaima = new ImageIcon[5];
        portaima[0] = new ImageIcon("/Users/Kenny/Pictures/Photos Library.photoslibrary/resources/derivatives/masters/C/CDAF32F8-6BC2-4FE4-B9BF-D1622B46F28C_4_5005_c.jpeg");
        portaima[1] = new ImageIcon("/Users/Kenny/Pictures/Photos Library.photoslibrary/resources/derivatives/masters/C/C860DC54-9589-4CF4-99E9-10B1AB064078_4_5005_c.jpeg");
        portaima[3] = new ImageIcon("/Users/Kenny/Pictures/Photos Library.photoslibrary/resources/derivatives/masters/1/1E7092F9-02DF-4EB2-B2B9-4D874F1815F6_4_5005_c.jpeg");
        portaima[2] = new ImageIcon("/Users/Kenny/Pictures/Photos Library.photoslibrary/resources/derivatives/masters/4/48000217-3D34-47DA-8FC9-71D1B9374EFB_4_5005_c.jpeg");
        portaima[4] = new ImageIcon("/Users/Kenny/Pictures/Photos Library.photoslibrary/resources/derivatives/masters/4/489172B8-F8AF-47C8-9947-14867C5F46AB_4_5005_c.jpeg");
        //verticak
        portaimaver = new ImageIcon[5];
        portaimaver[0] = new ImageIcon("/Users/Kenny/Pictures/Photos Library.photoslibrary/resources/derivatives/masters/D/D24E0A19-AE51-414B-92F9-9EED2D10869F_4_5005_c.jpeg");
        portaimaver[1] = new ImageIcon("/Users/Kenny/Pictures/Photos Library.photoslibrary/resources/derivatives/masters/3/3658C93C-6D66-44A8-9959-F9C85955AA66_4_5005_c.jpeg");
        portaimaver[2] = new ImageIcon("/Users/Kenny/Pictures/Photos Library.photoslibrary/resources/derivatives/masters/5/5E98E17C-C54E-4539-912D-8ACF2E4E8B10_4_5005_c.jpeg");
        portaimaver[3] = new ImageIcon("/Users/Kenny/Pictures/Photos Library.photoslibrary/resources/derivatives/masters/2/2E399F05-DD1C-4DC0-957E-649B0FDA82F8_4_5005_c.jpeg");
        portaimaver[4] = new ImageIcon("/Users/Kenny/Pictures/Photos Library.photoslibrary/resources/derivatives/masters/B/B3DD2740-CF6C-4CEF-AB07-BE3B05AE013A_4_5005_c.jpeg");
        //destructor
        destruimaver = new ImageIcon[2];
        destruimaver[0] = new ImageIcon("/Users/Kenny/Pictures/Photos Library.photoslibrary/resources/derivatives/masters/F/FF15F1CF-4216-4A33-859D-D1C9BFEBB60B_4_5005_c.jpeg");
        destruimaver[1] = new ImageIcon("/Users/Kenny/Downloads/thumbnail_image.jpeg");
        //horizontal
        destruima = new ImageIcon[2];
        destruima[0] = new ImageIcon("/Users/Kenny/Pictures/Photos Library.photoslibrary/resources/derivatives/masters/C/CD2A0A91-7538-4940-BD53-930A39B635CA_4_5005_c.jpeg");
        destruima[1] = new ImageIcon("/Users/Kenny/Pictures/Photos Library.photoslibrary/resources/derivatives/masters/A/AED2D2BC-18F9-4E35-B08E-351319D761A4_4_5005_c.jpeg");
        //submarino
        submaimaver=new ImageIcon[3];
        submaimaver[0] =new ImageIcon("/Users/Kenny/Pictures/Photos Library.photoslibrary/resources/derivatives/masters/4/4972A72F-0908-4E9C-B66A-8F046C0E2632_4_5005_c.jpeg");
        submaimaver[1] =new ImageIcon("/Users/Kenny/Pictures/Photos Library.photoslibrary/resources/derivatives/masters/0/07E1BD40-B0B3-46B4-9EC5-567435B45B5C_4_5005_c.jpeg");
        submaimaver[2] =new ImageIcon("/Users/Kenny/Pictures/Photos Library.photoslibrary/resources/derivatives/masters/1/1B46E7DA-1A4B-4317-80A6-57E5EBCDD897_4_5005_c.jpeg");
        //horizontal
        submaima=new ImageIcon[3];
        submaima[0]=new ImageIcon("/Users/Kenny/Pictures/Photos Library.photoslibrary/resources/derivatives/masters/1/129255FA-3C9B-4ABA-9D0F-6BA4F36D60C7_4_5005_c.jpeg");
        submaima[1]=new ImageIcon("/Users/Kenny/Pictures/Photos Library.photoslibrary/resources/derivatives/masters/9/9078883A-9797-41C9-9609-B970FAD7CFE4_4_5005_c.jpeg");
        submaima[2]=new ImageIcon("/Users/Kenny/Pictures/Photos Library.photoslibrary/resources/derivatives/masters/7/7035B527-74A0-47A1-A911-E327CEE1138D_4_5005_c.jpeg");
        //acorzado
        acorazadoimaver= new ImageIcon[4];
        acorazadoimaver[0]= new ImageIcon("/Users/Kenny/Documents/minidocumental/image.png");
        acorazadoimaver[1]= new ImageIcon("/Users/Kenny/Documents/minidocumental/image 2.png");
        acorazadoimaver[2]= new ImageIcon("/Users/Kenny/Documents/minidocumental/image 3.png");
        acorazadoimaver[3]= new ImageIcon("/Users/Kenny/Documents/minidocumental/image 4.png");
        
        //horizontal
        acorazadoima= new ImageIcon[4];
        acorazadoima[0]= new ImageIcon("/Users/Kenny/Pictures/Photos Library.photoslibrary/resources/derivatives/masters/6/6B74C8A6-7EFE-4743-AA15-8A0685B97320_4_5005_c.jpeg");
        acorazadoima[1] =new ImageIcon("/Users/Kenny/Pictures/Photos Library.photoslibrary/resources/derivatives/masters/1/1DFB785C-B08E-4948-99AC-3FB0A5DB4C36_4_5005_c.jpeg");
        acorazadoima[2] =new ImageIcon("/Users/Kenny/Pictures/Photos Library.photoslibrary/resources/derivatives/masters/D/DC1D5CE0-C978-4E29-9E5E-5E23DEA689CF_4_5005_c.jpeg");
        acorazadoima[3] =new ImageIcon("/Users/Kenny/Pictures/Photos Library.photoslibrary/resources/derivatives/masters/4/4377E172-161E-4B6C-A461-ECA510122B94_4_5005_c.jpeg");

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                buttons[row][col] = new JButton("");
                buttons[row][col].setBackground(Color.WHITE);
                final int rowIdx = row;
                final int colIdx = col;

                buttons[row][col].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(Arcade && tutorial==false){
                        iniatack();
                        }
                        if(Arcade==false && tutorial){
                        iniatack2();
                        }
                         recoger();
                        //mandra tru en vez de el tamaño
                        tamañobar();
                        if (destructor && colocados < 1 && antes) {
                            // Permitir la colocación de barcos si aún no se han colocado 2
                            if (canPlaceCarrier(rowIdx, colIdx)) {
                                placeCarrier(rowIdx, colIdx);
                                ima = 0;
                                maxcolocados++;
                                if (vertical == false) {
                                    for (int i = colIdx; i < colIdx + tamaño; i++) {
                                        //buttons[rowIdx][i].setBackground(Color.RED);
                                        
                                        buttons[rowIdx][i].setIcon(destruima[ima]);
                                        
                                        ima++;
                                        board[rowIdx][i] = 'd';
                                    }
                                } else if (vertical) {
                                    for (int i = rowIdx; i < rowIdx + tamaño; i++) {
                                        //buttons[i][colIdx].setBackground(Color.RED);
                                        
                                        buttons[i][colIdx].setIcon(destruimaver[ima]);
                                        
                                        ima++;
                                        board[i][colIdx] = 'd';
                                    }
                                }
                                colocados++;
                            }else{ alma[cont-1]=0;
                            }
                        }else if(destructor && colocados==1 && antes){
                        alma[cont-1]=0;
                        } 
                        if (portaaviones && cantporta < maxmodo && antes) {
                            // Permitir la colocación de destructores si no se han colocado dos
                            if (canPlaceCarrier(rowIdx, colIdx)) {
                                ima = 0;
                                maxcolocados++;
                                placeCarrier(rowIdx, colIdx);
                                if (vertical == false) {
                                    for (int i = colIdx; i < colIdx + tamaño; i++) {
                                        //buttons[rowIdx][i].setBackground(Color.orange); // Cambiar color a azul para destructores
                                        
                                        buttons[rowIdx][i].setIcon(portaima[ima]);
                                        
                                        ima++;
                                        board[rowIdx][i] = 'p'; // Marcar como destructor
                                    }
                                } else if (vertical) {
                                    for (int i = rowIdx; i < rowIdx + tamaño; i++) {
                                        //buttons[i][colIdx].setBackground(Color.ORANGE);
                                       
                                        buttons[i][colIdx].setIcon(portaimaver[ima]);
                                        
                                        ima++;
                                        board[i][colIdx] = 'p';
                                    }
                                }
                                cantporta++;
                            }else{alma[cont-1]=0;}
                        }else if(portaaviones && cantporta==1 && antes){
                        alma[cont-1]=0;
                        }else if(portaaviones && cantporta==2 && antes){
                        alma[cont-1]=0;
                        }
                        if (acorazado && cantacorazado < maxmodo && antes) {
                            if (canPlaceCarrier(rowIdx, colIdx)) {
                                placeCarrier(rowIdx, colIdx);
                                ima=0;
                                maxcolocados++;
                                if (vertical == false) {
                                    for (int i = colIdx; i < colIdx + tamaño; i++) {
                                       // buttons[rowIdx][i].setBackground(Color.BLUE); // Cambiar color a azul para destructores
                                        
                                       buttons[rowIdx][i].setIcon(acorazadoima[ima]);
                                       
                                        ima++;
                                        board[rowIdx][i] = 'a'; // Marcar como destructor
                                    }
                                } else if (vertical) {
                                    for (int i = rowIdx; i < rowIdx + tamaño; i++) {
                                        //buttons[i][colIdx].setBackground(Color.BLUE);
                                        
                                        buttons[i][colIdx].setIcon(acorazadoimaver[ima]);
                                        
                                        ima++;
                                        board[i][colIdx] = 'a';
                                    }
                                }
                                cantacorazado++;
                            }else{alma[cont-1]=0;}

                        }else if(acorazado && cantacorazado==1 && antes){
                        alma[cont-1]=0;
                        }else if(acorazado && cantacorazado==2 && antes){
                        alma[cont-1]=0;
                        } 
                        if (submarino && cantsubmarino < maxmodo && antes) {
                            if (canPlaceCarrier(rowIdx, colIdx)) {
                                placeCarrier(rowIdx, colIdx);
                                ima=0;
                                maxcolocados++;
                                if (vertical == false) {
                                    for (int i = colIdx; i < colIdx + tamaño; i++) {
                                       // buttons[rowIdx][i].setBackground(Color.BLACK); // Cambiar color a azul para destructores
                                       
                                       buttons[rowIdx][i].setIcon(submaima[ima]);
                                       
                                        ima++; 
                                       board[rowIdx][i] = 's'; // Marcar como destructor
                                    }
                                } else if (vertical) {
                                    for (int i = rowIdx; i < rowIdx + tamaño; i++) {
                                        //buttons[i][colIdx].setBackground(Color.BLACK);
                                        
                                        buttons[i][colIdx].setIcon(submaimaver[ima]);
                                        
                                        ima++;
                                        board[i][colIdx] = 's';
                                    }
                                }
                                cantsubmarino++;
                            }else{alma[cont-1]=0;}
                        }else if(submarino && cantsubmarino==1 && antes){
                        alma[cont-1]=0;
                        }else if(submarino && cantsubmarino==2 && antes){
                        alma[cont-1]=0;
                        }
                        if (inicio && turno1 && colocados1 && colocados2) {
                            if(mirar==false){
                            restablecer();
                            }
                            // Realizar un ataque en este botón
                            if (board[rowIdx][colIdx] == 'd') {
                                Almacen_datos.setTurno1(false);
                                Almacen_datos.setTurno2(true);
                                buttons[rowIdx][colIdx].setIcon(fire[0]);
                                JOptionPane.showMessageDialog(null, "A golpeado al barco de destructor.\n Entregue la pc al player2", "Noticia!!!", JOptionPane.WARNING_MESSAGE);
                                //alma[cont-1]=0;
                                atacdestrutor();
                                if(vidadestrutor==0){
                               JOptionPane.showMessageDialog(null, "A destruido el barco Destructor del contrario.\n Entregue la pc al player2", "Noticia!!!", JOptionPane.WARNING_MESSAGE);
                               
                               eliminarbarco(2);
                               vidadestrutor=2; 
                                }
                                if(win()==true){
                                winpeople();
                                }
                                redrawBoard();
                                moveRandomly();
                            } else if (board[rowIdx][colIdx] == 'p') {
                                Almacen_datos.setTurno1(false);
                                Almacen_datos.setTurno2(true);
                                buttons[rowIdx][colIdx].setIcon(fire[0]);
                                JOptionPane.showMessageDialog(null, "A golpeado al barco de Portaaviones.\n Entregue la pc al player2", "Noticia!!!", JOptionPane.WARNING_MESSAGE);
                                //alma[cont-1]=0;
                                atacporta();
                                if(vidaporta==0){
                               JOptionPane.showMessageDialog(null, "A destruido el barco tipo Portaviones del contrario.\n Entregue la pc al player2", "Noticia!!!", JOptionPane.WARNING_MESSAGE);
                               
                               eliminarbarco(5);
                               vidaporta=5; 
                                }
                                if(win()==true){
                                winpeople();
                                }
                                redrawBoard();
                                moveRandomly();
                            } else if (board[rowIdx][colIdx] == 'a') {
                                Almacen_datos.setTurno1(false);
                                Almacen_datos.setTurno2(true);
                                buttons[rowIdx][colIdx].setIcon(fire[0]);
                                JOptionPane.showMessageDialog(null, "A golpeado al barco de Acorazado.\n Entregue la pc al player2", "Noticia!!!", JOptionPane.WARNING_MESSAGE);
                                //alma[cont-1]=0;
                                atacacorazado();
                                if(vidaacorazado==0){
                               JOptionPane.showMessageDialog(null, "A destruido el barco Acorazado del contrario.\n Entregue la pc al player2", "Noticia!!!", JOptionPane.WARNING_MESSAGE);
                               
                               eliminarbarco(4);
                               vidaacorazado=4; 
                               
                                }
                                if(win()==true){
                                winpeople();
                                }
                                redrawBoard();
                                moveRandomly();
                            } else if (board[rowIdx][colIdx] == 's') {
                                Almacen_datos.setTurno1(false);
                                Almacen_datos.setTurno2(true);
                                buttons[rowIdx][colIdx].setIcon(fire[0]);
                                JOptionPane.showMessageDialog(null, "A golpeado al barco de Submarino.\n Entregue la pc al player2", "Noticia!!!", JOptionPane.WARNING_MESSAGE);
                                //alma[cont-1]=0;
                                atacsubmarino();
                                if(vidasubmarino==0){
                               JOptionPane.showMessageDialog(null, "A destruido el barco del tipo Submarino del contrario.\n Entregue la pc al player2", "Noticia!!!", JOptionPane.WARNING_MESSAGE);
                               eliminarbarco(3);
                               vidasubmarino=3; 
                                }
                                if(win()==true){
                                winpeople();
                                }
                                redrawBoard();
                                moveRandomly();
                            } else {
                                Almacen_datos.setTurno1(false);
                                Almacen_datos.setTurno2(true);
                                buttons[rowIdx][colIdx].setIcon(agua[0]);
                                board[rowIdx][colIdx]= 'w';
                            } 
                        }else if(inicio && turno1==false){
                        JOptionPane.showMessageDialog(null, "No es su turno\nTurno del plater2", "Noticia!!!", JOptionPane.WARNING_MESSAGE);
                        }
                        moderestric();
                        System.out.println("porta " + portaaviones + "  detru " + destructor + "  acorazado " + acorazado + "  submarino " + submarino);

                        //para evitar poner barcos que no ban 
                        portaaviones = false;
                        destructor = false;
                        acorazado = false;
                        submarino = false;
                    }
                });
                add(buttons[row][col]);
            }
        }
    }
    private void moveRandomly() {
        Random rand = new Random();
        for (int op = 0; op < alma.length; op++) {
            int tama = alma[op];
            if (tama != 0) {
                int ima = 0;
                int newRow, newCol;
                boolean ver;
                do {
                    newCol = rand.nextInt(8);
                    newRow = rand.nextInt(8 - tama + 1);
                    ver = rand.nextBoolean();
                } while (!canPlaceCarrier(newRow, newCol) || newRow + tama > 8 || newCol + tama > 8 || isOverlap(newRow, newCol, tama, ver));

                markOccupiedCells(newRow, newCol, tama, ver);

                if (ver) {
                    for (int i = 0; i < tama; i++) {
                        if (tama == 5) {
                            if(mirar){
                            buttons[newRow + i][newCol].setIcon(portaimaver[ima]);
                            }
                            board[newRow + i][newCol] = 'p';
                        } else if (tama == 4) {
                            if(mirar){
                            buttons[newRow + i][newCol].setIcon(acorazadoimaver[ima]);
                            }
                            board[newRow + i][newCol] = 'a';
                        } else if (tama == 3) {
                            if(mirar){
                            buttons[newRow + i][newCol].setIcon(submaimaver[ima]);
                            }
                            board[newRow + i][newCol] = 's';
                        } else if (tama == 2) {
                            if(mirar){
                            buttons[newRow + i][newCol].setIcon(destruimaver[ima]);
                            }
                            board[newRow + i][newCol] = 'd';
                        }
                        ima++;
                    }
                } else {
                    for (int i = 0; i < tama; i++) {
                        if (tama == 5) {
                            if(mirar){
                            buttons[newRow][newCol + i].setIcon(portaima[ima]);
                            }
                            board[newRow][newCol + i] = 'p';
                        } else if (tama == 4) {
                            if(mirar){
                            buttons[newRow][newCol + i].setIcon(acorazadoima[ima]);
                            }
                            board[newRow][newCol + i] = 'a';
                        } else if (tama == 3) {
                            if(mirar){
                            buttons[newRow][newCol + i].setIcon(submaima[ima]);
                            }
                            board[newRow][newCol + i] = 's';
                        } else if (tama == 2) {
                            if(mirar){
                            buttons[newRow][newCol + i].setIcon(destruima[ima]);
                            }
                            board[newRow][newCol + i] = 'd';
                        }
                        ima++;
                    }
                }
            }
        }
    }

    private boolean isOverlap(int newRow, int newCol, int tama, boolean vertical) {
        for (int i = 0; i < tama; i++) {
            if (vertical && board[newRow + i][newCol] != '\0') {
                return true;
            } else if (!vertical && board[newRow][newCol + i] != '\0') {
                return true;
            }
        }
        return false;
    }

    private void markOccupiedCells(int newRow, int newCol, int tama, boolean vertical) {
        for (int i = 0; i < tama; i++) {
            if (vertical) {
                if (tama == 5) {
                    board[newRow + i][newCol] = 'p';
                } else if (tama == 4) {
                    board[newRow + i][newCol] = 'a';
                } else if (tama == 3) {
                    board[newRow + i][newCol] = 's';
                } else if (tama == 2) {
                    board[newRow + i][newCol] = 'd';
                }
            } else {
                if (tama == 5) {
                    board[newRow][newCol + i] = 'p';
                } else if (tama == 4) {
                    board[newRow][newCol + i] = 'a';
                } else if (tama == 3) {
                    board[newRow][newCol + i] = 's';
                } else if (tama == 2) {
                    board[newRow][newCol + i] = 'd';
                }
            }
        }
    }
    public void almaceno(int el){
    alma[cont]= el;
    cont++;
        System.out.println("sout llama:"+alma.length+": "+cont);
        for(int h=0;h<alma.length;h++){
            System.out.println("la posicion "+h+"\n es: "+alma[h]);
        
        }
    }
    
    
    private void redrawBoard() {
        // Actualizar la representación visual del tablero
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (board[row][col] == 'd') {
                    buttons[row][col].setIcon(null);
                    board[row][col] ='\0';
                } else if (board[row][col] == 'p') {
                    buttons[row][col].setIcon(null);
                    board[row][col] ='\0';
                } else if (board[row][col] == 'a') {
                    buttons[row][col].setIcon(null);
                    board[row][col] ='\0';
                } else if (board[row][col] == 's') {
                    buttons[row][col].setIcon(null);
                    board[row][col] ='\0';
                }else if (board[row][col] == 'w') {
                    buttons[row][col].setIcon(null);
                    board[row][col] ='\0';
                }  
            }
        }
    }
    public void restablecer(){
    for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                    buttons[row][col].setIcon(null);
            }
        }
    }
    
    private void placeCarrier(int row, int col) {
        if (!vertical) {
            for (int i = col; i <= col + tamaño - 1; i++) {
                board[row][i] = 'C';
            }
        } else {
            for (int i = row; i <= row + tamaño - 1; i++) {
                board[i][col] = 'C';
            }
        }
    }

    private boolean canPlaceCarrier(int row, int col) {
        if (!vertical) {
            if (col + tamaño - 1 >= 8) {
                return false;
            }
            for (int i = col; i <= col + tamaño - 1; i++) {
                if (board[row][i] == 'd' || board[row][i] == 'a' || board[row][i] == 's' || board[row][i] == 'p') {
                    return false;
                }
            }
        } else {
            if (row + tamaño - 1 >= 8) {
                return false;
            }
            for (int i = row; i <= row + tamaño - 1; i++) {
                if (board[i][col] == 'd' || board[i][col] == 'a' || board[i][col] == 'p' || board[i][col] == 's') {
                    return false;
                }
            }
        }
        return true;
    }

    public void setVertical(boolean bb) {
        vertical = bb;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
    public void tamañobar() {
        if (portaaviones) {
            tamaño = 5;
        } else if (acorazado) {
            tamaño = 4;
        } else if (submarino) {
            tamaño = 3;
        } else if (destructor) {
            tamaño = 2;
        }
        if(tamaño!=0 && antes==true){
        almaceno(tamaño);
        }
    }

    //para ver que barco desean presionar
    public void setacorazado(boolean cora) {
        this.acorazado = cora;
    }

    public void setporta(boolean porta) {
        this.portaaviones = porta;
    }

    public void setsubamarino(boolean sub) {
        this.submarino = sub;
    } 
    public void setdestru(boolean destr) {
        this.destructor = destr;
    }
    
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
    vidadestrutor--;
    }
    private void eliminarbarco(int num){
    boolean entro=true;
    for(int i=0;i<alma.length;i++){
    if(alma[i]==num && entro==true){
    alma[i]=0;
    entro=false;
    }
    }
    }
    public void moderestric(){
    if(tutorial){
        if(maxcolocados==4){
        inicio=true;
        antes=false;
         mirar=true;
         coloini();
        //JOptionPane.showMessageDialog(null, "A colocado todos sus barcos \n Entregue la pc al Player 2", "Noticia!!!", JOptionPane.WARNING_MESSAGE);
        }
    }else if(Arcade){
        if(easy){
            System.out.println("esta true easy");
            mirar=false;
            if(maxcolocados==5){
            mirar=false;
            inicio=true;
            antes=false;
            coloini();
            }
        }else if(normal){
                    System.out.println("esta true normal");
                    mirar=false;
            if(maxcolocados==4){
            mirar=false;
            inicio=true;
            antes=false;
            coloini();
            }
        }else if(expert){
                    System.out.println("esta true expert");
                    mirar=false;
            if(maxcolocados==2){
            mirar=false;
            inicio=true;
            antes=false;
            coloini();
            }
        }else if(genius){
                    System.out.println("esta true genius");
           mirar=false;
            if(maxcolocados==1){
            mirar=false;
            inicio=true;
            antes=false;
            coloini();
            }
        }
    }
           
    }
    
    public boolean win(){
    int nada=0;
    for(int i=0;i<alma.length;i++){
    if(alma[i]==0){
    nada++;
    if(nada==alma.length){
    return true;
    }
    }
    }
    return false;
    }
   public void winpeople(){
//    Usuarios user2=buscar(Almacen_datos.getPlayer2());
//    user2.agregardes(Almacen_datos.Descrip());
//    Usuarios user=buscar(Almacen_datos.getPlayer1());
//    user.agregardes(Almacen_datos.Descrip());
//    user.puntosmas();
    Almacen_datos.setGano1(true);
    JOptionPane.showMessageDialog(null, "El jugador 1 ha ganado.\n", "Noticia!!!", JOptionPane.WARNING_MESSAGE);
    Almacen_datos.setWinner(true);
    tableromain uf =controladortablero.getUf();
    uf.dispose();
    back.setVisible(true);
    }
    public void recoger(){
    this.turno1=Almacen_datos.isTurno1();
    this.turno2=Almacen_datos.isTurno2();
    }
    public void coloini(){
    if(inicio){
        Almacen_datos.setColocado1(inicio);
    }    
    }
    public void iniatack(){
    this.colocados1=Almacen_datos.isColocado1();
    if(despues && colocados1){
    restablecer();
    }
    this.colocados2=Almacen_datos.isColocado2();
    }
    
    public void iniatack2(){
    this.colocados1=Almacen_datos.isColocado1();
    this.colocados2=Almacen_datos.isColocado2();
    }
    
    public void restarall(){
        if(true)
    //restablesco los turnos    
    Almacen_datos.setTurno1(true);
    Almacen_datos.setTurno2(false);
    //restablecer el arreglo
    for(int i=0;i<alma.length;i++){
    alma[i]=0;
    }
    //los colocados 
    inicio=false;
    Almacen_datos.setColocado2(false);
    Almacen_datos.setColocado1(false);
    antes=true;
    despues=true;
    Almacen_datos.setColocado1(false);
    colocados = 0;
    cantporta = 0;
    cantacorazado = 0;
    cantsubmarino = 0;
    }
//     public Usuarios buscar(String user){
// for (int i = 0; i < ListadeUsuarios.size(); i++) {
//
//            if (ListadeUsuarios.get(i).Nombre.equals(user)) {
//                return ListadeUsuarios.get(i);
//                
//            }
//
//        }   
//    return null;
//    }
}

