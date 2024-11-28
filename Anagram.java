/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		//System.out.println(isAnagram("silent","listen"));  // true
		//System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		//System.out.println(isAnagram("Madam Curie","Radium came")); // true
		//System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println("l");
		for(int i =0;i<10;i++){
			System.out.println(randomAnagram("hello") + randomAnagram("hello").length());
		}
		//System.out.println(randomAnagram("AB35 B"));
		
		
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
		String word2=preProcess(str2);// מילה שנייה שנשלחה לפעולה שמחזירה מילה בלי תויים שהן לא אותיות או רווחים
		String newWord1=("");
		String newWord2=("");
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
		int j=0;
		for(int i=0;i<str.length();i++)
		{
			if(((str.charAt(i) >= 'a' && str.charAt(i) <= 'z')) || str.charAt(i) == ' ')
			{
				strletter[j]=str.charAt(i);
				j++;
			}
		}
		String newWord="";
		for(int i=0;i<j;i++)
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
		String randomWord="";
		int random=0;
		for(int i='a';i<='z';i++)
		{
			for(int j=0;j<word.length();j++)
			{
				if(word.charAt(j)==i)
					randomWord+=word.charAt(j);
			}
		}
		char [] strletter=new char[randomWord.length()];
		for(int i=0;i<randomWord.length();i++)
		{
			strletter[i]=randomWord.charAt(i);
		}
		int length=randomWord.length();
		randomWord=(" ");
		for(int i=0;i<length;i++)
		{
			while(bool==true)
			{
				random=(int)(Math.random()*length);
				if(strletter[random]!='\0')
				{
					randomWord+=strletter[random];
					strletter[random]=('\0');
					bool=false;
				}
			}
			bool=true;
		}
		
		// שמתי לב שכאשר אני מחזירה את המילה הרנדנומלית החדשה אני מקבלת מילה עם רווח לפניה
		// הפיתרון שלי היה פשוט ליצור סטרינג חדש החל מהתו השני 
		String x="";
		for(int i=1; i<randomWord.length(); i++)
		{
			x+=randomWord.charAt(i);
		}
		return x;
	}
}
