package projetos.desafogachefespring.domain.records;

import projetos.desafogachefespring.domain.entities.Job;
import projetos.desafogachefespring.domain.entities.WorkSchedule;

public record ColaboratorRecord(String name,
                                String CPF,
                                Job job,
                                WorkSchedule workSchedule) {
    public ColaboratorRecord{
        if(CPF == null || CPF.isBlank()){
            throw new IllegalArgumentException("Colaborator must have CPF");
        }
        if(job == null){
            throw new IllegalArgumentException("Colaborator must have job");
        }
        if(workSchedule == null){
            throw new IllegalArgumentException("Colaborator must have Work Schedule");
        }
    }

}
