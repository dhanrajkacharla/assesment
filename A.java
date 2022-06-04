import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A {

	public static String readFile(String fileName) {
		String data = "";
		try {
			data = new String(Files.readAllBytes(Paths.get(fileName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	public static void showWordList(List<Word> words) {
		System.out.println("List of Word (Ascending)");
		Collections.sort(words, Word.wordValueComparator);
		for (Word word : words) {
			System.out.println(word.toString());
		}

		System.out.println("List of Word (Descending)");
		for (int i = words.size(); i >= 0; i--) {
			System.out.println(words.get(i).toString());
		}
	}

	public static void showFrequentWords(List<Word> words) {
		System.out.println("Words in Descending order of Frequency");
		Collections.sort(words, Word.wordCountComparator);
		for (Word word : words) {
			System.out.println(word.toString());
		}
	}

	public static void main(String[] args) {
		String data = readFile("**/data/daffodils.txt");
		String[] words = data.split(" ");
		List<Word> wordObjects = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			int flag = 0;
			Word word = null;
			for (int j = 0; j < wordObjects.size(); j++) {
				String x = wordObjects.get(j).getWord();
				if (x.equals(words[i])) {
					flag = 1;
					word = wordObjects.get(j);
				}
			}
			if (flag == 0) {
				word = new Word(1, words[i]);
				wordObjects.add(word);
			} else {
				int k = word.getWordCount();
				word.setWordCount(k++);
			}
		}
		showWordList(wordObjects);
		showFrequentWords(wordObjects);
	}
}