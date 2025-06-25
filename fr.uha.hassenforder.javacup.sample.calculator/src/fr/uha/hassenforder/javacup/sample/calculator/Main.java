public class Main {
    public static void main(String[] args) {
        try {
            // Phase 1: Parsing
            String filename = args.length > 0 ? args[0] : "input.toml";
            AdvancedSymbolFactory symbolFactory = new AdvancedSymbolFactory();
            Lexer lexer = new Lexer(new FileReader(filename));
            lexer.setAdvancedSymbolFactory(symbolFactory);
            Parser parser = new Parser(lexer, symbolFactory);
            TomlDocument document = (TomlDocument) parser.parse().value;
            
            // Phase 2: (Optionnelle) Transformation des données
            // Si nécessaire, vous pouvez modifier le document ici
            
            // Phase 3: Génération JSON
            JsonGenerator generator = new JsonGenerator();
            document.accept(generator);
            String json = generator.getJson();
            
            // Écriture du résultat
            try (FileWriter writer = new FileWriter("output.json")) {
                writer.write(json);
            }
            
            System.out.println("Conversion terminée avec succès.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}