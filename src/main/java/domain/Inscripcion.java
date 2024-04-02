package domain;

import java.util.ArrayList;
import java.util.List;

public class Inscripcion {
    private List<Materia> materias;
    private Alumno alumno;

    public Inscripcion(List<Materia> materias, Alumno alumno) {
        this.materias = materias;
        this.alumno = alumno;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public boolean aprobada() {
        List<Materia> materiasYaAprobadas = this.alumno.getMateriasAprobadas();
        List<Materia> correlativasNecesarias =
                this.materias
                .stream()
                .flatMap(m -> m.getCorrelativas().stream())
                .toList();

        return materiasYaAprobadas.containsAll(correlativasNecesarias);
    }
}
