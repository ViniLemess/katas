Outside-In TDD with Acceptance Tests
====================================

### Objective

Learn and practice the double loop of TDD
Test application from outside, identifying side effects

### Problem description - Bank kata

Create a simple bank application with the following features:

     - Deposit into Account
     - Withdraw from an Account
     - Print a bank statement to the console

## Desired Behaviour

Here's the specification for an acceptance test that expresses the desired
behaviour for this

Given a client makes a deposit of 1000 on 10-01-2012 <br>
And a deposit of 2000 on 13-01-2012 <br>
And a withdrawal of 500 on 14-01-2012 <br>
When they print their bank statement <br>
Then they would see:

```
Date       | Amount | Balance
14/01/2012 | -500   | 2500
13/01/2012 | 2000   | 3000
10/01/2012 | 1000   | 1000
```

## Starting point and constraints

Start with a class the following structure:

    public class Account {

        public void deposit(int amount);

        public void withdrawal(int amount);

        public void printStatement();

    }

You are not allowed to add any other public method to this class.



## Notes

- We're using ints for the money amounts to keep the auxiliaries as simple
  as possible. In a real system, we would always use a datatype with guaranteed
  arbitrary precision, but doing so here would distract from the main purpose
  of the exercise.
- Don't worry about spacing and indentation in the statement output. (You could 
instruct your acceptance test to ignore whitespace if you wanted to.)
- Use the acceptance test to guide your progress towards the solution.
Sandro does this by making all unimplemented methods throw an exception, so that he 
can immediately see what remains to be implemented when he runs the acceptance test.