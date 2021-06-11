package bsuir.entity.impl;

import bsuir.entity.Document;
import bsuir.entity.Folder;
import bsuir.entity.Secretary;

import java.util.List;

public class SecretaryImpl implements Secretary {

    @Override
    public synchronized boolean addDocument(Folder folder, Document document) {
        return folder.addDocument(document);
    }

    @Override
    public synchronized Document searchDocumentByHeader(Folder currentFolder, String header) {
        List<Folder> foldersInCurrentFolder = currentFolder.getFolders();

        for (Folder folder : foldersInCurrentFolder) {
            List<Document> documentsInFolder = folder.getDocuments();
            for (Document document : documentsInFolder) {
                if (document.getHeader().equals(header)) {
                    return document;
                }
            }
        }
        return null;
    }

    @Override
    public synchronized Document searchDocumentByAuthor(Folder currentFolder, String author) {
        List<Folder> foldersInCurrentFolder = currentFolder.getFolders();

        for (Folder folder : foldersInCurrentFolder) {
            List<Document> documentsInFolder = folder.getDocuments();
            for (Document document : documentsInFolder) {
                if (document.getAuthor().equals(author)) {
                    return document;
                }
            }
        }
        return null;
    }
}
