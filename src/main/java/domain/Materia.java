package domain;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private List<Materia> correlativas;

    public Materia(List<Materia> correlativas) {
        this.correlativas = correlativas;
    }

    public List<Materia> getCorrelativas() {
        List<Materia> todasCorrelativas = new ArrayList<>();
        obtenerCorrelativasRecursivas(this.correlativas, todasCorrelativas);
        return todasCorrelativas;
    }

    private void obtenerCorrelativasRecursivas(List<Materia> correlativas, List<Materia> todasCorrelativas) {
        for (Materia correlativa : correlativas) {
            todasCorrelativas.add(correlativa);
            obtenerCorrelativasRecursivas(correlativa.getCorrelativas(), todasCorrelativas);
        }
    }
}
