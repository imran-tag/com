public interface TomlVisitor {
    void visit(TomlDocument doc);
    void visit(TomlTable table);
    void visit(TomlArray array);
    void visit(TomlString string);
    void visit(TomlInteger integer);
    void visit(TomlFloat floatValue);
    void visit(TomlBoolean bool);
    void visit(TomlDateTime dateTime);
}

public class JsonGenerator implements TomlVisitor {
    private StringBuilder json = new StringBuilder();
    
    // Implémentation des méthodes de visite pour générer le JSON
    @Override
    public void visit(TomlDocument doc) {
        // Génère le JSON pour le document entier
    }
    
    @Override
    public void visit(TomlTable table) {
        // Génère le JSON pour une table
        json.append("{");
        // Parcourir les entrées de la table...
        json.append("}");
    }
    
    // Autres méthodes de visite...
    
    public String getJson() {
        return json.toString();
    }
}