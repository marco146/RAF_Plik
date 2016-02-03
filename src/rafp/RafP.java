package rafp;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RafP {

    public void zapisywanie(String plik) throws IOException {
        RandomAccessFile czytacz = new RandomAccessFile(plik, "rw");

        long poz;

        String linia;
        double wynik, zm1, zm2;
        try{
        while (true) {
            poz = czytacz.getFilePointer();

            czytacz.readDouble();
            zm1 = czytacz.readDouble();
            zm2 = czytacz.readDouble();
            wynik = zm1 + zm2;

            czytacz.seek(poz);
            czytacz.writeDouble(wynik);
            czytacz.readDouble();
            czytacz.readDouble();

        }
        }catch( EOFException e) { if( plik != null ) czytacz.close();}
       catch( FileNotFoundException e) {}
       catch( IOException e)  { if( plik != null ) czytacz.close();}
    }
public void czytanie(String WEj) throws IOException{
     double x, EPS, sinus;
    
     RandomAccessFile plik = null;
       try{  
           plik = new RandomAccessFile( WEj, "r");
           while(true){
             
               sinus = plik.readDouble();
               EPS = plik.readDouble();
               x = plik.readDouble();
               System.out.println( x + " ; " + EPS + " ; " + sinus );
           }
       }    
       catch( EOFException e)  { if( plik != null ) plik.close();}
}
    public static void main(String[] args) throws IOException {
        zapisRAF e = new zapisRAF();
        RafP c = new RafP();
        
        e.baz("zapis.txt");
        c.czytanie("zapis.txt");
        System.out.println("--------------------");
        c.zapisywanie("zapis.txt");
        c.czytanie("zapis.txt");
    }

}
