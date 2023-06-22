/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import Modelos.ModeloPaciente;

public class ImplementacionPacienteDAO implements InterfacePacientesDAO {

    private List<ModeloPaciente> todosLosPacientes;

    public ImplementacionPacienteDAO() {
        todosLosPacientes = new ArrayList<>();

        todosLosPacientes.add(new ModeloPaciente("123", "Acevedo", "Leandro", "321", "Cra1#12-45",""));
    }

    @Override
    public List<ModeloPaciente> pacientes() {
        return todosLosPacientes;
    }

    @Override
    public ModeloPaciente getPaciente(String id) {
        for (ModeloPaciente paciente : todosLosPacientes) {
            if (paciente.getId().equals(id)) {
                System.out.println(paciente);
                return paciente;
            }
        }
        return null;
    }

    @Override
    public void save(ModeloPaciente paciente) {
        ModeloPaciente nuevoPaciente = new ModeloPaciente(paciente.getId(), paciente.getApellidos(), paciente.getNombres(), paciente.getTelefono(), paciente.getDireccion(), paciente.getObservaciones());
        todosLosPacientes.add(nuevoPaciente);
    }

    @Override
    public void update(ModeloPaciente paciente) {
        for (int i = 0; i < todosLosPacientes.size(); i++) {
            if (todosLosPacientes.get(i).getId().equals(paciente.getId())) {
                todosLosPacientes.set(i, paciente);
                break;
            }
        }
    }

}
