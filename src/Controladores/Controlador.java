/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Vista.Ventana;
import Modelos.ModeloPaciente;
import Modelos.ModeloAlergia;
import DAO.ImplementacionPacienteDAO;
import DAO.InterfacePacientesDAO;

import DAO.InterfacePacientesDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author leand
 */
public class Controlador implements ActionListener {

    private Ventana ventana;
    private ModeloPaciente modeloPaciente;
    private InterfacePacientesDAO interfacePacientesDAO;

    public Controlador(Ventana ventana, ModeloPaciente modeloPaciente, InterfacePacientesDAO interfacePacientesDAO) {
        this.ventana = ventana;
        this.modeloPaciente = modeloPaciente;
        this.interfacePacientesDAO = new ImplementacionPacienteDAO();

        this.ventana.btn_registrar.addActionListener(this);
        this.ventana.btn_actualizar.addActionListener(this);
        this.ventana.btn_cancelar.addActionListener(this);
        this.ventana.btn_agregar.addActionListener(this);
    }

    public void iniciar() {
        ventana.setTitle("Pacientes");
        ventana.setLocationRelativeTo(null);

    }

    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == ventana.btn_agregar) {
        String selectedItem = (String) ventana.jComboBox1.getSelectedItem();
        ventana.jTextArea1.append(selectedItem + "\n");
    }
    if (e.getSource() == ventana.btn_cancelar) {
        ventana.ID.setText("");
        ventana.apellidos.setText("");
        ventana.nombres.setText("");
        ventana.telefono.setText("");
        ventana.direccion.setText("");
        ventana.jTextArea1.setText("");
    }

    // Agrega al usuario
    if (e.getSource() == ventana.btn_registrar) {
        if (!ventana.ID.getText().isEmpty()) {
            // Verifica si el usuario existe, si es así, no se agregará a la lista
            String id = ventana.ID.getText();
            ModeloPaciente pacienteEncontrado = interfacePacientesDAO.getPaciente(id);

            if (pacienteEncontrado != null) {
                ventana.apellidos.setText(pacienteEncontrado.getApellidos());
                ventana.nombres.setText(pacienteEncontrado.getNombres());
                ventana.telefono.setText(pacienteEncontrado.getTelefono());
                ventana.direccion.setText(pacienteEncontrado.getDireccion());
                ventana.jTextArea1.setText(pacienteEncontrado.getObservaciones());
            }

            try {
                // Obtener los datos del paciente de los campos de texto
                String ids = ventana.ID.getText();
                String apellidos = ventana.apellidos.getText();
                String nombres = ventana.nombres.getText();
                String telefono = ventana.telefono.getText();
                String direccion = ventana.direccion.getText();
                String obs = ventana.jTextArea1.getText();
                System.out.println(obs);
                // Crear un nuevo objeto ModeloPaciente con los datos obtenidos
                ModeloPaciente nuevoPaciente = new ModeloPaciente(ids, apellidos, nombres, telefono, direccion, obs);

                // Obtener el contenido del JTextArea y asignarlo al paciente
                String observaciones = ventana.jTextArea1.getText();
                nuevoPaciente.setObservaciones(observaciones);

                // Guardar el nuevo paciente utilizando el método save del objeto interfacePacientesDAO
                interfacePacientesDAO.save(nuevoPaciente);

                // Escribir los datos en un archivo de texto
                try {
                    FileWriter fileWriter = new FileWriter("datos.txt");
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                    bufferedWriter.write(nuevoPaciente.getId());
                    bufferedWriter.newLine();
                    bufferedWriter.write(nuevoPaciente.getApellidos());
                    bufferedWriter.newLine();
                    bufferedWriter.write(nuevoPaciente.getNombres());
                    bufferedWriter.newLine();
                    bufferedWriter.write(nuevoPaciente.getTelefono());
                    bufferedWriter.newLine();
                    bufferedWriter.write(nuevoPaciente.getDireccion());
                    bufferedWriter.newLine();
                    bufferedWriter.write(nuevoPaciente.getObservaciones());
                    bufferedWriter.newLine();

                    bufferedWriter.close();

                    System.out.println("Archivo de texto creado correctamente.");
                } catch (IOException ex) {
                    System.out.println("Error al crear el archivo de texto: " + ex.getMessage());
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Digite un número válido en el campo Código", "Advertencia", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Actualiza al usuario
    if (e.getSource() == ventana.btn_actualizar) {
        if (!ventana.nombres.getText().isEmpty() && !ventana.apellidos.getText().isEmpty() && !ventana.telefono.getText().isEmpty() && !ventana.direccion.getText().isEmpty()) {
            String id = ventana.ID.getText();
            ModeloPaciente pacienteEncontrado = interfacePacientesDAO.getPaciente(id);

            if (pacienteEncontrado != null) {
                String alergiaSeleccionada = (String) ventana.jComboBox1.getSelectedItem();

                // Actualizar los datos del paciente encontrado
                pacienteEncontrado.setApellidos(ventana.apellidos.getText());
                pacienteEncontrado.setNombres(ventana.nombres.getText());
                pacienteEncontrado.setTelefono(ventana.telefono.getText());
                pacienteEncontrado.setDireccion(ventana.direccion.getText());
                pacienteEncontrado.setObservaciones(ventana.jTextArea1.getText());

                // Llama al método update en lugar de save para actualizar el paciente en la base de datos
                interfacePacientesDAO.update(pacienteEncontrado);

                // Escribir los datos en un archivo de texto
                try {
                    FileWriter fileWriter = new FileWriter("datos.txt");
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                    bufferedWriter.write(pacienteEncontrado.getId());
                    bufferedWriter.newLine();
                    bufferedWriter.write(pacienteEncontrado.getApellidos());
                    bufferedWriter.newLine();
                    bufferedWriter.write(pacienteEncontrado.getNombres());
                    bufferedWriter.newLine();
                    bufferedWriter.write(pacienteEncontrado.getTelefono());
                    bufferedWriter.newLine();
                    bufferedWriter.write(pacienteEncontrado.getDireccion());
                    bufferedWriter.newLine();
                    bufferedWriter.write(pacienteEncontrado.getObservaciones());
                    bufferedWriter.newLine();

                    bufferedWriter.close();

                    System.out.println("Archivo de texto creado correctamente.");
                } catch (IOException ex) {
                    System.out.println("Error al crear el archivo de texto: " + ex.getMessage());
                }

                // Mostrar un mensaje de éxito o realizar cualquier otra acción necesaria
                JOptionPane.showMessageDialog(null, "Paciente actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el paciente", "Advertencia", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los espacios para actualizar el paciente", "Advertencia", JOptionPane.ERROR_MESSAGE);
        }
    }
}
}


    

