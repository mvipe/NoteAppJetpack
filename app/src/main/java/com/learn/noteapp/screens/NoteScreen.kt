package com.learn.noteapp.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learn.noteapp.Greeting
import com.learn.noteapp.R
import com.learn.noteapp.components.NoteInputText
import com.learn.noteapp.ui.theme.NotesAppJetpackTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NoteScreen(){
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
NoteInputText(text = "hello", label = "hell", onTextChange = {})
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview(){
    NoteScreen()
}

