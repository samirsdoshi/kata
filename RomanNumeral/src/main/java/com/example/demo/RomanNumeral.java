package com.example.demo;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;


public class RomanNumeral {

	static HashMap<Integer,String> romans=new HashMap<Integer, String>();
	static {
		romans.put(0,"nulla");
		romans.put(1, "I");
		romans.put(5, "V");
		romans.put(10, "X");
		romans.put(50, "L");
		romans.put(100, "C");
		romans.put(500, "D");
		romans.put(1000, "M");
	}

	public String getRoman(int number){
		String roman = getRomanString(number);
		return normalize(roman);
	}

	public String getRomanString(int number){
		if (romans.get(number)!=null) return romans.get(number);
		Map.Entry<Integer,String> toDiv = findLowestRoman(number);
		String roman = toDiv.getValue();
		int rem = number-toDiv.getKey();
		if (rem >0){
			roman = roman + getRomanString(rem);
		}
		return roman;
	}


	public boolean doesRepeat4times(String str){
		return str.length() >= 4 && StringUtils.countOccurrencesOf(str.substring(0,4),str.substring(0,1)) == 4;
	}

	//keep track of highest number.
	//find sequence of chacracters repeating 4 times.
	//get the next highest roman of highest number.
	//replace the highest number + 4 characters with <char><next highest roman>
	//so LXXXX -> XC, IIII -> IV, LXXXVIIII -> LXXXIX
	public String normalize(String roman){
		int lastAnchorRoman=0;
		int lastAnchorRomanIndex=0;
		char lastChar=0;
		int i=0;
		for (i=0;i<roman.length();i++) {
			if (doesRepeat4times(roman.substring(i))) {
				lastChar = roman.charAt(i);
				lastAnchorRomanIndex = i == 0 ? i : i - 1;
				lastAnchorRoman = getKey(Character.toString(roman.charAt(lastAnchorRomanIndex)));
				Map.Entry<Integer, String> nextRomanNumber = findFirstHighestRoman(lastAnchorRoman + 1);
				String nextRoman = nextRomanNumber.getValue();
				String pre = (lastAnchorRomanIndex > 0 ? roman.substring(0, lastAnchorRomanIndex) : "");
				String post = roman.substring(i + 4);
				return (post.length() > 0 ? pre + lastChar + nextRoman + normalize(post) : pre + lastChar + nextRoman);
			}
		}
		return roman;
	}

//	public String normalize_old(String roman){
//		int lastAnchorRoman=0;
//		char lastChar=0;
//		int lastCharCount=0;
//		int i=0;
//		for (i=0;i<roman.length();i++) {
//			if (roman.charAt(i) == lastChar) lastCharCount++;
//			else {
//				lastChar = roman.charAt(i);
//				lastCharCount = 1;
//			}
//			if (lastCharCount > 3) {
//				break;
//			}
//		}
//		if (lastCharCount>3){
//			int lastAnchorRomanIndex =i-4<0?i-3:i-4;
//			lastAnchorRoman = getKey(Character.toString(roman.charAt(lastAnchorRomanIndex)));
//			Map.Entry<Integer,String> nextRomanNumber = findFirstHighestRoman(lastAnchorRoman+1);
//			String nextRoman = nextRomanNumber.getValue();
//			String pre = (lastAnchorRomanIndex > 0?roman.substring(0,lastAnchorRomanIndex):"");
//			String post = roman.substring(i+1);
//			return (post.length()>0?pre + lastChar + nextRoman +  normalize(post):pre + lastChar + nextRoman);
//		}else{
//			return roman;
//		}
//	}

	public int getKey(String roman){
		return romans.entrySet().stream().filter(e->e.getValue().equals(roman)).findFirst().get().getKey();
	}

	public Map.Entry<Integer, String> findLowestRoman(int number){
		return romans.entrySet().stream().sorted((o1, o2) -> (o1.getKey() > o2.getKey())?-1:1)
				.filter(i->i.getKey()<number).findFirst().get();
	}

	public Map.Entry<Integer, String> findFirstHighestRoman(int number){
		return romans.entrySet().stream().sorted((o1, o2) -> (o1.getKey() > o2.getKey())?1:-1)
				.filter(i->i.getKey()>number).findFirst().get();
	}

}
