package com.prep.cci.arrayandstrings;

public class StringReplace {

	public String replace(String str, char ch, String rplm) {
		assert (str == null) : "Input is null";
		assert (rplm == null) : "Input is null";
		char arr[] = null;
		int newlength = 0, tail =0, rlen = rplm.length();
		int occurance =0;
		for(int cnt=0;cnt<str.length(); cnt++) {
			if(str.charAt(cnt) == ch) {
				occurance++;
			}
		}
		newlength = str.length() + ((rlen-1)*occurance);
		arr = new char[newlength];
		for(char curch : str.toCharArray()) {
			if(curch == ch) {
				for(char rch: rplm.toCharArray()) {
					arr[tail++] = rch;
				}
			}
			else {
				arr[tail++] = curch;
			}
		}
		return new String(arr);
	}
	
	
	
}
