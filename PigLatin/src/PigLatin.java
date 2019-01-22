import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class PigLatin {	
	public static void main(String[] args)
	{
		List<String> Vowels = Arrays.asList("A","E","I","O","U");
		String englishWord;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an English Word");
		englishWord = sc.nextLine();
		System.out.println("Translated Word:" + Translate(englishWord,Vowels));		
		sc.close();
	}
	
	public static boolean IsWordStartsWithVowel(String word,List<String> vowels)
	{
	  if(vowels.isEmpty()) return false;
	  String firstCharacter = word.substring(0,1).toUpperCase();
	  if(vowels.contains(firstCharacter)) return true;
	  return false;	
	}
	
	public static int IsWordContainVowel(char[] words,List<String> vowels)
	{
		for(int i = 0; i < words.length; i++)
		{			
			if(vowels.contains(Character.toString(words[i])))return i;
		}
		return -1;
	}
	
	public static int IsWordHasVowels(String word,List<String> vowels)
	{		 
		if(vowels.isEmpty()) return -1;
		char[] words = word.toUpperCase().toCharArray();		
		return IsWordContainVowel(words,vowels);
	}
	
	public static String Translate(String word,List<String> vowels)
	{
		if(IsWordStartsWithVowel(word,vowels)) {
		return word.concat("yay");
		}
		int vowelIndex = IsWordHasVowels(word,vowels);
		if(vowelIndex > 0) {
			String part = word.substring(0,vowelIndex);
			return word.replaceFirst(part, "").concat(part).concat("ay");
		}
		if(vowelIndex < 0) {
			return word.concat("ay");
		}
		
		return word;
	}

}
