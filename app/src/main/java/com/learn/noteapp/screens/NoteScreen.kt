package com.learn.noteapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learn.noteapp.R
import com.learn.noteapp.components.NoteButton
import com.learn.noteapp.components.NoteInputText
import com.learn.noteapp.components.NoteRow
import com.learn.noteapp.data.NoteDataSource
import com.learn.noteapp.model.Note

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NoteScreen(notes:List<Note>,
               onAddNote: (Note)->Unit,
               onRemoveNote:(Note)->Unit){


    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }


    Column(modifier = Modifier.padding(6.dp)) {
        TopAppBar(title = {
                          Text(text = stringResource(id = R.string.app_name))
        }, actions ={
         Icon(imageVector = Icons.Rounded.Notifications, contentDescription = "bell icon")
        } ,
        backgroundColor = Color(0xFFADFE))

        //content
        Column(modifier = Modifier.fillMaxWidth()
        , horizontalAlignment = Alignment.CenterHorizontally) {
            NoteInputText(modifier=Modifier.padding(
                top = 9.dp,
                bottom = 8.dp
            ),
                text = title, label = "title", onTextChange = {
                    if(it.all { char-> char.isLetter() || char.isWhitespace() }){
                        title=it
                    }
                })
            NoteInputText(modifier=Modifier.padding(
                top = 9.dp,
                bottom = 8.dp
            ),text = description, label = "Add a Note", onTextChange = {
                if(it.all { char-> char.isLetter() || char.isWhitespace() }){
                    description=it
                }
            })
            NoteButton(modifier = Modifier.padding(8.dp), text = "Save", onClick = {
                if(title.isNotEmpty() && description.isNotEmpty()){
                    //save/add to the list
                    title=""
                    description=""
                }
            })
        }

        Divider(modifier = Modifier.padding(10.dp))
        LazyColumn{
            items(notes){
                note-> NoteRow(note = note, onNoteClicked ={} )
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview(){
    NoteScreen(notes= NoteDataSource().loadNotes(), onAddNote = {}, onRemoveNote = {})
}

