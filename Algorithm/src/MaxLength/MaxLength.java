
package MaxLength;

/**
 *
 * @author jieli
 * Description: Given a string, find the length of the longest substring without
 * repeating characters. For example, the longest substring without repeating letters
 * for "abcabcbb" is "abc", which the length is 3.
 * 
 */
public class MaxLength {
    /*
    @param s -- is a character String. Assume each character is between 'a' and 'z'
    */
    public int lengthOfLongestSubstring(String s) {
        //convert the current string into an array of characters
        char[] array = s.toCharArray();
        int[] letters = new int[26];
        
        int length;
        int max_length = 0;
        //initialize letters array
        for(int i = 0; i < letters.length; i++){
            letters[i] = 0;
        }
        
        //since each letter in array can be the start of the substring with the longest length.
        //go through each element of array. 
        for(int i = 0; i < array.length; i++){
            letters[array[i]- 'a'] = 1;
            length = 1;
            //read the letter coming after the array[i]
            for(int j = i+1; j < array.length; j++){
                if(letters[array[j]- 'a'] == 1){
                    
                    break;
                }else{
                    letters[array[j]- 'a'] = 1;
                    length++;
                }
            }
            //update max_length
            if(max_length < length){
                max_length = length;
            }
            //clean letters[]
            for(int k = 0; k < letters.length; k++){
                letters[k] = 0;
            }
        }//get max_length
        return max_length;  
    }
    public static void main(String[] args){
        char letter = 'b';
        int b = letter - 'a';
        System.out.println(b);
        MaxLength m = new MaxLength();
        int max_length = m.lengthOfLongestSubstring("abcabcccc");
        System.out.println("the maximum length: " + max_length);
    }
}
