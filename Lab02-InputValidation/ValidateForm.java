import java.util.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

public class ValidateForm
{
    public ValidateForm() {
        //no variables to initialize
    }

    public boolean isAllAlpha(String str)
    {
        for(int index = 0; index < str.length(); index++)
        {
            if(Character.isLetter(str.charAt(index)) == false) 
            {
                return false;
            }
        }
        return true;
    }

    public boolean isNumeric(String str)
    {
        int periodCount = 0;
        for(int index = 0; index < str.length(); index++)
        {
            if(str.charAt(index) == '.')
            {
                periodCount++;
            }
            if(Character.isDigit(str.charAt(index)) == false && (periodCount != 0 && periodCount != 1)) 
            {
                return false;
            }
        }
        return true;
    }

    public String checkName(String name) {
        if(isAllAlpha(name))
        {
            if(name.length() >= 2)
            {
                return "";
            }
        }
        return "Invalid name!\n";
    }

    public String checkEmail(String email) {
        boolean hasAt = false;
        boolean period = false;
        for(int index = 0; index < email.length(); index++)
        {
            if(email.charAt(index) == '@')
            {
                hasAt = true;
            }
            if(email.charAt(index) == '.')
            {
                period = true;
            }
        }
        if(hasAt && period)
        {
            int periodIndex = 0;
            int atIndex = 0;
            atIndex = email.indexOf('@');
            periodIndex = email.indexOf('.');
            if(periodIndex > atIndex)
            {
                if(atIndex >= 1)
                {
                    if(periodIndex < email.length() - 2)
                    {
                        return "";
                    }
                }
            }
        }
        return "Invalid email!\n";
    }

    public String checkPW(String pw) {
        if(pw.length() >= 4)
        {
            boolean hasNum = false;
            boolean numSat = false;
            boolean hasLower = false;
            boolean lowerSat = false;
            boolean hasUpper = false;
            boolean upperSat = false;
            for(int index = 0; index < pw.length(); index++)
            {
                if(Character.isUpperCase(pw.charAt(index)) && upperSat == false)
                {
                    hasUpper = true;
                    upperSat = true;
                }
                if(Character.isLowerCase(pw.charAt(index)) && lowerSat == false)
                {
                    hasLower = true;
                    lowerSat = true;
                }
                if(Character.isDigit(pw.charAt(index)) && numSat == false)
                {
                    hasNum = true;
                    numSat = true;
                }
            }
            if(hasUpper && hasLower && hasNum)
            {
                return "";
            }
        }
        return "Invalid password!\n";
    }

    public String checkZip(String zip) {
        if(zip.length() >= 3 && zip.length() <= 5)
        {
            for(int index = 0; index < zip.length(); index++)
            {
                if(Character.isDigit(zip.charAt(index)))
                {
                    return "";
                }
            }
        }
        return "Invalid zip code!\n";
    }

    public String checkBirth(String date) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int maxYear = currentYear - 100;
        int userYear = 0;
        try {
            userYear = Integer.parseInt(date);
        }
        catch (NumberFormatException ex) {
            userYear = 0;
        }

        //will not run until you are within 100 years old
        //only ppl who are between 5 - 95 years will be able to enter
        if(userYear >= maxYear + 5 && userYear <= currentYear - 5)
        {
            return "";
        }
        return "Invalid birth year!\n";
    }

    public String checkPhone(String phone) {
        String[] check = phone.split("-");
        String mainStr = "";
        for(int index = 0; index < check.length; index++)
        {
            mainStr += check[index];
        }
        if(mainStr.length() == 10)
        {
            for(int index = 0; index < mainStr.length(); index++)
            {
                if(Character.isDigit(mainStr.charAt(index)))
                {
                    return "";
                }
            }
        }
        return "Invalid phone number!\n";
    }

    public static void main(String[] args)
    {
        ValidateForm newForm = new ValidateForm();
        System.out.println(newForm.isAllAlpha("SiNgArAJu"));
        System.out.println(newForm.isAllAlpha("Th1s 4 1s n0t !alph@..."));

        System.out.println(newForm.isNumeric("pRaNaV"));
        System.out.println(newForm.isNumeric("Th1s 4 1s n0t nVm3r1C..."));
        System.out.println(newForm.isNumeric("123456"));
        System.out.println(newForm.isNumeric("23.345"));
        System.out.println(newForm.isNumeric("23.345.6"));

        EventQueue.invokeLater(new Runnable() 
            {
                public void run() {
                    TextComponentFrame frame = new TextComponentFrame(new ValidateForm());
                    frame.setVisible(true);
                }
            });
    }
}

class TextComponentFrame extends JFrame 
{
    static final int DEFAULT_WIDTH  = 300;
    static final int DEFAULT_HEIGHT = 400;

    ValidateForm validater;

    public TextComponentFrame(ValidateForm v)
    {
        validater = v;

        initGUI();

        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null); //center on screen
    }

    private void initGUI()
    {
        setTitle("Subscription Form");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        final JTextField personName = new JTextField();
        final JTextField emailField = new JTextField();
        final JTextField zipCode    = new JTextField();
        final JTextField birthDate  = new JTextField();

        MaskFormatter mfor = null;
        try {
            mfor = new MaskFormatter("###-###-####");
        }
        catch (ParseException e) {}

        final JFormattedTextField phoneNumber   = new JFormattedTextField(mfor);
        final JPasswordField      passwordField = new JPasswordField();

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(6, 6)); //dimensions of layout
        northPanel.add(new JLabel("Name :  ", SwingConstants.RIGHT));
        northPanel.add(personName);
        northPanel.add(new JLabel("Password :  ", SwingConstants.RIGHT));
        northPanel.add(passwordField);
        northPanel.add(new JLabel("Email : ", SwingConstants.RIGHT));
        northPanel.add(emailField);
        northPanel.add(new JLabel("Zip Code (US) : ", SwingConstants.RIGHT));
        northPanel.add(zipCode);
        northPanel.add(new JLabel("Year of Birth: ", SwingConstants.RIGHT));
        northPanel.add(birthDate);
        northPanel.add(new JLabel("Phone Number: ", SwingConstants.RIGHT));
        northPanel.add(phoneNumber);

        add(northPanel, BorderLayout.NORTH);

        final JTextArea textArea = new JTextArea(8, 40);
        JScrollPane scrollPane   = new JScrollPane(textArea);

        add(scrollPane, BorderLayout.CENTER);

        JPanel  southPanel   = new JPanel();
        JButton submitButton = new JButton("Submit");
        southPanel.add(submitButton);
        submitButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    String name     = personName.getText() ;
                    String email    = emailField.getText();
                    String zip      = zipCode.getText();
                    String birth    = birthDate.getText();
                    String phone    = phoneNumber.getText(); 
                    String password = new String(passwordField.getPassword());

                    String result = ""; 

                    result += validater.checkName(name);
                    result += validater.checkPW(password);
                    result += validater.checkEmail(email);
                    result += validater.checkZip(zip);
                    result += validater.checkBirth(birth);
                    result += validater.checkPhone(phone);

                    if (result.length() == 0)
                        result = "Input accepted!";

                    textArea.setText(result);
                }
            });

        add(southPanel, BorderLayout.SOUTH);
    }
}