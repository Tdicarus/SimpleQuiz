package ngothuctridat.sv61133478.simplequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView questionTextView;
    private Button trueButton;
    private Button falseButton;
    private ImageButton forwardButton;
    private ImageButton backwardButton;
    private int currentQuestionIndex = 0;


    private Question[] questionBank = new Question[]
            {
                    new Question(R.string.question_1, false),
                    new Question(R.string.question_2, false),
                    new Question(R.string.question_3, false),
                    new Question(R.string.question_4, true),
                    new Question(R.string.question_5, true),
                    new Question(R.string.question_6, true),
                    new Question(R.string.question_7, true),
                    new Question(R.string.question_8, true),
                    new Question(R.string.question_9, true),
                    new Question(R.string.question_10, false)
            };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView =(TextView) findViewById(R.id.quest);
        trueButton = (Button) findViewById(R.id.yes);
        falseButton = (Button) findViewById(R.id.no);
        forwardButton = (ImageButton) findViewById(R.id.forward);
        backwardButton = (ImageButton) findViewById(R.id.backward);

        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        forwardButton.setOnClickListener(this);
        backwardButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.yes:
                Toast.makeText(MainActivity.this,"True",Toast.LENGTH_SHORT).show();
                break;

            case R.id.no:
                Toast.makeText(MainActivity.this,"False",Toast.LENGTH_SHORT).show();
                break;

            case R.id.forward:
                currentQuestionIndex = (currentQuestionIndex + 1 ) % questionBank.length;
                updateQuestion();
                break;

            case R.id.backward:
                if (currentQuestionIndex >0 )
                {
                    currentQuestionIndex = (currentQuestionIndex - 1) % questionBank.length;
                    updateQuestion();
                    break;
                }
        }

    }

    private void updateQuestion()
    {
        Log.d("current","onclick" + currentQuestionIndex);
        questionTextView.setText(questionBank[currentQuestionIndex].getAnswerResId());
    }

}