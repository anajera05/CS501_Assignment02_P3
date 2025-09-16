package com.example.problem3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.problem3.ui.theme.Problem3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Problem3Theme {
                AssignmentPreview()
            }
        }
    }
}

@Composable
fun KotlinPracticeScreen() {
    var input by remember { mutableStateOf("general") }
    var nullableMessage: String? by remember { mutableStateOf("Message is not nul!") }
    var counter by remember { mutableIntStateOf(0) }


    val joke = when (input.lowercase()) {
        "knock-knock" -> "Knock knock. Who's there? Hatch. Hatch who?\n" +
                "Bless you!"
        "programming" -> "A user interface is like a joke.\n" +
                "If you have to explain it then it is not that good."
        else -> "What did the Buffalo say to his little boy when he dropped him off at school?\n" +
                "Bison."
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        // When expression to display different jokes based on the input
        Text(text = "$input Joke: \n$joke")
        Row{
            Button(onClick = { input = "Knock-Knock" }) {
                Text("Knock-Knock Joke")
            }
            Button(onClick = { input = "Programming" }) {
                Text("Programming Joke")
            }
        }

        // Display message if not null
        nullableMessage?.let {
            Text(text = "Message: $it")
        }
        Button(onClick = { nullableMessage = null }) {
            Text("Set message to null")
        }

        
        // Counter button
        Text(text = "Counter: $counter")
        Button(

            onClick = {
                if (counter < 5) counter++
            }
        ) {
            Text("Increment Counter")
        }




    }
}

@Preview(showBackground = true)
@Composable
fun AssignmentPreview() {
    Problem3Theme {
        KotlinPracticeScreen()
    }
}