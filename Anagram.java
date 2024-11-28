/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		//System.out.println(isAnagram("silent","listen"));  // true
		//System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		//System.out.println(isAnagram("Madam Curie","Radium came")); // true
		//System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(randomAnagram("kkkj jjk  kkjjj"));
		
		// Tests the randomAnagram function.
		//System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		//String str = "1234567";
		//Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		//for (int i = 0; i < 10; i++) {
			//String randomAnagram = randomAnagram(str);
		//	System.out.println(randomAnagram);
		//	pass = pass && isAnagram(str, randomAnagram);
		//	if (!pass) break;
		//}
		//System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		Boolean bool=false;
		String word1=preProcess(str1);//מילה ראשונה שנשלחת לפעולה שמחזירה מילה בלי תווים שהן לא אותיות או רווחים
		String word2=preProcess(str1);// מילה שנייה שנשלחה לפעולה שמחזירה מילה בלי תויים שהן לא אותיות או רווחים
		String newWord1=(" ");
		String newWord2=(" ");
		for(int i='a';i<='z';i++)
		{
			for(int j=0;j<word1.length();j++)
			{
				if(word1.charAt(j)==i)
					newWord1+=i;
			}
			for(int k=0;k<word2.length();k++)
			{
				if(word2.charAt(k)==i)
					newWord2+=i;
			}
		}
		if(newWord1.equals(newWord2))//משווה את שתי המילים החדשות שהתקבלו
			bool=true;
		return bool;
	}
	   
	public static String preProcess(String str) {
		str = str.toLowerCase(); //הסטרינג שנתון באותיות קטנות
		char [] strletter=new char[str.length()]; //מערך אותיות בלי שום דבר שהוא לא אות
		for(int i=0;i<str.length();i++)
		{
			if((str.charAt(i) >= 97 && str.charAt(i) <= 122) || str.charAt(i) == ' ')
			{
				strletter[i]=str.charAt(i);
			}
		}
		String newWord=(" ");
		for(int i=0;i<strletter.length;i++)
		{
			newWord+=strletter[i];
		}
		return newWord;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) 
	{
		Boolean bool=true;
		String word = preProcess(str);
		System.out.println(word);
		String randomWord=("");
		for(int i=word.length()-1 ;i>=0;i--)
		{
			randomWord+=word.charAt(i);
		}
		if(randomWord.equals(word))
		{
			for(int i=0;i<(randomWord.length())&&(bool==false);i++)
			{
				for(int k=i+1;k<randomWord.length();k++)
				{
					char ch=randomWord.charAt(i);
					char ch2=randomWord.charAt(k);
					randomWord=randomWord.replace(randomWord.charAt(i),randomWord.charAt(k));
					randomWord=randomWord.replace(ch2,ch);
					bool=true;
				}
			}
		}
		return randomWord;
	}
}
