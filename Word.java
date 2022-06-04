import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Word {
	private int wordCount = 0;
	private String wordValue;

	public Word() {

	}

	public Word(int value, String word) {
		this.wordValue = word;
		this.wordCount += value;
	}

	public int getWordCount() {
		return wordCount;
	}

	public String getWord() {
		return wordValue;
	}

	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}

	public void setWord(String word) {
		this.wordValue = word;
	}

	public static Comparator<Word> wordValueComparator = new Comparator<Word>() {
		public int compare(Word s1, Word s2) {

			String word1 = s1.getWord().toUpperCase();
			String word2 = s2.getWord().toUpperCase();
			return word1.compareTo(word2);
		}
	};

	public static Comparator<Word> wordCountComparator = new Comparator<Word>() {
		public int compare(Word s1, Word s2) {

			int no1 = s1.getWordCount();
			int no2 = s2.getWordCount();
			return no2 - no1;
		}
	};

	@Override
	public String toString() {
		return this.wordValue + ":" + this.wordCount;
	}

}