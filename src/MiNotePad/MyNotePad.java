package MiNotePad;

import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class MyNotePad extends javax.swing.JFrame 
{    
    public MyNotePad() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        AreaTexto = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuArchivo = new javax.swing.JMenu();
        BotonNuevo = new javax.swing.JMenuItem();
        BotonAbrir = new javax.swing.JMenuItem();
        BotonGuardar = new javax.swing.JMenuItem();
        BotonGuargarComo = new javax.swing.JMenuItem();
        BotonSalir = new javax.swing.JMenuItem();
        MenuEditar = new javax.swing.JMenu();
        BotonCopiar = new javax.swing.JMenuItem();
        MenuPegar = new javax.swing.JMenuItem();
        MenuCortar = new javax.swing.JMenuItem();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("My NotePad : Sin Título");
        setBounds(new java.awt.Rectangle(0, 0, 1024, 640));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        AreaTexto.setColumns(20);
        AreaTexto.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        AreaTexto.setRows(5);
        AreaTexto.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        AreaTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AreaTextoKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(AreaTexto);

        MenuArchivo.setText("Archivo");

        BotonNuevo.setText("Nuevo");
        BotonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonNuevoActionPerformed(evt);
            }
        });
        MenuArchivo.add(BotonNuevo);

        BotonAbrir.setText("Abrir");
        BotonAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAbrirActionPerformed(evt);
            }
        });
        MenuArchivo.add(BotonAbrir);

        BotonGuardar.setText("Guardar");
        BotonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarActionPerformed(evt);
            }
        });
        MenuArchivo.add(BotonGuardar);

        BotonGuargarComo.setText("Guardar como...");
        BotonGuargarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuargarComoActionPerformed(evt);
            }
        });
        MenuArchivo.add(BotonGuargarComo);

        BotonSalir.setText("Salir");
        BotonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSalirActionPerformed(evt);
            }
        });
        MenuArchivo.add(BotonSalir);

        jMenuBar1.add(MenuArchivo);

        MenuEditar.setText("Editar");
        MenuEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        BotonCopiar.setText("Copiar");
        BotonCopiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCopiarActionPerformed(evt);
            }
        });
        MenuEditar.add(BotonCopiar);

        MenuPegar.setText("Pegar");
        MenuPegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuPegarActionPerformed(evt);
            }
        });
        MenuEditar.add(MenuPegar);
        MenuPegar.getAccessibleContext().setAccessibleDescription("");

        MenuCortar.setText("Cortar");
        MenuCortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCortarActionPerformed(evt);
            }
        });
        MenuEditar.add(MenuCortar);

        jMenuBar1.add(MenuEditar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void guardarComo(FileWriter fwr) 
    {   
        JFileChooser fc = new JFileChooser();//Inicializo un nuevo objeto fileChooser

        int val = fc.showSaveDialog(this); //Muestro la ventana de selección de directorio de guardado
        
        if(val != JFileChooser.APPROVE_OPTION)//Si puso cancelar retorno
            return;
        
        try {
            fwr = new FileWriter(new File(fc.getSelectedFile().getPath() + ".txt"));//Inicializo el objeto Writer y le paso la ruta que seleccioné en el jFilechooser
            AreaTexto.write(fwr);//Le paso al FileWriter el contenido de mi textArea
            tecla_apretada = false; //Reseteo la variable de presión de tecla
            fwr.close(); //Cierro el vinculo con el archivo
            archivoAbierto = fc.getSelectedFile();
            this.setTitle("My NotePad : "+ fc.getSelectedFile().getName());
        }
        catch (IOException ex) {
            Logger.getLogger(MyNotePad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void guardar(FileWriter fwr)//Casi lo mismo que guardar como, pero en este caso debe existir el archivo de antemano
    {
        try 
        {
            fwr = new FileWriter(archivoAbierto);
            AreaTexto.write(fwr);
            tecla_apretada = false;
            fwr.close();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(MyNotePad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("null")
    public void abrir()
    {
        JFileChooser fc;

        fc = new JFileChooser(); //Ventana que selecciona los archivos

        FileReader fr = null; //Objeto que vincula un archivo con el programa, para poder leerlo

        int ret = fc.showOpenDialog(this);//aca guardo un valor en caso de que cerré el filechooser sin seleccionar nada

        if(ret != JFileChooser.APPROVE_OPTION)//Si puse cancelar, retorno
            return;

        archivoAbierto = fc.getSelectedFile();//Le paso el archivo seleccionado a mi objeto File

        try 
        {
            fr = new FileReader(archivoAbierto);//Leo el archivo que recibi por medio de fc
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(MyNotePad.class.getName()).log(Level.SEVERE, null, ex);
        }

        try 
        {
            AreaTexto.read(fr, null);//Pongo el texto que recibi en el textArea
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(MyNotePad.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            fr.close();//Cierro el vínculo con el archivo
        } catch (IOException ex) {
            Logger.getLogger(MyNotePad.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setTitle("My NotePad : "+ archivoAbierto.getName());
        
        tecla_apretada = false;
    }
    
    public void salir()
    {
        Object[] opciones = {"Salir","Guardar","Cancelar"};//Vector de objetos con los mensajes de cada botón
        
        if(WindowEvent.WINDOW_CLOSING != 0)//Si estoy intentando cerrar
        {
            if(tecla_apretada == false || AreaTexto.getText().equals(""))
                System.exit(NORMAL);//No presioné teclas y el textArea está vacío, puedo salir sin guardar
            else
            {
                int opcion;//Muestro el pop-up para elegir si guardar antes de salir
                opcion = JOptionPane.showOptionDialog(this,"¿Salir sin guardar?","Confirmación",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, opciones,null);
                
                if(opcion == JOptionPane.YES_OPTION)//Si elegí la primer opcion ("si")
                {
                    System.exit(0);//Salgo
                }
                else if(opcion == 1) //Si elegí guardar antes de salir
                {
                    if(archivoAbierto != null)
                        guardar(fw);//Si ya habia un archivo abierto lo sobreescribo
                    else if(archivoAbierto == null)
                        guardarComo(fw);//Si no habia archivo muestro la ventana para generarlo
                    
                    System.exit(NORMAL);//Salgo
                }
            }
        }
    }
    
    private void AreaTextoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AreaTextoKeyPressed
       tecla_apretada = true;
    }//GEN-LAST:event_AreaTextoKeyPressed

    private void BotonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarActionPerformed
        
        if(archivoAbierto != null) //Si estoy trabajando con un archivo abierto previamente lanzo guardar 
            guardar(fw);
        else if(archivoAbierto == null)//Si no abri un archivo en ningun momento y toco guardar, se lanza guardar como
        {    
            guardarComo(fw);
        }   
    }//GEN-LAST:event_BotonGuardarActionPerformed

    private void BotonAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAbrirActionPerformed
               
        Object[] options = {"Si","No","Cancelar"};
        
        if(tecla_apretada == false || AreaTexto.getText().equals(""))//Si no presione teclas o el campo esta vacio abro directamente el filechooser
            abrir();
        else
        {
            int decision = JOptionPane.showOptionDialog(null, "¿Desechar los cambios?", "Abrir",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);

            if(decision == 0)//Si elijo descartar los cambios
                abrir();
            else if(decision == 1)//Si quiero guardar antes de abrir nuevo
            {
                if(archivoAbierto == null)
                    guardarComo(fw);
                else if(archivoAbierto != null)
                    guardar(fw);

                tecla_apretada = false;
            }
        }
    }//GEN-LAST:event_BotonAbrirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        salir();//Aca llamo directamente al método salir que se encarga de todo en caso de querer cerrar la ventana
    }//GEN-LAST:event_formWindowClosing

    private void BotonGuargarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuargarComoActionPerformed
        guardarComo(fw);//Llamo al método guardarComo
    }//GEN-LAST:event_BotonGuargarComoActionPerformed

    private void BotonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSalirActionPerformed
        salir();//Lo mismo que pasa si toco la X roja para cerrar la ventana
    }//GEN-LAST:event_BotonSalirActionPerformed

    @SuppressWarnings("UnnecessaryReturnStatement")
    private void BotonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonNuevoActionPerformed
        
        Object[] options = {"Si","Guardar cambios","Cancelar"};
        
        if(tecla_apretada == false || AreaTexto.getText().equals(""))
            return; //Si no apreté teclas o no realize modificaciones sobre textArea
        else
        {   //Muestro la ventana de confirmar o no la elección
            int decision = JOptionPane.showOptionDialog(null, "¿Desechar los cambios?", "Nuevo",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);

            if(decision == 0)//Si puse si
            {
                AreaTexto.setText(null);//Borro todo el contenido de textArea
            }
            if(decision == 1)//Si puse no (Quiero guardar los cambios actuales)
            {
                if(archivoAbierto != null) guardar(fw);//Llamo al método correspondiente según exista o no el archivo
                else guardarComo(fw);
                AreaTexto.setText(null);//Despues de guardar borro el contenido del area de texto
            }
        }
    }//GEN-LAST:event_BotonNuevoActionPerformed

    private void BotonCopiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCopiarActionPerformed
        AreaTexto.copy();
    }//GEN-LAST:event_BotonCopiarActionPerformed

    private void MenuPegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuPegarActionPerformed
        AreaTexto.paste();
    }//GEN-LAST:event_MenuPegarActionPerformed

    private void MenuCortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCortarActionPerformed
        AreaTexto.cut();
    }//GEN-LAST:event_MenuCortarActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                //Cambio el aspecto de los componentes de la ventana por el predeterminado de windows
                javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyNotePad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyNotePad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyNotePad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyNotePad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyNotePad().setVisible(true);
            }
        });
    }
    
    //Todos los atributos de la ventana
    private final FileWriter fw = null;
    private File archivoAbierto;
    private boolean tecla_apretada = false;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreaTexto;
    private javax.swing.JMenuItem BotonAbrir;
    private javax.swing.JMenuItem BotonCopiar;
    private javax.swing.JMenuItem BotonGuardar;
    private javax.swing.JMenuItem BotonGuargarComo;
    private javax.swing.JMenuItem BotonNuevo;
    private javax.swing.JMenuItem BotonSalir;
    private javax.swing.JMenu MenuArchivo;
    private javax.swing.JMenuItem MenuCortar;
    private javax.swing.JMenu MenuEditar;
    private javax.swing.JMenuItem MenuPegar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
