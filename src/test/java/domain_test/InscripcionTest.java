package domain_test;

import domain.Alumno;
import domain.Inscripcion;
import domain.Materia;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InscripcionTest {

    @Test
    public void testInscripcion_ok() {
        //MATERIAS
        Materia analisis1 = new Materia(List.of());
        Materia algebra = new Materia(List.of());
        Materia analisis2 = new Materia(List.of(analisis1, algebra));
        Materia fisica1 = new Materia(List.of());
        Materia fisica2 = new Materia(List.of(fisica1));
        Materia simulacion = new Materia(List.of(analisis2));
        //ALUMNOS
        Alumno ivan = new Alumno(1727977, 42720035, 1559657141);
        ivan.setMateriasAprobadas(analisis1, algebra, analisis2, fisica1);
        //INSCRIPCION
        Inscripcion ivan_inscripcion = new Inscripcion(List.of(simulacion, fisica2), ivan);

        assertTrue(ivan_inscripcion.aprobada());
    }

    @Test
    public void testInscripcion_fail() {
        //MATERIAS
        Materia analisis1 = new Materia(List.of());
        Materia algebra = new Materia(List.of());
        Materia analisis2 = new Materia(List.of(analisis1, algebra));
        Materia fisica1 = new Materia(List.of());
        Materia fisica2 = new Materia(List.of(fisica1));
        Materia simulacion = new Materia(List.of(analisis2));
        //ALUMNOS
        Alumno ivan = new Alumno(1727977, 42720035, 1559657141);
        ivan.setMateriasAprobadas(analisis1, algebra, fisica1);
        //INSCRIPCION
        Inscripcion ivan_inscripcion = new Inscripcion(List.of(simulacion, fisica2), ivan);

        //No se puede inscribir porque le falta analisis2 que es correlativa de simulacion
        assertFalse(ivan_inscripcion.aprobada());
    }

}
