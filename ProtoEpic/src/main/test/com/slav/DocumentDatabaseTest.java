package com.slav;

import org.junit.Assert;
import org.junit.Test;

public class DocumentDatabaseTest {

    @Test
    public void testDatabase() {

        DocumentDatabase db = new DocumentDatabase();
        db.populateDatabase();

        Assert.assertEquals("Project number 3", db.filterDatabase("Project number 3")
                                                            .get("Project number 3")
                                                            .getDocumentName()
        );
    }
}
