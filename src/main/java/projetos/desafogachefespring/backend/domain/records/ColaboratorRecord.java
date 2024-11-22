package projetos.desafogachefespring.backend.domain.records;

import org.springframework.lang.NonNull;
import projetos.desafogachefespring.backend.domain.entities.Job;
import projetos.desafogachefespring.backend.domain.entities.WorkSchedule;

public record ColaboratorRecord(
        @NonNull
        String name,

        @NonNull
        String CPF,

        @NonNull
        Job job,

        @NonNull
        WorkSchedule workSchedule
) {
    public ColaboratorRecord{
        if( CPF.isBlank()){
            throw new IllegalArgumentException("Colaborator must have CPF");
        }
        if(name.isBlank()){
            throw new IllegalArgumentException("Colaborator must have Name");
        }

    }

}
