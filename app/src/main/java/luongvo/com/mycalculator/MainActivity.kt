package luongvo.com.mycalculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var button0: Button? = null
    var button1: Button? = null
    var button2: Button? = null
    var button3: Button? = null
    var button4: Button? = null
    var button5: Button? = null
    var button6: Button? = null
    var button7: Button? = null
    var button8: Button? = null
    var button9: Button? = null
    var buttonAdd: Button? = null
    var buttonSubstract: Button? = null
    var buttonMul: Button? = null
    var buttonDiv: Button? = null
    var buttonClear: Button? = null
    var buttonEqual: Button? = null
    var result: String? = null
    var tmp: String? = null
    var operator: String? = null
    var resultTextView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initControl()
        initControlListener()
    }

    private fun initControlListener() {
        button0!!.setOnClickListener { onNumberButtonClicked("0") }
        button1!!.setOnClickListener { onNumberButtonClicked("1") }
        button2!!.setOnClickListener { onNumberButtonClicked("2") }
        button3!!.setOnClickListener { onNumberButtonClicked("3") }
        button4!!.setOnClickListener { onNumberButtonClicked("4") }
        button5!!.setOnClickListener { onNumberButtonClicked("5") }
        button6!!.setOnClickListener { onNumberButtonClicked("6") }
        button7!!.setOnClickListener { onNumberButtonClicked("7") }
        button8!!.setOnClickListener { onNumberButtonClicked("8") }
        button9!!.setOnClickListener { onNumberButtonClicked("9") }
        buttonClear!!.setOnClickListener { onClearButtonClicked() }
        buttonSubstract!!.setOnClickListener { onOperatorButtonClicked("-") }
        buttonAdd!!.setOnClickListener { onOperatorButtonClicked("+") }
        buttonMul!!.setOnClickListener { onOperatorButtonClicked("X") }
        buttonDiv!!.setOnClickListener { onOperatorButtonClicked("/") }
        buttonEqual!!.setOnClickListener { onEqualButtonClicked() }
    }

    private fun onEqualButtonClicked() {
        var res = 0
        try {
            val number = tmp!!.toInt()
            val number2 = resultTextView!!.getText().toString().toInt()
            when (operator) {
                "+" -> res = number + number2
                "/" -> res = number / number2
                "-" -> res = number - number2
                "X" -> res = number * number2
            }
            result = res.toString()
            resultTextView!!.text = result
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun onOperatorButtonClicked(operator: String) {
        tmp = resultTextView!!.getText().toString()
        onClearButtonClicked()
        this.operator = operator
    }

    private fun onClearButtonClicked() {
        result = ""
        resultTextView!!.text = ""
    }

    private fun onNumberButtonClicked(pos: String) {
        result = resultTextView!!.getText().toString()
        result = result + pos
        resultTextView!!.text = result
    }

    private fun initControl() {
        button0 = findViewById<View>(R.id.button0) as Button
        button1 = findViewById<View>(R.id.button1) as Button
        button2 = findViewById<View>(R.id.button2) as Button
        button3 = findViewById<View>(R.id.button3) as Button
        button4 = findViewById<View>(R.id.button4) as Button
        button5 = findViewById<View>(R.id.button5) as Button
        button6 = findViewById<View>(R.id.button6) as Button
        button7 = findViewById<View>(R.id.button7) as Button
        button8 = findViewById<View>(R.id.button8) as Button
        button9 = findViewById<View>(R.id.button9) as Button
        buttonAdd = findViewById<View>(R.id.buttonAdd) as Button
        buttonClear = findViewById<View>(R.id.buttonClear) as Button
        buttonSubstract = findViewById<View>(R.id.buttonSub) as Button
        buttonMul = findViewById<View>(R.id.buttonMul) as Button
        buttonDiv = findViewById<View>(R.id.buttonDiv) as Button
        buttonEqual = findViewById<View>(R.id.buttonEqual) as Button
        resultTextView = findViewById<View>(R.id.text_view_result) as TextView
    }
}
