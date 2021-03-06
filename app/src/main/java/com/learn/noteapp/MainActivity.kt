package com.learn.noteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.learn.noteapp.data.NoteDataSource
import com.learn.noteapp.model.Note
import com.learn.noteapp.screens.NoteScreen
import com.learn.noteapp.screens.NoteViewModel
import com.learn.noteapp.ui.theme.NotesAppJetpackTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesAppJetpackTheme {


                // A surface container using the 'background' color from the theme
                Surface(
                   color = MaterialTheme.colors.background
                ) {
                    //val noteViewModel= viewModel<NoteViewModel>()
                    val noteViewModel:NoteViewModel by viewModels()
                    NotesApp(noteViewModel=noteViewModel)
                }
            }
        }
    }
}

@Composable
fun NotesApp(noteViewModel: NoteViewModel){
    val notesList=noteViewModel.noteList.collectAsState().value
    NoteScreen(notes= notesList, onAddNote = {
        noteViewModel.addNote(it)
    }, onRemoveNote = {
       noteViewModel.removeNote(it)
    })
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NotesAppJetpackTheme {

    }
}