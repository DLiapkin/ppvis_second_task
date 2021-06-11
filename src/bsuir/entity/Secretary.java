package bsuir.entity;

public interface Secretary {
    boolean addDocument(Folder folder, Document document);

    Document searchDocumentByHeader(Folder folder, String header);

    Document searchDocumentByAuthor(Folder folder, String writer);
}
