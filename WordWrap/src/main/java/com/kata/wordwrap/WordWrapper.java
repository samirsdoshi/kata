package com.kata.wordwrap;

/*
  Problem statement: Take a one line string and a maximum line length integer as inputs
  and replace spaces with newlines if the word after a space would exceed the line limit.
  Only replace spaces with a newline.  Do not insert newlines in the middle of a word.
  All non-space characters can be regarded as word characters.
*/
public class WordWrapper {
    public static void main(String[] args) {
        String inputText = "Here is a sentence that is so very long that it needs to be wrapped.";
        int maximumLineLength = 42;
        // note that the 'h' in the second instance of 'that' is the 42nd character,
        // so the entire second instance of 'that' was moved to the next line
        String expectedOutputText = "Here is a sentence that is so very long\n" +
                "that it needs to be wrapped.";
        String actualOutputText = wordWrap(inputText, maximumLineLength);
        System.out.println(expectedOutputText.equals(actualOutputText));
        System.out.println(actualOutputText);
    }
        public static String wordWrap(String in, int lim) {
            // your code here
            if (in.length()<=lim) return in;
            int index = in.substring(0,lim).lastIndexOf(' ');
            return (index==-1?in.substring(0,lim) + "\n" + wordWrap(in.substring(lim+1),lim)
                    :in.substring(0,index) + "\n" + wordWrap(in.substring(index+1), lim));

        }
}

