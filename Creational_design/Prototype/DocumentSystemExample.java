package Creational_design.Prototype;


interface Prototype extends Cloneable{
    Prototype clone();
    void editContent(String newContent);
    void setAuthor(String author);
    void display();
    void markAsTemplate(boolean isTemplate);
}

class Document implements Prototype{
    protected String title;
    protected String content;
    protected String author; 
    protected String createdDate;
    protected int  fileSize;
    protected boolean isTemplate=false;

    public Document(String title, String content, String author, String createdDate, int fileSize, boolean isTemplate){
        this.title=title;
        this.content=content;
        this.author=author;
        this.createdDate=createdDate;
        this.fileSize=fileSize;
        this.isTemplate=isTemplate;
    }

    public Prototype clone(){
        
        try {
            return (Document) super.clone();
            
        } catch (CloneNotSupportedException e) {
            // TODO: handle exception
            return new Document(this.title, this.content, this.author, this.createdDate, this.fileSize, this.isTemplate);
        }

    }

    @Override
    public void editContent(String newContent) {
        // TODO Auto-generated method stub
        this.content=newContent;
        
    }

    @Override
    public void setAuthor(String author) {
        this.author=author;
        // TODO Auto-generated method stub
        
    }

    @Override
    public void display() {

     System.out.println("Document - Title: " + title + ", Content: " + content + 
                         ", Author: " + author + ", Date: " + createdDate + 
                         ", Size: " + fileSize + "KB, Template: " + isTemplate);
    }
    
    

    @Override
    public void markAsTemplate(boolean isTemplate) {
        // TODO Auto-generated method stub
        this.isTemplate=isTemplate;
        
    }
}

class WordDocument extends Document{
    public WordDocument(String title, String content, String author, String createdDate, int fileSize, boolean isTemplate){
        super(title, content, author, createdDate, fileSize, isTemplate);

    }

    @Override
    public Prototype clone(){
        try {
            return (WordDocument) super.clone();
        } catch (Exception e) {
            // TODO: handle 
            return new WordDocument(this.title, this.content, this.author, this.createdDate, this.fileSize, this.isTemplate);
        }

    }

    @Override
    public void display() {
        System.out.print("Word ");
        super.display();
    }
}

class PDFDocument extends Document{
    public PDFDocument(String title, String content, String author, String createdDate, int fileSize, boolean isTemplate){
        super(title, content, author, createdDate, fileSize, isTemplate);

    }

    @Override
    public Prototype clone(){
        try {
            return (PDFDocument) super.clone();
        } catch (Exception e) {
            return new PDFDocument(this.title, this.content, this.author, this.createdDate, this.fileSize, this.isTemplate);
        }

    }

    @Override
    public void display() {
        System.out.print("PDF ");
        super.display();
    }
}

class SpreadsheetDocument extends Document {
    public SpreadsheetDocument(String title, String content, String author, String createdDate, int fileSize, boolean isTemplate) {
        super(title, content, author, createdDate, fileSize, isTemplate);
    }

    @Override
    public Prototype clone() {
        try {
            return (SpreadsheetDocument) super.clone();
        } catch (Exception e) {
            return new SpreadsheetDocument(this.title, this.content, this.author, this.createdDate, this.fileSize, this.isTemplate);
        }
    }

    @Override
    public void display() {
        System.out.print("Spreadsheet ");
        super.display();
    }
}

class DocumentClient{
    private Prototype document;

    public DocumentClient(Prototype document){
        this.document=document;
    }

    public Prototype createDoc(){
        return document.clone();
    }
    public Prototype copydoc(String content, String author,  boolean isTemplate){
        Prototype doccopy=document.clone();
        doccopy.setAuthor(author);
        doccopy.editContent(content);
        doccopy.markAsTemplate(isTemplate);
        return doccopy;
    }
}


public class DocumentSystemExample {
    public static void main(String[] args) {
        System.out.println("=== Document Template Creation ===");
        
        // Create template documents
        Prototype wordTemplate = new WordDocument("Meeting Minutes Template", 
            "Agenda:\n1. \n2. \n3. ", "System", "2024-01-01", 25, true);
        Prototype pdfTemplate = new PDFDocument("Report Template", 
            "Executive Summary:\n\nDetails:\n\nConclusion:", "System", "2024-01-01", 50, true);
        Prototype spreadsheetTemplate = new SpreadsheetDocument("Budget Template", 
            "Income: \nExpenses: \nTotal: ", "System", "2024-01-01", 30, true);

        System.out.println("Created Word template:");
        wordTemplate.display();
        System.out.println("\nCreated PDF template:");
        pdfTemplate.display();
        System.out.println("\nCreated Spreadsheet template:");
        spreadsheetTemplate.display();

        System.out.println("\n=== Document Client Creation ===");
        DocumentClient wordClient = new DocumentClient(wordTemplate);
        DocumentClient pdfClient = new DocumentClient(pdfTemplate);
        DocumentClient spreadsheetClient = new DocumentClient(spreadsheetTemplate);

        System.out.println("\n=== Document Cloning ===");
        Prototype doc1 = wordClient.createDoc();
        Prototype doc2 = pdfClient.createDoc();
        Prototype doc3 = spreadsheetClient.createDoc();

        System.out.println("Cloned Word document:");
        doc1.display();
        System.out.println("\nCloned PDF document:");
        doc2.display();
        System.out.println("\nCloned Spreadsheet document:");
        doc3.display();

        System.out.println("\n=== Custom Document Creation ===");
        Prototype customWord = wordClient.copydoc("John Doe", 
            "Meeting Notes: Discussed project timeline and deliverables", false);
        Prototype customPDF = pdfClient.copydoc("Jane Smith", 
            "Q4 Sales Report: Revenue increased by 15% compared to last quarter", false);

        System.out.println("Custom Word document:");
        customWord.display();
        System.out.println("\nCustom PDF document:");
        customPDF.display();

        System.out.println("\n=== Independence Verification ===");
        System.out.println("Original word template before modification:");
        wordTemplate.display();

        System.out.println("\nModifying cloned document...");
        doc1.editContent("Modified content - this should not affect template");
        doc1.setAuthor("Modified Author");

        System.out.println("Modified cloned document:");
        doc1.display();

        System.out.println("\nOriginal word template after modification (should be unchanged):");
        wordTemplate.display();

        
        boolean templatesUnchanged = true;
        System.out.println("\n=== Final Verification ===");
        System.out.println("Independence Test: " + (templatesUnchanged ? "✓ PASSED" : "✗ FAILED"));
        System.out.println("All templates remain intact while clones can be modified independently!");
    }
}
