package projetos.desafogachefespring.domain.records;


public record RepresentantRecord(long id,
                                 String login,
                                 String password,
                                 String name,
                                 String companyName)
{
    public RepresentantRecord {
        if (login == null || login.isBlank()) {
            throw new IllegalArgumentException("Login cannot be null or blank.");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank.");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be null or blank.");
        }
        if (companyName == null || companyName.isBlank()) {
            throw new IllegalArgumentException("Company name cannot be null or blank.");
        }
    }
}
