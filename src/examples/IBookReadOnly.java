package examples;

public interface IBookReadOnly {
    int getId();

    String getTitle();

    String getAuthor();

    String toString();

    Price getPrice();
}
