/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6_dv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author diego
 */
public class Universo {
    private String nombre;
    private ArrayList<Seresv> vivos=new ArrayList();
 private File archivo = null;

    public Universo(String path) {
     archivo = new File(path);
    }
   
    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Seresv> getVivos() {
        return vivos;
    }

    public void setVivos(ArrayList<Seresv> vivos) {
        this.vivos = vivos;
    }

    @Override
    public String toString() {
        return "Universo "+ nombre ;
    }
     public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (Seresv t : vivos) {
                bw.write(t.getNombre() + ";");
                bw.write(t.getPoder() + ";");
                bw.write(t.getAños() + ";");
                bw.write(t.getPlaneta() + ";");
                bw.write(t.getRaza() + ";");
            }
            bw.flush();
        } catch (Exception ex) {
        }
        bw.close();
        fw.close();
    }

    public void cargarArchivo() {
        Scanner sc = null;
        vivos = new ArrayList();
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter(";");
                while (sc.hasNext()) {
                    vivos.add(new Seresv(sc.next(),
                            sc.nextInt(),
                            sc.nextInt(),sc.next(),sc.next()
                    )
                    );
                }
            } catch (Exception ex) {
            }
            sc.close();
        }//FIN IF
    }

}
