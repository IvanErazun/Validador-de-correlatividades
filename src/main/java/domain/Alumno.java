package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alumno {
    private Integer legajo;
    private Integer dni;
    private Integer numTel;
    private List<Materia> materiasAprobadas;

    public Alumno(Integer legajo, Integer dni, Integer numTel) {
        this.legajo = legajo;
        this.dni = dni;
        this.numTel = numTel;
        this.materiasAprobadas = new ArrayList<>();
    }


    public Integer getLegajo() {
        return legajo;
    }

    public Integer getDni() {
        return dni;
    }

    public Integer getNumTel() {
        return numTel;
    }

    public void setMateriasAprobadas(Materia ... nuevasMaterias) {
        Collections.addAll(this.materiasAprobadas, nuevasMaterias);
    }

    public List<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }
}
