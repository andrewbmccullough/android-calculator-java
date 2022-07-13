package com.example.android_calculator_java;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.udojava.evalex.Expression;
import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    TextView expressionTV;
    TextView resultTV;

    String expressionString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextViews();
    }

    private void initTextViews()
    {
        expressionTV = (TextView)findViewById(R.id.workingsTextView);
        resultTV = (TextView)findViewById(R.id.resultTextView);
    }

    private void appendExpression(String givenValue)
    {
        expressionString = expressionString + givenValue;
        expressionTV.setText(expressionString);
    }

    public void equalsOnClick(View view)
    {
        if(expressionString.length() > 0) {
            Expression expression = new Expression(expressionString);
            BigDecimal result = null;

            try {
                result = expression.eval();
            } catch (Expression.ExpressionException e) {
                Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
            }

            if (result != null) {
                resultTV.setText(String.valueOf(result.doubleValue()));
                expressionString = resultTV.getText().toString();
                expressionTV.setText(expressionString);
            }
        }
    }

    public void equalsCheck(View view)
    {
        if(expressionString.length() > 0) {
            Expression expression = new Expression(expressionString);
            BigDecimal result = null;

            try {
                result = expression.eval();
            } catch (Expression.ExpressionException e) {
                resultTV.setText("");
            }

            if (result != null) {
                resultTV.setText(String.valueOf(result.doubleValue()));
            }
        }
        else
        {
            resultTV.setText("");
        }
    }

    public void clearOnClick(View view)
    {
        expressionTV.setText("");
        expressionString = "";
        resultTV.setText("");
    }

    public void delOnClick(View view)
    {
        if(expressionString.length() > 0)
        {
            expressionString = expressionString.substring(0, expressionString.length() - 1);
            expressionTV.setText(String.valueOf(expressionString));
            resultTV.setText("");
        }
        equalsCheck(view);
    }

    public void leftBracketOnClick(View view)
    {
        appendExpression("(");
        equalsCheck(view);
    }

    public void rightBracketOnClick(View view)
    {
        appendExpression(")");
        equalsCheck(view);
    }

    public void powerOfOnClick(View view)
    {
        appendExpression("^");
        equalsCheck(view);
    }

    public void divisionOnClick(View view)
    {
        appendExpression("/");
        equalsCheck(view);
    }

    public void timesOnClick(View view)
    {
        appendExpression("*");
        equalsCheck(view);
    }

    public void minusOnClick(View view)
    {
        appendExpression("-");
        equalsCheck(view);
    }

    public void plusOnClick(View view)
    {
        appendExpression("+");
        equalsCheck(view);
    }

    public void decimalOnClick(View view)
    {
        appendExpression(".");
        equalsCheck(view);
    }

    public void zeroOnClick(View view)
    {
        appendExpression("0");
        equalsCheck(view);
    }

    public void oneOnClick(View view)
    {
        appendExpression("1");
        equalsCheck(view);
    }

    public void twoOnClick(View view)
    {
        appendExpression("2");
        equalsCheck(view);
    }

    public void threeOnClick(View view)
    {
        appendExpression("3");
        equalsCheck(view);
    }

    public void fourOnClick(View view)
    {
        appendExpression("4");
        equalsCheck(view);
    }

    public void fiveOnClick(View view)
    {
        appendExpression("5");
        equalsCheck(view);
    }

    public void sixOnClick(View view)
    {
        appendExpression("6");
        equalsCheck(view);
    }

    public void sevenOnClick(View view)
    {
        appendExpression("7");
        equalsCheck(view);
    }

    public void eightOnClick(View view)
    {
        appendExpression("8");
        equalsCheck(view);
    }

    public void nineOnClick(View view)
    {
        appendExpression("9");
        equalsCheck(view);
    }
}