package Day8;

public class BranchingStatement {
    public static void main(String[] args) {
        System.out.println(monthlySalary(25000));
    }

    public static String monthlySalary(int Salary){
        double annualSalary,tax,net;
        annualSalary = Salary * 12;
        tax = 0.0;
        //Example of Ladderize if-else statement
        if(annualSalary>0 && annualSalary<=250000.00){
            tax = 0;
        }
        else if(annualSalary>250000 && annualSalary<=400000){
            tax = (annualSalary - 250000) * .15;
        }
        else if(annualSalary>400000 && annualSalary<=800000){
            tax = 22500 + (annualSalary - 400000) * .20;
        }
        else if(annualSalary>800000 && annualSalary<=2000000){
            tax = 102500 + (annualSalary - 800000) * .25;
        }
        else if(annualSalary>2000000 && annualSalary<=8000000){
            tax = 402500 + (annualSalary - 2000000) * .30;
        }
        else if(annualSalary>8000000){
            tax = 2202500 + (annualSalary - 8000000) * .35;
        }

        net = annualSalary - tax;

        return "Monthly Salary: " + Salary + "\nAnnual Salary: " + annualSalary +
                "\nTax: " + tax + "\nNet: " + net;
    }
}
/*
Control Flow Branching Statements
 - statements that we can use to control/manipulate the flow of our program

        3 ways of control flow
          * Decision-Making
              * if statements
                  ~ simple if - one condition, one code block
                  ~ if else - one condition, two code block
                  ~ if else if/ladderize if - multiple conditions, each conditions has its own code block
                  ~ nested if - if block inside an if block
              * switch statements - like ladderize if else, but have specific scope, could be nested as well
*/