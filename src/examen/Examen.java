/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen;

import Vista.Ventana;
import Controladores.Controlador;
import Modelos.ModeloAlergia;
import Modelos.ModeloPaciente;
import DAO.ImplementacionPacienteDAO;
import DAO.InterfacePacientesDAO;

/**
 *
 * @author leand
 */
public class Examen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ventana view = new Ventana();
        ModeloPaciente model = new ModeloPaciente("", "", "", "", "","");
        InterfacePacientesDAO daoAministrador = new ImplementacionPacienteDAO();
        Controlador ctrl = new Controlador(view, model, daoAministrador);
        ctrl.iniciar();
        view.setVisible(true);

    }

}
