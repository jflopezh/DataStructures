package Strings;

import EstructurasLineales.List;
import java.io.*;

public class StringAsList {

    private List string = new List();

    public StringAsList() {
        string = new List();
    }

    public StringAsList(char[] string_) {
        string = new List();

        for (int i = 0; i < string_.length; i++) {
            string.insertAtEnd(new StringNode(string_[i]));
        }
    }

    public void concatenate(StringAsList newString) {
        string.insertAtEnd(newString.string.head);
    }

    public StringAsList[] split(StringAsList regex) {
        StringAsList[] response = null;
        return response;
    }
    
    public boolean contains(StringAsList regex) {
        return false;
    }

    public StringAsList substring(int beginIndex) {
        StringAsList subString = new StringAsList();
        subString.string = this.string.sublist(beginIndex);
        return subString;
    }

    public StringAsList substring(int beginIndex, int endIndex) {
        StringAsList subString = new StringAsList();
        subString.string = this.string.sublist(beginIndex, endIndex);
        return subString;
    }

    public int indexOf(StringAsList regex) {
        return 0;
    }

    public boolean equals(StringAsList string_) {
        return this.string.equals(string_.string);
    }

    public int length() {
        return this.string.length();
    }

    public StringAsList reverse() {
        StringAsList reverse = new StringAsList();
        reverse.string = this.string.cloneList();
        reverse.string.reverse();

        return reverse;
    }

    public boolean isPalindrome() {
        return false;
    }

    public boolean isAnagram(StringAsList anagramCandidate) {
        return false;
    }

    public void print() {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringNode temp = (StringNode) string.head;

        try {
            while (temp != null) {
                bw.write(temp.character);
                temp = (StringNode) temp.getNext();
            }
            bw.flush();
        } catch (IOException ex) {}
    }
}
