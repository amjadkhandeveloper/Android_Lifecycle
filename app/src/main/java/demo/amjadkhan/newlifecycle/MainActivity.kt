package demo.amjadkhan.newlifecycle
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import demo.amjadkhan.newlifecycle.observer.MyObserver
import demo.amjadkhan.newlifecycle.ui.theme.NewLifecycleTheme

class MainActivity : ComponentActivity() {
    private val _data = MutableLiveData<String>()
    lateinit var myLifecycleOwner: LifecycleOwner;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        myLifecycleOwner = this
        myLifecycleOwner.lifecycle.addObserver(MyObserver());

        enableEdgeToEdge()
        setContent {
            NewLifecycleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Check Logs you can see the both lifecycle and observer",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

        Log.d("MainActivity", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume")
        _data.value = "OnResume";
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause")
        _data.value = "OnPause";
    }


    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onRestart")
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier, isP: Boolean = false) {
        Column {
            Text(
                text = "Hello $name!",
                modifier = modifier
            )
        }
    }

}