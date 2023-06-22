/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import Modelos.ModeloPaciente;
/**
 *
 * @author leand
 */
public interface InterfacePacientesDAO {
    List<ModeloPaciente> pacientes();
    ModeloPaciente getPaciente(String id);
    void save(ModeloPaciente paciente);
    void update(ModeloPaciente paciente);

    
}

