package Behavioral.Iterator;
import java.util.ArrayList;
import java.util.List;

interface Iterator{
    boolean hasNext();
    Object next();
}

interface Container{
    Iterator getIterator();
}

class Book{
  private String book;
  public Book( String book){
    this.book=book;
  }
  public String getbooktitle(){
    return this.book;
  }
}

class Library implements Container {
  private List<Book> books;

  public Library(){
    books = new ArrayList<>();
  }
  public void addbook(Book book){
    books.add(book);
  }

  @Override
  public Iterator getIterator() {
    // TODO Auto-generated method stub
    return new BookIterator();
  }

  class BookIterator implements Iterator{
  int index=0;

  @Override
  public boolean hasNext() {
    return index<books.size();

  }

  @Override
  public Object next() {
    if(this.hasNext()){
      return books.get(index++);
    }
    return null;
  }
  
}
  
}


class BookLibrary {

    public static void main(String[] args) {
      Library library = new Library();
      library.addbook(new Book("book1"));
      library.addbook(new Book("book2"));
      library.addbook(new Book("book3"));

      Iterator bookIterator=library.getIterator();
      while (bookIterator.hasNext()) {
        Book book= (Book) bookIterator.next();
        System.out.println(book.getbooktitle());
        
      }

    }
}