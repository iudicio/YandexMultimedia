package com.example.playlistmarket

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.example.playlistmarket.ui.theme.PlaylistMarketTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaylistMarketTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MainXmlLayout()
                }
            }
        }
    }
}

@Composable
fun MainXmlLayout() {
    AndroidView(
        factory = { context ->
            val view = LayoutInflater.from(context).inflate(R.layout.activity_main, null, false)

            val btnSearch = view.findViewById<androidx.cardview.widget.CardView>(R.id.btnSearch)
            val btnLibrary = view.findViewById<androidx.cardview.widget.CardView>(R.id.btnLibrary)
            val btnSettings = view.findViewById<androidx.cardview.widget.CardView>(R.id.btnSettings)

            btnSearch.setOnClickListener(object : android.view.View.OnClickListener {
                override fun onClick(v: android.view.View?) {
                    val intent = android.content.Intent(context, SearchActivity::class.java)
                    context.startActivity(intent)
                }
            })

            btnLibrary.setOnClickListener {
                val intent = android.content.Intent(context, LibraryActivity::class.java)
                context.startActivity(intent)
            }

            btnSettings.setOnClickListener {
                val intent = android.content.Intent(context, SettingsActivity::class.java)
                context.startActivity(intent)
            }

            view
        }
    )
}
