package com.slav;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DocumentDatabase {

    Map<String, ProjectDocument> docDatabase;
    Map<String, ProjectDocument> searchResult;

    public Map<String, ProjectDocument> populateDatabase() {

        docDatabase = new HashMap<String, ProjectDocument>();

        for(int i = 0; i < 20; i++) {
            String randomName = "Project number: " + i;
            docDatabase.put(randomName, new ProjectDocument(randomName));
        }
        return docDatabase;
    }

    public Map<String, ProjectDocument> filterDatabase(String nameFilter) {

        searchResult = docDatabase.entrySet().stream()
                       .filter(doc -> doc.getKey().contains(nameFilter))
                       .collect(Collectors.toMap(doc -> doc.getKey(), doc -> doc.getValue()));

        return searchResult;
    }
}
