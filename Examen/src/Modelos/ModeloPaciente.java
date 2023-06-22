package Modelos;

import java.util.ArrayList;
import java.util.List;

public class ModeloPaciente {

    private String id;
    private String apellidos;
    private String nombres;
    private String telefono;
    private String direccion;
    private List<String> alergias;
    private String observaciones;

    public ModeloPaciente(String id, String apellidos, String nombres, String telefono,
            String direccion, String observaciones) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.telefono = telefono;
        this.direccion = direccion;
        this.alergias = new ArrayList<>();
        this.observaciones = observaciones;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setAlergias(List<String> alergias) {
        this.alergias = alergias;
    }

    public List<String> getAlergias() {
        return alergias;
    }

    public void agregarAlergia(String alergia) {
        alergias.add(alergia);
    }
        public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
