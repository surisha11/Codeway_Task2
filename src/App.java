import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class App extends JFrame implements ActionListener {

    JPanel mainPanel, topPanel, gradePanel, resultPanel;
    JLabel topHeadingLabel, gradeTopLabel, markLabel, totalMarkHeadingLabel, totalMarkLabel, averagePercentageHeadingLabel, averagePercentageLabel, gradeHeadingLabel, gradeLabel;
    JTextField numberOfSubject, markInput;
    JButton submit;
    Component invisibleComponent1, invisibleComponent2, invisibleComponent3, invisibleComponent4, invisibleComponent5;
    int width, subjectNumber, index = 0, markArray[], totalMark = 0;
    double averagePercentage;
    String numberOfSubjectText = " ", markInputText, grade, average;
    Dimension dimensionOfInvisibleComponent;
    Font bodyFont, headingFont;
    DecimalFormat averagePercentageFormat;

    public App(){
        super();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        averagePercentageFormat = new DecimalFormat("#.##");

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.WHITE);
        topHeadingLabel = new JLabel("Grade Calculator");
        topHeadingLabel.setFont(new Font(Font.SERIF, Font.BOLD, 60));
        topPanel.add(topHeadingLabel, BorderLayout.WEST);

        gradePanel = new JPanel();
        gradePanel.setBackground(Color.WHITE);
        dimensionOfInvisibleComponent = new Dimension(width, 40);
        invisibleComponent1 = Box.createRigidArea(dimensionOfInvisibleComponent);
        gradeTopLabel = new JLabel("<HTML><p><font size = 7>To calculate your grade:</font></p><br><p><font size = 6>&emsp;&emsp;1. Enter the total number of subject you wants to calculate grade for and click submit.</font></p><p><font size = 6>&emsp;&emsp;2. Enter mark of each subject and click save to save your marks for further calculations.</font></p><p><font size = 6>&emsp;&emsp;3. After entering all marks a <b>\"Show\"</b> button will appear click on Show to see your grade.</font></p><font size = 6>&emsp;&emsp;4. Once you have noted your <b>Total mark</b>, <b>Average Percentage</b>, <b>Grade</b> click back to calculate again.</font></p></HTML>");
        bodyFont = new Font(Font.SERIF, Font.PLAIN, 25);
        gradeTopLabel.setFont(bodyFont);
        invisibleComponent2 = Box.createRigidArea(dimensionOfInvisibleComponent);
        markLabel = new JLabel("Enter the number of subject :   ");
        markLabel.setFont(bodyFont);
        numberOfSubject = new JTextField(2);
        numberOfSubject.setFont(bodyFont);
        markInput = new JTextField(4);
        markInput.setFont(bodyFont);
        markInput.setVisible(false);
        submit = new JButton("Submit");
        submit.setFont(new Font(Font.SERIF, Font.BOLD, 15));
        submit.addActionListener(this);
        invisibleComponent3 = Box.createRigidArea(dimensionOfInvisibleComponent);

        resultPanel = new JPanel(new GridLayout(2, 4));
        resultPanel.setBackground(Color.WHITE);
        invisibleComponent4 = Box.createVerticalStrut(70);
        totalMarkHeadingLabel = new JLabel("Total Mark");
        headingFont = new Font(Font.SERIF, Font.BOLD, 30);
        totalMarkHeadingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        totalMarkHeadingLabel.setFont(headingFont);
        totalMarkHeadingLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        averagePercentageHeadingLabel = new JLabel("   Average Percentage   ");
        averagePercentageHeadingLabel.setFont(headingFont);
        averagePercentageHeadingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        averagePercentageHeadingLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        gradeHeadingLabel = new JLabel("Grade");
        gradeHeadingLabel.setFont(headingFont);
        gradeHeadingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gradeHeadingLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        resultPanel.add(invisibleComponent4);
        resultPanel.add(totalMarkHeadingLabel);
        resultPanel.add(averagePercentageHeadingLabel);
        resultPanel.add(gradeHeadingLabel);
        invisibleComponent5 = Box.createVerticalStrut(30);
        totalMarkLabel = new JLabel(" ");
        totalMarkLabel.setFont(bodyFont);
        totalMarkLabel.setHorizontalAlignment(SwingConstants.CENTER);
        totalMarkLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        averagePercentageLabel = new JLabel(" ");
        averagePercentageLabel.setFont(bodyFont);
        averagePercentageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        averagePercentageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        gradeLabel = new JLabel(" ");
        gradeLabel.setFont(bodyFont);
        gradeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gradeLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        resultPanel.add(invisibleComponent5);
        resultPanel.add(totalMarkLabel);
        resultPanel.add(averagePercentageLabel);
        resultPanel.add(gradeLabel);
        resultPanel.setVisible(false);

        gradePanel.add(invisibleComponent1);
        gradePanel.add(gradeTopLabel);
        gradePanel.add(invisibleComponent2);
        gradePanel.add(markLabel);
        gradePanel.add(numberOfSubject);        
        gradePanel.add(markInput);
        gradePanel.add(submit);
        gradePanel.add(invisibleComponent3);
        gradePanel.add(resultPanel);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(gradePanel);

        add(mainPanel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand() == "Submit"){
            numberOfSubjectText = numberOfSubject.getText();
            if(numberOfSubjectText.matches("[0-9]+")){
                numberOfSubject.setVisible(false);
                markInput.setVisible(true);
                subjectNumber = Integer.valueOf(numberOfSubjectText);
                markArray = new int[subjectNumber];
                // numberOfSubjectText = " ";
                markLabel.setText("Enter the marks of each subject :   ");
                submit.setText("Save");
                markInput.requestFocus(true);
            }
            else{
                JOptionPane.showMessageDialog(mainPanel, "<HTML><p><font size = 5>Your input : " + numberOfSubjectText +"</font></p><p><font size = 5>Is not a valid input enter valid input</font></p><p><font size = 5>Number is the only valid input.</font></p></HTML>", "Error : Enter valid input", JOptionPane.ERROR_MESSAGE, null);
            }
        }
        
        if(ae.getActionCommand() == "Save"){
            markInputText = markInput.getText();
            if(markInput.getText().matches("[0-9]+")){
                markArray[index] = Integer.valueOf(markInputText);
                index++;
                markInput.setText("");
                markInput.requestFocus(true);
                if(index == subjectNumber){
                    markInput.setVisible(false);
                    markLabel.setVisible(false);
                    submit.setText("Show");
                }
            }
            else{
                JOptionPane.showMessageDialog(mainPanel, "<HTML><p><font size = 5>Your input : " + markInputText +"</font></p><p><font size = 5>Is not a valid input enter valid input</font></p><p><font size = 5>Number is the only valid input.</font></p></HTML>", "Error : Enter valid input", JOptionPane.ERROR_MESSAGE, null);
            }
        }
        if(ae.getActionCommand() == "Show"){
            calculation();
            average = averagePercentageFormat.format(averagePercentage);
            totalMarkLabel.setText(" " + totalMark + " ");
            averagePercentageLabel.setText(" " + average + "%");
            gradeLabel.setText(" " + grade + " ");
            resultPanel.setVisible(true);
            submit.setText("Back");
        }
        if(ae.getActionCommand() == "Back"){
            resultPanel.setVisible(false);
            numberOfSubject.setVisible(true);
            submit.setText("Submit");
            markLabel.setText("Enter the number of subject :   ");
            markLabel.setVisible(true);
            numberOfSubject.setText("");
            numberOfSubject.requestFocus(true);
            index = 0;
            totalMark = 0;
        }
    }

    public void calculation(){
        for(int i = 0; i < subjectNumber; i++){
            totalMark += markArray[i];
        }
        averagePercentage = (double)(totalMark / subjectNumber);
        if(averagePercentage > 90){
            grade = "A+";
        }
        else if(averagePercentage > 80 && averagePercentage < 90){
            grade = "A";
        }
        else if(averagePercentage > 70 && averagePercentage < 80){
            grade = "B+";
        }
        else if(averagePercentage > 60 && averagePercentage < 70){
            grade = "B";
        }
        else if(averagePercentage > 50 && averagePercentage < 60){
            grade = "C";
        }
        else {
            grade = "D";
        }
    }

    public static void main(String[] args){
        App studentGradeCalculator = new App();
    }
}
