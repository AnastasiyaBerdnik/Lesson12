package anastasiya.lesson12.home.task;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import anastasiya.lesson10.home.task.Book;


public class ReadBooksFile {
	
	public static final String fileName = "d:\\Books.txt";
	public static final String delimeter = ";";

	public static void main(String[] args) {

		Set<Book> booksFromFile = new HashSet<Book>();

		try {
			FileReader fileReader = new FileReader(fileName);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line;
			while (((line = bufferedReader.readLine()) != null)) {
				// System.out.println(line);
				String[] mas = line.split(delimeter);

				Book book = new Book(mas[0], mas[1], Integer.parseInt(mas[2]),Integer.parseInt(mas[3]),mas[4],
						Double.parseDouble(mas[5]));
				booksFromFile.add(book);
			}

		} catch (FileNotFoundException e) {

			System.out.println("File not found.");
		} catch (IOException e) {
			System.out.println("Error reading file");
		}

		for (Book book : booksFromFile) {
			System.out.println(book.getAuthor() + "-" + book.getTitle());
		}
	}


}
