public class Sentence_Formatter {
public static void main(String[] args) {
String paragraph = "hello!this is a test. how are you?i hope you're doing well. ";
String correctedParagraph = correctParagraph(paragraph);
System.out.println(correctedParagraph);
}
public static String correctParagraph(String paragraph) {

paragraph = paragraph.trim();

StringBuilder corrected = new StringBuilder();
boolean capitalizeNext = true;

for (int i = 0; i < paragraph.length(); i++) {
char currentChar = paragraph.charAt(i);

if (currentChar == '.' || currentChar == '!' || currentChar == '?') {
corrected.append(currentChar);
capitalizeNext = true;
} else if (Character.isWhitespace(currentChar)) {

if (corrected.length() > 0 && corrected.charAt(corrected.length() - 1) != ' ') {
corrected.append(' ');
}
} else {
if (capitalizeNext && Character.isLetter(currentChar)) {
corrected.append(Character.toUpperCase(currentChar));
capitalizeNext = false;
} else {
corrected.append(currentChar);
}
}
}

return corrected.toString().trim();
}

}