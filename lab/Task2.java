public class Task2
{
    public static void main (String[] args)
    {
       //A system stores a customer's first and last name separately. Combine them into a single formatted full name.
        String str1 = "Atkia";
        String str2 = "Nowshin";

        String result = str1 + " " + str2;

        System.out.println ("Full Name : " + result);

        //Generate a product code by joining the product name and ID.
        String productName = "Cocacola";
        String productID = "54367";

       String concatenated = productName + " " + productID;
       System.out.println ("Product code : " + concatenated);

       //Extract the username (before@) from an email address.
       String email = "studentofaiub@gmail.com";
       int index = email.indexOf("@");
       String userName = email.substring(0,index);
       System.out.println ("Username : " + userName);
       
       //A chat app must show the total number of characters in a user's message.
       String message = "Hello, how are you?";
       int totalCharacters = message.length();

       System.out.println ("Total number of characters in user's message : " + totalCharacters);

       //Convert a user-entered sentence to both uppercase and lowercase.
       String sentence = "I am a Student of AIUB";
       String upperCaseString = sentence.toUpperCase();
       String lowerCaseString = sentence.toLowerCase();
       
       System.out.println ("UpperCase sentence : " + upperCaseString);
       System.out.println ("LowerCase sentence : " + lowerCaseString);

       //Replace a specific word in a sentence.
       String str4 = "VS Code";
       String replaceString = str4.replace("Code", "Code");
       
       System.out.println ("Replaced String : " + replaceString);
    }
}
