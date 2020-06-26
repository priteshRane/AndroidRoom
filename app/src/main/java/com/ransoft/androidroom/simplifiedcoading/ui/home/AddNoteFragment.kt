package com.ransoft.androidroom.simplifiedcoading.ui.home

import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.ransoft.androidroom.R
import com.ransoft.androidroom.simplifiedcoading.data.db.NoteDatabase
import com.ransoft.androidroom.simplifiedcoading.data.db.entities.Note
import com.ransoft.androidroom.simplifiedcoading.util.toast
import kotlinx.android.synthetic.main.fragment_add_note.*
import kotlinx.android.synthetic.main.fragment_home.*

class AddNoteFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_done.setOnClickListener {
            val noteTitle = tie_title.text.toString().trim()
            val noteBody: String = tie_note.text.toString().trim()

            if (noteTitle.isNullOrEmpty()) {
                tie_title.error = "title required"
                tie_title.requestFocus()
                return@setOnClickListener
            }

            if (noteBody.isNullOrEmpty()) {
                tie_note.error = "note required"
                tie_note.requestFocus()
                return@setOnClickListener
            }

            val note = Note(noteTitle, noteBody)
            saveNote(note)
        }
    }

    private fun saveNote(note: Note) {
        class SaveNote : AsyncTask<Void, Void, Void>(){
            override fun doInBackground(vararg params: Void?): Void? {
                NoteDatabase(requireActivity()).getNoteDao().addNote(note)
                return null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)
                requireActivity().toast("Note saved")
            }
        }
        SaveNote().execute()
    }
}