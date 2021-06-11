package bsuir.entity.impl;

import bsuir.entity.Author;
import bsuir.entity.Document;
import bsuir.entity.Folder;
import bsuir.exception.CustomException;

import java.time.LocalDate;

public class AuthorImpl implements Author {

    private final String name;

    public AuthorImpl(String name) {
        this.name = name;
    }

    @Override
    public synchronized void updateHeader(Document document, String newHeader) {
        document.setHeader(newHeader);
    }

    @Override
    public synchronized Document createDocument(Folder folder, String header, String context) throws CustomException {
        LocalDate currentDate = LocalDate.now();
        return new Document(folder, header, currentDate, this.name, context);
    }

    @Override
    public synchronized void updateContext(Document document, String newContext) {
        document.setContext(newContext);
    }
}
