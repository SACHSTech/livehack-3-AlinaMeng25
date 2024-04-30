class Problem1 extends ConsoleProgram {

  /**
  * Make methods for a student account registration
  * @author: Alina Meng
  */
  
  public void run() {
    System.out.println("***** Student Account Registration *****");

    String strFirstName = readLine("Enter your first name: ");
    String strLastName = readLine("Enter your last name: ");
    String strStuNum = readLine("Enter your student number: ");
    String strNewUser = readLine("Enter a new username: ");

    System.out.println("Valid username: " + validateUsername(strNewUser));
    System.out.println("Your password is: " + creatPassword(strFirstName, strLastName, strStuNum));
    
  }

  /**
   * Checks for the validation of the user's username
   * @author Alina Meng
   * @param strusername the user input for the username
   * @return if the username checks the requirements
   */

  private boolean validateUsername(String strusername){
    
    Boolean blnValid;
    
    Boolean blnLength;
    Boolean blnHasNum = false;
    Boolean blnInvalidChar = false;

    if (strusername.length() < 7){
      blnLength = false;
    }
    else{
      blnLength = true;
    }
    
    for (int i = 0; i < strusername.length(); i++){
      char chrCheck = strusername.charAt(i);
      
      // Check if string has a number
      for (int j = 48; j <= 57; j++){
        if (chrCheck == j){
          blnHasNum = true;
        }
      }
      
      // Check is string has characters other than numbers and letters
      for (int j = 0; j <= 127; j++){
        if (j == 48){
          j = 58;
        }
        else if (j == 65){
          j = 91;
        }
        else if (j == 97){
          j = 123;
        }

        if (chrCheck == j){
          blnInvalidChar = true;
        }
      }
    }

    if (blnLength == true && blnHasNum == true && blnInvalidChar == false) {
      blnValid = true;
    }
    else{
      blnValid = false;
    }

    return blnValid;
  }

  /**
   * @author ALina Meng
   * @param strFirstName the first name
   * @param strLastName the last name
   * @param strStudentNum the student number
   * @return the password
   */
  private String creatPassword(String strFirstName, String strLastName, String strStudentNum){
    String strPassword = "";
    int intPassLength;

    if (strLastName.length() < 4){
      intPassLength = strLastName.length() + 4;
    }
    else{
      intPassLength = 8;
    }

    for(int i = 0; i <= intPassLength; i++){
      if (i <= intPassLength - 4){
        strPassword = strPassword + Character.toLowerCase(strLastName.charAt(i));
      }
      else if (i <= intPassLength - 3){
        strPassword = strPassword + Character.toUpperCase(strLastName.charAt(i));
      }
      else if (i <= intPassLength - 2){
        strPassword = strPassword + strStudentNum.charAt(3);
      }
      else if (i <= intPassLength - 1){
        strPassword = strPassword + strStudentNum.charAt(4);
      }
      else{
        strPassword = strPassword + strStudentNum.charAt(5);
      }
    }

    return strPassword;
  }
}